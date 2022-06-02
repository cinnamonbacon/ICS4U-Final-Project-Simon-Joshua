import javafx.scene.shape.Shape;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.Group;
import javafx.scene.Scene;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfrontationScene {
    
    private ImageView backgroundImageView;
    
    private ImageView char1;
    
    private ImageView char2;
    
    private GameButton topLeftButton;
    
    private GameButton bottomLeftButton;
    
    private GameButton topRightButton;
    
    private GameButton bottomRightButton;
    
    private Ellipse closePlat;
    
    private Ellipse farPlat;
    
    private double char1HealthBarLen;
    
    private double char2HealthBarLen;
    
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, ImageView char1, ImageView char2, GameButton topLeftButton, GameButton bottomLeftButton, GameButton topRightButton, GameButton bottomRightButton, String closeEllipsePaint, String farEllipsePaint, boolean setHealth, double healthChar1, double healthChar2) {
        this.backgroundImageView = backgroundImageView;
        this.backgroundImageView.setPreserveRatio(true);
        this.backgroundImageView.setSmooth(true);
        this.backgroundImageView.setX(0);
        this.backgroundImageView.setY(0);
        this.backgroundImageView.setFitWidth(600);

        this.char1 = char1;
        this.char2 = char2;
        
        this.topLeftButton = topLeftButton;
        this.topLeftButton.setXCoord(0.0);
        this.topLeftButton.setYCoord(0.0);
        
        this.bottomLeftButton = bottomLeftButton;
        this.bottomLeftButton.setXCoord(0.0);
        this.bottomLeftButton.setYCoord(0.0);
        
        this.topRightButton = topRightButton;
        this.topRightButton.setXCoord(0.0);
        this.topRightButton.setYCoord(0.0);
        
        this.bottomRightButton = bottomRightButton;
        this.bottomRightButton.setXCoord(0.0);
        this.bottomRightButton.setYCoord(0.0);
        
        this.createBackground(closeEllipsePaint, farEllipsePaint);
    }
    
    private void createBackground(String closeEllipsePaint, String farEllipsePaint) {
        Ellipse closeCharPlat = new Ellipse (150, 350, 120, 30);
        closeCharPlat.setFill(Paint.valueOf(closeEllipsePaint));
        closeCharPlat.setStyle(
            "-fx-background-radius: 10; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 20);"
        );
        closeCharPlat.setStroke(Paint.valueOf("black"));
        closeCharPlat.setStrokeWidth(2.0);
        //closeCharPlat.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 25);");
        this.closePlat = closeCharPlat;
        
        Ellipse farCharPlat = new Ellipse (450, 225, 120, 30);
        farCharPlat.setFill(Paint.valueOf(farEllipsePaint));
        farCharPlat.setStyle(
            "-fx-background-radius: 10; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 20);"
        );
        farCharPlat.setStroke(Paint.valueOf("black"));
        farCharPlat.setStrokeWidth(2.0);
        //farCharPlat.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 25);");
        this.farPlat = farCharPlat;
    }
    
    private Font getFontFromFile(File fontFile, double fontSize) {
        Font fontFont = new Font(1); // It doesn't matter what size font I put, so I will default it to 1.
        try {
            FileInputStream fontFIS = new FileInputStream(fontFile);
            fontFont = Font.loadFont(fontFIS, fontSize);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return fontFont;
    }
    
    private void setChar1HealthBarLen(double amtTo) {
        
    }
    
    public Scene getScene() {
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            this.backgroundImageView,
            this.farPlat,
            this.closePlat,
            this.char2,
            this.char1,
            this.bottomRightButton.getButton(),
            this.topRightButton.getButton(),
            this.bottomLeftButton.getButton(),
            this.topLeftButton.getButton()
        );
        
        Scene scene = new Scene(nodesToAdd, 600, 600);
        return scene;
    }
    
}
