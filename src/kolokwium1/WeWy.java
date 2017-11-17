package kolokwium1;

import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;

public class WeWy {
    public static Stack<Operator> pobierzDzialanie(String dzialanie) {
        Stack<Operator> stack = new Stack<>();

        Scanner scanner = new Scanner(dzialanie);
        while(scanner.hasNext()) {
            String s = scanner.next();
            switch (s) {
                case "!": {
                    Operator operator = new Silnia(s);
                    stack.push(operator);
                    break;
                }
                case "+": {
                    Operator operator = new Dodawanie(s);
                    stack.push(operator);
                    break;
                }
                case "*": {
                    Operator operator = new Mnozenie(s);
                    stack.push(operator);
                    break;
                }
                case "/": {
                    Operator operator = new Dzielenie(s);
                    stack.push(operator);
                    break;
                }
                default:
                    boolean isNumber = true;
                    for (int i = 0; i < s.length(); ++i) {
                        if (!Character.isDigit(s.charAt(i))) {
                            isNumber = false;
                            break;
                        }
                    }
                    if (isNumber) {
                        Operator operator = new Stala(s);
                        stack.push(operator);
                    }
                    break;
            }
        }
        return stack;
    }

    public static void zapiszWynik(Double v) {
        System.out.println(v);
    }
}
