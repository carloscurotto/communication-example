package ar.com.carloscurotto.distributed.communication.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class Server {

    public static void main(String[] args) throws Exception {

        int clientPort = 33000;
        String groupIP = "239.1.54.52";

        InetAddress groupAddress = InetAddress.getByName(groupIP);

        MulticastSocket serverSocket = new MulticastSocket(clientPort);
        serverSocket.joinGroup(groupAddress);

        byte[] clientBuffer = new byte[256];
        clientBuffer = (new Date()).toString().getBytes();
        DatagramPacket packet = new DatagramPacket(clientBuffer, clientBuffer.length, groupAddress, clientPort);

        serverSocket.send(packet);

        serverSocket.leaveGroup(groupAddress);

        serverSocket.close();
    }

}
