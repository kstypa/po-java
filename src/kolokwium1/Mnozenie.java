package kolokwium1;

import java.util.Stack;

public class Mnozenie extends Operator2Arg {
    public Mnozenie(String wartosc) {
        super(wartosc);
    }

    @Override
    public double oblicz(Stack<Operator> s) {
        double a = Double.parseDouble(s.pop().getWartosc());
        double b = Double.parseDouble(s.pop().getWartosc());
        return a * b;
    }
}
