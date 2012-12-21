import pickle
from time import time

__author__ = 'kiro'

class MessageHandler():

    def __init__(self, controller=""):
        self.controller = controller
        self.setup_time = time()
        print "MessageHandler initialized"

    def setController(self, controller):
        self.controller = controller

    def evaluateCommand(self, ip, port, message):
        if self.controller=="":
            return
        
    
        print "handeling: ", ip
        message = pickle.loads(message)

        if message.type == "newOrder":
            self.controller.newOrder(message.type, 1)
            print "newOrder"
        elif message.type == "orderComplete":
            self.controller.orderComplete(message)
            print "orderComplete"
        elif message.type == "updateOrders":
            self.controller.updateOrders(message)
            print "updateOrders"
        elif message.type == "updateStatus":
            self.controller.updateStaturs(message)
            print "updateStatus"
        elif message.type == "imAlive":
            self.controller.stillAlive(message, time())
            print "stillAlive"
        else:
            print "you are an idiot, message type not found."



