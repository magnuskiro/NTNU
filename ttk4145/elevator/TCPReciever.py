#!/usr/bin/python
# Accepts connections, prints the received messages to stdout.

from socket import *
import threading
from MessageHandler import MessageHandler
from time import sleep
from _socket import SHUT_RD
import pickle

__author__ = 'kiro'

class TCPReceiver( threading.Thread ):
    serverHost = "127.0.0.1"
    serverPort = 5005

    def getMyIP(self):
        s=socket(AF_INET, SOCK_DGRAM)
        s.connect(("gmail.com",80))
        addr = s.getsockname()[0]
        s.close()
        return addr

    def __init__(self, ip="", port=5005, messageHandler=""):
        super(TCPReceiver, self).__init__()

        if ip=="":
            # serverHostname = get the ip address of this local machine.
            self.serverHost = self.getMyIP()
        else:
            self.serverHost = ip

        # set the port
        if not port or port == 0:
            self.serverPort = 5005
        else:
            self.serverPort = port

        # set the message handler
        self.messageHandler = messageHandler
        if self.messageHandler == "":
            print "No messageHandler in TCPReceiver"
#            exit()

        # print debug info
        print "TCP-RECEIVER initialized"
        print "\t target IP:", self.serverHost
        print "\t target port:", self.serverPort

    def run(self):
        try:
            # Open socket to listen on
            sock = socket(AF_INET, SOCK_STREAM)
            sock.bind((self.serverHost, self.serverPort))
            sock.listen(1024)

            # Process connections
            while 1:
                # Accept connections
                connection, address = sock.accept()
                print 'Connection accepted from %s' % str(address)
                # Receive data
                try:
                    data = connection.recv(2 ** 16)
                    ip = connection.getsockname()[0]
                    port = connection.getsockname()[1]
                    print "incoming: ", ip
#                    print 'Received: %s' % str(data)
                    print "ty: ",pickle.loads(data).type
                    #sock.shutdown(SHUT_RD)
#                    self.messageHandler.evaluateCommand(ip, port, data)
                    connection.close()
                    # Acknowledge reception of data
                    r = 'ACK\n'
                    #connection.send(r)

                except error:
                    print error
        except error:
            print error
            exit(1)

# test code for running only this file.
#a = TCPReceiver("129.241.187.145")
#a.run()
