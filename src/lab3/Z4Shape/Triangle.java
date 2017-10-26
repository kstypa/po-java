package lab3.Z4Shape;

public class Triangle extends Shape{
    public Triangle() {
        super();
    }

    public Triangle(double size) {
        super(size);
    }

    @Override
    public void draw() {
        System.out.println("To jest trójkąt  o rozmiarze " + size);
    }
}
