import javafx.application.*;
import javafx.animation.*;
import javafx.css.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.media.*;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.scene.web.*;
import javafx.scene.media.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.util.*;

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
//import java.awt.*;
import javax.swing.*;
//import java.time.*;
import java.util.concurrent.*;


public class MainApplication extends Application {

   private File logoFile;
   
   private File introBorderFile;
   
   public MainApplication () {
      logoFile = new File("ICS ISP - Single Star Games Logo.png");
      introBorderFile = new File("ICS ISP - Border for Intro Screens.png");
   }


   public void game (Stage primaryStage) throws IOException {
      try {
         primaryStage.setTitle("Testing the title");
            
         Grid grid = new Grid(15,15);
         for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
               grid.assign(i, j, "\\Simon Bakan Joshua Persaud Final ISP Draft 1\\Sprites\\Grass.png", "\\Simon Bakan Joshua Persaud Final ISP Draft 1\\Sprites\\AdditionalGrass.png", false, false);
            }
         }
         grid.draw(primaryStage);
            
            //primaryStage.setStage(scene);
         primaryStage.show();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
    
   public void initializeStageSettings(Stage stage) throws IOException {
      stage.setTitle("Trans-form: The Awakening");
      stage.initStyle(StageStyle.DECORATED); // <-------------------------------------------------------------------------------------------------------------------------------- set this to StageStyle.TRANSPARENT later on
      stage.isIconified();
      stage.setResizable(false);
      stage.toFront();
   }
   
   public void introAnimation(Stage stage) throws IOException {
      ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
  	logoImageView.setPreserveRatio(true);
  	logoImageView.setSmooth(true);
  	logoImageView.setX(100);
  	logoImageView.setY(100);
  	logoImageView.setFitWidth(400);
 	 
  	FadeTransition ftLogo = new FadeTransition(Duration.millis(5000), logoImageView);
  	ftLogo.setFromValue(0.0);
  	ftLogo.setToValue(1.0);
  	ftLogo.setByValue(0.01);
  	ftLogo.play();
    // Taken from https://stackoverflow.com/questions/11188018/how-to-wait-for-a-transition-to-end-in-javafx-2-1
 	ftLogo.onFinishedProperty().set(new EventHandler<ActionEvent>() {
        @Override 
        public void handle(ActionEvent actionEvent) {
            try{
            mainMenu(stage);
            }catch(Exception e){}
        }
    });
  	ImageView introBorderImageView = new ImageView(new Image(introBorderFile.getPath()));
  	introBorderImageView.setPreserveRatio(true);
  	introBorderImageView.setSmooth(true);
  	introBorderImageView.setX(0);
  	introBorderImageView.setY(0);
  	introBorderImageView.setFitWidth(600);

  	Scene scene = new Scene(new Group(introBorderImageView, logoImageView), 600, 600);
  	 
  	scene.setFill(Color.BLACK);
  	stage.setScene(scene);

  	stage.show();

   }
   
   public void mainMenu(Stage stage) throws IOException {
   
      ImageView introBorderImageView = new ImageView(new Image(introBorderFile.getPath()));
      introBorderImageView.setPreserveRatio(true);
      introBorderImageView.setSmooth(true);
      introBorderImageView.setX(0);
      introBorderImageView.setY(0);
      introBorderImageView.setFitWidth(600);
    
      Scene scene = new Scene(new Group(introBorderImageView), 600, 600);
      
      scene.setFill(Color.BLUE);
      stage.setScene(scene);
   
      stage.show();
   
   }
   
   @Override
   public void start(Stage stage) throws IOException {
      this.initializeStageSettings(stage);
      this.introAnimation(stage);
      //this.mainMenu(stage);
   }

    
   public static void main(String[] args) {
      Application.launch(args);
   }
}
