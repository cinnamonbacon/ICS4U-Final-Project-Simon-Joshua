//import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.paint.Paint;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
//import javafx.geometry.Pos;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class GameButton {

    private double xCoord;
    
    private double yCoord;
    
    private double width;
    
    private double height;
    
    private double textTranslationX;

    private double textTranslationY;
        
    private Text textText;
    
    private Rectangle boxAroundLabel;
    
    private File textFontFile;
    
    public GameButton (File textFontFile, String text, double xCoord, double yCoord, int fontSize) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = 160;
        this.height = 50;
        this.textTranslationX = 0;
        this.textTranslationY = 0;
        this.textFontFile = textFontFile;
        
        this.textText = new Text(text);
        this.textText.setFont(this.getFontFromFile(fontSize));
        this.textText.setFill(Paint.valueOf("rgb(255,255,255)"));
        
        
        this.boxAroundLabel = new Rectangle(0, 0, this.width, this.height);
        this.boxAroundLabel.setFill(Paint.valueOf("rgb(0,0,0)"));
        this.boxAroundLabel.setStrokeType(StrokeType.OUTSIDE);
        this.boxAroundLabel.setStroke(Paint.valueOf("rgb(255,0,0)"));
        this.boxAroundLabel.setStrokeWidth(0.0);
    }
    
    public void cursorOverButton() {
        this.boxAroundLabel.setStrokeWidth(3.0);
    }
    
    public void cursorNotOverButton() {
        this.boxAroundLabel.setStrokeWidth(0.0);
    }
    
    public double getLeftX() {
        return this.xCoord;
    }
    
    public double getRightX() {
        return this.xCoord + this.width;
    }
    
    public double getTopY() {
        return this.yCoord;
    }
    
    public double getBottomY() {
        return this.yCoord + this.height;
    }
    
    public void setXCoord(double newXCoord) {
        this.xCoord = newXCoord;
    }
    
    public void setYCoord(double newYCoord) {
        this.yCoord = newYCoord;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(double newWidth) {
        this.width = newWidth;
        //this.textTextFlow.setPrefWidth(newWidth);
        this.boxAroundLabel.setWidth(newWidth);
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setHeight(double newHeight) {
        this.height = newHeight;
        //this.textTextFlow.setPrefHeight(newHeight);
        this.boxAroundLabel.setHeight(newHeight);
    }
    
    public double getTextTranslationX() {
        return this.textTranslationX;
    }
    
    public void setTextTranslationX(double newTextTranslationX) {
        this.textTranslationX = newTextTranslationX;
    }
    
    public double getTextTranslationY() {
        return this.textTranslationY;
    }
    
    public void setTextTranslationY(double newTextTranslationY) {
        this.textTranslationY = newTextTranslationY;
    }
    
    public Text getText() {
        return this.textText;
    }
    
    public Rectangle getBackgroundRectangle() {
        return this.boxAroundLabel;
    }
    
    public File getFontFile() {
        return this.textFontFile;
    }
    
    public void setFontFile(File newFontFile) {
        this.textFontFile = newFontFile;
    }
        
    public Font getFontFromFile(double fontSize) {
        Font fontFont = new Font(1); // It doesn't matter what size font I put, so I will default it to 1.
        try {
            FileInputStream fontFIS = new FileInputStream(this.textFontFile);
            fontFont = Font.loadFont(fontFIS, fontSize);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return fontFont;
    }
    
    public Pane getButton() {
        Pane returnedValue = new Pane();
        
        TextFlow textTextFlow = new TextFlow();
        textTextFlow.getChildren().addAll(
            this.textText
        );
        textTextFlow.setTextAlignment(TextAlignment.CENTER);
        textTextFlow.setPrefWidth(this.width);
        textTextFlow.setPrefHeight(this.height);
        textTextFlow.setTranslateX(this.textTranslationX + 1);
        textTextFlow.setTranslateY(this.textTranslationY + 16);
        
        returnedValue.getChildren().addAll(
            //this.redRectangleAroundButton,
            this.boxAroundLabel,
            //this.label
            textTextFlow
            //this.textText
        );
        returnedValue.setTranslateX(this.xCoord);
        returnedValue.setTranslateY(this.yCoord);
        return returnedValue;
    }
}


/*
public GameButton (String text, File fontFile, int fontSize, String fontPaint, String backgroundPaint, String strokePaint, double xCoord, double yCoord, double width, double height, double textTranslationX, double textTranslationY) {
        //this.label = new Label(text);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = width;
        this.height = height;
        
        Text textText = new Text(text);
        
        textText.setFont(this.getFontFromFile(fontFile, fontSize));
        textText.setFill(Paint.valueOf(fontPaint));
        
        this.textTextFlow = new TextFlow();
        this.textTextFlow.getChildren().addAll(
            textText
        );
        this.textTextFlow.setTextAlignment(TextAlignment.CENTER);
        this.textTextFlow.setPrefWidth(width);
        this.textTextFlow.setPrefHeight(height);
        this.textTextFlow.setTranslateX(textTranslationX);
        this.textTextFlow.setTranslateY(textTranslationY);
        
        //System.out.println(fontFile.getPath());
        
        //fontFont = Font.loadFont("https://fonts.googleapis.com/css2?family=Press+Start+2P", 1);
        //System.out.println(fontFont);
        //this.label.setTextFill(Paint.valueOf(fontPaint));
        //this.label.setFont(this.getFontFromFile(fontFile, 1)); // It doesn't matter what size font I put, so I will default it to 1.
        //this.label.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P");
        //this.label.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: " + backgroundColour + "; -fx-text-fill: " + fontPaint + "; -fx-font-size: " + fontSize + "px;"); // -fx-font-family: 'Press Start 2P', cursive;
        //this.label.setTranslateX(textTranslationX);
        //this.label.setTranslateY(textTranslationY);
        //this.label.setTranslateX(xCoord);
        //this.label.setTranslateY(yCoord);
        
        this.boxAroundLabel = new Rectangle(0, 0, width, height); // this.boxAroundLabel = new Rectangle(-this.getHoriPadding(width), -this.getVertPadding(height), width, height);
        this.boxAroundLabel.setFill(Paint.valueOf(backgroundPaint));
        //this.boxAroundLabel.setSmooth(false);
        //this.boxAroundLabel.setStyle("-fx-stroke: red; -fx-stroke-width: 3;");
        this.boxAroundLabel.setStrokeType(StrokeType.OUTSIDE);
        this.boxAroundLabel.setStroke(Paint.valueOf(strokePaint));
        //this.boxAroundLabel.setStrokeWidth(3.0);
        this.boxAroundLabel.setStrokeWidth(0.0);
        //this.boxAroundLabel.setTranslateX(-2.0);
        //this.boxAroundLabel.setTranslateY(-2.0);
        //System.out.println(this.label.prefWidth(-1));
        //this.boxAroundLabel = new Rectangle(this.label.getWidth() + 2 * horiPadding, this.label.getHeight() + 2 * vertPadding);
        //this.boxAroundLabel.setFill(Paint.valueOf("rgb(255,255,0)"));
        //this.boxAroundLabel.setTranslateX(innerRectTranslationX);
        //this.boxAroundLabel.setTranslateY(innerRectTranslationY);
        //this.boxAroundLabel.setTranslateX(xCoord);
        //this.boxAroundLabel.setTranslateY(yCoord);
        
        //this.redRectangleAroundButton = new Rectangle(0.0, 0.0, width + 5.0, height + 5.0);
        //this.redRectangleAroundButton = new Rectangle(width + 4.0, height + 4.0);
        //this.redRectangleAroundButton.setTranslateX(-2.0);
        //this.redRectangleAroundButton.setTranslateY(-2.0);
        //this.redRectangleAroundButton.setFill(Paint.valueOf("rgb(255,0,0)"));
        //this.redRectangleAroundButton.setSmooth(false);
        //this.redRectangleAroundButton.setVisible(false);

        
        //this.redRectangleAroundButton = new Rectangle(-horiPadding - 2, -vertPadding - 2, this.getWidth(this.label) + 2 * horiPadding + 4, this.getHeight(this.label) + 2 * vertPadding + 4);
        //this.redRectangleAroundButton.setFill(Paint.valueOf("rgb(255,0,0)"));
        //this.redRectangleAroundButton.setTranslateX(xCoord);
        //this.redRectangleAroundButton.setTranslateY(yCoord);
    }
*/