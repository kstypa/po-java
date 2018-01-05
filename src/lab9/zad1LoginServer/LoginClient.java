package lab9.zad1LoginServer;

import java.io.*;
import java.net.*;

public class LoginClient {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        login(out, in);

        password(out, in);




        out.close();
        in.close();
        echoSocket.close();
    }

    private static void login(PrintWriter out, BufferedReader in) throws IOException {
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;
        String serverResponse;
        System.out.println("Enter login: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            serverResponse = in.readLine();
            System.out.println("server response: " + serverResponse);
            if(serverResponse.equals("!@#LOGIN_CORRECT"))
                break;
            System.out.println("Enter login: ");
        }
        stdIn.close();
    }

    private static void password(PrintWriter out, BufferedReader in) throws IOException {
        String password;
        String oldPassword;
        String serverResponse;
        int trueDistance;
        int counter = 1;
        BufferedReader fileReader = new BufferedReader(new FileReader("/home/karol/java/po-java/src/lab9/zad1LoginServer/polish-dic.txt"));
        password = fileReader.readLine();
        while (true) {
            out.println(password);
            serverResponse = in.readLine();
            if(serverResponse.equals("!@#PASSWORD_CORRECT")) {
                System.out.println(password);
                System.out.println(counter);
                break;
            }
            System.out.println("Levenshtein distance: " + serverResponse);
            ++counter;
            trueDistance = Integer.parseInt(serverResponse);
            oldPassword = password;
            while (true) {
                password = fileReader.readLine();
                if(Levenshtein.levenshtein(password, oldPassword) == trueDistance)
                    break;
            }
        }
        fileReader.close();
    }
}