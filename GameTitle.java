import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create a rectangle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.text.Font; // Imports the Font.java class, which allows the program to create and use fonts.
import javafx.scene.layout.StackPane; // Imports the StackPane.java class, which allows the program to use the StackPane layout manager.
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create and use different paint colours.
import javafx.scene.control.Label; // Imports the Label.java class, which allows the program to use labels to compute the width and height of the given text.
import javafx.scene.layout.HBox; // Imports the HBox.java class, which allows the program to add the labels to a layout manager so that the width and height can be computed.
import javafx.scene.Scene; // Imports the Scene.java class, which allows the program to have access to a scene on which the GUI can be added onto and displayed to the user.
import javafx.scene.text.Text; // Imports the Text.java class, which allows the program to take Strings of text and convert it into a good looking String for the user.
import javafx.scene.text.TextAlignment; // Imports the TextAlignment.java class, which allows the program to set the alignment of text, especially within TextFlow instances.
import javafx.scene.text.TextFlow; // Imports the TextFlow.java class, which allows the program to add two or more Text.java instances together.
import javafx.scene.layout.Region; // Imports the Region.java class, which allows the program to use default computed values for the width and height.

import java.io.File; // Imports the File.java class, which allows the program to access files that are on the user's computer.
import java.io.IOException; // Imports the IOException.java class, which allows the program to take care of the IOExceptions that are thrown by any parts of the program.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to read in data from files that are on the user's computer.

/**
 * Helper class that will create game titles.
 * <p>
 * This class will be used to create a game title.
 * It will do so by creating instances of the Text.java
 * class and then modifying them to look like titles.
 * 
 * This was made fully by Joshua Persaud.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: a helper class to create game titles.
 * <p>
 * Filename: GameTitle.java
 *
 * @author Joshua Persaud
 * @version 6/10/2022
 * 
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.text.Font
 * @see javafx.scene.layout.StackPane
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.control.Label
 * @see javafx.scene.layout.HBox
 * @see javafx.scene.Scene
 * @see javafx.scene.text.Text
 * @see javafx.scene.text.TextAlignment
 * @see javafx.scene.text.TextFlow
 * @see javafx.scene.layout.Region
 * @see java.io.File
 * @see java.io.IOException
 * @see java.io.FileInputStream
 *
 * @since JDK1.17
 */
public class GameTitle {
    
    /** Private non-static double variable used to hold the x-coordinate of the GameTitle instance. */
    private double xCoord;
    
    /** Private non-static double variable used to hold the y-coordinate of the GameTitle instance. */
    private double yCoord;
    
    /** Private non-static double variable used to hold the width of the GameTitle instance. */
    private double width;
    
    /** Private non-static double variable used to hold the height of the GameTitle instance. */
    private double height;
    
    /** Private non-static double variable used to hold the spacing of the text of the GameTitle instance. */
    private double spacing;
    
    /** Private non-static variable that is an instance of the Text.java class and is used to hold the title of the GameTitle instance. */
    private Text title;
    
    /** Private non-static variable that is an instance of the Text.java class and is used to hold the subheading of the GameTitle instance. */    
    private Text subheading;
    
    /** Private non-static variable that is an instance of the Rectangle.java class and is used to hold a rectangle that will act as the underline of the GameTitle instance. */
    private Rectangle underlineRect;
    
    /** Private non-static variable that is an instance of the File.java class and is used to hold the font file for the GameTitle instance. */
    private File textFontFile;
    
    /*
     * Class constructor used to create an instance of the GameTitle.java class. It will take in 6 parameters.
     * 
     * @param textFontFile An instance of the File.java class, which is the file that holds the location of the font.
     * @param titleText An instance of the String.java class, which will hold the text for the title.
     * @param subheadingText An instance of the String.java class, which will hold the text for the subheading.
     * @param xCoord A double, which will be the x-coordinate of the GameTitle instance.
     * @param yCoord A double, which will be the y-coordinate of the GameTitle instance.
     * @param fontSize An double, which will be the size of the font used in the GameTitle instance.
     */
    public GameTitle(File textFontFile, String titleText, String subheadingText, double xCoord, double yCoord, double fontSize) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = Region.USE_COMPUTED_SIZE;
        this.height = Region.USE_COMPUTED_SIZE;
        this.spacing = 10;
        this.textFontFile = textFontFile;
        
