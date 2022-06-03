import javafx.scene.shape.Shape;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfrontationScene {
    private File fontFile;

    private ImageView backgroundImageView;
    
    private Ellipse closeCharPlat;
    
    private Ellipse farCharPlat;
    
    private ImageView char1;
    
    private ImageView char2;
    
    private Rectangle bottomRectangle;
    
    private GameButton topLeftButton;
    
    private GameButton bottomLeftButton;
    
    private GameButton topRightButton;
    
    private GameButton bottomRightButton;
    
    private double char1HealthBar;
    
    private Rectangle char1HealthBarForeground;
    
    private Rectangle char1HealthBarBackground;
    
    private double char2HealthBar;
    
    private Rectangle char2HealthBarForeground;
    
    private Rectangle char2HealthBarBackground;
    
    private Text title;
    
    private Text body;
    
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
        char1.setX(50);
        char1.setY(150);
        char1.setFitWidth(200);
        this.char1 = char1;
        
        char2.setPreserveRatio(true);
        char2.setSmooth(true);
        char2.setX(375);
        char2.setY(100);
        char2.setFitWidth(150);
        this.char2 = char2;
        
        bottomRectangle.setWidth(550);
        bottomRectangle.setHeight(150);
        bottomRectangle.setX(25);
        bottomRectangle.setY(425);
        this.bottomRectangle = bottomRectangle;
        
        if (title != null) {
            topLeftButton.setXCoord(35);
            topLeftButton.setYCoord(435);
            topLeftButton.setWidth(260);
            topLeftButton.setHeight(60);
            this.topLeftButton = topLeftButton;
        } else {
            this.title = null;
        }
        
        if (body != null) {
            bottomLeftButton.setXCoord(35);
            bottomLeftButton.setYCoord(505);
            bottomLeftButton.setWidth(260);
            bottomLeftButton.setHeight(60);
            this.bottomLeftButton = bottomLeftButton;
        } else {
            this.body = null;
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
    
    public ConfrontationScene (File fontFile, ImageView backgroundImageView, Ellipse closeCharPlat, Ellipse farCharPlat, ImageView char1, ImageView char2, Rectangle bottomRectangle, GameButton topLeftButton, GameButton bottomLeftButton, GameButton topRightButton, GameButton bottomRightButton) {
        this(fontFile, backgroundImageView, closeCharPlat, farCharPlat, char1, char2, bottomRectangle, topLeftButton, bottomLeftButton, topRightButton, bottomRightButton, 0, null, null, 0, null, null);
    }
    
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
        char1.setX(50);
        char1.setY(150);
        char1.setFitWidth(200);
        this.char1 = char1;
        
        char2.setPreserveRatio(true);
        char2.setSmooth(true);
        char2.setX(375);
        char2.setY(100);
        char2.setFitWidth(150);
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
        
        this.title = null;
        this.body = null;
    }
    
    public File getFontFile() {
        return this.fontFile;
    }
    
    public void setFontFile(File newFontFile) {
        this.fontFile = newFontFile;
    }
    
    public ImageView getBackground() {
        return this.backgroundImageView;
    }
    
    public Ellipse getCloseCharPlat() {
        return this.closeCharPlat;
    }
    
    public Ellipse getFarCharPlat() {
        return this.farCharPlat;
    }
    
    public ImageView getChar1() {
        return this.char1;
    }
    
    public ImageView getChar2() {
        return this.char2;
    }
    
    public Rectangle getBottomRectangle() {
        return this.bottomRectangle;
    }
    
    public GameButton getTopLeftButton() {
        return this.topLeftButton;
    }
    
    public GameButton getBottomLeftButton() {
        return this.bottomLeftButton;
    }
    
    public GameButton getTopRightButton() {
        return this.topRightButton;
    }
    
    public GameButton getBottomRightButton() {
        return this.bottomRightButton;
    }
    
    public double getChar1HealthBar() {
        return this.char1HealthBar;
    }
    
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
    
    public double getChar2HealthBar() {
        return this.char2HealthBar;
    }
    
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
    
    public Scene getScene() {
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
        textToAdd.setPrefWidth(500);
        textToAdd.setPrefHeight(200);
        textToAdd.setTranslateX(50);
        textToAdd.setTranslateY(350);
        
        Scene scene = new Scene(nodesToAdd, 600, 600);
        
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (xVal >= this.topLeftButton.getLeftX() && xVal <= this.topLeftButton.getRightX() && yVal >= this.topLeftButton.getTopY() && yVal <= this.topLeftButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= this.bottomLeftButton.getLeftX() && xVal <= this.bottomLeftButton.getRightX() && yVal >= this.bottomLeftButton.getTopY() && yVal <= this.bottomLeftButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= this.topRightButton.getLeftX() && xVal <= this.topRightButton.getRightX() && yVal >= this.topRightButton.getTopY() && yVal <= this.topRightButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= this.bottomRightButton.getLeftX() && xVal <= this.bottomRightButton.getRightX() && yVal >= this.bottomRightButton.getTopY() && yVal <= this.bottomRightButton.getBottomY()) {
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

                if (xVal >= this.topLeftButton.getLeftX() && xVal <= this.topLeftButton.getRightX() && yVal >= this.topLeftButton.getTopY() && yVal <= this.topLeftButton.getBottomY()) {
                    this.topLeftButton.cursorOverButton();
                } else {
                    this.topLeftButton.cursorNotOverButton();
                }

                if (xVal >= this.bottomLeftButton.getLeftX() && xVal <= this.bottomLeftButton.getRightX() && yVal >= this.bottomLeftButton.getTopY() && yVal <= this.bottomLeftButton.getBottomY()) {
                    this.bottomLeftButton.cursorOverButton();
                } else {
                    this.bottomLeftButton.cursorNotOverButton();
                }
                
                if (xVal >= this.topRightButton.getLeftX() && xVal <= this.topRightButton.getRightX() && yVal >= this.topRightButton.getTopY() && yVal <= this.topRightButton.getBottomY()) {
                    this.topRightButton.cursorOverButton();
                } else {
                    this.topRightButton.cursorNotOverButton();
                }
                
                if (xVal >= this.bottomRightButton.getLeftX() && xVal <= this.bottomRightButton.getRightX() && yVal >= this.bottomRightButton.getTopY() && yVal <= this.bottomRightButton.getBottomY()) {
                    this.bottomRightButton.cursorOverButton();
                } else {
                    this.bottomRightButton.cursorNotOverButton();
                }
            }
        );
        
        return scene;
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