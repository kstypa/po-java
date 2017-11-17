package kolokwium1;

import java.util.Stack;

public class Silnia extends Operator1Arg {
    public Silnia(String wartosc) {
        super(wartosc);
    }

    @Override
    public double oblicz(Stack<Operator> s) {
        return fact(Integer.parseInt(s.pop().getWartosc()));
    }

    private int fact(int n) {
        if(n == 0)
            return 1;
        return n * fact(n-1);
    }
}
