// Wrapper for libComedi Elevator control.
// These functions provides an interface to the elevators in the real time lab
//
// 2006, Martin Korsgaard
#ifndef __INCLUDE_DRIVER_ELEV_H__
#define __INCLUDE_DRIVER_ELEV_H__


// Number of floors
#define N_FLOORS 4


typedef enum elev_direction_t {ELEV_DIR_UP = 0, ELEV_DIR_DOWN = 1, ELEV_DIR_COMMAND = 2, ELEV_DIR_NONE = 2}
	elev_direction_t;

/**
	Sets the speed of the elevator. 
	@param speed New speed of elevator. Positive values denote upward movement
		and vice versa. Set speed to 0 to stop the elevator.
*/
void elev_set_speed(int speed);



/**
	Turn door-open lamp on or off.
	@param value Non-zero value turns lamp on, 0 turns lamp off.
*/
void elev_set_door_open_lamp(int value);



/**
	Turn stop lamp on or off.
	@param value Non-zero value turns lamp on, 0 turns lamp off.
*/
void elev_set_stop_lamp(int value);



/**
	Set floor indicator lamp for a given floor.
	@param floor Which floor lamp to turn on. Other floor lamps are turned off.
*/
void elev_set_floor_indicator(int floor);



/**
	Set a button lamp.
	@param lamp Which type of lamp to set (call up, call down, or "inside"
		command).
	@param floor Floor of lamp to set.
	@param value Non-zero value turns lamp on, 0 turns lamp off.
*/
void elev_set_button_lamp(elev_direction_t lamp, int floor, int value);



/**
	Signal type definitions for register_callback().
*/
typedef enum tag_elev_signal {
	SIGNAL_TYPE_CALL_UP = 0,
	SIGNAL_TYPE_CALL_DOWN = 1,
	SIGNAL_TYPE_COMMAND = 2,
	SIGNAL_TYPE_SENSOR = 3,
	SIGNAL_TYPE_STOP = 4,
	SIGNAL_TYPE_OBSTR = 5
} elev_signal_t;



/**
	Register a callback function to handle signals from the elevator.
	@param type Type of signal to register handler for.
	@param Callback function to call when signal arrives. The callback function
		must be on the following form: `void fun(int floor, int value)'.
		SIGNAL_TYPE_STOP triggers on pushing the stop button, `floor' and
			`value' is always passed 0.
		SIGNAL_TYPE_OBSTR triggers on flipping the obstruction switch. `floor'
			is always passed 0. `value' is one for obstruction enabled, 0 for
			disabled.
		SIGNAL_TYPE_SENSOR triggers on both entering and leaving a floor.
			`floor' is the number of the floor, `value' is 1 for entering the
			floor, 0 for leaving.
		SIGNAL_TYPE_CALL_UP,
		SIGNAL_TYPE_CALL_DOWN,
		SIGNAL_TYPE_COMMAND triggers on button push. The command buttons are the
			floor buttons "inside" the elevator. `floor' is the floor of the
			button being pushed, `value' is the type of button, according to
			elev_direction_t, defined above (ELEV_DIR_DOWN etc.).
*/
void elev_register_callback(elev_signal_t type, void (*callback)(int, int));



/**
	Remove an association from a callback function.
	After calling this function, callback will not be called when the associated
		signal arrives.
	@param type Type of signal to register handler for.
*/
void elev_unregister_callback(elev_signal_t type);



/**
	Initialize elevator.
	@return Non-zero on success, 0 on failure.
*/
int elev_init(void);



/**
	Start calling callbacks when signals arrive.
	This function spawns a new thread that polls the elevator for signals (like 
		the elevator arriving at a new floor, or a button is pushed), and calls
		the associated callback functions (if registered). 
	@return thread index of new thread. Needed to call elev_disable_callbacks().
*/
int elev_enable_callbacks(void);
	
	

/**
	Stops calling callbacks when signals arrive.
	This function will kill off the thread that polls the elevator for signals.
	@param thread Value returned from corresponding elev_enable_callbacks().
*/
void elev_disable_callbacks(int thread) ;


/**
	Clears all lamps. 
	Clears all lamps. Useful on reset, as lamps from previous runs may still be
	lit.
*/
void elev_reset_all_lamps(void);


#endif // #ifndef __INCLUDE_DRIVER_ELEV_H__

