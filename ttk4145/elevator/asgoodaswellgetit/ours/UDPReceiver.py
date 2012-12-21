#!/usr/bin/python
# Accepts connections, prints the received messages to stdout.

import socket
import threading
from time import sleep

__author__ = 'kiro'

class UDPReceiver( threading.Thread ):
    UDP_IP="127.0.0.1"
    UDP_PORT=6005

    def __init__(self, port=6005, messageHandler=""):
        super(UDPReceiver, self).__init__()
        self.UDP_IP = "<broadcast>"

        if not port:
            self.UDP_PORT = 6005
        else:
            self.UDP_PORT = port
        self.messageHandler = messageHandler
        if self.messageHandler == "":
            print "No messageHandler in UDPReceiver"
            exit()
        print "UDP-RECEIVER initialized"
        print "\t target IP:", self.UDP_IP
        print "\t target port:", self.UDP_PORT

    def run(self):
        sock = socket.socket( socket.AF_INET, # Internet
            socket.SOCK_DGRAM ) # UDP
        sock.bind( (self.UDP_IP,self.UDP_PORT) )

        while True:
            data, addr = sock.recvfrom( 1024 ) # buffer size is 1024 bytes
#            print "received message:", data
            ip = sock.getsockname()[0]
            port = sock.getsockname()[1]
            self.messageHandler.evaluateCommand(ip, port, data)

# test code for running only this file.
#a = UDPReceiver(5005)
#a.run()
