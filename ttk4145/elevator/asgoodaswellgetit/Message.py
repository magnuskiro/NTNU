'''
Represents a message. 
Following messages are allowed:
new_order = [type:NEWORDER, ip:null, floor:[order origin], direction:[order direction], orders:null, state:null]
order_done = [type:ORDERDONE, ip:[ip of sender], floor:[order floor], direction:[order direction], orders:null, state:null]
update_orders = [type:UPDATEORDERS, ip:null, floor:null, direction:null, orders:[updated list of orders], state:null]
update_state = [type:UPDATESTATE, ip:[ip of sender], floor:null, direction:null, orders:null, state:[state of sender]]
'''


'''
messageTypes:
    newOrder
    orderComplete
    updateOrders
    updateStatus
    stillAlive
'''

class Message:
    
    def __init__(self, message_type="none", ip="127.0.0.1", floor="0", direction="0", orders="", state=""):
        self.type = message_type
        self.ip = ip
        self.floor = floor
        self.direction = direction
        self.order = orders
        self.state = state
