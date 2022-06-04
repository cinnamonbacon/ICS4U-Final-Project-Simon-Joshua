import javafx.scene.shape.Shape; // Imports the Shape.java class, which allows the program to create shapes.
import javafx.scene.image.ImageView; // Imports the ImageView.java class, which allows the program to ImageView objects which are images that can be added to scenes and such (as they are just have the Image.java class functionality but also extend the very useful Node.java class).
import javafx.scene.shape.Ellipse; // Imports the Ellipse.java class, which allows the program to create ellipse shapes.
import javafx.scene.text.Text; // Imports the Text.java class, which allows the program to beautiful text to display to the user.
import javafx.scene.text.TextFlow; // Imports the TextFlow.java class, which allows the program to layout instances of the Text.java class using a TextFlow instance.
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create Paint instances and set various colours.
import javafx.scene.text.Font; // Imports the Font.java class, which allows the program to create and use different fonts.
import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create rectangles.
import javafx.scene.input.MouseEvent; // Imports the MouseEvent.java class, which allows the program to act on various events that occur with the mouse, such as moving the mouse or clicking it.
import javafx.scene.Cursor; // Imports the Cursor.java class, which allows the program to gain access over the design of the cursor (allows it to change the cursor design over buttons to make them look more like buttons and act like them too).
import javafx.scene.Group; // Imports the Group.java class, which allows the program to combing various nodes together so that they can be added to the Scene that is returned.
import javafx.scene.Scene; // Imports the Scene.java class, which allows the program to return ta scene that the MainApplication.java class will use.

import java.io.File; // Imports the File.java class, which allows the program to access files on the computer, such as images.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to easily read in data from certain files.
import java.io.IOException; // Imports the IOException.java class, which allows the program to deal with and catch any errors thrown during reading of IO.

/**
 * Program to create a scene that displayes a confrontation.
 * <p>
 * This class will be used to create a confrontation scene
 * that shoows a face-off between two characters.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: to create confrontation scenes.
 * <p>
 * Filename: ConfrontationScene.java
 *
 * @author Simon Bakan
 * @author Joshua Persaud
 * @version 5/27/2022
 * 
 * @see javafx.scene.shape.Shape
 * @see javafx.scene.image.ImageView
 * @see javafx.scene.shape.Ellipse
 * @see javafx.scene.text.Text
 * @see javafx.scene.text.TextFlow
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.text.Font
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.input.MouseEvent
 * @see javafx.scene.Cursor
 * @see javafx.scene.Group
 * @see javafx.scene.Scene
 * @see java.io.File
 * @see java.io.FileInputStream
 * @see java.io.IOException
 *
 * @since JDK1.17
 */

public class ConfrontationScene {
    /** Private non-static File variable that will hold onto the file that stores the font to be used in the confrontation scene. */
    private File fontFile;

    /** Private non-static ImageView variable that will hold onto the background of the confrontation scene. */
    private ImageView backgroundImageView;
    
    /** Private non-static Ellipse variable that will hold onto the ellipse that is used as a platform for the closer character. */
    private Ellipse closeCharPlat;
    
    /** Private non-static Ellipse variable that will hold onto the ellipse that is used as a platform for the farther character. */
    private Ellipse farCharPlat;
    
    /** Private non-static ImageView variable that will hold onto the image that is used for the first character. */
    private ImageView char1;
    
    /** Private non-static ImageView variable that will hold onto the image that is used for the second character. */
    private ImageView char2;
    
    /** Private non-static Rectangle variable that will hold onto the rectangle that is used at the bottom of the scene. */
    private Rectangle bottomRectangle;
    
    /** Private non-static GameButton variable that will hold onto the game button that is used for the top left of the lower rectangle. */
    private GameButton topLeftButton;
    
    /** Private non-static GameButton variable that will hold onto the game button that is used for the bottom left of the lower rectangle. */
    private GameButton bottomLeftButton;
    
    /** Private non-static GameButton variable that will hold onto the game button that is used for the top right of the lower rectangle. */
    private GameButton topRightButton;
    
    /** Private non-static GameButton variable that will hold onto the game button that is used for the bottom right of the lower rectangle. */
    private GameButton bottomRightButton;
    
    /** Private non-static double variable that will hold onto the amount of health for the first character (as a percentage out of 100). */
    private double char1HealthBar;
    
    /** Private non-static Rectangle variable that will hold onto the front rectangle that is used to show the first character's health. */
    private Rectangle char1HealthBarForeground;
    
    /** Private non-static Rectangle variable that will hold onto the back rectangle that is used to show the first character's health. */
    private Rectangle char1HealthBarBackground;
    
    /** Private non-static double variable that will hold onto the amount of health for the second character (as a percentage out of 100). */
    private double char2HealthBar;
    
    /** Private non-static Rectangle variable that will hold onto the front rectangle that is used to show the second character's health. */
    private Rectangle char2HealthBarForeground;
    
    /** Private non-static Rectangle variable that will hold onto the back rectangle that is used to show the second character's health. */
    private Rectangle char2HealthBarBackground;
    
    /** Private non-static Text variable that will hold onto the text that will be used for the title. */
    private Text title;
    
    /** Private non-static Text variable that will hold onto the text that will be used for the body (the text underneath the title). */
    private Text body;
    
