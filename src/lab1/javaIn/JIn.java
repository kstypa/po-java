package lab1.javaIn;

import java.io.*;

public class JIn {
    public static String getString() {
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}
        return text;
    }

    public static int getInt() {
        int x = 0;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            x = Integer.parseInt(bfr.readLine());
        }catch(IOException e){e.printStackTrace();}
        return x;
    }
}