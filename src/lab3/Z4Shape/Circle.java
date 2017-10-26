package lab3.Z4Shape;

public class Circle extends Shape{
    public Circle() {
        super();
    }

    public Circle(double size) {
        super(size);
    }

    @Override
    public void draw() {
        System.out.println("To jest koło o rozmiarze " + size);
    }
}
