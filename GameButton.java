import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.paint.Paint;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
//import javafx.geometry.Pos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class GameButton {
    
    private Label label;
    
    private Rectangle boxAroundLabel;
    
    //private Rectangle redRectangleAroundButton;
    
    private double xCoord;
    
    private double yCoord;
    
    public GameButton (String text, File fontFile, int fontSize, String fontPaint, String backgroundColour, double xCoord, double yCoord, double width, double height, double textTranslationX, double textTranslationY) {
        this.label = new Label(text);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        
        System.out.println(fontFile.getPath());
        
        Font fontFont = new Font(1); // It doesn't matter what size font I put, so I will default it to 1.
        try {
            FileInputStream fontFIS = new FileInputStream(fontFile);
            fontFont = Font.loadFont(new FileInputStream(fontFile), 1); // It doesn't matter what size font I put, so I will default it to 1.
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //fontFont = Font.loadFont("https://fonts.googleapis.com/css2?family=Press+Start+2P", 1);
        //System.out.println(fontFont);
        //this.label.setTextFill(Paint.valueOf(fontPaint));
        this.label.setFont(fontFont);
        //this.label.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P");
        this.label.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: " + backgroundColour + "; -fx-text-fill: " + fontPaint + "; -fx-font-size: " + fontSize + "px;"); // -fx-font-family: 'Press Start 2P', cursive;
        this.label.setTranslateX(textTranslationX);
        this.label.setTranslateY(textTranslationY);
        //this.label.setTranslateX(xCoord);
        //this.label.setTranslateY(yCoord);
        
        this.boxAroundLabel = new Rectangle(0, 0, width, height); // this.boxAroundLabel = new Rectangle(-this.getHoriPadding(width), -this.getVertPadding(height), width, height);
        this.boxAroundLabel.setFill(Paint.valueOf(backgroundColour));
        this.boxAroundLabel.setStrokeWidth(2.0);
        this.boxAroundLabel.setStroke(Paint.valueOf("rgb(255,0,0)"));
        this.boxAroundLabel.setTranslateX(-2.0);
        this.boxAroundLabel.setTranslateY(-2.0);
        //System.out.println(this.label.prefWidth(-1));
        //this.boxAroundLabel = new Rectangle(this.label.getWidth() + 2 * horiPadding, this.label.getHeight() + 2 * vertPadding);
        //this.boxAroundLabel.setFill(Paint.valueOf("rgb(255,255,0)"));
        //this.boxAroundLabel.setTranslateX(innerRectTranslationX);
        //this.boxAroundLabel.setTranslateY(innerRectTranslationY);
        //this.boxAroundLabel.setTranslateX(xCoord);
        //this.boxAroundLabel.setTranslateY(yCoord);
        
        //this.redRectangleAroundButton = new Rectangle(-horiPadding - 2, -vertPadding - 2, this.getWidth(this.label) + 2 * horiPadding + 4, this.getHeight(this.label) + 2 * vertPadding + 4);
        //this.redRectangleAroundButton.setFill(Paint.valueOf("rgb(255,0,0)"));
        //this.redRectangleAroundButton.setTranslateX(xCoord);
        //this.redRectangleAroundButton.setTranslateY(yCoord);
    }
    
    /*
    public Rectangle getRedRectangle() {
        return this.redRectangleAroundButton;
    }
    */
    
    public Rectangle getRectAroundLabel () {
        return this.boxAroundLabel;
    }
    
    /*
    private double getWidth(Label label) {
        HBox root = new HBox();
        root.getChildren().addAll(
            label
        );
        Scene scene = new Scene(root, 600, 600);
        
        root.applyCss();
        root.layout();
        return label.getWidth();
    }
    
    private double getHoriPadding(double width) {
        return (width - this.getWidth(this.label)) / 2.0;
    }
    
    private double getHeight(Label label) {
        HBox root = new HBox();
        root.getChildren().addAll(
            label
        );
        Scene scene = new Scene(root, 600, 600);
        
        root.applyCss();
        root.layout();
        return label.getHeight();
    }
    
    private double getVertPadding(double height) {
        return (height - this.getHeight(this.label)) / 2.0;
    }
    */
    
    public String getText() {
        return this.label.getText();
    }
    
    public void setText(String newText) {
        this.label.setText(newText);
    }
    
    public Label getLabel() {
        return this.label;
    }
    
    public StackPane getButton() {
        StackPane returnedValue = new StackPane();
        returnedValue.getChildren().addAll(
            //this.redRectangleAroundButton,
            this.boxAroundLabel,
            this.label
        );
        returnedValue.setTranslateX(this.xCoord);
        returnedValue.setTranslateY(this.yCoord);
        return returnedValue;
    }
}
