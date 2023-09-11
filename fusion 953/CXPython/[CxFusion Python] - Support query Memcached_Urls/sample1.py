from pymemcache.client import base

client = base.Client(('localhost', 11211))

client.set('key1', 'value1')

value = client.get('key1')

added = client.add('key2', 'value2')
print(added)  # True

added_again = client.add('key2', 'new_value')
print(added_again)  # False

replaced = client.replace('key1', 'new_value1')
print(replaced)  # True

replaced_again = client.replace('key3', 'value3')
print(replaced_again)  # False

replaced = client.replace('key1', 'new_value1')
print(replaced)  # True

replaced_again = client.replace('key3', 'value3')
print(replaced_again)  # False

appended = client.append('key1', 'appended_value')
print(appended)  # True

value = client.get('key1')
print(value)  # 'value1appended_value'

items = {'key3': 'value3', 'key4': 'value4'}
client.set_multi(items)

keys = ['key1', 'key2', 'key3']
values = client.get_multi(keys)
print(values)  # {'key1': 'value1appended_value', 'key2': 'value2', 'key3': 'value3'}

client.set('counter', '10')

incremented = client.incr('counter', 1)
print(incremented)  # 11

decremented = client.decr('counter', 2)
print(decremented)  # 9
