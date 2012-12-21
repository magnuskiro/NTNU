// Test functions for libComedi Elevator control. Connects all buttons and
// lights. Can be used for testing an elevator, or as an example of use of the
// drivers.
//
// 2008 Martin Korsgaard

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>
#include <unistd.h>
#include <signal.h>

#include "elev.h"


// Callback function that handles the elevator reaching a floor
static void signal_floor_sensor(int floor, int value)
{
    elev_set_floor_indicator(floor);

    if (floor == 0) 
		elev_set_speed(1000);
    else if (floor == 3)
		elev_set_speed(-1000);

    printf(__FILE__ ": Floor %d %s.\n", floor+1, value ? "arrive" : "depart");
}



// Callback for elevator buttons being pushed.
static void signal_button_pushed(int floor, int dir)
{
    static int lamps[3][4] = {{0}};

    lamps[dir][floor] ^= 1;
	elev_set_button_lamp(dir, floor, lamps[dir][floor]);

	printf(__FILE__ ": Button %s pushed for floor %d.\n", dir==0?"CALL UP":dir==1?"CALL DOWN":"COMMAND", floor+1);
}



// Callback for stop.
static void signal_stop(int dummy, int dummy2)
{
    static int lamp = 0;
    lamp ^= 1;
	elev_set_stop_lamp(lamp);
	printf(__FILE__ ": Stop button pushed!\n");
}



// Callback for obstruction. Sets the stop lamp.
static void signal_obstruction(int dummy, int value)
{
    elev_set_door_open_lamp(value);
	printf(__FILE__ ": Obstruction switch flipped!\n");
}


void ctrlc(int x)
{
    elev_set_speed(0);
    exit(0);
}

int main()
{
	// Initialize hardware
	if (!elev_init()) {
		printf(__FILE__ ": Unable to initialize elevator hardware.\n");
		exit (1);
	}
	
    signal(SIGINT, ctrlc);

	elev_register_callback(SIGNAL_TYPE_CALL_UP, &signal_button_pushed);
	elev_register_callback(SIGNAL_TYPE_CALL_DOWN, &signal_button_pushed);
	elev_register_callback(SIGNAL_TYPE_COMMAND, &signal_button_pushed);
	elev_register_callback(SIGNAL_TYPE_SENSOR, &signal_floor_sensor);
	elev_register_callback(SIGNAL_TYPE_STOP, &signal_stop);
	elev_register_callback(SIGNAL_TYPE_OBSTR, &signal_obstruction);
	
	elev_reset_all_lamps();

    elev_set_speed(1000);

	elev_enable_callbacks();

	// Loop endlessly. 
	while (1) ;
	
	return 0;
}
