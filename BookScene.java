import javafx.scene.image.ImageView; // Imports the ImageView.java class, which allows the program to ImageView objects which are images that can be added to scenes and such (as they are just have the Image.java class functionality but also extend the very useful Node.java class).
import javafx.scene.text.Text; // Imports the Text.java class, which allows the program to beautiful text to display to the user.
import javafx.scene.text.TextFlow; // Imports the TextFlow.java class, which allows the program to layout instances of the Text.java class using a TextFlow instance.
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create Paint instances and set various colours.
import javafx.scene.text.Font; // Imports the Font.java class, which allows the program to create and use different fonts.
import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create rectangles.
import javafx.scene.layout.StackPane; // Imports the StackPane.java class, which allows the program to use the StackPane layout manager.
import javafx.scene.Group; // Imports the Group.java class, which allows the program to combing various nodes together so that they can be added to the Scene that is returned.

import java.io.File; // Imports the File.java class, which allows the program to access files on the computer, such as images.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to easily read in data from certain files.
import java.io.IOException; // Imports the IOException.java class, which allows the program to deal with and catch any errors thrown during reading of IO.

/**
 * Helper class that will create book scenes.
 * <p>
 * This class will be used to create a book scene.
 * It will do so by creating a Rectangle.java instances
 * for the book's cover, pages, and spine. There will also
 * be Text.java instances for the title and body text, and
 * there will be an ImageView.java instance for the image
 * that goes within the book. Lastly, there will be a
 * GameButton.java instance that will act as the back button
 * for the book scene.
 * 
 * This was made fully by Joshua Persaud.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: a helper class to create book scenes.
 * <p>
 * Filename: BookScene.java
 *
 * @author Joshua Persaud
 * @version 6/12/2022
 * 
 * @see javafx.scene.image.ImageView
 * @see javafx.scene.text.Text
 * @see javafx.scene.text.TextFlow
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.text.Font
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.layout.StackPane
 * @see javafx.scene.Group
 * @see java.io.File
 * @see java.io.IOException
 * @see java.io.FileInputStream
 *
 * @since JDK1.17
 */
public class BookScene {

    /** Private non-static variable that is an instance of the ImageView.java class and is used to hold onto the ImageView that is used on the book's page for the BookScene instance. */
    private ImageView bookImage;

    /** Private non-static variable that is an instance of the Text.java class and is used to hold onto the title text for the BookScene instance. */
    private Text titleText;

    /** Private non-static variable that is an instance of the Text.java class and is used to hold onto the body text for the BookScene instance. */
    private Text bodyText;

    /** Private non-static variable that is an instance of the Rectangle.java class and is used to hold onto the rectangle used for the background of the BookScene instance. */
    private Rectangle background;

    /** Private non-static variable that is an instance of the Rectangle.java class and is used to hold onto the rectangle used for the book cover of the BookScene instance. */
    private Rectangle bookCover;

    /** Private non-static variable that is an instance of the Rectangle.java class and is used to hold onto the rectangle used for the left page of the book in the BookScene instance. */
    private Rectangle bookLeftPage;

    /** Private non-static variable that is an instance of the Rectangle.java class and is used to hold onto the rectangle used for the right page of the book in the BookScene instance. */
    private Rectangle bookRightPage;

    /** Private non-static variable that is an instance of the Rectangle.java class and is used to hold onto the rectangle used for the spine of the book in the BookScene instance. */
    private Rectangle bookSpine;

    /** Private non-static variable that is an instance of the GameButton.java class and is used to act as the back button in the BookScene instance. */
    private GameButton backButton;

    /** Private non-static variable that is an instance of the File.java class and is used to onto the file that stores the font to be used in the BookScene instance. */
    private File textFontFile;

    /** Private non-static boolean variable that is used to hold onto whether or not the BookScene instance has its text on the left page (and its image on the right page) or the right page (and its image is on the left page). */
    private boolean textOnLeftSide;

    /** Private non-static double variable that is used to hold onto the amount of spacing to have between the lines of text for the BookScene instance. */
    private double lineSpacing;

