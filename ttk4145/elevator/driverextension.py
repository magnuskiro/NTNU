from channels import *
from IO import *
NO_FLOORS = 4

def set_door_open_lamp(self, value):
    if value:
        io.setBit(OUTPUT.DOOR_OPEN, value)
    else:
        io.setBit(OUTPUT.DOOR_OPEN, 0)

def reset_all_lamps(self):
    
    self.set_door_open_lamp(0)
    
    for light in OUTPUT.LIGHTS:
        io.setBit(light, 0)
    
def set_speed(self, speed):
    last_speed = 0
    
    if speed > 0:
        io.setBit(OUTPUT.MOTORDIR, 0)
    elif speed < 0:
        io.setBit(OUTPUT.MOTORDIR, 1)
    
    elif last_speed < 0:
        io.setBit(MOTORDIR, 0)
    elif last_speed > 0:
        io.setBit(MOTORDIR, 1)
    
    last_speed = speed
    
    io.write(OUTPUT.MOTOR,2048 + 2*abs(speed))
    

def set_command_light(self, floor, command_buttons):
    if floor == 1:
        self.setChannel(OUTPUT.LIGHT_COMMAND1, command_buttons[floor-1])
    elif floor == 2:
        self.setChannel(OUTPUT.LIGHT_COMMAND2, command_buttons[floor-1])
    elif floor == 3:
        self.setChannel(OUTPUT.LIGHT_COMMAND3, command_buttons[floor-1])
    elif floor == 4:
        self.setChannel(OUTPUT.LIGHT_COMMAND4, command_buttons[floor-1])

def set_call_light(self, floor, direction, value):
    if floor == 1:
        if direction == 0:
            self.setChannel(OUTPUT.UP_LIGHTS[floor-1], value)
        if direction == 1:
            print "wrong value in call_light, trying to go down from floor 1"
    if floor == 2:
        if direction == 0:
            self.setChannel(OUTPUT.UP_LIGHTS[floor-1], value)
        if direction == 1:
            self.setChannel(OUTPUT.DOWN_LIGHTS[floor-2], value)
    if floor == 3:
        if direction == 0:
            self.setChannel(OUTPUT.UP_LIGHTS[floor-1], value)
        if direction == 1:
            self.setChannel(OUTPUT.DOWN_LIGHTS[floor-2], value)
    if floor == 4:
        if direction == 1:
            self.setChannel(OUTPUT.DOWN_LIGHTS[floor-2], value)
        if direction == 0:
            print "wrong value in call_light, trying to go up from floor 4"

    
    
