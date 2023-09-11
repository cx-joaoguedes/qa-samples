# Option 1: Import Client class directly from pymemcache.client.base
from pymemcache.client.base import Client

# Option 2: Import Client class from pymemcache.client
from pymemcache.client import Client

# Option 3: Import Client class from pymemcache
import pymemcache
client = pymemcache.client.base.Client(('localhost', 11211))

# Option 4: Import Client class from pymemcache as an alias
import pymemcache.client as pymc
client = pymc.base.Client(('localhost', 11211))

# Option 4: Import Client class from pymemcache as an alias
import pymemcache.client.base as pymc
client = pymc.Client(('localhost', 11211))

# Option 5: Import the entire pymemcache.client.base module and reference the Client class
import pymemcache.client.base
client = pymemcache.client.base.Client(('localhost', 11211))