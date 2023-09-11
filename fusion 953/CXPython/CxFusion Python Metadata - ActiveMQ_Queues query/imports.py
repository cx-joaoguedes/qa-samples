# Option 1: Import Connection class directly from stomp
from stomp import Connection

conn = Connection([('localhost', 61613)])

# Option 2: Import Connection class from stomp.connect
from stomp.connect import Connection

conn = Connection([('localhost', 61613)])

# Option 3: Import Connection class from stomp.Connection
from stomp.Connection import Connection

conn = Connection([('localhost', 61613)])

# Option 4: Import the entire stomp module and reference the Connection class
import stomp

conn = stomp.Connection([('localhost', 61613)])
