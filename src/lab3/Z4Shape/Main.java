package lab3.Z4Shape;

import java.util.LinkedList;
import lab1.javaIn.*;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        Shape circle = new Circle();
        Shape triangle = new Triangle();

        LinkedList<Shape> list = new LinkedList<>();
        list.add(square);
        list.add(circle);
        list.add(triangle);
        list.get(0).draw();

        list.add(new Square(3.0));


        /*
        System.out.println("1 - wyświetl element listy");
        System.out.println("2 - dodaj nowy element");
        int option = JIn.getInt();
        if(option == 1) {
            System.out.println("Podaj indeks elementu - obecnie " + list.size() + " elementów w liście");
            int index = JIn.getInt();
            list.get(index).draw();
        }
        else if(option == 2) {
            System.out.println("1 - kwadrat");
            System.out.println("2 - koło");
            System.out.println("3 - trójkąt");
            int shape = JIn.getInt();
            if(shape == 1) {
                list.add(new Square());
                System.out.println("Dodano kwadrat");
            }
            else if(shape == 2) {
                list.add(new Circle());
                System.out.println("Dodano koło");
            }
            else if(shape == 3) {
                list.add(new Triangle());
                System.out.println("Dodano trójkąt");
            }
        }
        */
    }
}
