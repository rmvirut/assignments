from socket import *
import http

serverPort = 12000
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(("", serverPort))
serverSocket.listen(1)
print("The server is ready to receive")
print("Connect to ", serverSocket.getsockname())

while 1:
    connectionSocket, addr = serverSocket.accept()
    sentence = connectionSocket.recv(4096)
    capitalizedSentence = sentence.upper()
    connectionSocket.send(capitalizedSentence)
    connectionSocket.close()