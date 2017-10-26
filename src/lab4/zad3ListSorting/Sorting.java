package lab4.zad3ListSorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Sorting {
    public static LinkedList SortList(LinkedList<Pracownik> list) {
        list.sort(Comparator.comparingDouble(p -> p.getSalary()));
        return list;
    }

    public static void main(String[] args) {
        //test
        LinkedList<Pracownik> list = new LinkedList<>();
        list.add(new PracownikEtatowy(2000, "0"));
        list.add(new PracownikEtatowy(1000, "0"));
        list.add(new PracownikEtatowy(3000, "0"));
        for(Pracownik n : list)
            System.out.println(n.getSalary());

        SortList(list);
        for(Pracownik n : list)
            System.out.println(n.getSalary());

    }
}
