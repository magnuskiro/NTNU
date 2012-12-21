from socket import *
from time import sleep
import pickle
import threading 
from Message import Message

__author__ = 'kiro'

class UDPSender( threading.Thread ):
    UDP_IP = ""
    UDP_PORT = 6005
    
    def getMyIP(self):
        s=socket(AF_INET, SOCK_DGRAM)
        s.connect(("gmail.com",80))
        addr = s.getsockname()[0]
        s.close()
        return addr

    def __init__(self, port=6005):
        super(UDPSender, self).__init__()
        # Set the ip to default or given value.
        self.UDP_IP = "<broadcast>"
        #self.UDP_IP = "127.0.0.1"
        
        # Set the port to default or given value.
        if not port:
            self.UDP_PORT = 6005
        else:
            self.UDP_PORT = port
    
        self.message = Message("stillAlive",  self.getMyIP())

        print "UDP-SENDER initialized"
        print "\t target IP:", self.UDP_IP
        print "\t target port:", self.UDP_PORT
        
        self.start()

    def run(self):
        while 1:
#            print "sending alive message"
            self.send(self.message)
            sleep(3)

    def send(self, message):
        s = socket(AF_INET, SOCK_DGRAM)
        s.bind(('', 0))
        s.setsockopt(SOL_SOCKET, SO_BROADCAST, 1)
        s.sendto(pickle.dumps(message), ('<broadcast>', self.UDP_PORT))
        s.close()

# test code for running only this file.

#a = UDPSender()
#a.send("testing")
#a.send("testing1")
#a.send("testing2")
#a.send("testing3")