        this.title = new Text(titleText + "\n");
        this.title.setFont(this.getFontFromFile(fontSize));
        this.title.setFill(Paint.valueOf("rgb(255,255,255)"));
        
        this.subheading = new Text(subheadingText);
        this.subheading.setFont(this.getFontFromFile(fontSize));
        this.subheading.setFill(Paint.valueOf("rgb(255,0,0)"));
        
        this.underlineRect = new Rectangle(0, this.getHeight(this.title), this.getWidth(this.title), 2);
        this.underlineRect.setFill(Paint.valueOf("rgb(255,255,255)"));
    }
    
    /*
     * Public non-static method used to get the x-coordinate of the GameTitle instance.
     * <p>
     * This public non-static method will return a double, which is the x-coordinate of the
     * GameTitle instance.
     * 
     * @return  A double, which will be the x-coordinate of the GameTitle instance.
     */
    public double getXCoord() {
        return this.xCoord;
    }
    
    /*
     * Public non-static method used to set the x-coordinate of the GameTitle instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, 
     * which is the new x-coordinate of the GameTitle instance.
     * 
     * @param newXCoord A double, which will be the new x-coordinate of the GameTitle instance.
     */
    public void setXCoord(double newXCoord) {
        this.xCoord = newXCoord;
    }
    
    /*
     * Public non-static method used to get the y-coordinate of the GameTitle instance.
     * <p>
     * This public non-static method will return a double, which is the y-coordinate
     * of the GameTitle instance.
     * 
     * @return  A double, which will be the y-coordinate of the GameTitle instance.
     */
    public double getYCoord() {
        return this.yCoord;
    }
    
    /*
     * Public non-static method used to set the y-coordinate of the GameTitle instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, 
     * which is the new y-coordinate of the GameTitle instance.
     * 
     * @param newYCoord A double, which will be the new y-coordinate of the GameTitle instance.
     */
    public void setYCoord(double newYCoord) {
        this.yCoord = newYCoord;
    }
    
    /*
     * Public non-static method used to get the width of the GameTitle instance.
     * <p>
     * This public non-static method will return a double, which is the width of
     * the GameTitle instance.
     * 
     * @return  A double, which will be the width of the GameTitle instance.
     */
    public double getWidth() {
        return this.width;
    }
    
    /*
     * Public non-static method used to set the width of the GameTitle instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, 
     * which will be the new width of the GameTitle instance.
     * 
     * @param newWidth A double, which will be the new width of the GameTitle instance.
     */
    public void setWidth(double newWidth) {
        this.width = newWidth;
        this.underlineRect.setWidth(newWidth);
    }
    
    /*
     * Public non-static method used to get the height of the GameTitle instance.
     * <p>
     * This public non-static method will return a double, which is the height
     * of the GameTitle instance.
     * 
     * @return  A double, which will be the height of the GameTitle instance.
     */
    public double getHeight() {
        return this.height;
    }
    
    /*
     * Public non-static method used to set the height of the GameTitle instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, 
     * which will be the new height of the GameTitle instance.
     * 
     * @param newHeight A double, which will be the new height of the GameTitle instance.
     */
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }
    
    /*
     * Public non-static method used to get the spacing between the text of the GameTitle instance.
     * <p>
     * This public non-static method will return a double, which is the amount of spacing (in pixels)
     * between the title and the subheading of the GameTitle instance.
     * 
     * @return  A double, which will be the spacing between the text of the GameTitle instance.
     */
    public double getSpacing() {
        return this.spacing;
    }
    
    /*
     * Public non-static method used to set the spacing between the text of the GameTitle instance.
     * <p>
     * This public non-static method is void and it will take in a double as a parameter, which will
     * be the new amount of spacing (in pixels) between the title and subheading of the GameTitle instance.
     * 
     * @param newSpacing A double, which will be the new spacing between the text of the GameTitle instance.
     */
    public void setSpacing(double newSpacing) {
        this.spacing = newSpacing;
    }
    
    /*
     * Public non-static method used to get the title text of the GameTitle instance.
     * <p>
     * This public non-static method will return an instance of the Text.java class, which
     * will be the title portion of the GameTitle instance.
     * 
     * @return  An instance of the Text.java class, which will be the title text of the GameTitle instance.
     */
    public Text getTitleText() {
        return this.title;
    }
    
    /*
     * Public non-static method used to get the subheading text of the GameTitle instance.
     * <p>
     * This public non-static method will return an instance of the Text.java class, which
     * will be the subheading portion of the GameTitle instance.
     * 
     * @return  An instance of the Text.java class, which will be the subheading text of the GameTitle instance.
     */
    public Text getSubheadingText() {
        return this.subheading;
    }
    
    /*
     * Public non-static method used to get the underline rectangle of the GameTitle instance.
     * <p>
     * This public non-static method will return an instance of the Rectangle.java class, which
     * will be the rectangle that is used for the underline underneath the title portion of the
     * GameTitle instance (a rectangle is used because the default underline that is created
     * through JavaFX CSS is too thin and cannot be customized).
     * 
     * @return  An instance of the Rectangle.java class, which will be the underline rectangle of the GameTitle instance.
     */
    public Rectangle getUnderlineRectangle() {
        return this.underlineRect;
    }
    
    /*
     * Public non-static method used to get the file for the font of the GameTitle instance.
     * <p>
     * This public non-static method will return an instance of the File.java class, which will
     * be the file that holds the .ttf file that is used for the font type for the GameTitle
     * instance's text.
     * 
     * @return  An instance of the File.java class, which will be the file for the font of the GameTitle instance.
     */
    public File getFontFile() {
        return this.textFontFile;
    }
    
    /*
     * Public non-static method used to set the file for the font of the GameTitle instance.
     * <p>
     * This public non-static method is void and it will take in an instance of the File.java
     * class as a parameter, which will be the new .ttf file that will be used for the font
     * type for the GameTitle instance.
     * 
     * @param newFontFile An instance of the File.java class, which will be the new file for
     *                    the font of the GameTitle instance.
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
     * Public non-static method used to get the actual game title from the GameTitle instance.
     * <p>
     * This public non-static method will return an instance of the StackPane.java class,
     * which will hold onto the title text, the subheading text, and the rectangle that
     * is used for the underline.
     * 
     * @return  An instance of the StackPane.java class, which will be the actual game title
                from the GameTitle instance.
     */
    public StackPane getTitle() {
        TextFlow tempTextFlow = new TextFlow();
        tempTextFlow.getChildren().addAll(
            this.title,
            this.subheading
        );
        tempTextFlow.setTextAlignment(TextAlignment.CENTER);
        tempTextFlow.setLineSpacing(this.spacing);
        tempTextFlow.setPrefWidth(this.width);
        tempTextFlow.setPrefHeight(this.height);
        
        StackPane overallTitle = new StackPane();
        overallTitle.getChildren().addAll(
            tempTextFlow,
            this.underlineRect
        );
        
        overallTitle.setTranslateX(this.xCoord);
        overallTitle.setTranslateY(this.yCoord);
        
        return overallTitle;
    }
    
    /*
     * Private non-static method used to compute and return the width of a Text.java instance.
     * <p>
     * This private non-static method will return a double, which is the computed width of the
     * Text.java instance that is passed through as a parameter. The reason why a method is needed
     * is because the Text.java instance needs to be rendered first (and its CSS has to be compiled
     * and ran) so that its true width can be found.
     * 
     * @param text An instance of the Text.java class, which will be the Text that this method needs
     *             to render (and whose CSS needs to be compiled and ran) so that its width can be found.
     * @return  A double, which will be the computed width of the Text.java instance that is passed
     *          through as a parameter.
     */
    private double getWidth(Text text) {
        Label label = new Label(text.getText());
        label.setFont(text.getFont());
        HBox root = new HBox();
        root.getChildren().addAll(
            label
        );
        Scene scene = new Scene(root, 600, 600);
        
        root.applyCss();
        root.layout();
        return label.getWidth();
    }
    
    /*
     * Private non-static method used to compute and return the height of a Text.java instance.
     * <p>
     * This private non-static method will return a double, which is the computed height of the
     * Text.java instance that is passed through as a parameter. The reason why a method is needed
     * is because the Text.java instance needs to be rendered first (and its CSS has to be compiled
     * and ran) so that its true height can be found.
     * 
     * @param text An instance of the Text.java class, which will be the Text that this method needs
     *             to render (and whose CSS needs to be compiled and ran) so that its height can be found.
     * @return  A double, which will be the computed height of the Text.java instance that is passed
     *          through as a parameter.
     */
    private double getHeight(Text text) {
        Label label = new Label(text.getText());
        label.setFont(text.getFont());
        HBox root = new HBox();
        root.getChildren().addAll(
            label
        );
        Scene scene = new Scene(root, 600, 600);
        
        root.applyCss();
        root.layout();
        return label.getHeight();
    }    
}

