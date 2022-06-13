import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create a rectangle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.text.Font; // Imports the Font.java class, which allows the program to create and use fonts.
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create and use different paint colours.
import javafx.scene.layout.StackPane; // Imports the StackPane.java class, which allows the program to use the StackPane layout manager.
import javafx.scene.layout.HBox; // Imports the HBox.java class, which allows the program to add the labels to a layout manager so that the width and height can be computed.
import javafx.scene.Scene; // Imports the Scene.java class, which allows the program to have access to a scene on which the GUI can be added onto and displayed to the user.
import javafx.scene.shape.StrokeType; // Imports the StrokeType.java class, which allows the program to set the type of stroke that is used on the outer rectangle for the GameButton instance.
import javafx.scene.text.Text; // Imports the Text.java class, which allows the program to take Strings of text and convert it into a good looking String for the user.
import javafx.scene.text.TextAlignment; // Imports the TextAlignment.java class, which allows the program to set the alignment of text, especially within TextFlow instances.
import javafx.scene.text.TextFlow; // Imports the TextFlow.java class, which allows the program to add two or more Text.java instances together.
import javafx.scene.layout.Pane; // Imports the Pane.java class, which allows the program to have a simple and vanilla layout manager where multiple Node.java instances can be added to.

import java.io.File; // Imports the File.java class, which allows the program to access files that are on the user's computer.
import java.io.IOException; // Imports the IOException.java class, which allows the program to take care of the IOExceptions that are thrown by any parts of the program.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to read in data from files that are on the user's computer.


/**
 * Helper class that will create game buttons.
 * <p>
 * This class will be used to create a game button.
 * It will do so by creating a Text.java instance
 * for the inner text, and it will create an instance
 * of the Rectangle.java class to be the background
 * colour. Its stroke size and colour will be changed
 * depending on whether or not the mouse cursor is over
 * the button.
 * 
 * This was made fully by Joshua Persaud.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: a helper class to create game buttons.
 * <p>
 * Filename: GameButton.java
 *
 * @author Joshua Persaud
 * @version 6/10/2022
 * 
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.text.Font
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.layout.StackPane
 * @see javafx.scene.layout.HBox
 * @see javafx.scene.Scene
 * @see javafx.scene.shape.StrokeType
 * @see javafx.scene.text.Text
 * @see javafx.scene.text.TextAlignment
 * @see javafx.scene.text.TextFlow
 * @see javafx.scene.layout.Pane
 * @see java.io.File
 * @see java.io.IOException
 * @see java.io.FileInputStream
 *
 * @since JDK1.17
 */
public class GameButton {
    
    /** Private non-static double variable used to hold the x-coordinate of the GameButton instance. */
    private double xCoord;
    
    /** Private non-static double variable used to hold the y-coordinate of the GameButton instance. */
    private double yCoord;
    
    /** Private non-static double variable used to hold the width of the GameButton instance. */
    private double width;
    
    /** Private non-static double variable used to hold the height of the GameButton instance. */
    private double height;
    
    /** Private non-static double variable used to hold the amount of pixels that the stroke of the rectangle behind the text will change to for the GameButton instance. */
    private double highlightSize;
    
    /** Private non-static double variable used to hold the amount of translation on the x-axis for the text inside of the GameButton instance. */
    private double textTranslationX;
    
    /** Private non-static double variable used to hold the amount of translation on the y-axis for the text inside of the GameButton instance. */
    private double textTranslationY;

    /** Private non-static variable that is an instance of the Text.java class and is used to hold the text inside of the GameButton instance. */
    private Text textText;
    
    /** Private non-static variable that is an instance of the Rectangle.java class and is used to hold the rectangle that will be behind the text for the GameButton instance. */
    private Rectangle boxAroundLabel;
    
    /** Private non-static variable that is an instance of the File.java class and is used to hold the font file for the GameButton instance. */
    private File textFontFile;
    
    /*
     * Class constructor used to create an instance of the GameButton.java class. It will take in 5 parameters.
     * 
     * @param textFontFile An instance of the File.java class, which is the file that holds the location of the font.
     * @param text An instance of the String.java class, which will hold the text for the GameButton instance's inside.
     * @param xCoord A double, which will be the x-coordinate of the GameButton instance.
     * @param yCoord A double, which will be the y-coordinate of the GameButton instance.
     * @param fontSize An double, which will be the size of the font used in the GameButton instance.
     */
    public GameButton (File textFontFile, String text, double xCoord, double yCoord, double fontSize) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = 160;
        this.height = 50;
        this.highlightSize = 3.0;
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
    
