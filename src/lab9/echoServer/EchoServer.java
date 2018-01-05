package lab9.echoServer;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        short port = 6666;
        ExecutorService services = Executors.newFixedThreadPool(100);

        try {
            serverSocket = new ServerSocket(port);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket.getInetAddress());
                services.submit(new SockReader(clientSocket));
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        serverSocket.close();

    }
}