/*
    public GameTitle(File fontFile, String titleFontPaint, String subheadingText, String subheadingFontPaint, double spacing, double xCoord, double yCoord, double width) {
        this(fontFile, "Trans-form:", 24, titleFontPaint, subheadingText, 24, subheadingFontPaint, spacing, 0, 2, xCoord, yCoord, width, Region.USE_COMPUTED_SIZE);
    }
    
    public GameTitle(File fontFile, String titleText, int titleFontSize, String titleFontPaint, String subheadingText, int subheadingFontSize, String subheadingFontPaint, double spacing, double underlineY, double underlineHeight, double xCoord, double yCoord, double width, double height) {
        Text title = new Text(titleText + "\n");
        
        title.setFont(this.getFontFromFile(fontFile, titleFontSize));
        title.setFill(Paint.valueOf(titleFontPaint));
        //title.setStyle("-fx-underline: true;");
        //title.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: rgba(255,255,255,0); -fx-text-fill: " + titleFontPaint + "; -fx-font-size: " + titleFontSize + "px;"); // -fx-text-decoration: underline; -fx-opacity: 1;
        //title.setUnderline(true);

        Text subheading = new Text(subheadingText);
        subheading.setFont(this.getFontFromFile(fontFile, subheadingFontSize));
        subheading.setFill(Paint.valueOf(subheadingFontPaint));
        //subheading.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: rgba(255,255,255,0); -fx-text-fill: " + subheadingFontPaint + "; -fx-font-size: " + subheadingFontSize + "px;"); // -fx-opacity: 1;
        
        TextFlow tempTextFlow = new TextFlow();
        tempTextFlow.getChildren().addAll(
            title,
            subheading
        );
        tempTextFlow.setTextAlignment(TextAlignment.CENTER);
        tempTextFlow.setLineSpacing(spacing);
        tempTextFlow.setPrefWidth(width);
        tempTextFlow.setPrefHeight(height);
        
        Rectangle underlineRect = new Rectangle(0, this.getHeight(title), this.getWidth(title), underlineHeight);
        underlineRect.setFill(Paint.valueOf(titleFontPaint));
        underlineRect.setTranslateY(underlineY);
        
        
        this.overallTitle = new StackPane();
        this.overallTitle.getChildren().addAll(
            tempTextFlow,
            underlineRect
        );
        
        this.overallTitle.setTranslateX(xCoord);
        this.overallTitle.setTranslateY(yCoord);
           
    }
*/

