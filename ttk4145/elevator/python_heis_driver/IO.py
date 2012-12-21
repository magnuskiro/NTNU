## \file IO.py
## \brief Interface for the comedi-library, rewritten for python.
from comedi.comedi import *
from channels import INPUT, OUTPUT

class IOException(ElevatorException):
    """Exception raised when driver fails to communicate with the hardware"""
    error=None
    errno=-1
    def __init__(self,value,error=None,errno=None):
        self.value = value
        self.error = error
        self.errno = errno
    def __str__(self):
        return repr(self.value+' ('+self.error+').')

class IO:
    comedi=None
    status=0
    device = '/dev/comedi0'
    def __init__(self):
        self.comedi=comedi_open(self.device)
        if not self.comedi:
            raise IOException('Could not connect to '+self.device,comedi_strerror(comedi_errno()),comedi_errno())
        for i in xrange(8):
            self.status |= comedi_dio_config(self.comedi, INPUT.PORT1, i, COMEDI_INPUT)
            self.status |= comedi_dio_config(self.comedi, OUTPUT.PORT2, i, COMEDI_OUTPUT)
            self.status |= comedi_dio_config(self.comedi, OUTPUT.PORT3, i+8, COMEDI_OUTPUT)
            self.status |= comedi_dio_config(self.comedi, INPUT.PORT4, i+16, COMEDI_INPUT)
        if self.status==-1:
            raise IOException('Error in config, status '+self.status,comedi_strerror(comedi_errno()),comedi_errno())

    def setBit(self,channel,value):
        """Changes the bit of a given channel to 0 or 1.
        
        channel -- The channel to change.
        value   -- Value to set (1 or 0).
        
        """
        if value!=0 and value!=1:
            raise IOException('Failed to set value, not binary')
        if comedi_dio_write(self.comedi, channel >> 8, channel & 0xff, value) == -1:
            raise IOException('Could not write {0} to channel 0x{1:X}'.format(value,channel))

    def readBit(self,channel):
        """Reads a bit from the given channel."""
        data = comedi_dio_read(self.comedi, channel>>8, channel & 0xff)
        if(data[0]==-1):
            raise IOException('Could not read from channel 0x{0:X}'.format(channel),channel, comedi_strerror(comedi_errno()),comedi_errno())
        return data[1]

    def getAllInput(self):
        """Read and return every polarity of the input sensors"""
        return [self.readBit(i) for i in INPUT.ALL]

    def write(self,channel, value):
        """Sets a bit in the given channel"""
        if comedi_data_write(self.comedi, channel>>8, channel&0xff, 0, AREF_GROUND, value) == -1:
            raise IOException('Could not write "'+str(value)+'" to channel '+str(channel),comedi_strerror(comedi_errno()),comedi_errno())

"""Global IO-class. ("singleton")"""
io = IO()        


