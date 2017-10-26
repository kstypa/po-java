package lab3.Z4Shape;

public abstract class Shape {
    public String name;
    public double size;

    public Shape() {
        this.size = 1;
    }

    public Shape(double size) {
        this.size = size;
    }

    public abstract void draw();
}
