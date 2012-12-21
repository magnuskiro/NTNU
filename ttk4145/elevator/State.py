NO_FLOORS = 4
class State:

    def __init__(self):
        self.complete = False
        self.floor = 0
        self.direction = 1
        self.obstructed = False    # True/False
        self.stopped = ""       # True/False
        self.running = ""       # True/False
        self.doors_open = ""    # True/False
        self.at_floor = False      # True/False, does the driver give this information? how? 
        self.commands = [0]*4   # To hold commands
        self.orders = [[0 for x in range(NO_FLOORS)] for x in range(2)]
        self.id = "1337"
        
    def __str__(self):
        'Returns a string representation of the state object'
        direction = ""
        if self.direction == 1:
            direction = "DOWN"
        elif self.direction == 0:
            direction = "UP"
        state_as_string = ""
        state_as_string += "Floor: " + str(self.floor)
        state_as_string += "\nDirection: " + direction
        state_as_string += "\nObstructed: " + str(self.obstructed)
        state_as_string += "\nRunning: " + str(self.running)
        state_as_string += "\nDoors open: " + str(self.doors_open)
        state_as_string += "\nCOMPLETE: " + str(self.complete)
        state_as_string += "\n============================="
        
        return state_as_string
