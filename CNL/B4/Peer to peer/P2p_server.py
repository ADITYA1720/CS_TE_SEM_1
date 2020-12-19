import socket
import sys
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.bind(('localhost',23000))
sock.listen(1)
clisock, (ip,port) = sock.accept()
while True:    	
	data = clisock.recv(16)
	dt = data.decode()
	if "stop."==dt:
		break
	else:			
		print("client: " + dt)
	data = input("you: ")
	clisock.send(str.encode(data))
	if "stop."==data:
		break
sock.close()
