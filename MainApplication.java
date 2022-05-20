//import javafx.application.*;
import javafx.application.Application; // Imports the Application.java class, which allows the program to create a GUI and display it on the screen to the user.
//import javafx.animation.*;
import javafx.animation.FadeTransition; // Imports the FadeTransition.java class, which allows the program to create a fading transition that is used in various places, such as in the loading screen.
//import javafx.css.*;
//import javafx.event.*;
import javafx.event.EventHandler; // Imports the EventHandler.java class, which allows the program to recognize inputs and events that are occuring on the computer (say from user input from the mouse or keyboard).
import javafx.event.ActionEvent; // Imports the ActionEvent.java class, which allows the program to recognize inputs and actions that are occuring on the computer (say from user input from the mouse or keyboard).
//import javafx.geometry.*;
//import javafx.fxml.*;
//import javafx.scene.*;
import javafx.scene.Scene; // Imports the Scene.java class, which allows the program to have access to a scene on which the GUI can be added onto and displayed to the user.
import javafx.scene.Group; // Imports the Group.java class, which allows the program to have access to the group layout to organize Nodes and other graphics within (it can group various nodes together).
//import javafx.scene.media.*;
//import javafx.scene.chart.*;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.*;
//import javafx.scene.layout.*;
//import javafx.scene.web.*;
//import javafx.scene.media.*;
//import javafx.scene.text.*;
//import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create a rectangle that will be shown to the user (by being added as a node to the current scene).
//import javafx.scene.paint.*;
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create specific paint colours for various parts of the GUI.
import javafx.scene.paint.Color; // Imports the Color.java class, which allows the programa to create specific colors for various parts of the GUI.
//import javafx.scene.image.*;
import javafx.scene.image.Image; // Imports the Image.java class, which allows the program to create images from various files that are on the user's computer.
import javafx.scene.image.ImageView; // Imports the ImageView.java class, which allows the program to create images that can act as nodes and can be added onto the scenes (and displayed to the user).
//import javafx.scene.input.*;
import javafx.scene.input.KeyEvent; // Imports the KeyEvent.java class, which allows the program to recognize inputs that are coming from the keyboard and act accordingly based on what key the input is coming from.
import javafx.scene.input.KeyCode; // Imports the KeyCode.java class, which allows the program to see what key the key event is coming from.
import javafx.scene.input.MouseEvent; // Imports the MouseEvent.java class, which allows the program to recognize inputs that are coming from the mouse and act accordingly.
//import javafx.stage.*;
import javafx.stage.Stage; // Imports the Stage.java class, which allows the program to have access to a stage to display the graphics within.
import javafx.stage.StageStyle; // Imports the StageStyle.java class, which allows the program to set the style of the stage (such as modifying its border).
//import javafx.util.*;
import javafx.util.Duration; // Imports the Duration.java class, which allows the program to set the duration of time for a specific task (say how long the fading animation (so FadeTransition instance) should last for).
//import javafx.concurrent.*;

//import java.io.*;
import java.io.File; // Imports the File.java class, which allows the program to access files that are on the user's computer.
import java.io.IOException; // Imports the IOException.java class, which allows the user to take care of the IOExceptions that are thrown by any parts of the program.
//import java.util.*;
//import java.math.*;
//import java.lang.*;
//import java.awt.*;
//import javax.swing.*;
//import java.time.*;
//import java.util.concurrent.*;

/**
 * Create a Grid made of Tiles that the user will move around in.
 * <p>
 * This class will create a grid made from numerous instances of
 * the Tile.java class, which will all be stored within a global
 * 2D array that will be a code representation of the grid. This
 * class will also have various methods that help with user
 * movement.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: to build manipulate and draw a screen with tiles
 * that the player can move around in.
 * <p>
 * Filename: MainApplication.java
 *
 * @author Simon Bakan
 * @author Joshua Persaud
 * @version 5/20/2022
 * 
 * @see javafx.application.Application
 * @see javafx.animation.FadeTransition
 * @see javafx.event.EventHandler
 * @see javafx.event.ActionEvent
 * @see javafx.scene.Scene
 * @see javafx.scene.Group
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.paint.Color
 * @see javafx.scene.image.Image
 * @see javafx.scene.image.ImageView
 * @see javafx.scene.input.KeyEvent
 * @see javafx.scene.input.KeyCode
 * @see javafx.scene.input.MouseEvent
 * @see javafx.stage.Stage
 * @see javafx.util.Duration
 * @see java.io.File
 * @see java.io.IOException
 *
 * @since JDK1.17
 */
 
// Number of things to change: 2

public class MainApplication extends Application {

   private File logoFile;
   
   private File introBorderFile;
   
   private File whiteTitleFile;
   
   private File blackTitleFile;
   
   private File grassTileFile;
   
   private File additionalGrassTileFile;
   
   private File newGameFile;
   
   private String screen;
   
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
      screen="main";
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
      stage.addEventFilter(KeyEvent.ANY, k -> {
            if(k.getCode()== KeyCode.SPACE&&screen.equals("main")){
                try{
                    game(stage);
                }catch(Exception e){}
            }
      });
      
      stage.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
        
        final double xVal = e.getX();
        final double yVal = e.getY();
        
        System.out.println(xVal + " " + yVal);
      });
      
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

   public void game(Stage stage) throws IOException {
      screen = "game";
      try {            
         Grid grid = new Grid(15,15);
         for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
               grid.assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
         }
         grid.draw(stage);
            
            //stage.setStage(scene);
         stage.show();
         stage.addEventFilter(KeyEvent.KEY_RELEASED, k -> {
            try{
                if(screen.equals("game")){
                    if(k.getCode()== KeyCode.W){
                        grid.moveUp();
                        grid.draw(stage);
                        stage.show();
                    }else if(k.getCode()== KeyCode.A){
                        grid.moveLeft();
                        grid.draw(stage);
                        stage.show();
                    }else if(k.getCode()== KeyCode.S){
                        grid.moveDown();
                        grid.draw(stage);
                        stage.show();
                    }if(k.getCode()== KeyCode.D){
                        grid.moveRight();
                        grid.draw(stage);
                        stage.show();
                    }
                }
            }catch(Exception e){}
         });
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