/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wheel;

import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Garena
 */
public class WheelRegion extends ImageView {
    public static final int WIDTH = 402;
    public static final int HEIGHT = 402;
    private Image img;
    
    public WheelRegion(){
        super();
        this.setPreserveRatio(true);
        this.setFitWidth(WIDTH);
        this.setFitHeight(HEIGHT);
        this.setPreserveRatio(true);
        this.setSmooth(true);
    }
    
    public WheelRegion(Image imgSrc) {
        super();
        
        this.img = imgSrc;
        this.setPreserveRatio(true);
        this.setFitWidth(WIDTH);
        this.setFitHeight(HEIGHT);
        this.setPreserveRatio(true);
        this.setSmooth(true);
        this.setImage(img);
    }
    
    public void normalizeProperties() {
        this.setFitWidth(WIDTH);
        this.setFitHeight(HEIGHT);
        this.setPreserveRatio(true);
        this.setSmooth(true);
    }
    
}
