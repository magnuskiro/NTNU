class Elevator:

    UP = 1
    DOWN = -1
    NONE = 0
    
    def __init__(self):
        # TODO: this class should implement functionaltity for interfacing with the driver
        # TODO: update both state object and physical elevator
        self.state = State()
        self.stops = [] # list of floors to stop on
        self.orders = ""
        self.id = ""
        
    
    def update_state():
        # TODO: update state
        if self.state.obstructed or self.state.doors_open or self.state.stopped:
            print self.state
        else:
            if state.at_floor:
                call_up = orders[UP][self.state.floor] == self.id
                call_down = orders[DOWN][self.state.floor] == self.id
                calls_over = False
                calls_under = False
                for direction in range(2):
                    for floor in range(NO_FLOORS):
                        if orders[direction][floor] == self.id:
                            if floor > self.state.floor:
                                calls_over = True
                            elif floor < self.state.floor:
                                calls_under = True
                                
                print "Calls over: ", calls_over, "\nCalls under: ", calls_under
                
                if (calls_over or call_up) and not (calls_under or call_down):
                    self.state.direction = UP
                elif (calls_under or call_down) and not (calls_over or call_up):
                    self.state.direction = DOWN
                elif (calls_under or call_down) and self.state.direction == DOWN:
                    self.state.direction = DOWN
                elif (calls_over or call_up) and self.state.direction == UP:
                    self.state.direction = UP
                else:
                    self.state.direction = NONE
                
                 
        print state
        
    def update_physical():
        # TODO: send commands to physical elevator
        
    
    def floor_stop():
        'Stop elevator to let people on or off'
        self.state.doors_open = True
        # TODO: new thread that waits DOOR_OPEN_TIME before starting the elevator again
        # in thread; while still waiting, or obstructed, sleep
        # when wait over, and no obstruction, state.doors.open = False
        
        
        
        
