from driver import *
from channels import *
from State import *
from time import sleep
import threading

command_buttons = [0]*4
speed = 250
UP = 0
DOWN = 1
NONE = -1
NO_FLOORS = 4

class Elevator:
    boot = True

    def __init__(self, controller):
        # TODO: this class should implement functionality for interfacing with the driver
        # TODO: update both state object and physical elevator
        self.state = State()
        self.controller = controller
        
        driver.addListener(INPUT.UP_BUTTONS, self.up_button_pushed)
        driver.addListener(INPUT.DOWN_BUTTONS, self.down_button_pushed)
        driver.addListener(INPUT.IN_BUTTONS, self.command_button_pushed)
        driver.addListener(INPUT.SENSORS, self.signal_floor_sensor)
        driver.addListener(INPUT.STOP, self.signal_stop)
        driver.addListener(INPUT.OBSTRUCTION, self.signal_obstruction)
        
        driver.reset_all_lamps()
        driver.setChannel(OUTPUT.LIGHT_STOP, 0)
        
        # run the elevator to the firest floor to begin with. 
        self.boot = True
        self.state.direction = 1
        driver.set_speed(-speed)
        self.run()
        
    def run(self):
        while 1:
            continue 
        return 0
    
    def update_state(self):
        print "updating state"
        # TODO: update state
        if self.boot:
            return
        if self.state.obstructed or self.state.doors_open or self.state.stopped:
            v = 0
        else:
            call_up = False
            call_down = False
            
            for i in range(2):
                for j in range(NO_FLOORS):
                    if (self.state.orders[i][j] == self.state.id) or self.state.commands[j] == self.state.id:
                        if j+1>self.state.floor:
                            call_up = True
                        elif j+1 < self.state.floor:
                            call_down = True
            
            if call_up and not call_down:
                print "SETTING DIRECTION TO UP!", call_up, call_down, self.state.orders
                self.state.direction = UP
            elif call_down and not call_up:
                print "SETTING DIRECTION TO DOWN!", call_up, call_down, self.state.orders
                self.state.direction = DOWN
            elif call_down and self.state.direction == DOWN:
                print "SETTING DIRECTION TO DOWN!", call_up, call_down, self.state.orders    
                self.state.direction = DOWN
            elif call_up and self.state.direction == UP:
                print "SETTING DIRECTION TO UP", call_up, call_down, self.state.orders
                self.state.direction = UP
            else:
                if self.state.floor==3 and self.state.commands[3] == self.state.id:
                    self.state.direction=0
                elif self.state.floor==2 and self.state.commands[0] == self.state.id:
                    self.state.direction=1
            '''
            else:
                print "DIRECTION IS NOW NONE!", call_up, call_down, self.state.orders
                self.state.direction = NONE
            ''' 
            order_dir = ""
            if self.state.orders[DOWN][self.state.floor-1] == self.state.id:
                order_dir = DOWN
                print "reached order floor"
                self.state.orders[order_dir][self.state.floor-1] = 0
                self.state.direction = order_dir
                threading.Thread(self.floor_stop())
                driver.set_call_light(self.state.floor, order_dir, 0)
            if self.state.orders[UP][self.state.floor-1] == self.state.id:
                order_dir = UP
                print "reached order floor"
                self.state.orders[order_dir][self.state.floor-1] = 0
                self.state.direction = order_dir
                threading.Thread(self.floor_stop())
                driver.set_call_light(self.state.floor, order_dir, 0)
            if self.state.commands[self.state.floor-1] == self.state.id:
                self.state.commands[self.state.floor-1] = 0
                command_buttons[self.state.floor-1] ^= 1
                driver.set_command_light(self.state.floor, command_buttons)
                print "HEUREKA"
                threading.Thread(self.floor_stop())
                
        print self.state
        self.update_physical()
                
                
        
    def update_physical(self):
        
        """
        if self.state.direction == UP:
            driver.set_speed(speed)
        elif self.state.direction == DOWN:
            driver.set_speed(speed*-1)
        else:
            driver.set_speed(0)
        """
        """
        # update lights. 
        for direction in range(2):
            for floor in range(NO_FLOORS):
                if self.state.orders[direction][floor] == self.state.id and direction == DOWN:
                    driver.setChannel(OUTPUT.DOWN_LIGHTS[floor-1], 1)
                elif self.state.orders[direction][floor] != self.state.id and direction == DOWN:
                    driver.setChannel(OUTPUT.DOWN_LIGHTS[floor-1], 0)
                if self.state.orders[direction][floor] == self.state.id and direction == UP:
                    driver.setChannel(OUTPUT.UP_LIGHTS[floor-1], 1)
                elif self.state.orders[direction][floor] != self.state.id and direction == UP:
                    driver.setChannel(OUTPUT.UP_LIGHTS[floor-1], 0)
       """
                    
        # update the indicator lights. WORKS
        driver.setFloorIndicator(self.state.floor)

        
        
        # if the stop button is pushed.  WORKS
        if self.state.stopped:
            print "STOP"
            driver.stop()
        else:
            if self.state.direction == UP:
                driver.set_speed(speed)
            elif self.state.direction == DOWN:
                driver.set_speed(speed*-1)
            
        # if the elevator has no orders. do not move. 
        if self.state.complete == True:
            driver.stop()
        
    def floor_stop(self):
        speed_now = ""

        #Stop elevator to let people 
        driver.set_speed(0)
        driver.set_door_open_lamp(1)
        self.state.at_floor = True
        self.state.doors_open = True
        sleep(1)
        self.state.doors_open = False
        self.state.at_floor = False
        driver.set_door_open_lamp(0)
        self.state.direction = NONE
        self.update_state()  
        # TODO: new thread that waits DOOR_OPEN_TIME before starting the elevator again
        # in thread; while still waiting, or obstructed, sleep
        # when wait over, and no obstruction, state.doors.open = False
        
    def addOrder(self, floor, direction):
        print "add order: ", floor, direction
        self.state.orders[direction][floor-1] = self.state.id
        self.controller.newOrder(floor, direction)
        

    ############################
    #### INTERFACE METHODS #####
    ############################

    '''
    BEGIN CALLBACK METHODS FOR INPUT
    '''
    # Callback funtion that handles the elevator reaching a floor
    def signal_floor_sensor(self, floor, value):
        current_floor = driver.channelToFloor(floor)[0]
        self.state.floor = current_floor
        #self.state.at_floor = True
        print current_floor
        if current_floor == 1:
            if self.boot:
                driver.set_speed(0)
                self.boot = False
                print "boot complete"
                return
            driver.set_speed(0)
        elif current_floor == 4:
            driver.set_speed(0)
            
        self.update_state()
        print "Arrived at floor", current_floor
        print self.state.orders

    # buttons inside the elevator
    def command_button_pushed(self, channel, value):
        floor = driver.channelToFloor(channel)[0]
        command_buttons[floor-1] ^= 1
        self.state.commands[floor-1] = self.state.id
        self.state.complete = False
        self.update_state()
        print floor
        if floor == 1:
            driver.setChannel(OUTPUT.LIGHT_COMMAND1, command_buttons[floor-1])
        if floor == 2:
            driver.setChannel(OUTPUT.LIGHT_COMMAND2, command_buttons[floor-1])
        if floor == 3:
            driver.setChannel(OUTPUT.LIGHT_COMMAND3, command_buttons[floor-1])
        if floor == 4:
            driver.setChannel(OUTPUT.LIGHT_COMMAND4, command_buttons[floor-1])
            
    # the buttons for requesting an elevator to go up from this floor
    def up_button_pushed(self, channel, value):
        floor = driver.channelToFloor(channel)[0]
        print "up button pushed in:", floor
        driver.set_call_light(floor, UP, 1)
        self.addOrder(floor, UP)
        self.update_state()
        
    # the buttons to request a downgoing elevator from this floor. 
    def down_button_pushed(self, channel, value):
        floor = driver.channelToFloor(channel)[0]
        print "down button pushed in :", floor
        driver.set_call_light(floor, DOWN, 1)
        self.addOrder(floor, DOWN)
        self.update_state()
        
    # STOP notification function        
    def signal_stop(self, channel, value):
        print "stopp!!!!"
        if self.state.stopped:
            self.state.stopped = False
            driver.setChannel(OUTPUT.LIGHT_STOP, 0)
        else: 
            self.state.stopped = True
            driver.setChannel(OUTPUT.LIGHT_STOP, 1)
        self.update_physical()
        
    # Obstruction notification function
    def signal_obstruction(self, channel, value):
