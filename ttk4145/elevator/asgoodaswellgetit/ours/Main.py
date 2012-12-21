from time import sleep
from Communicator import Communicator
from Controller import Controller
from Message import Message
from MessageHandler import MessageHandler
from Peer import Peer

__author__ = 'kiro'

# to be the top most file, where we call everything else from.
class Main():

    def __init__(self):


        self.messageHandler = MessageHandler()
        self.communicator = Communicator(self.messageHandler)
        self.controller = Controller(self.communicator)
        self.messageHandler.setController(self.controller)

        print "MAIN initialize"



        ## test code.
        print "--------------"
        sleep(2)
        print "testing start"

        peer = Peer("78.91.5.10")
        message = Message("stillAlive", peer.IP, "", "", "", "")

        self.communicator.broadcast(message)

        #self.communicator.sendToOne(peer, message)

        print "testing complete"
        print "--------------"
        #exit()

Main()