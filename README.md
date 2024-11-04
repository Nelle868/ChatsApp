In my client-server chat project, I am building a simple system that lets two people send messages to each other using JavaFX, 
a framework for creating graphical user interfaces in Java. Imagine it like this: one person (the server) starts the conversation, 
and another person (the client) joins in to chat back and forth. They use two different chat windows, one for the server and one 
for the client, but the messages they send appear in both windows.

The client and server are coded in two separate projects that work together once connected to the same port. The server begins 
the program by establishing the port and awaiting the client connection. Once connected, the chat windows open on both sides. These windows 
are a graphical interface where messages can be typed, sent, and read. Both the server and the client can see what each other types. If 
the server sends a message, it shows up in both the server's and the client's chat windows. The same happens when the client sends a message. 
It's like having a conversation where both people can see what the other person is saying, even though they are typing on different computers. 
This is similar to apps like iMessage, or WhatsApp. On the back end, the server and client are sending text messages back and forth over the internet 
through the connected port, similar to a note being passed between two people. Each time the server or client types a message and hits send, that note 
gets delivered instantly to the other person's chat window. This project helps us understand how computers talk to each other over a network. By building 
this chat system, I see how a server can wait for a client to connect, and how they can exchange messages once connected.

In summary, my client-server chat project is like setting up a two-person chat room where one person (the server) starts the chat, and another person 
(the client) joins in. They type messages to each other, and these messages show up in both of their chat windows. Through this project, I am learning 
how computers can communicate over the internet using JavaFX, and also how to work with other programmers.