    /*
     * Class constructor used to create an instance of the BookScene.java class. It will take in 6 parameters.
     * 
     * @param textFontFile An instance of the File.java class, which is the file that holds the location of the font for the BookScene instance.
     * @param bookImage An instance of the ImageView.java class, which is the ImageView for the image used on either the left page or the right page of the BookScene instance.
     * @param textForTitle An instance of the String.java class, which is the text that will be used in the title for the BookScene instance.
     * @param textForBody An instance of the String.java class, which is the text that will be used in the body for the BookScene instance.
     * @param textOnLeftSide A boolean, which is whether the text should be on the left page (and the image on the right page) or the right page (and the image on the left page).
     * @param lineSpacing A double, which is the amount of spacing (in pixels) to have between the lines of text.
     */
    public BookScene(File textFontFile, ImageView bookImage, String textForTitle, String textForBody, boolean textOnLeftSide, double lineSpacing) {
        this.instantiateVariables(textFontFile, bookImage, textForTitle, textForBody, textOnLeftSide, lineSpacing);

        this.backButton = new GameButton(this.textFontFile, "Back", 420, 535, 18);
        this.backButton.setWidth(125);
        this.backButton.setTextTranslationX(1);

    }
    
    /*
     * Class constructor used to create an instance of the BookScene.java class. It will take in 7 parameters.
     * 
     * @param textFontFile An instance of the File.java class, which is the file that holds the location of the font for the BookScene instance.
     * @param bookImage An instance of the ImageView.java class, which is the ImageView for the image used on either the left page or the right page of the BookScene instance.
     * @param textForTitle An instance of the String.java class, which is the text that will be used in the title for the BookScene instance.
     * @param textForBody An instance of the String.java class, which is the text that will be used in the body for the BookScene instance.
     * @param textOnLeftSide A boolean, which is whether the text should be on the left page (and the image on the right page) or the right page (and the image on the left page).
     * @param backButton An instance of the GameButton.java class, which is the GameButton that will act as the back button for the BookScene instance.
     * @param lineSpacing A double, which is the amount of spacing (in pixels) to have between the lines of text.
     */
    public BookScene(File textFontFile, ImageView bookImage, String textForTitle, String textForBody, boolean textOnLeftSide, GameButton backButton, double lineSpacing) {
        this.instantiateVariables(textFontFile, bookImage, textForTitle, textForBody, textOnLeftSide, lineSpacing);

        if (backButton != null) {
            backButton.setXCoord(420);
            backButton.setYCoord(535);
            //backButton = new GameButton(this.textFontFile, topLeftButtonText, 420, 535, 17);
            backButton.setWidth(125);
            backButton.getText().setText("Back");
            backButton.setTextTranslationX(1);
            this.backButton = backButton;
        } else {
            this.backButton = null;
        }
    }
    
