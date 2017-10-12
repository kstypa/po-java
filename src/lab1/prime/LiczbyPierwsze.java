package lab1.prime;

import java.util.Vector;

public class LiczbyPierwsze {
    public static Vector<Boolean> ZnajdzPierwsze(int n) {
        Vector<Boolean> IsPrime = new Vector<>();
        IsPrime.add(false);
        IsPrime.add(false);
        for(int i = 0; i < n-1; i++)
           IsPrime.add(true);
        for(int j = 2; j < Math.ceil(Math.sqrt(n)); j++)
            if(IsPrime.elementAt(j)) {
                int k = j+j;
                while(k <= n) {
                    IsPrime.set(k, false);
                    k += j;
                }
            }
        return IsPrime;
    }
}
