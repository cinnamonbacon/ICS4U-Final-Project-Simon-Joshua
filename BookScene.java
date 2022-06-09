import javafx.scene.image.ImageView; // Imports the ImageView.java class, which allows the program to ImageView objects which are images that can be added to scenes and such (as they are just have the Image.java class functionality but also extend the very useful Node.java class).
import javafx.scene.text.Text; // Imports the Text.java class, which allows the program to beautiful text to display to the user.
import javafx.scene.text.TextFlow; // Imports the TextFlow.java class, which allows the program to layout instances of the Text.java class using a TextFlow instance.
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create Paint instances and set various colours.
import javafx.scene.text.Font; // Imports the Font.java class, which allows the program to create and use different fonts.
import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create rectangles.
import javafx.scene.layout.StackPane;
import javafx.scene.Group; // Imports the Group.java class, which allows the program to combing various nodes together so that they can be added to the Scene that is returned.

import java.io.File; // Imports the File.java class, which allows the program to access files on the computer, such as images.
import java.io.FileInputStream; // Imports the FileInputStream.java class, which allows the program to easily read in data from certain files.
import java.io.IOException; // Imports the IOException.java class, which allows the program to deal with and catch any errors thrown during reading of IO.



public class BookScene {
    private ImageView bookImage;
   
    private Text titleText;
   
    private Text bodyText;
   
    private Rectangle background;
   
    private Rectangle bookCover;
   
    private Rectangle bookLeftPage;
   
    private Rectangle bookRightPage;
   
    private Rectangle bookSpine;
   
    private GameButton backButton;
   
    private File textFontFile;
   
    private boolean textOnLeftSide;
   
    public BookScene(File textFontFile, ImageView bookImage, String textForTitle, String textForBody, boolean textOnLeftSide) {
        this.instantiateVariables(textFontFile, bookImage, textForTitle, textForBody, textOnLeftSide);
        
        this.backButton = new GameButton(this.textFontFile, "Back", 420, 535, 18);
        this.backButton.setWidth(125);
        this.backButton.setTextTranslationX(1);
        
    }
    
    public BookScene(File textFontFile, ImageView bookImage, String textForTitle, String textForBody, boolean textOnLeftSide, GameButton backButton) {
        this.instantiateVariables(textFontFile, bookImage, textForTitle, textForBody, textOnLeftSide);
        
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
    
    private void instantiateVariables(File textFontFile, ImageView bookImage, String textForTitle, String textForBody, boolean textOnLeftSide) {
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
    }
   
    public ImageView getBookImage() {
        return this.bookImage;
    }
   
    public Text getTitle() {
        return this.titleText;  
    }
   
    public Text getBody() {
        return this.bodyText;  
    }
   
    /*
    public Paint backgroundPaint() {
        return this.backgroundPaint;
    }
    */
   
    public Rectangle getBackground() {
        return this.background;
    }
   
    public Rectangle getBookCover() {
        return this.bookCover;  
    }
   
    public Rectangle getBookLeftPage() {
        return this.bookLeftPage;
    }
   
    public Rectangle getBookRightPage() {
        return this.bookRightPage;
    }
   
    public Rectangle getBookSpine() {
        return this.bookSpine;  
    }
   
    public GameButton getBackButton() {
        return this.backButton;
    }
   
    public File getFontFile() {
        return this.textFontFile;
    }

    public void setFontFile(File newTextFontFile) {
        this.textFontFile = newTextFontFile;
    }
   
    public boolean getIfTextOnLeftSide() {
        return this.textOnLeftSide;
    }
   
    public void setIfTextOnLeftSide(boolean newTextOnLeftSide) {
        this.textOnLeftSide = newTextOnLeftSide;
    }
   
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
            tempTextFlow.setLineSpacing(7);
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
            tempTextFlow.setLineSpacing(7);
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