    /*
     * Private non-static method used to instantiate variables that are instantiated in both constructors.
     * <p>
     * This private non-static method is void and will be used to instantiated variables
     * that would be instantiated in both constructors. This method is used to reduce the 
     * amount of code that is copied between both constructors.
     * 
     * @param textFontFile An instance of the File.java class, which is the file that holds the font for the text.
     * @param bookImage An instance of the ImageView.java class, which is the ImageView for the image used on either the left page or the right page of the BookScene instance.
     * @param textForTitle An instance of the String.java class, which is the text that will be used in the title for the BookScene instance.
     * @param textForBody An instance of the String.java class, which is the text that will be used in the body for the BookScene instance.
     * @param textOnLeftSide A boolean, which is whether the text should be on the left page (and the image on the right page) or the right page (and the image on the left page).
     * @param lineSpacing A double, which is the amount of spacing (in pixels) to have between the lines of text.
     */
    private void instantiateVariables(File textFontFile, ImageView bookImage, String textForTitle, String textForBody, boolean textOnLeftSide, double lineSpacing) {
        this.textFontFile = textFontFile;

        //this.backgroundPaint = Paint.valueOf("green");
        this.background = new Rectangle(600, 600, Paint.valueOf("rgb(64,158,64)"));
        this.background.setX(0);
        this.background.setY(0);

        //this.bookColour = Paint.valueOf("brown");
        this.bookCover = new Rectangle(550, 550, Paint.valueOf("rgb(164,116,73)"));
        this.bookCover.setX(25);
        this.bookCover.setY(25);
        this.bookCover.setStroke(Paint.valueOf("rgb(0,0,0)"));
        this.bookCover.setStrokeWidth(1.0);

        this.bookLeftPage = new Rectangle(245, 520, Paint.valueOf("rgb(242,238,203)"));
        this.bookLeftPage.setX(0);
        this.bookLeftPage.setY(0);
        this.bookLeftPage.setStroke(Paint.valueOf("gray"));
        this.bookLeftPage.setStrokeWidth(1.0);

        this.bookRightPage = new Rectangle(245, 520, Paint.valueOf("rgb(242,238,203)"));
        this.bookRightPage.setX(0);
        this.bookRightPage.setY(0);
        this.bookRightPage.setStroke(Paint.valueOf("gray"));
        this.bookRightPage.setStrokeWidth(1.0);

        //this.bookSpineColour = Paint.valueOf("rgb(0,0,0)");
        this.bookSpine = new Rectangle(10, 520, Paint.valueOf("rgb(0,0,0)"));
        this.bookSpine.setX(295);
        this.bookSpine.setY(40);

        bookImage.setPreserveRatio(true);
        bookImage.setSmooth(true);
        bookImage.setX(0);
        bookImage.setY(0);
        bookImage.setFitWidth(220);
        this.bookImage = bookImage;

        if (textForTitle != null) {
            this.titleText = new Text(textForTitle + "\n");
            this.titleText.setFont(this.getFontFromFile(12));
            this.titleText.setStyle("-fx-underline: true;");
            this.titleText.setX(0);
            this.titleText.setY(0);
            //this.titleText.setWrappingWidth(220);
        } else {
            this.titleText = null;
        }

        if (textForBody != null) {
            this.bodyText = new Text(textForBody);
            this.bodyText.setFont(this.getFontFromFile(11));
            //this.bodyText.setLineSpacing(5);
            this.bodyText.setX(0);
            this.bodyText.setY(0);
            //this.bodyText.setWrappingWidth(220);
        } else {
            this.bodyText = null;
        }

        this.textOnLeftSide = textOnLeftSide;

        this.lineSpacing = lineSpacing;
    }
    
    /**
     * Public method that returns the ImageView that is used for the image in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * ImageView.java class, which is the image that is used as
     * the image for the BookScene instance.
     * 
     * @return  An instance of the ImageView.java class, which is
     *          the image for the book used by the BookScene
     *          instance.
     */
    public ImageView getBookImage() {
        return this.bookImage;
    }
    
    /**
     * Public method that returns the text that is used for the title in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * Text.java class, which is the text that is used for the
     * title in the BookScene instance.
     * 
     * @return  An instance of the Text.java class, which is the
     *          title text for the book used by the BookScene
     *          instance.
     */
    public Text getTitle() {
        return this.titleText;
    }

    /**
     * Public method that returns the text that is used for the body in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * Text.java class, which is the text that is used for the
     * body in the BookScene instance.
     * 
     * @return  An instance of the Text.java class, which is the
     *          body text for the book used by the BookScene
     *          instance.
     */
    public Text getBody() {
        return this.bodyText;
    }

    /*
    public Paint backgroundPaint() {
        return this.backgroundPaint;
    }
    */

    /**
     * Public method that returns the rectangle that is used for the background in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * Rectangle.java class, which is the rectangle that is used
     * for the background in the BookScene instance.
     * 
     * @return  An instance of the Rectangle.java class, which is
     *          the background for the book used by the BookScene
     *          instance.
     */
    public Rectangle getBackground() {
        return this.background;
    }
    
    /**
     * Public method that returns the rectangle that is used for the book cover for the book in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * Rectangle.java class, which is the rectangle that is used
     * for the book cover for the book in the BookScene instance.
     * 
     * @return  An instance of the Rectangle.java class, which is
     *          the book cover for the book used by the BookScene
     *          instance.
     */
    public Rectangle getBookCover() {
        return this.bookCover;
    }

