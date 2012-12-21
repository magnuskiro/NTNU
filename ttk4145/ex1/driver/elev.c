// Wrapper for libComedi Elevator control.
// These functions provides an interface to the elevators in the real time lab
//
// 2006, Martin Korsgaard
#define _XOPEN_SOURCE 500
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>

#include "channels.h"
#include "elev.h"
#include "io.h"

#define POLLING_INTERVAL 50000

// Number of signals and lamps per floor (signals includes stop, obstr)
#define N_SIGNALS 6
#define N_LAMPS 3


// Array of callback associations.
static void (*callbacks_g[N_SIGNALS])(int, int);



// Matrix of lamp channels indexed by floor and lamp type.
static const int lamp_channel_matrix[N_FLOORS][N_LAMPS] = {
	{LIGHT_UP1, LIGHT_DOWN1, LIGHT_COMMAND1},
	{LIGHT_UP2, LIGHT_DOWN2, LIGHT_COMMAND2},
	{LIGHT_UP3, LIGHT_DOWN3, LIGHT_COMMAND3},
	{LIGHT_UP4, LIGHT_DOWN4, LIGHT_COMMAND4}};



// Matrix of elevator signals channels indexed by floor and signal type.
static const int signal_channel_matrix[N_FLOORS][N_SIGNALS] = {
	{FLOOR_UP1, FLOOR_DOWN1, FLOOR_COMMAND1, SENSOR1, STOP, OBSTRUCTION},
	{FLOOR_UP2, FLOOR_DOWN2, FLOOR_COMMAND2, SENSOR2, STOP, OBSTRUCTION},
	{FLOOR_UP3, FLOOR_DOWN3, FLOOR_COMMAND3, SENSOR3, STOP, OBSTRUCTION},
	{FLOOR_UP4, FLOOR_DOWN4, FLOOR_COMMAND4, SENSOR4, STOP, OBSTRUCTION}};



void elev_set_speed(int speed)
{
	// In order to sharply stop the elevator, the direction bit is toggled
	// before setting speed to zero.
	static int last_speed = 0;
	
	// If to start (speed > 0)
	if (speed > 0) 
		io_clear_bit(MOTORDIR);
	else if (speed < 0) 
		io_set_bit(MOTORDIR);

	// If to stop (speed == 0)
	else if (last_speed < 0)
		io_clear_bit(MOTORDIR);
	else if (last_speed > 0)
		io_set_bit(MOTORDIR);

	last_speed = speed ;

	// Write new setting to motor.
	io_write_analog(MOTOR, 2048 + 2*abs(speed));

	printf(__FILE__ ": Speed set to %d\n", speed);
}



void elev_set_door_open_lamp(int value)
{
	if (value)
		io_set_bit(DOOR_OPEN);
	else
		io_clear_bit(DOOR_OPEN);
}
 


void elev_set_stop_lamp(int value)
{
	if (value)
		io_set_bit(LIGHT_STOP);
	else
		io_clear_bit(LIGHT_STOP);
}




void elev_set_floor_indicator(int floor)
{
	assert(floor >= 0);
	assert(floor < N_FLOORS);

	if (floor & 0x02)
		io_set_bit(FLOOR_IND1);
	else
		io_clear_bit(FLOOR_IND1);
		
	if (floor & 0x01)
		io_set_bit(FLOOR_IND2);
	else
		io_clear_bit(FLOOR_IND2);
}



void elev_set_button_lamp(elev_direction_t lamp, int floor, int value)
{
	assert(floor >= 0);
	assert(floor < N_FLOORS);

	if (value == 1)
		io_set_bit(lamp_channel_matrix[floor][lamp]);
	else
		io_clear_bit(lamp_channel_matrix[floor][lamp]);		
}



void elev_unregister_callback(elev_signal_t type)
{
	callbacks_g[type] = NULL;
}



void elev_register_callback(elev_signal_t type, void (*callback)(int, int))
{
	callbacks_g[type] = callback;
}



void elev_disable_callbacks(int thread)
{
	pthread_cancel(thread);
}



int elev_init(void)
{
	memset(callbacks_g, 0, sizeof(callbacks_g));
	
	return io_init();
}



static void *polling_thread(void *p)
{
	// Store previous values of inputs, raise signal if changed between
	// two polls.
	static int prev_values[N_FLOORS][N_SIGNALS];

	memset(prev_values, 0, sizeof(prev_values));
	
	while (1) {
		for (int type = 0; type < N_SIGNALS; type++){
			for (int floor = 0; floor < N_FLOORS; floor++){
				int value = io_read_bit(signal_channel_matrix[floor][type]);

				// If no associated callback: ignore.
				if (callbacks_g[type] == NULL) {
					;
				}
				// If value has not changed, ignore.
				else if (value == prev_values[floor][type]) {
					;
				}
				// Obstruction is raised on any edge, with new value as param.
				else if (type == SIGNAL_TYPE_OBSTR) {
					callbacks_g[type](0, value);
				}
				// STOP is called with no arguments, only when pushed (not when
				// released).
				else if (type == SIGNAL_TYPE_STOP && value == 1) {
					callbacks_g[type](0, 0);
				}
				// Floor sensor is raised on any edge, entering and leaving floor,
				// with floor and value (edge) as param.
				else if (type == SIGNAL_TYPE_SENSOR) {
					callbacks_g[type](floor, value);
				}
				// Other signals (CALL_UP, CALL_DOWN, COMMAND) are raised on
				// rising edge only, with floor and type as parameters.
				else if (value == 1) {
					callbacks_g[type](floor, type);
				}
				// Store current value of signal to avoid multiple calls on the
				// same signal.
				prev_values[floor][type] = value;
				
				// Obstr and stop is not floor dependent, so only loop once.
				if (type == SIGNAL_TYPE_OBSTR || type == SIGNAL_TYPE_STOP) 
					break;

			}
		}

		usleep(POLLING_INTERVAL);
	}
    return NULL;
}



int elev_enable_callbacks(void)
{
	pthread_t new_thread ;
	
	if (pthread_create(&new_thread, NULL, polling_thread, NULL) != 0)
		return -1;
	else
		return new_thread;	
}


void elev_reset_all_lamps(void) {
	elev_set_speed(0);
	elev_set_stop_lamp(0);
	elev_set_door_open_lamp(0);

	for (int floor = 0; floor < N_FLOORS; ++floor) {
		elev_set_button_lamp(ELEV_DIR_DOWN, floor, 0);
		elev_set_button_lamp(ELEV_DIR_UP, floor, 0);
		elev_set_button_lamp(ELEV_DIR_COMMAND, floor, 0);
	}
}

