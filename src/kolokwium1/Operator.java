package kolokwium1;

public abstract class Operator implements Obliczanie {
    protected String wartosc;

    public Operator(String wartosc) {
        this.wartosc = wartosc;
    }

    public String getWartosc() {
        return wartosc;
    }
}
