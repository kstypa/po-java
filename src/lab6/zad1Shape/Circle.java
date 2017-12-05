package lab6.zad1Shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Circle implements Shape {
    public Object draw(){
        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(300, 200, 50);

        circle.setFill(Color.MEDIUMVIOLETRED);
        return circle;
    }
}
