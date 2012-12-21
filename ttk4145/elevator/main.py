from Elevator import Elevator
from Communicator import Communicator
from MessageHandler import MessageHandler
from Controller import Controller
from Message import Message
from Peer import Peer

#Elevator()

messageHandler = MessageHandler()
communicator = Communicator(messageHandler)
controller = Controller(communicator)

print "main"

message = Message("newOrder")
print message

peer = Peer("129.241.187.145")

#communicator.broadcast(message)
#communicator.sendToOne(peer, message)

print "main end"

