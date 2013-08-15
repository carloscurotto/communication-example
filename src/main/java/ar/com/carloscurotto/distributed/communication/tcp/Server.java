package ar.com.carloscurotto.distributed.communication.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(6789);

        Socket clientSocket = serverSocket.accept();

        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(
                        clientSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

        String received = inFromClient.readLine();

        System.out.println("Received: " + received);

        String sent = received.toUpperCase() + '\n';
        outToClient.writeBytes(sent);

        clientSocket.close();

        serverSocket.close();
    }

}
