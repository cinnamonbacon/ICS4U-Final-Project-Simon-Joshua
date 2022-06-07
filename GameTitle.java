import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
//import javafx.geometry.Pos;
//import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.scene.layout.Region;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;


public class GameTitle {
    
    private double xCoord;
    
    private double yCoord;
    
    private double width;
    
    private double height;
    
    private double spacing;
    
    private Text title;
    
    private Text subheading;
    
    private Rectangle underlineRect;
    
    private File textFontFile;
    
    public GameTitle(File textFontFile, String titleText, String subheadingText, double xCoord, double yCoord, int fontSize) {
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
    
    public double getXCoord() {
        return this.xCoord;
    }
    
    public void setXCoord(double newXCoord) {
        this.xCoord = newXCoord;
    }
    
    public double getYCoord() {
        return this.yCoord;
    }
    
    public void setYCoord(double newYCoord) {
        this.yCoord = newYCoord;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(double newWidth) {
        this.width = newWidth;
        this.underlineRect.setWidth(newWidth);
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }
    
    public double getSpacing() {
        return this.spacing;
    }
    
    public void setSpacing(double newSpacing) {
        this.spacing = newSpacing;
    }
    
    public Text getTitleText() {
        return this.title;
    }
    
    public Text getSubheadingText() {
        return this.subheading;
    }
    
    public Rectangle getUnderlineRectangle() {
        return this.underlineRect;
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