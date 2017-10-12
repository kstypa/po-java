package lab1.prime;

import lab1.javaIn.*;

import java.util.Vector;

public class LiczbyPierwszeMain {
    public static void main(String[] argv) {
        System.out.println("Podaj górną granicę zakresu szukania liczb pierwszych:");
        int x = JIn.getInt();
        Vector<Boolean> numbers = LiczbyPierwsze.ZnajdzPierwsze(x);
        for(int i = 0; i < numbers.size(); i++)
            if(numbers.elementAt(i))
                System.out.println(i);
    }
}
