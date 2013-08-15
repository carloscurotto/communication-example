package ar.com.carloscurotto.distributed.communication.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * This class shows a simple example of a client udp connection that exchanges messages with a
 * server. This example opens a udp socket, connects it to a server and performs upd communication.
 *
 * @author Carlos Curotto
 *
 */
public class Client {

    public static void main(String[] args) throws Exception {

        // Defines the server port
        int serverPort = 4445;

        // Creates the client socket
        DatagramSocket clientSocket = new DatagramSocket();

        // Creates the message to send to the server to its well known address
        byte[] serverBuffer = new byte[256];
        InetAddress serverAddress = InetAddress.getLocalHost(); // we assume client and server are
                                                                // both running on the same host
        DatagramPacket serverPacket = new DatagramPacket(serverBuffer, serverBuffer.length,
                        serverAddress, serverPort);

        // Sends the message to the server
        clientSocket.send(serverPacket);

        // Creates the message to receive data from the server
        byte[] clientBuffer = new byte[256];
        DatagramPacket clientPacket = new DatagramPacket(clientBuffer, clientBuffer.length);

        // Receives the data from the server
        clientSocket.receive(clientPacket);

        // Prints the received data
        String received = new String(clientPacket.getData(), 0, clientPacket.getLength());
        System.out.println("Received: " + received);

        // Closes the client socket
        clientSocket.close();
    }

}