    /**
     * An instance of the ConfrontationScene.java class will be created using this constructor. It will create a scene with one title, two buttons, and no health bars.
     * 
     * @param fontFile The File that stores the font used for the confrontation scene.
     * @param backgroundImageView The ImageView that stores the background image.
     * @param closeCharPlat The Ellipse for the platform for the closer character.
     * @param farCharPlat The Ellipse for the platform for the farther character.
     * @param char1 The ImageView that stores the image for the first character (the closer one).
     * @param char2 The ImageView that stores the image for the second character (the farther one).
     * @param bottomRectangle The Rectangle that will be used on the bottom of the scene.
     * @param title The Text that will be the title for the scene.
     * @param topLeftButton The GameButton that will be used for the top left button.
     * @param topRightButton The GameButton that will be used for the top right button.
     */
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, Ellipse closeCharPlat, Ellipse farCharPlat, ImageView char1, ImageView char2, Rectangle bottomRectangle, Text title, GameButton topLeftButton, GameButton topRightButton) {
        this(fontFile, backgroundImageView, closeCharPlat, farCharPlat, char1, char2, bottomRectangle, title, topLeftButton, topRightButton, 0, null, null, 0, null, null);
    }
    
    /**
     * An instance of the ConfrontationScene.java class will be created using this constructor. It will create a scene with one title, two buttons, and two health bars.
     * 
     * @param fontFile The File that stores the font used for the confrontation scene.
     * @param backgroundImageView The ImageView that stores the background image.
     * @param closeCharPlat The Ellipse for the platform for the closer character.
     * @param farCharPlat The Ellipse for the platform for the farther character.
     * @param char1 The ImageView that stores the image for the first character (the closer one).
     * @param char2 The ImageView that stores the image for the second character (the farther one).
     * @param bottomRectangle The Rectangle that will be used on the bottom of the scene.
     * @param title The Text that will be the title for the scene.
     * @param topLeftButton The GameButton that will be used for the top left button.
     * @param topRightButton The GameButton that will be used for the top right button.
     * @param char1HealthBar The double that will hold onto the amount of health in the first character.
     * @param char1HealthBarForeground The Rectangle that will be the front rectangle for the first character's health bar.
     * @param char1HealthBarBackground The Rectangle that will be the back rectangle for the first character's health bar.
     * @param char2HealthBar The double that will hold onto the amount of health in the second character.
     * @param char2HealthBarForeground The Rectangle that will be the front rectangle for the second character's health bar.
     * @param char2HealthBarBackground The Rectangle that will be the back rectangle for the second character's health bar.
     */
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, Ellipse closeCharPlat, Ellipse farCharPlat, ImageView char1, ImageView char2, Rectangle bottomRectangle, Text title, GameButton topLeftButton, GameButton topRightButton, double char1HealthBar, Rectangle char1HealthBarForeground, Rectangle char1HealthBarBackground, double char2HealthBar, Rectangle char2HealthBarForeground, Rectangle char2HealthBarBackground) {
        this.fontFile = fontFile;
        
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setSmooth(true);
        backgroundImageView.setX(0);
        backgroundImageView.setY(0);
        backgroundImageView.setFitWidth(600);
        this.backgroundImageView = backgroundImageView;
        
        //Ellipse closeCharPlat = new Ellipse (150, 350, 120, 30);
        closeCharPlat.setCenterX(150);
        closeCharPlat.setCenterY(350);
        closeCharPlat.setRadiusX(120);
        closeCharPlat.setRadiusY(30);
        closeCharPlat.setStyle(
            "-fx-background-radius: 10; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 20);"
        );
        closeCharPlat.setStroke(Paint.valueOf("black"));
        closeCharPlat.setStrokeWidth(2.0);
        //closeCharPlat.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 25);");
        this.closeCharPlat = closeCharPlat;
        
        //Ellipse farCharPlat = new Ellipse (450, 250, 120, 30);
        farCharPlat.setCenterX(450);
        farCharPlat.setCenterY(250);
        farCharPlat.setRadiusX(120);
        farCharPlat.setRadiusY(30);
        farCharPlat.setStyle(
            "-fx-background-radius: 10; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 20);"
        );
        farCharPlat.setStroke(Paint.valueOf("black"));
        farCharPlat.setStrokeWidth(2.0);
        //farCharPlat.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 25);");
        this.farCharPlat = farCharPlat;
            
        char1.setPreserveRatio(true);
        char1.setSmooth(true);
        char1.setX(75);
        char1.setY(150);
        char1.setFitWidth(150);
        this.char1 = char1;
        
        char2.setPreserveRatio(true);
        char2.setSmooth(true);
        char2.setX(387);
        char2.setY(85);
        char2.setFitWidth(126);
        this.char2 = char2;
        
        if (title != null) {
            title.setStyle("-fx-underline: true;");
            title.setX(0);
            title.setY(0);
        } else {
            this.title = null;
        }
        
        if (topLeftButton != null) {
            topLeftButton.setXCoord(35);
            topLeftButton.setYCoord(490);
            topLeftButton.setWidth(260);
            topLeftButton.setHeight(60);
            this.topLeftButton = topLeftButton;
        } else {
            this.topLeftButton = null;
        }
        
        if (topRightButton != null) {
            topRightButton.setXCoord(305);
            topRightButton.setYCoord(490);
            topRightButton.setWidth(260);
            topRightButton.setHeight(60);
            this.topRightButton = topRightButton;
        } else {
            this.topRightButton = null;
        }
        
        bottomRectangle.setWidth(550);
        bottomRectangle.setHeight(150);
        bottomRectangle.setX(25);
        bottomRectangle.setY(425);
        this.bottomRectangle = bottomRectangle;
                
        if (char1HealthBar > 100) char1HealthBar = 100;
        else if (char1HealthBar < 0) char1HealthBar = 0;
        this.char1HealthBar = char1HealthBar;
        
        if (char1HealthBarForeground != null) {
            char1HealthBarForeground.setWidth(250 * (char1HealthBar / 100));
            char1HealthBarForeground.setHeight(25);
            char1HealthBarForeground.setX(25);
            char1HealthBarForeground.setY(110);
            this.char1HealthBarForeground = char1HealthBarForeground;
        } else {
            this.char1HealthBarForeground = null;
        }
        
        if (char1HealthBarBackground != null) {
            char1HealthBarBackground.setWidth(250);
            char1HealthBarBackground.setHeight(25);
            char1HealthBarBackground.setX(25);
            char1HealthBarBackground.setY(110);
            this.char1HealthBarBackground = char1HealthBarBackground;
        } else {
            this.char1HealthBarBackground = null;
        }
        
        if (char2HealthBar > 100) char2HealthBar = 100;
        else if (char2HealthBar < 0) char2HealthBar = 0;
        this.char2HealthBar = char2HealthBar;
        
        if (char2HealthBarForeground != null) {
            char2HealthBarForeground.setWidth(250 * (char2HealthBar / 100));
            char2HealthBarForeground.setHeight(25);
            char2HealthBarForeground.setX(325);
            char2HealthBarForeground.setY(60);
            this.char2HealthBarForeground = char2HealthBarForeground;
        } else {
            this.char2HealthBarForeground = null;
        }
        
        if (char2HealthBarBackground != null) {
            char2HealthBarBackground.setWidth(250);
            char2HealthBarBackground.setHeight(25);
            char2HealthBarBackground.setX(325);
            char2HealthBarBackground.setY(60);
            this.char2HealthBarBackground = char2HealthBarBackground;
        } else {
            this.char2HealthBarBackground = null;
        }
        
        this.bottomLeftButton = null;
        this.bottomRightButton = null;
    }
    
    /**
     * An instance of the ConfrontationScene.java class will be created using this constructor. It will create a scene with one title, one body of text, and no health bars.
     * 
     * @param fontFile The File that stores the font used for the confrontation scene.
     * @param backgroundImageView The ImageView that stores the background image.
     * @param closeCharPlat The Ellipse for the platform for the closer character.
     * @param farCharPlat The Ellipse for the platform for the farther character.
     * @param char1 The ImageView that stores the image for the first character (the closer one).
     * @param char2 The ImageView that stores the image for the second character (the farther one).
     * @param bottomRectangle The Rectangle that will be used on the bottom of the scene.
     * @param title The Text that will be the title for the scene.
     * @param body The Text that will be the body of text for the scene.
     */
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, Ellipse closeCharPlat, Ellipse farCharPlat, ImageView char1, ImageView char2, Rectangle bottomRectangle, Text title, Text body) {
        this(fontFile, backgroundImageView, closeCharPlat, farCharPlat, char1, char2, bottomRectangle, title, body, 0, null, null, 0, null, null);
    }
    
    /**
     * An instance of the ConfrontationScene.java class will be created using this constructor. It will create a scene with one title, one body of text, and two health bars.
     * 
     * @param fontFile The File that stores the font used for the confrontation scene.
     * @param backgroundImageView The ImageView that stores the background image.
     * @param closeCharPlat The Ellipse for the platform for the closer character.
     * @param farCharPlat The Ellipse for the platform for the farther character.
     * @param char1 The ImageView that stores the image for the first character (the closer one).
     * @param char2 The ImageView that stores the image for the second character (the farther one).
     * @param bottomRectangle The Rectangle that will be used on the bottom of the scene.
     * @param title The Text that will be the title for the scene.
     * @param body The Text that will be the body of text for the scene.
     * @param char1HealthBar The double that will hold onto the amount of health in the first character.
     * @param char1HealthBarForeground The Rectangle that will be the front rectangle for the first character's health bar.
     * @param char1HealthBarBackground The Rectangle that will be the back rectangle for the first character's health bar.
     * @param char2HealthBar The double that will hold onto the amount of health in the second character.
     * @param char2HealthBarForeground The Rectangle that will be the front rectangle for the second character's health bar.
     * @param char2HealthBarBackground The Rectangle that will be the back rectangle for the second character's health bar.
     */
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, Ellipse closeCharPlat, Ellipse farCharPlat, ImageView char1, ImageView char2, Rectangle bottomRectangle, Text title, Text body, double char1HealthBar, Rectangle char1HealthBarForeground, Rectangle char1HealthBarBackground, double char2HealthBar, Rectangle char2HealthBarForeground, Rectangle char2HealthBarBackground) {
        this.fontFile = fontFile;
        
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setSmooth(true);
        backgroundImageView.setX(0);
        backgroundImageView.setY(0);
        backgroundImageView.setFitWidth(600);
        this.backgroundImageView = backgroundImageView;
        
        //Ellipse closeCharPlat = new Ellipse (150, 350, 120, 30);
        closeCharPlat.setCenterX(150);
        closeCharPlat.setCenterY(350);
        closeCharPlat.setRadiusX(120);
        closeCharPlat.setRadiusY(30);
        closeCharPlat.setStyle(
            "-fx-background-radius: 10; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 20);"
        );
        closeCharPlat.setStroke(Paint.valueOf("black"));
        closeCharPlat.setStrokeWidth(2.0);
        //closeCharPlat.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 25);");
        this.closeCharPlat = closeCharPlat;
        
        //Ellipse farCharPlat = new Ellipse (450, 250, 120, 30);
        farCharPlat.setCenterX(450);
        farCharPlat.setCenterY(250);
        farCharPlat.setRadiusX(120);
        farCharPlat.setRadiusY(30);
        farCharPlat.setStyle(
            "-fx-background-radius: 10; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 20);"
        );
        farCharPlat.setStroke(Paint.valueOf("black"));
        farCharPlat.setStrokeWidth(2.0);
        //farCharPlat.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 25);");
        this.farCharPlat = farCharPlat;
            
        char1.setPreserveRatio(true);
        char1.setSmooth(true);
        char1.setX(75);
        char1.setY(150);
        char1.setFitWidth(150);
        this.char1 = char1;
        
        char2.setPreserveRatio(true);
        char2.setSmooth(true);
        char2.setX(387);
        char2.setY(85);
        char2.setFitWidth(126);
        this.char2 = char2;
        
        if (title != null) {
            title.setStyle("-fx-underline: true;");
            title.setX(0);
            title.setY(0);
        } else {
            this.title = null;
        }
        
        if (body != null) {
            body.setX(0);
            body.setY(0);
        } else {
            this.body = null;
        }
        
        bottomRectangle.setWidth(550);
        bottomRectangle.setHeight(150);
        bottomRectangle.setX(25);
        bottomRectangle.setY(425);
        this.bottomRectangle = bottomRectangle;
                
        if (char1HealthBar > 100) char1HealthBar = 100;
        else if (char1HealthBar < 0) char1HealthBar = 0;
        this.char1HealthBar = char1HealthBar;
        
        if (char1HealthBarForeground != null) {
            char1HealthBarForeground.setWidth(250 * (char1HealthBar / 100));
            char1HealthBarForeground.setHeight(25);
            char1HealthBarForeground.setX(25);
            char1HealthBarForeground.setY(110);
            this.char1HealthBarForeground = char1HealthBarForeground;
        } else {
            this.char1HealthBarForeground = null;
        }
        
        if (char1HealthBarBackground != null) {
            char1HealthBarBackground.setWidth(250);
            char1HealthBarBackground.setHeight(25);
            char1HealthBarBackground.setX(25);
            char1HealthBarBackground.setY(110);
            this.char1HealthBarBackground = char1HealthBarBackground;
        } else {
            this.char1HealthBarBackground = null;
        }
        
        if (char2HealthBar > 100) char2HealthBar = 100;
        else if (char2HealthBar < 0) char2HealthBar = 0;
        this.char2HealthBar = char2HealthBar;
        
        if (char2HealthBarForeground != null) {
            char2HealthBarForeground.setWidth(250 * (char2HealthBar / 100));
            char2HealthBarForeground.setHeight(25);
            char2HealthBarForeground.setX(325);
            char2HealthBarForeground.setY(60);
            this.char2HealthBarForeground = char2HealthBarForeground;
        } else {
            this.char2HealthBarForeground = null;
        }
        
        if (char2HealthBarBackground != null) {
            char2HealthBarBackground.setWidth(250);
            char2HealthBarBackground.setHeight(25);
            char2HealthBarBackground.setX(325);
            char2HealthBarBackground.setY(60);
            this.char2HealthBarBackground = char2HealthBarBackground;
        } else {
            this.char2HealthBarBackground = null;
        }
        
        this.topLeftButton = null;
        this.bottomLeftButton = null;
        this.topRightButton = null;
        this.bottomRightButton = null;
    }
    
    /**
     * An instance of the ConfrontationScene.java class will be created using this constructor. It will create a scene with four game buttons and no health bars.
     * 
     * @param fontFile The File that stores the font used for the confrontation scene.
     * @param backgroundImageView The ImageView that stores the background image.
     * @param closeCharPlat The Ellipse for the platform for the closer character.
     * @param farCharPlat The Ellipse for the platform for the farther character.
     * @param char1 The ImageView that stores the image for the first character (the closer one).
     * @param char2 The ImageView that stores the image for the second character (the farther one).
     * @param bottomRectangle The Rectangle that will be used on the bottom of the scene.
     * @param topLeftButton The GameButton that will be the top left button in the scene.
     * @param bottomLeftButton The GameButton that will be the bottom left button in the scene.
     * @param topRightButton The GameButton that will be the top right button in the scene.
     * @param bottomRightButton The GameButton that will be the bottom right button in the scene.
     */
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, Ellipse closeCharPlat, Ellipse farCharPlat, ImageView char1, ImageView char2, Rectangle bottomRectangle, GameButton topLeftButton, GameButton bottomLeftButton, GameButton topRightButton, GameButton bottomRightButton) {
        this(fontFile, backgroundImageView, closeCharPlat, farCharPlat, char1, char2, bottomRectangle, topLeftButton, bottomLeftButton, topRightButton, bottomRightButton, 0, null, null, 0, null, null);
    }
    
    /**
     * An instance of the ConfrontationScene.java class will be created using this constructor. It will create a scene with four game buttons and two health bars.
     * 
     * @param fontFile The File that stores the font used for the confrontation scene.
     * @param backgroundImageView The ImageView that stores the background image.
     * @param closeCharPlat The Ellipse for the platform for the closer character.
     * @param farCharPlat The Ellipse for the platform for the farther character.
     * @param char1 The ImageView that stores the image for the first character (the closer one).
     * @param char2 The ImageView that stores the image for the second character (the farther one).
     * @param bottomRectangle The Rectangle that will be used on the bottom of the scene.
     * @param topLeftButton The GameButton that will be the top left button in the scene.
     * @param bottomLeftButton The GameButton that will be the bottom left button in the scene.
     * @param topRightButton The GameButton that will be the top right button in the scene.
     * @param bottomRightButton The GameButton that will be the bottom right button in the scene.
     * @param char1HealthBar The double that will hold onto the amount of health in the first character.
     * @param char1HealthBarForeground The Rectangle that will be the front rectangle for the first character's health bar.
     * @param char1HealthBarBackground The Rectangle that will be the back rectangle for the first character's health bar.
     * @param char2HealthBar The double that will hold onto the amount of health in the second character.
     * @param char2HealthBarForeground The Rectangle that will be the front rectangle for the second character's health bar.
     * @param char2HealthBarBackground The Rectangle that will be the back rectangle for the second character's health bar.
     */
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, Ellipse closeCharPlat, Ellipse farCharPlat, ImageView char1, ImageView char2, Rectangle bottomRectangle, GameButton topLeftButton, GameButton bottomLeftButton, GameButton topRightButton, GameButton bottomRightButton, double char1HealthBar, Rectangle char1HealthBarForeground, Rectangle char1HealthBarBackground, double char2HealthBar, Rectangle char2HealthBarForeground, Rectangle char2HealthBarBackground) {
        this.fontFile = fontFile;
        
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setSmooth(true);
        backgroundImageView.setX(0);
        backgroundImageView.setY(0);
        backgroundImageView.setFitWidth(600);
        this.backgroundImageView = backgroundImageView;
        
        //Ellipse closeCharPlat = new Ellipse (150, 350, 120, 30);
        closeCharPlat.setCenterX(150);
        closeCharPlat.setCenterY(350);
        closeCharPlat.setRadiusX(120);
        closeCharPlat.setRadiusY(30);
        closeCharPlat.setStyle(
            "-fx-background-radius: 10; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 20);"
        );
        closeCharPlat.setStroke(Paint.valueOf("black"));
        closeCharPlat.setStrokeWidth(2.0);
        //closeCharPlat.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 25);");
        this.closeCharPlat = closeCharPlat;
        
        //Ellipse farCharPlat = new Ellipse (450, 250, 120, 30);
        farCharPlat.setCenterX(450);
        farCharPlat.setCenterY(250);
        farCharPlat.setRadiusX(120);
        farCharPlat.setRadiusY(30);
        farCharPlat.setStyle(
            "-fx-background-radius: 10; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 20);"
        );
        farCharPlat.setStroke(Paint.valueOf("black"));
        farCharPlat.setStrokeWidth(2.0);
        //farCharPlat.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 25);");
        this.farCharPlat = farCharPlat;
            
        char1.setPreserveRatio(true);
        char1.setSmooth(true);
        char1.setX(75);
        char1.setY(150);
        char1.setFitWidth(150);
        this.char1 = char1;
        
        char2.setPreserveRatio(true);
        char2.setSmooth(true);
        char2.setX(387);
        char2.setY(85);
        char2.setFitWidth(126);
        this.char2 = char2;
        
        bottomRectangle.setWidth(550);
        bottomRectangle.setHeight(150);
        bottomRectangle.setX(25);
        bottomRectangle.setY(425);
        this.bottomRectangle = bottomRectangle;
        
        if (topLeftButton != null) {
            topLeftButton.setXCoord(35);
            topLeftButton.setYCoord(435);
            topLeftButton.setWidth(260);
            topLeftButton.setHeight(60);
            this.topLeftButton = topLeftButton;
        } else {
            this.topLeftButton = null;
        }
        
        if (bottomLeftButton != null) {
            bottomLeftButton.setXCoord(35);
            bottomLeftButton.setYCoord(505);
            bottomLeftButton.setWidth(260);
            bottomLeftButton.setHeight(60);
            this.bottomLeftButton = bottomLeftButton;
        } else {
            this.bottomLeftButton = null;
        }
        
        if (topRightButton != null) {
            topRightButton.setXCoord(305);
            topRightButton.setYCoord(435);
            topRightButton.setWidth(260);
            topRightButton.setHeight(60);
            this.topRightButton = topRightButton;
        } else {
            this.topRightButton = null;
        }
        
        if (bottomRightButton != null) {
            bottomRightButton.setXCoord(305);
            bottomRightButton.setYCoord(505);
            bottomRightButton.setWidth(260);
            bottomRightButton.setHeight(60);
            this.bottomRightButton = bottomRightButton;
        } else {
            this.bottomRightButton = null;
        }
        
        if (char1HealthBar > 100) char1HealthBar = 100;
        else if (char1HealthBar < 0) char1HealthBar = 0;
        this.char1HealthBar = char1HealthBar;
        
        if (char1HealthBarForeground != null) {
            char1HealthBarForeground.setWidth(250 * (char1HealthBar / 100));
            char1HealthBarForeground.setHeight(25);
            char1HealthBarForeground.setX(25);
            char1HealthBarForeground.setY(110);
            this.char1HealthBarForeground = char1HealthBarForeground;
        } else {
            this.char1HealthBarForeground = null;
        }
        
        if (char1HealthBarBackground != null) {
            char1HealthBarBackground.setWidth(250);
            char1HealthBarBackground.setHeight(25);
            char1HealthBarBackground.setX(25);
            char1HealthBarBackground.setY(110);
            this.char1HealthBarBackground = char1HealthBarBackground;
        } else {
            this.char1HealthBarBackground = null;
        }
        
        if (char2HealthBar > 100) char2HealthBar = 100;
        else if (char2HealthBar < 0) char2HealthBar = 0;
        this.char2HealthBar = char2HealthBar;
        
        if (char2HealthBarForeground != null) {
            char2HealthBarForeground.setWidth(250 * (char2HealthBar / 100));
            char2HealthBarForeground.setHeight(25);
            char2HealthBarForeground.setX(325);
            char2HealthBarForeground.setY(50);
            this.char2HealthBarForeground = char2HealthBarForeground;
        } else {
            this.char2HealthBarForeground = null;
        }
        
        if (char2HealthBarBackground != null) {
            char2HealthBarBackground.setWidth(250);
            char2HealthBarBackground.setHeight(25);
            char2HealthBarBackground.setX(325);
            char2HealthBarBackground.setY(50);
            this.char2HealthBarBackground = char2HealthBarBackground;
        } else {
            this.char2HealthBarBackground = null;
        }
        
        this.title = null;
        this.body = null;
    }
    
    /**
     * Public method that returns the file used for the font.
     * <p>
     * This public non-static method returns an instance of the 
     * File class, which is the file that is used for the confrontation
     * scene's font.
     * 
     * @return  An instance of the File class, which is the font used by
     *          the scene.
     */
    public File getFontFile() {
        return this.fontFile;
    }
    
    /**
     * Public method that sets the file used for the font.
     * <p>
     * This public non-static method is used to set the file that
     * is used by the program for a font.
     * 
     * @param newFontFile A File that is the new file that the program will use for fonts.
     */
    public void setFontFile(File newFontFile) {
        this.fontFile = newFontFile;
    }
    
    /**
     * Public method that returns the ImageView used for the background.
     * <p>
     * This public non-static method returns an instance of the 
     * ImageView class, which is the ImageView that is used for 
     * the background of the scene.
     * 
     * @return  An instance of the ImageView class, which is the
     *          ImageView used for the background of the scene.
     */
    public ImageView getBackground() {
        return this.backgroundImageView;
    }
    
    /**
     * Public method that returns the Ellipse used for the first character's platform.
     * <p>
     * This public non-static method returns an instance of the 
     * Ellipse class, which is the Ellipse that is used as the
     * closer platform (for the first character).
     * 
     * @return  An instance of the Ellipse class, which is the
     *          Ellipse used for the first character's platform.
     */
    public Ellipse getCloseCharPlat() {
        return this.closeCharPlat;
    }
    
    /**
     * Public method that returns the Ellipse used for the second character's platform.
     * <p>
     * This public non-static method returns an instance of the 
     * Ellipse class, which is the Ellipse that is used as the
     * farther platform (for the second character).
     * 
     * @return  An instance of the Ellipse class, which is the
     *          Ellipse used for the second character's platform.
     */
    public Ellipse getFarCharPlat() {
        return this.farCharPlat;
    }
    
    /**
     * Public method that returns the ImageView used for the first character.
     * <p>
     * This public non-static method returns an instance of the 
     * ImageView class, which is the ImageView that is used for 
     * the first character for the scene.
     * 
     * @return  An instance of the ImageView class, which is the
     *          ImageView used for the first character for the
     *          scene.
     */
    public ImageView getChar1() {
        return this.char1;
    }
    
    /**
     * Public method that returns the ImageView used for the second character.
     * <p>
     * This public non-static method returns an instance of the 
     * ImageView class, which is the ImageView that is used for 
     * the second character for the scene.
     * 
     * @return  An instance of the ImageView class, which is the
     *          ImageView used for the second character for the
     *          scene.
     */
    public ImageView getChar2() {
        return this.char2;
    }
    
    /**
     * Public method that returns the Rectangle used at the bottom of the scene.
     * <p>
     * This public non-static method returns an instance of the 
     * Rectangle class, which is the Rectangle that is used at
     * the bottom of the scene.
     * 
     * @return  An instance of the Rectangle class, which is the
     *          Rectangle used at the bottom of the scene.
     */
    public Rectangle getBottomRectangle() {
        return this.bottomRectangle;
    }
    
    /**
     * Public method that returns the GameButton used in the top left of the bottom rectangle.
     * <p>
     * This public non-static method returns an instance of the 
     * GameButton class, which is the GameButton that is used at
     * the top left of the bottom rectangle of the scene.
     * 
     * @return  An instance of the GameButton class, which is the
     *          GameButton used at the top left of the lower
     *          rectangle.
     */
    public GameButton getTopLeftButton() {
        return this.topLeftButton;
    }
    
    /**
     * Public method that returns the GameButton used in the bottom left of the bottom rectangle.
     * <p>
     * This public non-static method returns an instance of the 
     * GameButton class, which is the GameButton that is used at
     * the bottom left of the bottom rectangle of the scene.
     * 
     * @return  An instance of the GameButton class, which is the
     *          GameButton used at the bottom left of the lower
     *          rectangle.
     */
    public GameButton getBottomLeftButton() {
        return this.bottomLeftButton;
    }
    
    /**
     * Public method that returns the GameButton used in the top right of the bottom rectangle.
     * <p>
     * This public non-static method returns an instance of the 
     * GameButton class, which is the GameButton that is used at
     * the top right of the bottom rectangle of the scene.
     * 
     * @return  An instance of the GameButton class, which is the
     *          GameButton used at the top right of the lower
     *          rectangle.
     */
    public GameButton getTopRightButton() {
        return this.topRightButton;
    }
    
    /**
     * Public method that returns the GameButton used in the bottom right of the bottom rectangle.
     * <p>
     * This public non-static method returns an instance of the 
     * GameButton class, which is the GameButton that is used at
     * the bottom right of the bottom rectangle of the scene.
     * 
     * @return  An instance of the GameButton class, which is the
     *          GameButton used at the bottom right of the lower
     *          rectangle.
     */
    public GameButton getBottomRightButton() {
        return this.bottomRightButton;
    }
    
    /**
     * Public method that returns the health of the first character as a double.
     * <p>
     * This public non-static method returns a double, which is
     * the health of the first character as a double (a percentage
     * out of 100).
     * 
     * @return  A double, which is the health of the first character.
     */
    public double getChar1HealthBar() {
        return this.char1HealthBar;
    }
    
    /*
    public void setChar1HealthBar(double newChar1HealthBar) {
        if (newChar1HealthBar > 100) newChar1HealthBar = 100;
        else if (newChar1HealthBar < 0) newChar1HealthBar = 0;
        this.char1HealthBar = newChar1HealthBar;
        this.char1HealthBarForeground.setWidth(250 * (newChar1HealthBar / 100));
    }
    
    public Rectangle getChar1HealthBarForeground() {
        return this.char1HealthBarForeground;
    }
    
    public Rectangle getChar1HealthBarBackground() {
        return this.char1HealthBarBackground;
    }
    */
    
    /**
     * Public method that returns the health of the second character as a double.
     * <p>
     * This public non-static method returns a double, which is
     * the health of the second character as a double (a percentage
     * out of 100).
     * 
     * @return  A double, which is the health of the second character.
     */
    public double getChar2HealthBar() {
        return this.char2HealthBar;
    }
    
    /*
    public void setChar2HealthBar(double newChar2HealthBar) {
        if (newChar2HealthBar > 100) newChar2HealthBar = 100;
        else if (newChar2HealthBar < 0) newChar2HealthBar = 0;
        this.char2HealthBar = newChar2HealthBar;
        this.char2HealthBarForeground.setWidth(250 * (newChar2HealthBar / 100));
    }
    
    public Rectangle getChar2HealthBarForeground() {
        return this.char2HealthBarForeground;
    }
    
    public Rectangle getChar2HealthBarBackground() {
        return this.char2HealthBarBackground;
    }
    
    public Text getTitle() {
        return this.title;
    }
    
    public Text getBody() {
        return this.body;
    }
    */
    
    /**
     * Public method that returns a Group containing all the Nodes in the confrontation scene.
     * <p>
     * This public non-static method returns an instance of the Group
     * class, which are all the Nodes that will be used to make up the
     * confrontation scene.
     * 
     * @return  A Group, which is the Group that holds all the nodes
     *          are used in the scene.
     */
    public Group getScene() {
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            this.backgroundImageView,
            this.farCharPlat,
            this.char2,
            this.closeCharPlat,
            this.char1,
            this.bottomRectangle
        );
        
        if(this.bottomRightButton != null) nodesToAdd.getChildren().add(this.bottomRightButton.getButton());
        if(this.topRightButton != null) nodesToAdd.getChildren().add(this.topRightButton.getButton());
        if(this.bottomLeftButton != null) nodesToAdd.getChildren().add(this.bottomLeftButton.getButton());
        if(this.topLeftButton != null) nodesToAdd.getChildren().add(this.topLeftButton.getButton());
        
        if(this.char2HealthBarBackground != null) nodesToAdd.getChildren().add(this.char2HealthBarBackground);
        if(this.char2HealthBarForeground != null) nodesToAdd.getChildren().add(this.char2HealthBarForeground);
        if(this.char1HealthBarBackground != null) nodesToAdd.getChildren().add(this.char1HealthBarBackground);
        if(this.char1HealthBarForeground != null) nodesToAdd.getChildren().add(this.char1HealthBarForeground);
        
        TextFlow textToAdd = new TextFlow();
        if (this.title != null) textToAdd.getChildren().add(this.title);
        if (this.body != null) textToAdd.getChildren().add(this.body);
        textToAdd.setLineSpacing(10);
        textToAdd.setPrefWidth(550);
        textToAdd.setPrefHeight(150);
        textToAdd.setTranslateX(25);
        textToAdd.setTranslateY(425);
        nodesToAdd.getChildren().add(textToAdd);
        
        return nodesToAdd;
        
        /*
        Scene scene = new Scene(nodesToAdd, 600, 600);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.topLeftButton != null && xVal >= this.topLeftButton.getLeftX() && xVal <= this.topLeftButton.getRightX() && yVal >= this.topLeftButton.getTopY() && yVal <= this.topLeftButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (this.bottomLeftButton != null && xVal >= this.bottomLeftButton.getLeftX() && xVal <= this.bottomLeftButton.getRightX() && yVal >= this.bottomLeftButton.getTopY() && yVal <= this.bottomLeftButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (this.topRightButton != null && xVal >= this.topRightButton.getLeftX() && xVal <= this.topRightButton.getRightX() && yVal >= this.topRightButton.getTopY() && yVal <= this.topRightButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (this.bottomRightButton != null && xVal >= this.bottomRightButton.getLeftX() && xVal <= this.bottomRightButton.getRightX() && yVal >= this.bottomRightButton.getTopY() && yVal <= this.bottomRightButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (this.topLeftButton != null) {
                    if (xVal >= this.topLeftButton.getLeftX() && xVal <= this.topLeftButton.getRightX() && yVal >= this.topLeftButton.getTopY() && yVal <= this.topLeftButton.getBottomY()) {
                        this.topLeftButton.cursorOverButton();
                    } else {
                        this.topLeftButton.cursorNotOverButton();
                    }
                }

                if (this.bottomLeftButton != null) {
                    if (xVal >= this.bottomLeftButton.getLeftX() && xVal <= this.bottomLeftButton.getRightX() && yVal >= this.bottomLeftButton.getTopY() && yVal <= this.bottomLeftButton.getBottomY()) {
                        this.bottomLeftButton.cursorOverButton();
                    } else {
                        this.bottomLeftButton.cursorNotOverButton();
                    }
                }
                
                if (this.topRightButton != null) {
                    if (xVal >= this.topRightButton.getLeftX() && xVal <= this.topRightButton.getRightX() && yVal >= this.topRightButton.getTopY() && yVal <= this.topRightButton.getBottomY()) {
                        this.topRightButton.cursorOverButton();
                    } else {
                        this.topRightButton.cursorNotOverButton();
                    }
                }
                
                if (this.bottomRightButton != null) {
                    if (xVal >= this.bottomRightButton.getLeftX() && xVal <= this.bottomRightButton.getRightX() && yVal >= this.bottomRightButton.getTopY() && yVal <= this.bottomRightButton.getBottomY()) {
                        this.bottomRightButton.cursorOverButton();
                    } else {
                        this.bottomRightButton.cursorNotOverButton();
                    }
                }
            }
        );
        
        return scene;
        */
    }
    
    /**
     * Private method that returns the Font from the specified file.
     * <p>
     * This private non-static method is used to get a Font from a
     * certain file.
     * 
     * @param fontFile A File that is the source of the specified font.
     * @param fontSize A double, which is the font size that is desired.
     * @return  An instance of the Font class, which is the actual font
     *          at the specified size.
     */
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
}