#        if self.state.at_floor:
        current_speed = speed * self.state.direction
        if current_speed == 0:current_speed = 250
        print "OBSTRCUTION!"
        driver.stop()
        driver.setChannel(OUTPUT.DOOR_OPEN, 1)
        self.state.obstructed = True
        # while the elevator is still obstructed. 
        while self.state.obstructed:
            # if the obstruction switch is flipped off, resume operation. 
            #print driver.readChannel(INPUT.OBSTRUCTION)
            if not driver.readChannel(INPUT.OBSTRUCTION):
                self.state.obstructed = False
            sleep(0.3)
        driver.setChannel(OUTPUT.DOOR_OPEN, 0)
        driver.set_speed(current_speed)
        print "OBSTRUCTION cleared"


        """
        print "OBSTRCUTION!"
        driver.stop()
        driver.setChannel(OUTPUT.DOOR_OPEN, 1)
        # while the elevator is still obstructed. 
        while self.state.OBSTRUCTION:
            # if the obstruction switch is flipped off, resume operation. 
            if not driver.readChannel(INPUT.OBSTRUCTION):
                self.state.OBSTRUCTION = False
            sleep(0.3)
        driver.setChannel(OUTPUT.DOOR_OPEN, 0)
        print "OBSTRUCTION cleared"
        """
    '''
    END CALLBACK METHODS FOR INPUT
    '''


