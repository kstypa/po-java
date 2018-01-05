package lab9.zad1LoginServer;

import java.io.*;
import java.net.*;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        checkLogin(out, in);
        checkPassword(out, in);

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }

    private static void checkLogin(PrintWriter out, BufferedReader in) throws IOException {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if(inputLine.equals("login")) {
                out.println("!@#LOGIN_CORRECT");
                break;
            }
            else
                out.println("!@#LOGIN_INCORRECT");
        }
    }

    private static void checkPassword(PrintWriter out, BufferedReader in) throws IOException {
        String inputLine;
        String password = "dośrodkowujący/Xxbg";
        while ((inputLine = in.readLine()) != null) {
            if(inputLine.equals(password)) {
                out.println("!@#PASSWORD_CORRECT");
                break;
            }
            else
                out.println(Levenshtein.levenshtein(inputLine, password));
        }
    }
}