    /**
     * Public method that returns the rectangle that is used for the left page for the book in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * Rectangle.java class, which is the rectangle that is used
     * for the left page for the book in the BookScene instance.
     * 
     * @return  An instance of the Rectangle.java class, which is
     *          the left page for the book used by the BookScene
     *          instance.
     */
    public Rectangle getBookLeftPage() {
        return this.bookLeftPage;
    }

    /**
     * Public method that returns the rectangle that is used for the right page for the book in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * Rectangle.java class, which is the rectangle that is used
     * for the right page for the book in the BookScene instance.
     * 
     * @return  An instance of the Rectangle.java class, which is
     *          the right page for the book used by the BookScene
     *          instance.
     */
    public Rectangle getBookRightPage() {
        return this.bookRightPage;
    }

    /**
     * Public method that returns the rectangle that is used for the book spine for the book in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * Rectangle.java class, which is the rectangle that is used
     * for the book spine for the book in the BookScene instance.
     * 
     * @return  An instance of the Rectangle.java class, which is
     *          the book spine for the book used by the BookScene
     *          instance.
     */
    public Rectangle getBookSpine() {
        return this.bookSpine;
    }

    /**
     * Public method that returns the GameButton that is used as the back button in the BookScene instance.
     * <p>
     * This public non-static method returns an instance of the 
     * GameButton.java class, which is the GameButton that is used
     * as the back button in the BookScene instance.
     * 
     * @return  An instance of the GameButton.java class, which is
     *          the back button used by the BookScene instance.
     */
    public GameButton getBackButton() {
        return this.backButton;
    }

    /*
     * Public non-static method used to get the file for the font of the BookScene instance.
     * <p>
     * This public non-static method will return an instance of the File.java class, which will
     * be the file that holds the .ttf file that is used for the font type for the BookScene
     * instance's text.
     * 
     * @return  An instance of the File.java class, which will be the file for the font of the BookScene instance.
     */
    public File getFontFile() {
        return this.textFontFile;
    }
    
    /*
     * Public non-static method used to set the file for the font of the BookScene instance.
     * <p>
     * This public non-static method is void and it will take in an instance of the File.java
     * class as a parameter, which will be the new .ttf file that will be used for the font
     * type for the BookScene instance.
     * 
     * @param newFontFile An instance of the File.java class, which will be the new file for
     *                    the font of the BookScene instance.
     */
    public void setFontFile(File newFontFile) {
        this.textFontFile = newFontFile;
    }

    /*
     * Public non-static method used to get whether or not the text is on the left page of the book of the BookScene instance.
     * <p>
     * This public non-static method will return a boolean, which will be whether or not
     * the text is on the left page of the book or not.
     * 
     * @return  A boolean, which is whether or not the text is on the left page of the
     *          book or not for the BookScene instance.
     */
    public boolean getIfTextOnLeftSide() {
        return this.textOnLeftSide;
    }
    
    /*
     * Public non-static method used to set whether or not the text is on the left page of the book of the BookScene instance.
     * <p>
     * This public non-static method is void an will take in a boolean as a parameter
     * which will be the new value of whether or not the text is on the left page of
     * the book.
     * 
     * @param newTextOnLeftSide A boolean, which is whether or not the text is on the
     *                          left page of the book or not for the BookScene instance.
     */
    public void setIfTextOnLeftSide(boolean newTextOnLeftSide) {
        this.textOnLeftSide = newTextOnLeftSide;
    }

    /*
     * Public non-static method used to get the amount of line spacing (in pixels) that is used between the text in the BookScene instance.
     * <p>
     * This public non-static method will return a double, which is the amount of line
     * spacing (in pixels) between the text that is used in the BookScene instance.
     * 
     * @return  A double, which is the amount of spacing between the lines of text in
     *          the BookScene instance.
     */
    public double getLineSpacing() {
        return this.lineSpacing;
    }

