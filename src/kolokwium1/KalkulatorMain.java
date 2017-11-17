package kolokwium1;

import java.util.Scanner;
import java.util.Stack;

public class KalkulatorMain {
    public static void main(String[] args) {
        String dzialanie = "";
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) {
            dzialanie = scanner.nextLine();
        }
        Stack<Operator> obliczenia = WeWy.pobierzDzialanie(dzialanie);
    }
}
