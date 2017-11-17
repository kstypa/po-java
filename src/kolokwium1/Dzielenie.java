package kolokwium1;

import java.util.Stack;

public class Dzielenie extends Operator2Arg {
    public Dzielenie(String wartosc) {
        super(wartosc);
    }

    @Override
    public double oblicz(Stack<Operator> s) throws DivisionByZeroException {
        double a = Double.parseDouble(s.pop().getWartosc());
        double b = Double.parseDouble(s.pop().getWartosc());
        if(b == 0)
            throw new DivisionByZeroException();
        return a / b;
    }
}
