package lab4.zad3ListSorting;

import lab1.pesel.Pesel;

public abstract class Pracownik {
    protected Pesel pesel;
    protected double wynagrodzenieBrutto;

    public Pracownik(double salary, String pesel) {
        wynagrodzenieBrutto = salary;
        this.pesel = new Pesel(pesel);
    }

    public String getPesel() {
        return pesel.get_pesel();
    }

    public double getSalary() {
        return wynagrodzenieBrutto;
    }

    public abstract double ObliczNetto();
}
