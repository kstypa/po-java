package lab4.zad3ListSorting;

public class PracownikEtatowy extends Pracownik{
    public PracownikEtatowy(double salary, String pesel) {
        super(salary, pesel);
    }

    @Override
    public double ObliczNetto() {
        return 0.75 * wynagrodzenieBrutto;
    }
}