    /*
     * Public non-static method used to change the GameButton instance in the case that the cursor is over the button.
     * <p>
     * This public non-static method is void and will be used to change the GameButton
     * instance to the case when the cursor is over the button. This method will change
     * the stroke width of the rectangle used in the GameButton to have a stroke size of
     * the amount of pixels that is specified by the highlightSize variable.
     */
    public void cursorOverButton() {
        this.boxAroundLabel.setStrokeWidth(highlightSize);
    }
    
    /*
     * Public non-static method used to change the GameButton instance in the case that the cursor is not over the button.
     * <p>
     * This public non-static method is void and will be used to change the GameButton
     * instance to the case when the cursor is not over the button. This method will change
     * the stroke width of the rectangle used in the GameButton to have a stroke size of 0.
     */
    public void cursorNotOverButton() {
        this.boxAroundLabel.setStrokeWidth(0.0);
    }
    
    /*
     * Public non-static method used to get the left x-coordinate of the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the left x-coordinate of the
     * GameButton instance.
     * 
     * @return  A double, which will be the left x-coordinate of the GameButton instance.
     */
    public double getLeftX() {
        return this.xCoord;
    }
    
    /*
     * Public non-static method used to get the right x-coordinate of the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the right x-coordinate of the
     * GameButton instance. This is just the left x-coordinate plus the width of the GameButton
     * instance.
     * 
     * @return  A double, which will be the right x-coordinate of the GameButton instance.
     */
    public double getRightX() {
        return this.xCoord + this.width;
    }
    
    /*
     * Public non-static method used to get the top y-coordinate of the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the top y-coordinate of the
     * GameButton instance.
     * 
     * @return  A double, which will be the top y-coordinate of the GameButton instance.
     */
    public double getTopY() {
        return this.yCoord;
    }
    
    /*
     * Public non-static method used to get the bottom y-coordinate of the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the bottom y-coordinate of the
     * GameButton instance. This is just the top y-coordinate plus the height of the GameButton
     * instance.
     * 
     * @return  A double, which will be the bottom y-coordinate of the GameButton instance.
     */
    public double getBottomY() {
        return this.yCoord + this.height;
    }
    
    /*
     * Public non-static method used to set the x-coordinate of the GameButton instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, 
     * which is the new x-coordinate of the GameButton instance.
     * 
     * @param newXCoord A double, which will be the new x-coordinate of the GameButton instance.
     */
    public void setXCoord(double newXCoord) {
        this.xCoord = newXCoord;
    }
    
    /*
     * Public non-static method used to set the y-coordinate of the GameButton instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, 
     * which is the new y-coordinate of the GameButton instance.
     * 
     * @param newYCoord A double, which will be the new y-coordinate of the GameButton instance.
     */
    public void setYCoord(double newYCoord) {
        this.yCoord = newYCoord;
    }
    
    /*
     * Public non-static method used to get the width of the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the width of
     * the GameButton instance.
     * 
     * @return  A double, which will be the width of the GameButton instance.
     */
    public double getWidth() {
        return this.width;
    }
    
    /*
     * Public non-static method used to set the width of the GameButton instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, 
     * which will be the new width of the GameButton instance.
     * 
     * @param newWidth A double, which will be the new width of the GameButton instance.
     */
    public void setWidth(double newWidth) {
        this.width = newWidth;
        //this.textTextFlow.setPrefWidth(newWidth);
        this.boxAroundLabel.setWidth(newWidth);
    }
    
    /*
     * Public non-static method used to get the height of the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the height of
     * the GameButton instance.
     * 
     * @return  A double, which will be the height of the GameButton instance.
     */
    public double getHeight() {
        return this.height;
    }
    
    /*
     * Public non-static method used to set the height of the GameButton instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, 
     * which will be the new height of the GameButton instance.
     * 
     * @param newHeight A double, which will be the new height of the GameButton instance.
     */
    public void setHeight(double newHeight) {
        this.height = newHeight;
        //this.textTextFlow.setPrefHeight(newHeight);
        this.boxAroundLabel.setHeight(newHeight);
    }
    
    /*
     * Public non-static method used to get the size of the highlighting for the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the size of the
     * highlighting used (in pixels) in the GameButton instance.
     * 
     * @return  A double, which will be the size of the highlighting for the GameButton instance.
     */
    public double getHighlightSize() {
        return this.highlightSize;
    }
    
