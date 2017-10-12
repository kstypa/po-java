package lab1.pesel;

import java.util.Vector;

public class Pesel {
    private String _pesel;

    public Pesel(String pesel) {
        _pesel = pesel;
    }

    public String get_pesel() {
        return _pesel;
    }

    public static Boolean check(String pesel) {
        if(pesel.length() != 11)
            return false;
        for(int i = 0; i < pesel.length(); i++)
            if(!Character.isDigit(pesel.charAt(i)))
                return false;

        int a = 0;
        int[] multipliers = {9, 7, 3, 1};
        for(int j = 0; j < 10; j++)
            a += multipliers[j % 4] * (pesel.charAt(j) - 48);
        return a % 10 == pesel.charAt(10) - 48;
    }
}
