import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create a rectangle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create and use different paint colours.
import javafx.scene.Group; // Imports the Group.java class, which allows the program to combing various nodes together so that they can be added to the Scene that is returned.
import javafx.scene.text.Font;// Imports the Font.java class, which allows the program to create and use different fonts.
import java.io.File; // Imports the File.java class, which allows the program to access files on the computer, such as images.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to easily read in data from certain files.
import java.io.IOException; // Imports the IOException.java class, which allows the program to deal with and catch any errors thrown during reading of IO.

/**
 * Program to create a pause screen.
 * <p>
 * This class will be used to create a pause
 * screen. It will do so by creating a
 * mostly clear rectangle that will be the
 * background. It will also create two
 * rectangles for the pause symbol and it
 * will make two GameButton.java instances,
 * one for the exit button and the other for
 * the main menu button.
 * 
 * This was made fully by Joshua Persaud.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: to create pause scenes.
 * <p>
 * Filename: PauseScene.java
 * 
 * @author Joshua Persaud
 * @version 6/14/2022
 * 
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.Group
 * @see javafx.scene.text.Font
 * @see java.io.File
 * @see java.io.IOException
 * @see java.io.FileInputStream
 * 
 * @since JDK1.17
 */
public class PauseScene {

    /** Private non-static File variable that will hold onto the file that holds the font to be used. */
    private File textFontFile;
    
    /** Private non-static Rectangle variable that will hold onto the rectangle that is used as the clear overlay over the scene. */
    private Rectangle clearOverlay;

    /** Private non-static Rectangle variable that will hold onto the rectangle that is used as the left bar in the pause button symbol. */
    private Rectangle leftRectPauseButton;
    
    /** Private non-static Rectangle variable that will hold onto the rectangle that is used as the right bar in the pause button symbol. */
    private Rectangle rightRectPauseButton;
    
    /** Private non-static GameButton variable that will hold onto the GameButton instance that is used for the exit button. */
    private GameButton exitGameButton;
    
    /** Private non-static GameButton variable that will hold onto the GameButton instance that is used for the main menu button. */
    private GameButton mainMenuGameButton;
    
    /**
     * An instance of the PauseScene class will be created using this one parameter constructor.
     * 
     * @param textFontFile A File variable, which will be the file where the font to be used is located.
     */
    public PauseScene (File textFontFile) {
        this.textFontFile = textFontFile;
        
        this.clearOverlay = new Rectangle(600, 600, Paint.valueOf("rgba(0,0,0,0.2)"));
    
        this.leftRectPauseButton = new Rectangle(238, 100, 25, 175);
        this.leftRectPauseButton.setFill(Paint.valueOf("rgb(255,255,255)"));
        this.leftRectPauseButton.setStroke(Paint.valueOf("rgb(0,0,0)"));
        this.leftRectPauseButton.setStrokeWidth(3.0);
        
        this.rightRectPauseButton = new Rectangle(337, 100, 25, 175);
        this.rightRectPauseButton.setFill(Paint.valueOf("rgb(255,255,255)"));
        this.rightRectPauseButton.setStroke(Paint.valueOf("rgb(0,0,0)"));
        this.rightRectPauseButton.setStrokeWidth(3.0);
        
        this.exitGameButton = new GameButton(this.textFontFile, "Exit Game", 50, 400, 17);
        this.exitGameButton.setWidth(200);
        this.exitGameButton.setHeight(60);
        this.exitGameButton.setTextTranslationY(5);
        
        this.mainMenuGameButton = new GameButton(this.textFontFile, "Main Menu", 350, 400, 17);
        this.mainMenuGameButton.setWidth(200);
        this.mainMenuGameButton.setHeight(60);
        this.mainMenuGameButton.setTextTranslationY(5);
    }
    
    /**
     * An instance of the PauseScene class will be created using this three parameter constructor.
     * 
     * @param textFontFile A File variable, which will be the file where the font to be used is located.
     * @param exitGameButton A GameButton variable, which will be the GameButton that is used for the exit button.
     * @param mainMenuGameButton A GameButton variable, which will be the GameButton that is used for the main menu button.
     */
    public PauseScene (File textFontFile, GameButton exitGameButton, GameButton mainMenuGameButton) {
        this.textFontFile = textFontFile;
        
        this.clearOverlay = new Rectangle(600, 600, Paint.valueOf("rgba(0,0,0,0.2)"));
    
        this.leftRectPauseButton = new Rectangle(238, 100, 25, 175);
        this.leftRectPauseButton.setFill(Paint.valueOf("rgb(255,255,255)"));
        this.leftRectPauseButton.setStroke(Paint.valueOf("rgb(0,0,0)"));
        this.leftRectPauseButton.setStrokeWidth(3.0);
        
        this.rightRectPauseButton = new Rectangle(337, 100, 25, 175);
        this.rightRectPauseButton.setFill(Paint.valueOf("rgb(255,255,255)"));
        this.rightRectPauseButton.setStroke(Paint.valueOf("rgb(0,0,0)"));
        this.rightRectPauseButton.setStrokeWidth(3.0);
        
        exitGameButton.setXCoord(50); // = new GameButton(this.textFontFile, "Exit Game", 50, 400, 17);
        exitGameButton.setYCoord(400);
        exitGameButton.setWidth(200);
        exitGameButton.setHeight(60);
        exitGameButton.getText().setText("Exit Game");
        exitGameButton.getText().setFont(this.getFontFromFile(17));
        exitGameButton.setTextTranslationY(5);
        this.exitGameButton = exitGameButton;
        
        mainMenuGameButton.setXCoord(350); // = new GameButton(this.textFontFile, "Exit Game", 50, 400, 17);
        mainMenuGameButton.setYCoord(400);
        mainMenuGameButton.setWidth(200);
        mainMenuGameButton.setHeight(60);
        mainMenuGameButton.getText().setText("Main Menu");
        mainMenuGameButton.getText().setFont(this.getFontFromFile(17));
        mainMenuGameButton.setTextTranslationY(5);
        this.mainMenuGameButton = mainMenuGameButton;
    }
    
    /*
     * Public non-static method used to get the pause scene itself from the PauseScene instance.
     * <p>
     * This public non-static method will return an instance of the Group.java class,
     * which will be the actual pause scene. This Group.java instance will contain all
     * the nodes that are needed to create this scene.
     * 
     * @return  An instance of the Group.java class, which will be the actual pause
     *          scene from the PauseScene instance.
     */
    public Group getScene() {
        Group nodesToReturn = new Group();
        nodesToReturn.getChildren().addAll(
            this.clearOverlay,
            this.leftRectPauseButton,
            this.rightRectPauseButton,
            this.exitGameButton.getButton(),
            this.mainMenuGameButton.getButton()
        );
        return nodesToReturn;
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