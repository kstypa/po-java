package lab9.zad1LoginServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class LoginSockReader implements Runnable {
    private PrintWriter out;
    private Scanner in;
    private Socket socket;

    public LoginSockReader(Socket s) throws IOException {
        this(s.getOutputStream(), s.getInputStream());
        socket = s;
    }

    public LoginSockReader(OutputStream out, InputStream in) {
        this.out = new PrintWriter(out, true);
        this.in = new Scanner(in);
    }

    @Override
    public void run() {
        try {
            checkLogin(out, in);
            checkPassword(out, in);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkLogin(PrintWriter out, Scanner in) throws IOException {
        String inputLine;
        while ((inputLine = in.nextLine()) != null) {
            if(inputLine.equals("login")) {
                out.println("!@#LOGIN_CORRECT");
                break;
            }
            else
                out.println("!@#LOGIN_INCORRECT");
        }
    }

    private static void checkPassword(PrintWriter out, Scanner in) throws IOException {
        String inputLine;
        String password = "dośrodkowujący/Xxbg";
        while ((inputLine = in.nextLine()) != null) {
            if(inputLine.equals(password)) {
                out.println("!@#PASSWORD_CORRECT");
                break;
            }
            else
                out.println(Levenshtein.levenshtein(inputLine, password));
        }
    }
}
