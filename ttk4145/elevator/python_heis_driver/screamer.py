from IO import io
from channels import *
from threading import Thread
from time import sleep

class Screamer(Thread):
    """Hardware-polling thread with notifications on changes.
    
    The IO-module will constantly poll all hardware channels and compare
    their outputs with the previous output. If a new output is detected,
    all listeners will have their desired callback-functions called.
    """
    lastval=None
    listeners=[]
    channelmap={}

    """ Clears the list of listeners and sets the initial value to -1.
    """
    def __init__(self):
        Thread.__init__(self)
        self.listeners = [None]*len(INPUT.ALL)
        self.channelmap={}

        for i in xrange(len(INPUT.ALL)):
            self.listeners[i] = []
            self.channelmap[INPUT.ALL[i]] = i
        
        self.lastval = [-1]*len(INPUT.ALL)
        
    def run(self):
        """ run() polls the hardware for changes and notifies all listeners.
        """
        while True:
            sleep(0.001) #Run at ~1000Hz
            for ch in self.channelmap:
                newval = io.readBit(ch)
                if newval != self.lastval[self.channelmap[ch]]:
                    for listener in self.listeners[self.channelmap[ch]]:
                        if newval in listener[1]:
                            listener[0](ch, newval)
                    self.lastval[self.channelmap[ch]] = newval

    def addListener(self, channel, callback, listento=None):
        """Function to register a listener on a given channel to the given values.
        
        This function adds a listener which calls a given callback to the Screamer.
        One can choose which values to listen to (defaults to only 1).
        channel   -- The (hardware) channel to listen to.
        callback  -- The function(channel, value) to call when the event happens.
        listento  -- A list of values to listen to.
        """
        #print 'adding listener:',channel,callback #Used for debug
        if type(channel)!=int:
            for ch in channel:
                self.addListener(ch, callback, listento)
            return
        if listento==None:
            self.listeners[self.channelmap[channel]].append((callback,(1,)))
        else:
            self.listeners[self.channelmap[channel]].append((callback,tuple(listento)))