/*
    public GameTitle(File fontFile, String titleText, int titleFontSize, String titleFontPaint, String subheadingText, int subheadingFontSize, String subheadingFontPaint, double xCoord, double yCoord, double gap, double underlineHeight, double underlineY) {
        Label titleLabel = new Label(titleText);
        
        Font fontFont = new Font(1); // It doesn't matter what size font I put, so I will default it to 1.
        try {
            FileInputStream fontFIS = new FileInputStream(fontFile);
            fontFont = Font.loadFont(new FileInputStream(fontFile), 1); // It doesn't matter what size font I put, so I will default it to 1.
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println(fontFile.getPath());
        //titleLabel.setTextFill(Paint.valueOf(fontPaint));
        titleLabel.setFont(fontFont);
        titleLabel.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: rgba(255,255,255,0); -fx-text-fill: " + titleFontPaint + "; -fx-font-size: " + titleFontSize + "px;"); // -fx-text-decoration: underline; -fx-opacity: 1;
        //titleLabel.setTranslateX(xCoord);
        //titleLabel.setTranslateY(yCoord);
        //titleLabel.setWidth(width);
        //titleLabel.setHeight(height);
        
        Label subheadingLabel = new Label(subheadingText);
        subheadingLabel.setFont(fontFont);
        subheadingLabel.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: rgba(255,255,255,0); -fx-text-fill: " + subheadingFontPaint + "; -fx-font-size: " + subheadingFontSize + "px;"); // -fx-opacity: 1;
        //subheadingLabel.setTranslateX(xCoord);
        //subheadingLabel.setTranslateY(yCoord + this.label.getHeight());
        //subheadingLabel.setWidth(width);
        //subheadingLabel.setHeight(height);
        
        double width = Math.max(this.getWidth(titleLabel), this.getWidth(subheadingLabel));
        
        Rectangle rectAroundTitleLabel = new Rectangle(0, 0, width, this.getHeight(titleLabel));
        rectAroundTitleLabel.setFill(Paint.valueOf("rgba(255,255,255,0)"));
        
        StackPane titleStackPane = new StackPane();
        titleStackPane.getChildren().addAll(
            //rectAroundTitleLabel,
            titleLabel
        );
        
        //GridPane.setRowIndex(titleStackPane, 0);
        //GridPane.setColumnIndex(titleStackPane, 0);
        
        Rectangle rectAroundSubheadingLabel = new Rectangle(0, 0, width, this.getHeight(subheadingLabel));
        rectAroundSubheadingLabel.setFill(Paint.valueOf("rgba(255,255,255,0)"));
        
        StackPane subheadingStackPane = new StackPane();
        subheadingStackPane.getChildren().addAll(
            rectAroundSubheadingLabel,
            subheadingLabel
        );
        subheadingStackPane.setTranslateY(this.getHeight(titleLabel));
        
        //GridPane.setRowIndex(subheadingStackPane, 1);
        //GridPane.setColumnIndex(subheadingStackPane, 0);
        
        
        //StackPane.setAlignment(titleStackPane, Pos.TOP_CENTER);
        //StackPane.setAlignment(subheadingStackPane, Pos.BOTTOM_CENTER);
        
        /*
        this.overallTitle = new StackPane();
        this.overallTitle.getChildren().addAll(
            titleStackPane,
            subheadingStackPane
        );
        */
        
        //this.overallTitle = new GridPane();
        //this.overallTitle.add(titleStackPane, 0, 0);
        //this.overallTitle.add(subheadingStackPane, 0, 1);
        //GridPane titlePlusSubheadingGridPane = new GridPane();
        /*
        titlePlusSubheadingGridPane.getChildren().addAll(
            subheadingStackPane,
            titleStackPane
            
        );
        */
        //titlePlusSubheadingGridPane.add(titleLabel, 0, 0, 1, 1);
        //titlePlusSubheadingGridPane.add(subheadingLabel, 0, 1, 1, 1);
        //titlePlusSubheadingGridPane.setAlignment(Pos.CENTER);
        //titlePlusSubheadingGridPane.setVgap(gap);
        
        //Rectangle underlineRect = new Rectangle(0, underlineY, this.getWidth(titleLabel), underlineHeight);
        //underlineRect.setFill(Paint.valueOf(titleFontPaint));
        
        /*
        this.overallTitle = new StackPane();
        this.overallTitle.getChildren().addAll(
            //titlePlusSubheadingGridPane,
            //underlineRect
            //titleStackPane,
            //subheadingStackPane,
            //underlineRect
        );
        
        this.overallTitle.setTranslateX(xCoord);
        this.overallTitle.setTranslateY(yCoord);
        */
        //this.overallTitle = titleStackPane;
    //}