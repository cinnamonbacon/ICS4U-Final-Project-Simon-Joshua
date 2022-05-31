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
    
    private StackPane overallTitle;
    
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

    public StackPane getTitle() {
        return this.overallTitle;   
    }
}
