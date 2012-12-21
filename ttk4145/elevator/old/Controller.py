from time import time
from Constants import *
from Elevator import Elevator
from Message import Message
from Peer import Peer

class Controller:

    def getMyIP(self):
        import socket
        return socket.gethostbyname(socket.gethostname())

    def __init__(self, communicator, dispatcher=False):
        self.communicator = communicator

        self.orderList = [[0 for x in range(NO_FLOORS)] for x in range(2)] # direction is one dimension, no. floors the other
        self.peerList = {} # store peer objects, with IP as key
        self.dispatcher = dispatcher
        self.id = self.getMyIP()
        self.status = ""
        self.elevator = Elevator() # this object should handle the interface with the driver and keep track of elevator state
        
    def check_others(self):
        '''
        check to see if other elevators have problems
        if an elevator has timed out, delete from list
        if dispatcher dead, create new dispatcher
        '''
        currentTime = time()
        dead_peers = []
        dispatcher_dead = False
        for peer_id, peer in self.peerList.iteritems():
            if (currentTime - peer.last_alive) < TIMEOUT:
                continue
            else:
                dead_peers.append(peer)
                if peer.dispatcher:
                    dispatcher_dead = True
        if self.dispatcher:
            self.redistribute_jobs(dead_peers)
        elif dispatcher_dead:
            self.find_new_dispatcher(dead_peers)
            print "Dispatcher is dead, need to find new"

    def find_new_dispatcher(self, dead_peers):
        '''
        Method to decide which elevator becomes dispatcher
        if dispatcher has died. Highest IP (id) is dispatcher
        '''
        elder = self
        for peer_id, peer in self.peerList.iteritems():
            if peer in dead_peers:
                continue
            if peer.id > elder.id:
                elder = peer
        if elder == self:
            self.become_dispatcher(dead_peers)
        else:
            print "New dispatcher is ", elder.id

    def become_dispatcher(self, dead_peers):
        '''
        Turns this elevator into dispatcher
        '''
        self.dispatcher = True
        print "This elevator is now dispatcher.\nRedistributing jobs of dead peers"
        self.redistribute_jobs(dead_peers)

    def setup(self, messages):
        '''
        setup elevator to be ready
        '''
#        networking.do_stuff()
        # spawn networking thread
        # this thread sets up all the necessary connections
        # and listens for incoming messages for a set time period
        last_alive = time()
        for message in messages:
            self.peerList[message.id] = Peer(message.id, message.status, message.dispatcher, last_alive)
#        networking.set_peers(peers) # give networking thread the list of peers so that it can update them
#        networking.broadcast_existence()

    def newOrder(self, message):
        # TODO
        print "new Order, not impl"

    def orderComplete(self, message):
        # TODO
        print ""

    def updateOrders(self, message):
        # TODO
        print ""

    def updateStatus(self, message):
        # TODO
        print ""

    def stillAlive(self, message, time):
        ## keep track of the peers in the network. aka peerList updater.
        # TODO
        print ""

#################################
##### DISPATCHER METHODS ########
#################################


    def find_best_suited(self, floor, direction):
        '''
        Finds the elevator best suited for a job
        '''
        best_score = -1
        best_suited = ""
        for peer_id, peer in self.peerList.iteritems():
            if peer.is_obstructed or peer.is_stopped:
                continue
            else:
                score = self.get_score(peer, floor, direction)
                if score < best_score:
                    best_score = score
                    best_suited = peer
        return best_suited

    def get_score(self, peer, floor, direction):
        '''
        Gives elevator a score based on how suited it is for the job.
        A score of 1 is best
        '''
        # TODO: FIGURE OUT HOW BEST TO GIVE A SCORE! THIS IS PROBABLY THE WORST PART LOGIC-WISE!
        score = 0.0
        scaling_factor = 1/NO_FLOORS
        
        # current distance from job
        distance = 0
        if peer.direction == UP and floor > peer.floor:
            distance = floor - peer.floor
        elif peer.direction == UP and floor < peer.floor:
            distance = 0
        elif peer.direction == DOWN and floor > peer.floor:
            distance = 0
        elif peer.direction == DOWN and floor < peer.floor:
            distance = peer.floor - floor
        
        # number of jobs waiting
        no_jobs = 0
        for direction in range(2):
            for floor in range(NO_FLOORS):
                if self.orderList[floor][direction] == peer.id:
                    no_jobs+=1
        
        score = distance + no_jobs
        if not score:
            return 1
        else:
            return score
        

    def redistribute_jobs(self, dead_peers):
        '''
        This method takes a dead elevator and redistributes its jobs
        to the other elevators that are still online
        '''
        # TODO: takes in a dead peer, redistributes its jobs to the ones still online
        for peer in dead_peers:
            for direction in range(2):
                for floor in range(NO_FLOORS):
                    if self.orderList[floor][direction] == peer.id:
                        self.dispatch_job(floor,direction)

    

    def dispatch_job(self, floor, direction):
        '''
        Takes a job and finds an elevator to give it to
        When job list is updated, broadcast to all
        '''
        # if job is not in list of jobs, find elevator to take it
        if not self.orderList[direction][floor]:
            peer = self.find_best_suited(floor, direction)
            self.update_job_list(peer, floor, direction)
            message = Message("newOrder", peer.IP, floor, direction, "", "")
            self.communicator.sendToAll(self.peerList, message)
        else:
            print "Order Exists"

    def update_job_list(self, peer, floor, direction):
        self.orderList[direction][floor] = peer.IP
        message = Message("updateOrders", "", "", "", self.orderList, "")
        self.communicator.sendToAll(self.peerList, message)

    def receive_order(self, order):
        if order:
            print "hei"
