package lab4.zad3ListSorting;

import java.util.LinkedList;

public class Kadry {
    private LinkedList<Pracownik> employeeList;

    public void AddEmployee(double salary, String pesel) {
        employeeList.add(new PracownikEtatowy(salary, pesel));
    }

    public void AddStudent(double salary, String pesel) {
        employeeList.add(new Student(salary, pesel));
    }

    //WIP
}
