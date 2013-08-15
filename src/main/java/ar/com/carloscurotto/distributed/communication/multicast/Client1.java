package ar.com.carloscurotto.distributed.communication.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client1 {

    public static void main(String[] args) throws Exception {

        int clientPort = 33000;
        String groupIP = "239.1.54.52";

        InetAddress groupAddress = InetAddress.getByName(groupIP);

        MulticastSocket clientSocket = new MulticastSocket(clientPort);
        clientSocket.joinGroup(groupAddress);

        byte[] serverBuffer = new byte[256];
        DatagramPacket serverPacket = new DatagramPacket(serverBuffer, serverBuffer.length);

        clientSocket.receive(serverPacket);

        String received = new String(serverPacket.getData(), 0, serverPacket.getLength());
        System.out.println("Received: " + received);

        clientSocket.leaveGroup(groupAddress);

        clientSocket.close();
    }

}
