package lab4.zad4Algorithm;

import java.io.*;

public class Cryptographer {
    public static void encryptFile(File input, File output, Algorithm algorithm) {
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(input));
            writer = new PrintWriter(output);
            String text = null;
            String encrypted = null;

            while ((text = reader.readLine()) != null) {
                encrypted = algorithm.encrypt(text);
                writer.println(encrypted);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
            } catch (IOException e) {}
        }
    }

    public static void decryptFile(File input, File output, Algorithm algorithm) {

    }
}