    /*
     * Public non-static method used to set the amount of line spacing (in pixels) that is used between the text in the BookScene instance.
     * <p>
     * This public non-static method is void and will take in a double as a parameter,
     * which is the new amount of line spacing (in pixels) between the text that is
     * used in the BookScene instance.
     * 
     * @param newLineSpacing A double, which is the new amount of spacing between the
     *                       lines of text in the BookScene instance.
     */
    public void setLineSpacing(double newLineSpacing) {
        this.lineSpacing = newLineSpacing;
    }

    /*
     * Public non-static method used to get the book scene itself from the BookScene instance.
     * <p>
     * This public non-static method will return an instance of the Group.java class,
     * which will be the actual book scene. This Group.java instance will contain all
     * the nodes that are needed to create the book.
     * 
     * @return  An instance of the Group.java class, which will be the actual book
     *          scene from the BookScene instance.
     */
    public Group getScene() {
        /*
           TextFlow tempTextFlow = new TextFlow;
           tempTextFlow.getChildren().addAll(
               this.titleText,
               this.bodyText
           );
           tempTextFlow.setPrefWidth(245);
           tempTextFlow.setPrefHeight(500);
           if (textOnLeftSide) {
               tempTextFlow.setTranslateX(50);
           } else {
               tempTextFlow.setTranslateX(305);
           }
           tempTextFlow.setTranslateY(50);
           */

        //StackPane tempStackPaneText = new StackPane();
        TextFlow tempTextFlow = new TextFlow();
        StackPane tempStackPaneImage = new StackPane();
        if (this.textOnLeftSide) {
            this.bodyText.setTranslateY(20);

            tempTextFlow.getChildren().addAll(
                this.titleText,
                this.bodyText
            );
            tempTextFlow.setPrefWidth(200);
            tempTextFlow.setLineSpacing(this.lineSpacing);
            tempTextFlow.setTranslateX(70);
            tempTextFlow.setTranslateY(60);

            this.bookLeftPage.setX(50);
            this.bookLeftPage.setY(40);

            /*
            tempStackPaneText.getChildren().addAll(
                this.bookLeftPage,
                tempTextFlow
            );
            tempStackPaneText.setPrefWidth(200);
            //tempStackPaneText.setPrefHeight(480);
            tempStackPaneText.setTranslateX(50);
            tempStackPaneText.setTranslateY(40);
            */

            tempStackPaneImage.getChildren().addAll(
                this.bookRightPage,
                this.bookImage
            );
            tempStackPaneImage.setTranslateX(305);
            tempStackPaneImage.setTranslateY(40);
        } else {
            this.bodyText.setTranslateY(20);

            tempTextFlow.getChildren().addAll(
                this.titleText,
                this.bodyText
            );
            tempTextFlow.setPrefWidth(200);
            tempTextFlow.setLineSpacing(this.lineSpacing);
            tempTextFlow.setTranslateX(325);
            tempTextFlow.setTranslateY(60);

            this.bookLeftPage.setX(305);
            this.bookLeftPage.setY(40);

            /*
            tempStackPaneText.getChildren().addAll(
                this.bookLeftPage,
                tempTextFlow
            );
            tempStackPaneText.setPrefWidth(200);
            //tempStackPaneText.setPrefHeight(480);
            tempStackPaneText.setTranslateX(50);
            tempStackPaneText.setTranslateY(40);
            */

            tempStackPaneImage.getChildren().addAll(
                this.bookRightPage,
                this.bookImage
            );
            tempStackPaneImage.setTranslateX(50);
            tempStackPaneImage.setTranslateY(40);
        }

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            this.background,
            this.bookCover,
            this.bookLeftPage,
            tempTextFlow,
            //tempStackPaneText,
            tempStackPaneImage,
            //this.bookRightPage,
            this.bookSpine
            //this.bookImage
            //tempTextFlow
        );

        if (this.backButton != null) nodesToAdd.getChildren().add(this.backButton.getButton());

        return nodesToAdd;
    }

    /*
     * Public non-static method used to get a font of a specified size, from the file.
     * <p>
     * This public non-static method will return an instance of the Font.java class, and
     * it will be the font type that is created from the BookScene instance's textFontFile
     * File instance. The method will also take in a double as a parameter, and this will be
     * the font size of the desired font.
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
}