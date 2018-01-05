package lab9.echoServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SockReader implements Runnable {
    private PrintWriter out;
    private Scanner in;
    private Socket socket;

    public SockReader(Socket s) throws IOException {
        this(s.getOutputStream(), s.getInputStream());
        socket = s;
    }

    public SockReader(OutputStream out, InputStream in) {
        this.out = new PrintWriter(out, true);
        this.in = new Scanner(in);
    }

    @Override
    public void run() {
        while( (!Thread.currentThread().isInterrupted()) && in.hasNextLine() ) {
            String line = in.nextLine();
            System.out.println(line);
            out.println(line);
        }
        try {
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