/*
public class ConfrontationScene {
    
    private ImageView backgroundImageView;
    
    private ImageView char1;
    
    private ImageView char2;
    
    private int numOfButtons;
    
    private GameButton topLeftButton;
    
    private GameButton bottomLeftButton;
    
    private GameButton topRightButton;
    
    private GameButton bottomRightButton;
    
    private GameButton leftButton;
    
    private GameButton rightButton;
    
    private TextFlow text;
    
    private Rectangle rectAroundText;
    
    private Ellipse closePlat;
    
    private Ellipse farPlat;
    
    private File fontFile;
    
    private double char1HealthBarLen;
    
    private double char2HealthBarLen;
    
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, ImageView char1, ImageView char2, Text title, Text body, Rectangle rectAroundText, String closeEllipsePaint, String farEllipsePaint, boolean setHealth, double healthChar1, double healthChar2) {
        this.createBackgroundAndChars(fontFile, backgroundImageView, char1, char2, 0, rectAroundText, closeEllipsePaint, farEllipsePaint);
        
        this.text = new TextFlow();
        this.text.getChildren().addAll(
            text,
            title
        );
        this.text.setLineSpacing(10);
        this.text.setPrefWidth(500);
        this.text.setPrefHeight(200);
        this.text.setTranslateX(50);
        this.text.setTranslateY(350);
    }
    
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, ImageView char1, ImageView char2, GameButton leftButton, GameButton rightButton, Rectangle rectAroundText, String closeEllipsePaint, String farEllipsePaint, boolean setHealth, double healthChar1, double healthChar2) {
        this.createBackgroundAndChars(fontFile, backgroundImageView, char1, char2, 2, rectAroundText, closeEllipsePaint, farEllipsePaint);
        
        this.leftButton = leftButton;
        //this.leftButton.setXCoord(0.0);
        //this.leftButton.setYCoord(0.0);
        
        this.rightButton = rightButton;
        //this.rightButton.setXCoord(0.0);
        //this.rightButton.setYCoord(0.0);
    } 
    
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, ImageView char1, ImageView char2, GameButton topLeftButton, GameButton bottomLeftButton, GameButton topRightButton, Rectangle rectAroundText, String closeEllipsePaint, String farEllipsePaint, boolean setHealth, double healthChar1, double healthChar2) {
        this.createBackgroundAndChars(fontFile, backgroundImageView, char1, char2, 3, rectAroundText, closeEllipsePaint, farEllipsePaint);
        
        this.topLeftButton = topLeftButton;
        //this.topLeftButton.setXCoord(0.0);
        //this.topLeftButton.setYCoord(0.0);
        
        this.bottomLeftButton = bottomLeftButton;
        //this.bottomLeftButton.setXCoord(0.0);
        //this.bottomLeftButton.setYCoord(0.0);
        
        this.topRightButton = topRightButton;
        //this.topRightButton.setXCoord(0.0);
        //this.topRightButton.setYCoord(0.0);
    }
    
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, ImageView char1, ImageView char2, GameButton topLeftButton, GameButton bottomLeftButton, GameButton topRightButton, GameButton bottomRightButton, Rectangle rectAroundText, String closeEllipsePaint, String farEllipsePaint, boolean setHealth, double healthChar1, double healthChar2) {       
        this.createBackgroundAndChars(fontFile, backgroundImageView, char1, char2, 4, rectAroundText, closeEllipsePaint, farEllipsePaint);
        
        this.topLeftButton = topLeftButton;
        //this.topLeftButton.setXCoord(0.0);
        //this.topLeftButton.setYCoord(0.0);
        
        this.bottomLeftButton = bottomLeftButton;
        //this.bottomLeftButton.setXCoord(0.0);
        //this.bottomLeftButton.setYCoord(0.0);
        
        this.topRightButton = topRightButton;
        //this.topRightButton.setXCoord(0.0);
        //this.topRightButton.setYCoord(0.0);
        
        this.bottomRightButton = bottomRightButton;
        //this.bottomRightButton.setXCoord(0.0);
        //this.bottomRightButton.setYCoord(0.0);
    }
    
    private void createBackgroundAndChars(File fontFile, ImageView backgroundImageView, ImageView char1, ImageView char2, int numOfButtons, Rectangle rectAroundText, String closeEllipsePaint, String farEllipsePaint) {
        this.backgroundImageView = backgroundImageView;
        this.backgroundImageView.setPreserveRatio(true);
        this.backgroundImageView.setSmooth(true);
        this.backgroundImageView.setX(0);
        this.backgroundImageView.setY(0);
        this.backgroundImageView.setFitWidth(600);

        this.char1 = char1;
        this.char2 = char2;
        
        this.numOfButtons = numOfButtons;
        
        this.rectAroundText = rectAroundText;
        this.rectAroundText.setWidth(550);
        this.rectAroundText.setHeight(150);
        this.rectAroundText.setTranslateX(25);
        this.rectAroundText.setTranslateY(425);
        
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
        if (this.numOfButtons == 0) {
            nodesToAdd.getChildren().addAll(
                this.backgroundImageView,
                this.farPlat,
                this.closePlat,
                this.char2,
                this.char1,
                this.rectAroundText,
                this.text
            );
        } else if (this.numOfButtons == 2) {
            GridPane tempGridPane = new GridPane();
            tempGridPane.add(this.leftButton.getButton(), 0, 0);
            tempGridPane.add(this.rightButton.getButton(), 1, 0);
            tempGridPane.setPrefWidth(550);
            tempGridPane.setPrefHeight(150);
            tempGridPane.setTranslateX(25);
            tempGridPane.setTranslateY(425);
            nodesToAdd.getChildren().addAll(
                this.backgroundImageView,
                this.farPlat,
                this.closePlat,
                this.char2,
                this.char1,
                this.rectAroundText,
                tempGridPane
            );
        } else if (this.numOfButtons == 3) {
            GridPane tempGridPane = new GridPane();
            tempGridPane.add(this.topLeftButton.getButton(), 0, 0);
            tempGridPane.add(this.bottomLeftButton.getButton(), 0, 1);
            tempGridPane.add(this.topRightButton.getButton(), 1, 0);
            tempGridPane.setPrefWidth(550);
            tempGridPane.setPrefHeight(150);
            tempGridPane.setTranslateX(25);
            tempGridPane.setTranslateY(425);
            nodesToAdd.getChildren().addAll(
                this.backgroundImageView,
                this.farPlat,
                this.closePlat,
                this.char2,
                this.char1,
                this.rectAroundText,
                tempGridPane
            );
        } else {
            GridPane tempGridPane = new GridPane();
            tempGridPane.add(this.topLeftButton.getButton(), 0, 0);
            tempGridPane.add(this.bottomLeftButton.getButton(), 0, 1);
            tempGridPane.add(this.topRightButton.getButton(), 1, 0);
            tempGridPane.add(this.bottomRightButton.getButton(), 1, 1);
            tempGridPane.setVgap(20);
            tempGridPane.setHgap(20);
            tempGridPane.setAlignment(Pos.CENTER);
            StackPane tempStackPane = new StackPane();
            tempStackPane.getChildren().addAll(
                this.rectAroundText,
                tempGridPane
            );
            //tempStackPane.setPrefWidth(550);
            //tempStackPane.setPrefHeight(150);
            //tempStackPane.setTranslateX(170);
            //tempStackPane.setTranslateY(440);
            nodesToAdd.getChildren().addAll(
                this.backgroundImageView,
                this.farPlat,
                this.closePlat,
                this.char2,
                this.char1,
                tempStackPane
            );
        }
        
        Scene scene = new Scene(nodesToAdd, 600, 600);
        return scene;
    }
    
}
*/