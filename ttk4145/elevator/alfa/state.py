class State:

    def __init__(self):
        self.floor = ""
        self.direction = -1
        self.obstructed = ""    # True/False
        self.stopped = ""       # True/False
        self.running = ""       # True/False
        self.doors_open = ""    # True/False
        self.at_floor = ""      # True/False, does the driver give this information? how? 
        
    def __str__(self):
        'Returns a string representation of the state object'
        direction = ""
        if self.direction == 1:
            direction = "DOWN"
        elif self.direction == 0:
            direction = "UP"
        state_as_string = ""
        state_as_string += "Floor: " + self.floor 
        state_as_string += "\nDirection: " + direction
        state_as_string += "\nObstructed: " + self.obstructed
        state_as_string += "\nRunning: " + self.running
        state_as_string += "\nDoors open: " + self.doors_open
        state_as_string += "\n============================="
        
        return state_as_string
