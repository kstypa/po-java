package lab3.z1final;

import java.util.LinkedList;

public class Z1Final {
    public static void ChangeDouble(final double var) {
        //var = 10;
    }

    public static void AddToList(final LinkedList<Double> list) {
        list.add(10.0);
    }

    public static void main(String[] argv) {
        double var = 5;
        LinkedList<Double> list = new LinkedList<>();
        list.add(5.0);

        ChangeDouble(var);
        AddToList(list);
    }
}
