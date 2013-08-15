package ar.com.carloscurotto.distributed.communication.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 * This class shows a simple example of a server udp connection that exchanges messages with a
 * client. This example opens a udp socket, connects it to a client and performs upd communication.
 *
 * @author Carlos Curotto
 *
 */
public class Server {

    public static void main(String[] args) throws Exception {

        // Defines the server port
        int serverPort = 4445;

        // Creates and opens the server socket
        DatagramSocket serverSocket = new DatagramSocket(serverPort);

        // Creates the buffer message to receive data from the client
        byte[] clientBuffer = new byte[256];
        DatagramPacket clientPacket = new DatagramPacket(clientBuffer, clientBuffer.length);

        // Receives a message from the client
        serverSocket.receive(clientPacket);

        // Creates a message to send data to the client using its specific address
        InetAddress clientAddress = clientPacket.getAddress();
        int clientPort = clientPacket.getPort();
        byte[] serverBuffer = (new Date()).toString().getBytes();
        DatagramPacket serverPacket = new DatagramPacket(serverBuffer, serverBuffer.length,
                        clientAddress, clientPort);

        // Sends a message to the client
        serverSocket.send(serverPacket);

        // Closes the server socket
        serverSocket.close();
    }

}
