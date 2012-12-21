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
    
#    print "Speed set to", speed

    
    
