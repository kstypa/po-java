package lab6.zad1Shape;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ShapesMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Shape shape1 = new Square();
        Shape shape2 = new Circle();

//        javafx.scene.shape.Shape rectangle = (javafx.scene.shape.Shape) shape1.draw();
        javafx.scene.shape.Shape circle = (javafx.scene.shape.Shape) shape2.draw();
        Group group = new Group( circle);
//        javafx.scene.shape.Shape activeShape = circle;

        Scene scene = new Scene(group, 600, 400);
        moveShapeOnMouseEvent(scene, circle);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveShapeOnMouseEvent(Scene scene, javafx.scene.shape.Shape shape) {
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shape.setLayoutX(event.getX() - shape.getLayoutBounds().getMinX() - 50);
                shape.setLayoutY(event.getY() - shape.getLayoutBounds().getMinY() - 50);
            }
        });
    }

//    private javafx.scene.shape.Shape moveShapeOnKeyPress(Scene scene, javafx.scene.shape.Shape rectangle, javafx.scene.shape.Shape circle) {
//        javafx.scene.shape.Shape
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                switch (event.getCode()) {
//                    case RIGHT: return circle; break;
//                    case LEFT:  return rectangle;
//                }
//            }
//        });
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
