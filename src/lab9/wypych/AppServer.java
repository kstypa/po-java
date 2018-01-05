package lab9.wypych;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AppServer {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        //port musi być przekazany jako argument do programu
//        short port = Short.parseShort(args[0]);
        short port = 6666;
        //rozpoczęcie nasłuchiwania na porcie port,
        try(ServerSocket srv = new ServerSocket(port)){
            //przyjęcie nadchodzącego połączenia
            while(true) {
                Socket s = srv.accept();
                System.out.print("new connection accepted: ");
                System.out.println(s.getInetAddress());
                new Thread(new SockReader(s)).start();
            }

        }
    }
}

class SockReader implements Runnable {
    private Scanner in;
    private PrintStream out;
    private Socket s;

    public SockReader(Socket s) throws IOException {
        this(s.getInputStream(),s.getOutputStream());
        this.s = s;
    }

    public SockReader(InputStream input,OutputStream output) {
        in = new Scanner(input);
        out = new PrintStream(output);
    }

    private void msg(String msg) {
        System.out.print("SRV: ");
        System.out.println(msg);
    }
    public void run() {
        msg("new connection");
        while( (!Thread.currentThread().isInterrupted()) && in.hasNext() ) {
            String line = in.nextLine();
            msg(line);
            out.println(line);
        }
        try {
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg("connection closed");
    }
}