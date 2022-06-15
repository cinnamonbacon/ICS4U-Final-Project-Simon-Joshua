import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.Group;
import javafx.scene.text.Font;

import java.io.File; // Imports the File.java class, which allows the program to access files on the computer, such as images.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to easily read in data from certain files.
import java.io.IOException; // Imports the IOException.java class, which allows the program to deal with and catch any errors thrown during reading of IO.

public class PauseScene {

    private File textFontFile;
    
    private Rectangle clearOverlay;

    private Rectangle leftRectPauseButton;
    
    private Rectangle rightRectPauseButton;
    
    private GameButton exitGameButton;
    
    private GameButton mainMenuGameButton;
    
    
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