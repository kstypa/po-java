package kolokwium1;

import java.util.Stack;

public class Stala extends Operator0Arg {
    public Stala(String wartosc) {
        super(wartosc);
    }

    @Override
    public double oblicz(Stack<Operator> s) {
        return Double.parseDouble(getWartosc());
    }
}
