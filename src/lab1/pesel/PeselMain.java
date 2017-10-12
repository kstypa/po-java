package lab1.pesel;

import lab1.javaIn.JIn;

public class PeselMain {
    public static void main(String[] argv) {
        System.out.println("Podaj numer PESEL:");
        String pesel = JIn.getString();
        if(Pesel.check(pesel)) {
            Pesel pesel1 = new Pesel(pesel);
            System.out.println("Numer PESEL poprawny");
            System.out.println("Zapisano numer PESEL: " + pesel1.get_pesel());
        }
        else
            System.out.println("Numer PESEL niepoprawny - nie zapisano");
    }
}
