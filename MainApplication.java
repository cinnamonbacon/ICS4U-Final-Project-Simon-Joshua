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
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.util.*;
import javafx.concurrent.*;

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
//import java.awt.*;
import java.awt.Point;
import java.awt.MouseInfo;
import javax.swing.*;
//import java.time.*;
import java.util.concurrent.*;

// Number of things to change: 2

public class MainApplication extends Application {
   private File logoFile;
   
   private File introBorderFile;
   
   private File whiteTitleFile;
   
   private File blackTitleFile;
   
   private File grassTileFile;
   
   private File additionalGrassTileFile;
   
   private File newGameFile;
   
   public MainApplication () {
      logoFile = new File("ICS ISP - Single Star Games Logo.png");
      introBorderFile = new File("ICS ISP - Border for Intro Screens.png");
      whiteTitleFile = new File("ICS ISP - Title of Game (White Version).png");
      blackTitleFile = new File("ICS ISP - Title of Game (Black Version).png");
      grassTileFile = new File("Grass.png");
      additionalGrassTileFile = new File("AdditionalGrass.png");
      newGameFile = new File("ICS ISP - Button Design for New Game Button.png");      
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
      
      FadeTransition ftLogo = new FadeTransition(Duration.millis(1), logoImageView); // <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- set this to 5000 for 5 seconds later on
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
      
      Group nodesToAdd = new Group(introBorderImageView, logoImageView);
   
      Scene scene = new Scene(nodesToAdd, 600, 600);
       
      scene.setFill(Color.BLACK);
      stage.setScene(scene);
   
      stage.show();
      
      //groupLines.getChildren().clear();
   
   }
   
   public void mainMenu(Stage stage) throws IOException {
   
      ImageView introBorderImageView = new ImageView(new Image(introBorderFile.getPath()));
      introBorderImageView.setPreserveRatio(true);
      introBorderImageView.setSmooth(true);
      introBorderImageView.setX(0);
      introBorderImageView.setY(0);
      introBorderImageView.setFitWidth(600);
      
      Rectangle blackRectangleUnderOptions = new Rectangle(10, 10, 200, 580);
      blackRectangleUnderOptions.setFill(Paint.valueOf("rgb(0,0,0)"));
      
      Rectangle greyRectangleUnderTitle = new Rectangle(10, 50, 200, 75);
      greyRectangleUnderTitle.setFill(Paint.valueOf("rgb(96,96,96)"));
      
      ImageView whiteTitleImageView = new ImageView(new Image(whiteTitleFile.getPath()));
      whiteTitleImageView.setPreserveRatio(true);
      whiteTitleImageView.setSmooth(true);
      whiteTitleImageView.setX(20);
      whiteTitleImageView.setY(55);
      whiteTitleImageView.setFitWidth(180);
      
      /*
      stage.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {

        
        final double xVal = e.getX();
        final double yVal = e.getY();
        
        System.out.println(xVal + " " + yVal);

      });
      */
      /*
      Service<Void> service = new Service<Void>() {
          @Override
          protected Task<Void> createTask() {
              return new Task<Void>() {           
                  @Override
                  protected Void call() throws Exception {
                      stage.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
                          final double xVal = e.getX();
                          final double yVal = e.getY();
                      
                          System.out.println(xVal + " " + yVal);
                      
                      });               
                      final CountDownLatch latch = new CountDownLatch(1);
                      Platform.runLater(new Runnable() {                          
                          @Override
                          public void run() {
                                try{
                                    // Nothing for now
                              }finally{
                                  latch.countDown();
                              }
                          }
                      });
                      latch.await();                      
                      stage.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
                          final double xVal = e.getX();
                          final double yVal = e.getY();
                      
                          System.out.println(xVal + " " + yVal);
                      
                      }); 
                      return null;
                  }
              };
          }
      };
      service.start();
      */
           
      Group nodesToAdd = new Group(blackRectangleUnderOptions, greyRectangleUnderTitle, whiteTitleImageView, introBorderImageView);
     
      Scene scene = new Scene(nodesToAdd, 600, 600);
       
      scene.setFill(Color.DEEPSKYBLUE);
      stage.setScene(scene);
   
      stage.show();
   
   }
   
   private Label createMonitoredLabel(final Label reporter) {
    final Label monitored = new Label("Mouse Location Monitor");

    monitored.setStyle("-fx-background-color: forestgreen; -fx-text-fill: white; -fx-font-size: 20px;");

    monitored.setOnMouseMoved(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent event) {
        String msg =
          "(x: "       + event.getX()      + ", y: "       + event.getY()       + ") -- " +
          "(sceneX: "  + event.getSceneX() + ", sceneY: "  + event.getSceneY()  + ") -- " +
          "(screenX: " + event.getScreenX()+ ", screenY: " + event.getScreenY() + ")";

        reporter.setText(msg);
      }
    });

    monitored.setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent event) {
            reporter.setText("yo");
        }
    });

    return monitored;
  }

   public void game(Stage stage) throws IOException {
      try {            
         Grid grid = new Grid(15,15);
         for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
               grid.assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), false, false);
            }
         }
         grid.draw(stage);
            
            //stage.setStage(scene);
         stage.show();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   @Override
   public void start(Stage stage) throws IOException {
      this.initializeStageSettings(stage);
      this.introAnimation(stage);
      //MouseEvent me = new MouseEvent();
      //this.mainMenu(stage);
       
   }

   public static void main(String[] args) {
      Application.launch();
   }
}
