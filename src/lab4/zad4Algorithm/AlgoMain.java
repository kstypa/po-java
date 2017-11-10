package lab4.zad4Algorithm;

import java.io.File;
import lab1.javaIn.*;

public class AlgoMain {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Nie podano plików wejścia/wyjścia");
            System.exit(1);
        }

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        int mode = 0, algorithm = 0;
        do {
            System.out.println("1 - szyfruj, 2 - odszyfruj");
            mode = JIn.getInt();
        } while (!(mode == 1 || mode == 2));
        do {
            System.out.println("1 - ROT11, 2 - algorytm Polibiusza");
            algorithm = JIn.getInt();
        } while (!(algorithm == 1 || algorithm == 2));

        if(mode == 1) {
            if(algorithm == 1) {
                ROT11 rot11 = new ROT11();
                Cryptographer.encryptFile(inputFile, outputFile, rot11);
            }
            else if(algorithm == 2) {
                Polybius polybius = new Polybius();
                Cryptographer.encryptFile(inputFile, outputFile, polybius);
            }
        }
        else if(mode == 2) {
            if(algorithm == 1) {
                ROT11 rot11 = new ROT11();
                Cryptographer.decryptFile(inputFile, outputFile, rot11);
            }
            else if(algorithm == 2) {
                Polybius polybius = new Polybius();
                Cryptographer.decryptFile(inputFile, outputFile, polybius);
            }
        }
    }
}
