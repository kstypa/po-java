package lab6.zad1Shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Square implements Shape {
    public Object draw(){
        Rectangle rect = new Rectangle(250, 150, 100, 100);

        rect.setFill(Color.BLUE);
        return rect;
    }
}