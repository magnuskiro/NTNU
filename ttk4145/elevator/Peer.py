from time import time

class Peer:

    def __init__(self, IP="127.0.0.1", state="T-----", dispatcher=False, last_alive=time()):
        self.IP = IP
        self.state = state  # state object containing all relevant information about elevator state
        self.dispatcher = dispatcher
        self.last_alive = last_alive
        self.is_obstructed = False
        self.is_stopped = False


