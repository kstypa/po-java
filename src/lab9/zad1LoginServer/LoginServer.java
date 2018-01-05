package lab9.zad1LoginServer;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        ExecutorService services = Executors.newFixedThreadPool(100);
        try {
            serverSocket = new ServerSocket(6666);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket.getInetAddress());
                services.submit(new LoginSockReader(clientSocket));
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }


        serverSocket.close();

    }
}