package ar.com.carloscurotto.distributed.communication.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {

        Socket clientSocket = new Socket("localhost", 6789);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
                        clientSocket.getInputStream()));

        String sent = "data";
        outToServer.writeBytes(sent + '\n');

        String received = inFromServer.readLine();

        System.out.println("Received: " + received);

        clientSocket.close();
    }

}
