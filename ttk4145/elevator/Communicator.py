from TCPReciever import TCPReceiver
from TCPSender import TCPSender
from UDPReceiver import UDPReceiver
from UDPSender import UDPSender

__author__ = 'kiro'

class Communicator():

    def __init__(self, messageHandler):
        self.messageHandler = messageHandler

        # the tcp listener, that handles incoming connections on tcp.
        self.TCPReceiver = TCPReceiver("", 0, messageHandler)
        self.TCPReceiver.start()

        # the udp listener that gets broadcasting messages.
        self.UDPReceiver = UDPReceiver(6005, messageHandler)
        self.UDPReceiver.start()

        # the tcp and udp senders.
        self.TCPSender = TCPSender("", 0)
        self.UDPSender = UDPSender()

    # sends a message to one specific elevator.
    def sendToOne(self, peer, message):
        self.TCPSender.send(peer.IP, message)

    # Sends messages to all the elevators registered in this instance.
    def sendToAll(self, peerList, message):
        for peer in peerList:
            self.sendToOne(peer, message)

    # broadcasts messages on UDP, do not expect that It will arrive.
    def broadcast(self, message):
        self.UDPSender.send(message)
