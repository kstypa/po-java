package lab3.Z4Shape;

public class Square extends Shape {
    public Square() {
        super();
    }

    public Square(double size) {
        super(size);
    }

    @Override
    public void draw() {
        System.out.println("To jest kwadrat o rozmiarze " + size);
    }
}
