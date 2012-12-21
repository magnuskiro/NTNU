from IO import io
from channels import *
from screamer import Screamer

import signal
def killer(a=None,b=None):
    """Signal handler for Ctrl+C interrupt. Stops elevator before exiting."""
    try:
        global driver
        driver.stop()
    except:
        pass
    exit(0)
signal.signal(signal.SIGINT, killer)

class Driver:
    direction = OUTPUT.MOTOR_DOWN
    screamer = Screamer()
    def __init__(self):
        self.screamer.start()
        self.direction=OUTPUT.MOTOR_DOWN

    addListener = screamer.addListener
    readChannel = io.readBit
    setChannel = io.setBit

    def setChannels(self, channels, value):
        for channel in channels:
            io.setBit(channel, value)

    def getCurrentFloor(self):
        """Returns the floor where the elevator is, if any. Else returns None."""
        for i in xrange(len(INPUT.SENSORS)):
            if self.readChannel(INPUT.SENSORS[i]):
                return i+1
        return None

    def move(self,direction,speed=1000):
        """Asks the motor to move in a given direction and with a given speed.
        
        direction -- OUTPUT.MOTOR_UP or OUTPUT.MOTOR_DOWN, tells the direction to move in.
        speed     -- Defaults to 1000. Used for debugging purposes only.
        """
        self.direction = direction
        if (speed > 0):
            io.setBit(OUTPUT.MOTORDIR,direction)
        elif (speed < 0):
            io.setBit(OUTPUT.MOTORDIR,direction)
        io.write(OUTPUT.MOTOR,2048 + 2*abs(speed))

    def stop(self):
        """Stops the elevator, and flips direction for smoother stopping."""
        if self.direction is OUTPUT.MOTOR_UP:
            io.setBit(OUTPUT.MOTORDIR,OUTPUT.MOTOR_DOWN)
        elif self.direction is OUTPUT.MOTOR_DOWN:
            io.setBit(OUTPUT.MOTORDIR,OUTPUT.MOTOR_UP)

        io.write(OUTPUT.MOTOR,2048)

    def channelToFloor(self, channel):
        """Mapping from a given hardware channel to a floor. Note that all floors are +1, because the lists are 0-indexed"""
        if channel in INPUT.SENSORS:
            floor = INPUT.SENSORS.index(channel)+1
            type = INPUT.SENSORS

        elif channel in INPUT.UP_BUTTONS:
            floor = INPUT.UP_BUTTONS.index(channel)+1
            type = INPUT.UP_BUTTONS

        elif channel in INPUT.DOWN_BUTTONS:
            floor = INPUT.DOWN_BUTTONS.index(channel)+2 ##Because down-button does not exist.
            type = INPUT.DOWN_BUTTONS

        elif channel in INPUT.IN_BUTTONS:
            floor = INPUT.IN_BUTTONS.index(channel)+1
            type = INPUT.IN_BUTTONS

        elif channel in OUTPUT.UP_LIGHTS:
            floor = OUTPUT.UP_LIGHTS.index(channel)+1
            type = OUTPUT.UP_LIGHTS

        elif channel in OUTPUT.DOWN_LIGHTS:
            floor = OUTPUT.DOWN_LIGHTS.index(channel)+2 ##Because down-button does not exist.
            type = OUTPUT.DOWN_LIGHTS

        elif channel in OUTPUT.IN_LIGHTS:
            floor = OUTPUT.IN_LIGHTS.index(channel)+1
            type = OUTPUT.IN_LIGHTS

        elif channel in OUTPUT.FLOOR_LIGHTS:
            floor = OUTPUT.FLOOR_LIGHTS.index(channel)+1
            type = OUTPUT.FLOOR_LIGHTS

        else:
            raise WrongChannelException()
        return (floor,type)

    def floorToChannel(self,floor,type):
        """Maps between a given floor and its belonging hardware channel."""
        if type == OUTPUT.DOWN_LIGHTS or type == INPUT.DOWN_BUTTONS:
            return type[floor+1]
        return type[floor]

    def getAccordingLight(self, type, floor):
        """Maps between floors and hardware channel to a light in that floor.

        type  -- Type of light we are interested in. IN_BUTTONS, UP_BUTTONS or DOWN_BUTTONS
        floor -- The floor where the light belongs.

        """
        if type==INPUT.IN_BUTTONS:
            return OUTPUT.IN_LIGHTS[floor-1]
        if type==INPUT.UP_BUTTONS:
            return OUTPUT.UP_LIGHTS[floor-1]
        if type==INPUT.DOWN_BUTTONS:
            return OUTPUT.DOWN_LIGHTS[floor-2]

    def setFloorIndicator(self,floor):
        """Sets the floor indicator light in a floor and turns off the others."""
        self.setChannel(OUTPUT.FLOOR_LIGHTS[0], (floor-1)%2)
        self.setChannel(OUTPUT.FLOOR_LIGHTS[1], (floor-1)/2)
            
driver = Driver()

if __name__ == '__main__':
    """Declare a function with parameters channel and value"""
    def printValue(channel, value):
        print channel, value
        
    """When the given channel changes (INPUT.STOP), the given function is called (printValue)"""
    driver.addListener(INPUT.STOP, printValue)