    /*
     * Public non-static method used to set the size of the highlighting for the GameButton instance.
     * <p>
     * This public non-static method is void and will take in a double as a parameter, which will
     * be the new highlighting size for the GameButton instance.
     * 
     * @param newHighlightSize A double, which is the new highlighting size for the GameButton instance.
     */
    public void setHighlightSize(double newHighlightSize) {
        this.highlightSize = newHighlightSize;
    }
    
    /*
     * Public non-static method used to get the amount of translation on the x-axis for the text in the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the amount of translation
     * used on the x-axis for the text in the GameButton instance.
     * 
     * @return  A double, which will be the amount of translation on the x-axis for the text in the GameButton instance.
     */
    public double getTextTranslationX() {
        return this.textTranslationX;
    }
    
    /*
     * Public non-static method used to set the amount of translation on the x-axis for the text in the GameButton instance.
     * <p>
     * This public non-static method is void and will take in a double as a parameter, 
     * which will will be the new amount of translation used on the x-axis for the text
     * in the GameButton instance.
     * 
     * @param newTextTranslationX A double, which is the new amount of translation on the x-axis for the text in the GameButton instance.
     */
    public void setTextTranslationX(double newTextTranslationX) {
        this.textTranslationX = newTextTranslationX;
    }
    
    /*
     * Public non-static method used to get the amount of translation on the y-axis for the text in the GameButton instance.
     * <p>
     * This public non-static method will return a double, which is the amount of translation
     * used on the y-axis for the text in the GameButton instance.
     * 
     * @return  A double, which will be the amount of translation on the y-axis for the text in the GameButton instance.
     */
    public double getTextTranslationY() {
        return this.textTranslationY;
    }
    
    /*
     * Public non-static method used to set the amount of translation on the y-axis for the text in the GameButton instance.
     * <p>
     * This public non-static method is void and will take in a double as a parameter, 
     * which will will be the new amount of translation used on the y-axis for the text
     * in the GameButton instance.
     * 
     * @param newTextTranslationY A double, which is the new amount of translation on the y-axis for the text in the GameButton instance.
     */
    public void setTextTranslationY(double newTextTranslationY) {
        this.textTranslationY = newTextTranslationY;
    }
    
    /*
     * Public non-static method used to get the text of the GameButton instance.
     * <p>
     * This public non-static method will return an instance of the Text.java class, which
     * will be the text used in the GameButton instance.
     * 
     * @return  An instance of the Text.java class, which will be the text of the GameButton instance.
     */
    public Text getText() {
        return this.textText;
    }
    
    /*
     * Public non-static method used to get the rectangle that is used in the background of the GameButton instance.
     * <p>
     * This public non-static method will return an instance of the Rectangle.java class, which is
     * the rectangle that is used in the background of the GameButton instance.
     * 
     * @return  An instance of the Rectangle.java class, which will be the rectangle that is used in the background of the GameButton instance.
     */
    public Rectangle getBackgroundRectangle() {
        return this.boxAroundLabel;
    }
    
    /*
     * Public non-static method used to get the file for the font of the GameButton instance.
     * <p>
     * This public non-static method will return an instance of the File.java class, which will
     * be the file that holds the .ttf file that is used for the font type for the GameButton
     * instance's text.
     * 
     * @return  An instance of the File.java class, which will be the file for the font of the GameButton instance.
     */
    public File getFontFile() {
        return this.textFontFile;
    }
    
    /*
     * Public non-static method used to set the file for the font of the GameButton instance.
     * <p>
     * This public non-static method is void and it will take in an instance of the File.java
     * class as a parameter, which will be the new .ttf file that will be used for the font
     * type for the GameButton instance.
     * 
     * @param newFontFile An instance of the File.java class, which will be the new file for
     *                    the font of the GameButton instance.
     */
    public void setFontFile(File newFontFile) {
        this.textFontFile = newFontFile;
    }

    /*
     * Public non-static method used to get a font of a specified size, from the file.
     * <p>
     * This public non-static method will return an instance of the Font.java class, and
     * it will be the font type that is created from the GameTitle instance's textFontFile.java
     * instance. The method will also take in a double as a parameter, and this will be the
     * font size of the desired font.
     * 
     * @param fontSize A double, which is the size of the desired font.
     * @return  An instance of the Font.java class, which is the Font that is desired at the 
     *          desired size.
     */
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
    
    /*
     * Public non-static method used to get the actual button from the GameButton instance.
     * <p>
     * This public non-static method will return an instance of the Pane.java class, and it
     * will hold the text and the background rectangle used in the GameButton instance.
     * 
     * @return  An instance of the Pane.java class, which is the actual game button from
     *          the GameButton instance.
     */
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