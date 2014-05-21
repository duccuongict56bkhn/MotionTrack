/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motiontrack;

import java.util.Random;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Garena
 */
public class FXMLRoundSceneController {
    @FXML
    private AnchorPane backgroundAnchorPane;
    
    @FXML
    private ImageView wheel;
    
    /* Wheel background Image*/
    private Image img = new Image(getClass().getResource("/resources/Wheel.png").toExternalForm());
    
    @FXML
    public void initialize() {
        wheel.setImage(img);
//        wheel.addEventHandler(ActionEvent.ACTION, new WheelBoundingInParentChangeListener());
    }   
    
    @FXML
    private void rotateWheel(MouseEvent mv) {
        rotate(1355,5);
    }
    
    public void rotate(double angle, double duration) {
        RotateTransition rt = new RotateTransition();
        rt.setNode(wheel);
        rt.setByAngle(angle);
        rt.setDuration(Duration.seconds(duration));
        rt.setCycleCount(1);
        rt.setAutoReverse(false);
        rt.setInterpolator(Interpolator.EASE_OUT);
        rt.play();
        
        rt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                wheelBoundingBox();
            }
        });
    }
    
    public void wheelBoundingBox() {
        double MX = wheel.getBoundsInParent().getMaxX();
        double MY = wheel.getBoundsInParent().getMaxY();
        double mX = wheel.getBoundsInParent().getMinX();
        double mY = wheel.getBoundsInParent().getMinY();
        double depth = wheel.getBoundsInParent().getDepth();
        
//        double width = Math.abs(MX - mX);
//        double height = Math.abs(MY - mY);
        double width = MX - mX;
        double height = MY - mY;
        
//        Color[] colors = new Color[5];
//        colors[0] = new Color (255,255,255);
//        colors[1] = Color.RED;
//        colors[2] = Color.GREEN;
//        colors[3] = Color.BLACK;
//        colors[40] = Color.WHITE;
        
        Rectangle bb = new Rectangle(mX, mY, Color.TRANSPARENT);
        bb.setWidth(width);
        bb.setHeight(height);
        bb.setStroke(Color.WHITE);
        bb.setStrokeWidth(1);
        
        backgroundAnchorPane.getChildren().add(bb);
    }
    
    public void drawBoundingRectangle() {
        final Rectangle rect = new Rectangle(0,0, Color.TRANSPARENT);
        rect.setStroke(Color.ORANGE);
        rect.setManaged(false);
        wheel.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> observable,
                    Bounds oldValue, Bounds newValue) {
                rect.setLayoutX(wheel.getBoundsInParent().getMinX());
                rect.setLayoutY(wheel.getBoundsInParent().getMinY());
                rect.setWidth(wheel.getBoundsInParent().getWidth());
                rect.setHeight(wheel.getBoundsInParent().getHeight());
            }
        });
        backgroundAnchorPane.getChildren().add(rect);
    }
    
    private int randNum(int max) {
        Random ran = new Random();
        int x = ran.nextInt(max);
        
        return x;
    }
    
    class WheelBoundingInParentChangeListener implements EventHandler<Event> {
        @Override
        public void handle(Event me) {
            System.out.println("Can listener to action event changed!");
        }
    }
}

