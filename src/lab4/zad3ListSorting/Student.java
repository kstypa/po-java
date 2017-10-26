package lab4.zad3ListSorting;

public class Student extends Pracownik {
    public Student(double salary, String pesel) {
        super(salary, pesel);
    }

    @Override
    public double ObliczNetto() {
        return 0.9 * wynagrodzenieBrutto;
    }
}
