from stomp.connect import Connection

connec = Connection([('localhost', 61613)])

class MyListener(stomp.ConnectionListener):
    def on_message(self, headers, body):
        print(f"Received message: {body}")

connec.set_listener('', MyListener())

connec.subscribe(destination='/queue/my_queue', id=1, ack='auto')

connec.send(body='Hello, world!', destination='/queue/my_queue')

connec = stomp.Connection([('localhost', 61613)], username='my_username', password='my_password')

headers = {
    'header1': 'value1',
    'header2': 'value2'
}
connec.send(body='Hello, world!', destination='/queue/my_queue', headers=headers)

connec.subscribe(destination='/queue/queue1', id=1, ack='auto')
connec.subscribe(destination='/queue/queue2', id=2, ack='auto')

connec.send(body='Hello, specific client!', destination='/queue/my_queue', headers={'amq-msg-type': 'text', 'client-id': 'my_client_id'})
