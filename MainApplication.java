/*
  Names: Simon Bakan and Joshua Persaud
  Teacher: Ms. Krasteva
  Date: May 20, 2022
  Course: ICS4U0/P
  
  Purpose: to act as a driver class and run various code in the correct order to simulate a game.
  Worked on by: Joshua and Simon
*/

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


//Remember to add these imports to the JavaDoc
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.animation.TranslateTransition;
import javafx.animation.Animation;
import javafx.animation.SequentialTransition; // <------------------------------------------------------------------------------------------------ check to see if you have to remove this import (if it isn't used anywhere)
import javafx.animation.ParallelTransition;
import javafx.scene.Cursor;
import javafx.concurrent.*;
import javafx.application.Platform;
import java.util.concurrent.CountDownLatch;

/**
 * Main program that will act as driver class and run entire game.
 * <p>
 * This class will be used to create instances of various classes
 * to create the game. It will also coordinate the code so that
 * the program works as intended.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: to act as a driver class and run various code in
 * the correct order to simulate a game.
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

// Number of things to change: 5
// Remember to update the JavaDoc comments for the global variables, the methods (especially because return types changed), and for the imports

public class MainApplication extends Application {
    /** This private non-static File variable will hold the logo for the game. */
    private File logoFile;

    /** This private non-static File variable will hold the intro border design for the game. */
    private File introBorderFile;

    /** This private non-static File variable will hold the title design (the white version) for the game. */
    private File whiteTitleFile;

    /** This private non-static File variable will hold the title design (the black version) for the game. */
    private File blackTitleFile;

    /** This private non-static File variable will hold the grass tile that will be used in the game's grid. */
    private File grassTileFile;

    /** This private non-static File variable will hold the additional grass that will be added onto the grass tile that will be used in the game's grid. */
    private File additionalGrassTileFile;

    /** This private non-static File variable will hold the design for the "New Game" button in the main menu. */
    private File newGameButtonFile;

    /** This private non-static File variable will hold the design for the "Instructions" button in the main menu. */
    private File instructionsButtonFile;

    /** This private non-static File variable will hold the design for the "Leaderboard" button in the main menu. */
    private File leaderboardButtonFile;

    /** This private non-static File variable will hold the design for the "Quit Game" button in the main menu. */
    private File quitGameButtonFile;

    /** This private non-static File variable will hold the design for the copyright statement in the main menu. */
    private File copyrightStatementFile;

    /** This private non-static File variable will hold the design for the grass and dirt block in the main menu. */
    private File grassAndDirtBlockFile;

    /** This private non-static File variable will hold the design for the non-pixelated character in the main menu. */
    private File characterNonPixelatedFile;

    /** This private non-static File variable will hold the design for the white title for the instructions screen. */
    private File whiteInstructionsTitleFile;

    /** This private non-static File variable will hold the design for the black text for the instructions screen. */
    private File blackInstructionsTextFile;

    /** This private non-static File variable will hold the design for the "Back" button. */
    private File backButtonFile;

    private int screenNum; // <------------------------------------------------------------------------------------------------------------------------ Check to see if we have to delete this as well.

    private Scene introAnimationScene;

    private Scene mainMenuScene;

    private Scene instructionsScene;

    private Scene level1Scene;
    
    private File waterTileFile;
    
    private File sandTileFile;
    
    private File bookTileFile;
    
    private int gridNum;

    /**
     * An instance of the Tile class will be created using this no parameter constructor.
     */
    public MainApplication() {
        this.logoFile = new File("ICS ISP - Single Star Games Logo.png");
        this.introBorderFile = new File("ICS ISP - Border for Intro Screens.png");
        this.whiteTitleFile = new File("ICS ISP - Title of Game (White Version).png");
        this.blackTitleFile = new File("ICS ISP - Title of Game (Black Version).png");
        this.grassTileFile = new File("Grass.png");
        this.waterTileFile = new File("Water.png");
        this.sandTileFile = new File("Sand.png");
        this.bookTileFile = new File("Book.png");
        this.additionalGrassTileFile = new File("AdditionalGrass.png");
        this.newGameButtonFile = new File("ICS ISP - Button Design for New Game Button.png");
        this.instructionsButtonFile = new File("ICS ISP - Button Design for Instructions Button.png");
        this.leaderboardButtonFile = new File("ICS ISP - Button Design for Leaderboard Button.png");
        this.quitGameButtonFile = new File("ICS ISP - Button Design for Quit Game Button.png");
        this.copyrightStatementFile = new File("ICS ISP - Design for Copyright Statement.png");
        this.grassAndDirtBlockFile = new File("ICS ISP - Design for Grass and Dirt Block.png");
        this.characterNonPixelatedFile = new File("ICS ISP - Design for Character (Non-pixelated).png");
        this.whiteInstructionsTitleFile = new File("ICS ISP - Title for Instructions (White Version).png");
        this.blackInstructionsTextFile = new File("ICS ISP - Text for Instructions (Black Version).png");
        this.backButtonFile = new File("ICS ISP - Button Design for Back Button.png");

        this.screenNum = 0;
    }

    /**
     * Public non-static method used to initialize the settings of the stage for the GUI.
     * <p>
     * This public non-static method is void and it will be used to initialize
     * the settings of the stage that will be used in the GUI for the program.
     * It will set its title to "Trans-form: The Awakening", it will set the
     * surrounding border of the stage to a decorated style (using one of the
     * static variables in the StageStyle.java class), and it will set this
     * stage to have its own icon, not be resizable by the user, and to be
     * at the front of all the current windows.
     * @throws IOException
     */
    public void initializeStageSettings(Stage stage) throws IOException {
        stage.setTitle("Trans-form: The Awakening");
        stage.initStyle(StageStyle.DECORATED); // <-------------------------------------------------------------------------------------------------------------------------------- set this to StageStyle.TRANSPARENT later on
        Image logoImage = new Image(logoFile.getPath());
        stage.getIcons().add(logoImage);
        stage.setResizable(false);
        stage.toFront();
    }

    /**
     * Public non-static method used to create the intro animation for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * introduction animation for the program. It will use the ImageView.java
     * class to create a Node that holds the image of the logo and can add it
     * to the scene. The method will also use an instance of the FadeTransition
     * class to help create the fading effect that is seen at the start of the
     * game. A nested class will be used to wait for the animation to finish
     * and then call on the mainMenu() method to display the menu for the game.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @throws IOException
     */
    public Scene introAnimation(Stage stage) throws IOException {
        screenNum = 0;

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
        ftLogo.onFinishedProperty().set(
            new EventHandler < ActionEvent > () {
                @Override
                public void handle(ActionEvent actionEvent) {
                    screenNum = 1;
                    stage.setScene(mainMenuScene);
                    stage.show();
                }
            }
        );

        ImageView introBorderImageView = new ImageView(new Image(introBorderFile.getPath()));
        introBorderImageView.setPreserveRatio(true);
        introBorderImageView.setSmooth(true);
        introBorderImageView.setX(0);
        introBorderImageView.setY(0);
        introBorderImageView.setFitWidth(600);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().add(logoImageView);
        nodesToAdd.getChildren().add(introBorderImageView);

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.setFill(Color.BLACK);

        return scene;
    }

    /**
     * Public non-static method used to create the main menu for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * main menu for the program, which will allow the user to choose the
     * direction that they would like to go in the program. This will be done
     * by using various instances of the ImageView.java class to create Nodes
     * of certain images that can be added to the scene to make it more lovely
     * to look at. There will also be instances of  various classes from the
     * javafx.scene.shape package that will be added to the scene to create the
     * correct design. There are also pieces of code that are triggered by events
     * from the user's input and will act accordingly.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @throws IOException
     */
    public Scene mainMenu(Stage stage) throws IOException {
        screenNum = 1;

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

        ImageView newGameButtonImageView = new ImageView(new Image(newGameButtonFile.getPath()));
        newGameButtonImageView.setPreserveRatio(true);
        newGameButtonImageView.setSmooth(true);
        newGameButtonImageView.setX(33);
        newGameButtonImageView.setY(205);
        newGameButtonImageView.setFitWidth(160);

        Rectangle redRectangleAroundNewGameButton = new Rectangle(20, 205, 180, 58);
        redRectangleAroundNewGameButton.setStroke(Paint.valueOf("rgb(255,0,0)"));
        redRectangleAroundNewGameButton.setStrokeWidth(2);
        redRectangleAroundNewGameButton.setVisible(false);

        ImageView instructionsButtonImageView = new ImageView(new Image(instructionsButtonFile.getPath()));
        instructionsButtonImageView.setPreserveRatio(true);
        instructionsButtonImageView.setSmooth(true);
        instructionsButtonImageView.setX(30);
        instructionsButtonImageView.setY(277);
        instructionsButtonImageView.setFitWidth(160);

        Rectangle redRectangleAroundInstructionsButton = new Rectangle(20, 280, 180, 58);
        redRectangleAroundInstructionsButton.setStroke(Paint.valueOf("rgb(255,0,0)"));
        redRectangleAroundInstructionsButton.setStrokeWidth(2);
        redRectangleAroundInstructionsButton.setVisible(false);

        ImageView leaderboardButtonImageView = new ImageView(new Image(leaderboardButtonFile.getPath()));
        leaderboardButtonImageView.setPreserveRatio(true);
        leaderboardButtonImageView.setSmooth(true);
        leaderboardButtonImageView.setX(30);
        leaderboardButtonImageView.setY(352);
        leaderboardButtonImageView.setFitWidth(160);

        Rectangle redRectangleAroundLeaderboardButton = new Rectangle(20, 355, 180, 58);
        redRectangleAroundLeaderboardButton.setStroke(Paint.valueOf("rgb(255,0,0)"));
        redRectangleAroundLeaderboardButton.setStrokeWidth(2);
        redRectangleAroundLeaderboardButton.setVisible(false);

        ImageView quitGameButtonImageView = new ImageView(new Image(quitGameButtonFile.getPath()));
        quitGameButtonImageView.setPreserveRatio(true);
        quitGameButtonImageView.setSmooth(true);
        quitGameButtonImageView.setX(30);
        quitGameButtonImageView.setY(452);
        quitGameButtonImageView.setFitWidth(110);

        Rectangle redRectangleAroundQuitGameButton = new Rectangle(20, 455, 130, 48);
        redRectangleAroundQuitGameButton.setStroke(Paint.valueOf("rgb(255,0,0)"));
        redRectangleAroundQuitGameButton.setStrokeWidth(2);
        redRectangleAroundQuitGameButton.setVisible(false);

        ImageView copyrightStatementImageView = new ImageView(new Image(copyrightStatementFile.getPath()));
        copyrightStatementImageView.setPreserveRatio(true);
        copyrightStatementImageView.setSmooth(true);
        copyrightStatementImageView.setX(30);
        copyrightStatementImageView.setY(535);
        copyrightStatementImageView.setFitWidth(160);

        Group grassAndDirtBlocksGroup = new Group();
        for (int i = 0; i < 5; i++) {
            ImageView grassAndDirtBlockImageView = new ImageView(new Image(grassAndDirtBlockFile.getPath()));
            grassAndDirtBlockImageView.setPreserveRatio(true);
            grassAndDirtBlockImageView.setSmooth(true);
            grassAndDirtBlockImageView.setX(210 + i * 100);
            grassAndDirtBlockImageView.setY(535);
            grassAndDirtBlockImageView.setFitWidth(100);
            grassAndDirtBlocksGroup.getChildren().add(grassAndDirtBlockImageView);
        }

        ImageView characterNonPixelatedImageView = new ImageView(new Image(characterNonPixelatedFile.getPath()));
        characterNonPixelatedImageView.setPreserveRatio(true);
        characterNonPixelatedImageView.setSmooth(true);
        characterNonPixelatedImageView.setX(230);
        characterNonPixelatedImageView.setY(364);
        characterNonPixelatedImageView.setFitWidth(120);

        Circle yellowCircleForSun = new Circle(600, 0, 100, Paint.valueOf("rgb(255,255,0)"));
        yellowCircleForSun.setStroke(Paint.valueOf("rgb(0,0,0)"));
        System.out.println(yellowCircleForSun);

        Cloud cloudCloud = new Cloud(0.0, 0.0);
        Shape cloudShapeTop = cloudCloud.getShape();
        cloudShapeTop.setStroke(Paint.valueOf("rgb(0,0,0)"));

        Shape cloudShapeMiddle = cloudCloud.getShape();
        cloudShapeMiddle.setStroke(Paint.valueOf("rgb(0,0,0)"));

        Shape cloudShapeBottom = cloudCloud.getShape();
        cloudShapeBottom.setStroke(Paint.valueOf("rgb(0,0,0)"));

        TranslateTransition ttCloudTop = new TranslateTransition(Duration.millis(7000), cloudShapeTop);
        ttCloudTop.setByX(1.0);
        ttCloudTop.setFromX(700.0);
        ttCloudTop.setToX(0.0);
        ttCloudTop.setFromY(225.0);
        ttCloudTop.setToY(225.0);

        TranslateTransition ttCloudMiddle = new TranslateTransition(Duration.millis(16000), cloudShapeMiddle);
        ttCloudMiddle.setByX(1.0);
        ttCloudMiddle.setFromX(1600.0);
        ttCloudMiddle.setToX(0.0);
        ttCloudMiddle.setFromY(350.0);
        ttCloudMiddle.setToY(350.0);

        TranslateTransition ttCloudBottom = new TranslateTransition(Duration.millis(25000), cloudShapeBottom);
        ttCloudBottom.setByX(1.0);
        ttCloudBottom.setFromX(2500.0);
        ttCloudBottom.setToX(0.0);
        ttCloudBottom.setFromY(100.0);
        ttCloudBottom.setToY(100.0);

        ParallelTransition ptClouds = new ParallelTransition(ttCloudTop, ttCloudMiddle, ttCloudBottom);
        ptClouds.setCycleCount(Animation.INDEFINITE);
        ptClouds.play();

        /*
        // This code will be used in the case that the code for the events take too long to run and start to make the game feel unresponsive and laggy.
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

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().add(yellowCircleForSun);
        nodesToAdd.getChildren().add(cloudShapeTop);
        nodesToAdd.getChildren().add(cloudShapeMiddle);
        nodesToAdd.getChildren().add(cloudShapeBottom);
        nodesToAdd.getChildren().add(blackRectangleUnderOptions);
        nodesToAdd.getChildren().add(greyRectangleUnderTitle);
        nodesToAdd.getChildren().add(whiteTitleImageView);
        nodesToAdd.getChildren().add(redRectangleAroundNewGameButton);
        nodesToAdd.getChildren().add(newGameButtonImageView);
        nodesToAdd.getChildren().add(redRectangleAroundInstructionsButton);
        nodesToAdd.getChildren().add(instructionsButtonImageView);
        nodesToAdd.getChildren().add(redRectangleAroundLeaderboardButton);
        nodesToAdd.getChildren().add(leaderboardButtonImageView);
        nodesToAdd.getChildren().add(redRectangleAroundQuitGameButton);
        nodesToAdd.getChildren().add(quitGameButtonImageView);
        nodesToAdd.getChildren().add(copyrightStatementImageView);
        nodesToAdd.getChildren().add(grassAndDirtBlocksGroup);
        nodesToAdd.getChildren().add(characterNonPixelatedImageView);
        nodesToAdd.getChildren().add(introBorderImageView);

        Scene scene = new Scene(nodesToAdd, 600, 600);

        // Keep these two split or else the cursor will not work as expected
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= 20 && xVal <= 198 && yVal >= 205 && yVal <= 261) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= 20 && xVal <= 198 && yVal >= 280 && yVal <= 336) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= 20 && xVal <= 198 && yVal >= 355 && yVal <= 411) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= 20 && xVal <= 148 && yVal >= 455 && yVal <= 501) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= 20 && xVal <= 198 && yVal >= 205 && yVal <= 261) {
                    redRectangleAroundNewGameButton.setVisible(true);
                } else {
                    redRectangleAroundNewGameButton.setVisible(false);
                }

                if (xVal >= 20 && xVal <= 198 && yVal >= 280 && yVal <= 336) {
                    redRectangleAroundInstructionsButton.setVisible(true);
                } else {
                    redRectangleAroundInstructionsButton.setVisible(false);
                }

                if (xVal >= 20 && xVal <= 198 && yVal >= 355 && yVal <= 411) {
                    redRectangleAroundLeaderboardButton.setVisible(true);
                } else {
                    redRectangleAroundLeaderboardButton.setVisible(false);
                }

                if (xVal >= 20 && xVal <= 148 && yVal >= 455 && yVal <= 501) {
                    redRectangleAroundQuitGameButton.setVisible(true);
                } else {
                    redRectangleAroundQuitGameButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= 20 && xVal <= 198 && yVal >= 205 && yVal <= 261) {
                    screenNum = 2;
                    stage.setScene(this.level1Scene);
                    stage.show();
                }

                if (xVal >= 20 && xVal <= 198 && yVal >= 280 && yVal <= 336) {
                    screenNum = 3;
                    stage.setScene(this.instructionsScene);
                    stage.show();
                }

                if (xVal >= 20 && xVal <= 198 && yVal >= 355 && yVal <= 411) {
                    screenNum = 4;
                }

                if (xVal >= 20 && xVal <= 148 && yVal >= 455 && yVal <= 501) {
                    screenNum = 5;
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    /**
     * Public non-static method used to create the first level for the actual game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * first level of the program. It will do this by creating an instance of the
     * Grid.java class to simulate the grid and it will also have various
     * blocks of code that will run based on certain keys from keyboard events.
     * <p>
     * Done by: Simon
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @throws IOException
     */
    public Scene level1(Stage stage) throws IOException {
        screenNum = 2;
        Grid[] grid = {new Grid(15, 15),new Grid(15, 15),new Grid(15, 15),new Grid(15, 15)};
        Scene scene;
        // Top left grid
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 20; j++) {
                grid[0].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int i = 2; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                grid[0].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int j = 2; j < 20; j++) {
            int i=2;
            grid[0].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            int j=2;
            grid[0].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            for (int j = 3; j < 20; j++) {
                grid[0].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[0].setObject(17,13,bookTileFile.getPath());
        grid[0].setInteractable(17,13,true);
        grid[0].setMovable(17,13,false);
        grid[0].setObject(5,10,bookTileFile.getPath());
        grid[0].setInteractable(5,10,true);
        grid[0].setMovable(5,10,false);
        
        // Top right grid
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 20; j++) {
                grid[1].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int i = 2; i < 20; i++) {
            for (int j = 18; j < 20; j++) {
                grid[1].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int j = 0; j < 18; j++) {
            int i=2;
            grid[1].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            int j=17;
            grid[1].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            for (int j = 0; j < 17; j++) {
                grid[1].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[1].setObject(8,13,bookTileFile.getPath());
        grid[1].setInteractable(8,13,true);
        grid[1].setMovable(8,13,false);
        grid[1].setObject(15,7,bookTileFile.getPath());
        grid[1].setInteractable(15,7,true);
        grid[1].setMovable(15,7,false);
        
        // Bottom left grid
        for (int i = 18; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[2].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 2; j++) {
                grid[2].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int j = 2; j < 20; j++) {
            int i=17;
            grid[2].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            int j=2;
            grid[2].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i <17; i++) {
            for (int j = 3; j < 20; j++) {
                grid[2].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[2].setObject(3,18,bookTileFile.getPath());
        grid[2].setInteractable(3,18,true);
        grid[2].setMovable(3,18,false);
        grid[2].setObject(10,10,bookTileFile.getPath());
        grid[2].setInteractable(10,10,true);
        grid[2].setMovable(10,10,false);
        
        // Bottom right grid
        for (int i = 18; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[3].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int i = 0; i < 18; i++) {
            for (int j = 18; j < 20; j++) {
                grid[3].assign(i, j, waterTileFile.getPath(), "", false, false);
            }
        }
        for (int j = 0; j < 18; j++) {
            int i=17;
            grid[3].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            int j=17;
            grid[3].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i <17; i++) {
            for (int j = 0; j < 17; j++) {
                grid[3].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        
        this.gridNum = 0;
        Group[] gr = new Group[4];
        for(int i=0;i<4;i++){
            gr[i]=grid[i].draw();
        }
        ImageView mainChar = new ImageView();
        try {
            File file = new File("\\Simon Bakan Joshua Persaud Final ISP Draft 1\\mainChar.png");
            Image image = new Image(file.toURI().toString());
            mainChar.setImage(image);
            mainChar.setX(30 * grid[gridNum].getX());
            mainChar.setY(30 * grid[gridNum].getY());
        } catch (Exception e) {}
        Group view=new Group();
        view.getChildren().add(gr[gridNum]);
        view.getChildren().add(mainChar);
        scene = new Scene(view);

        try {
            stage.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (screenNum == 2) {
                            if (k.getCode() == KeyCode.W) {
                                final int OFF = grid[gridNum].moveUp();
                                if(OFF!=-1){
                                    this.gridNum-=2;
                                    grid[gridNum].setX(OFF);
                                    grid[gridNum].setY(19);
                                }
                            } else if (k.getCode() == KeyCode.A) {
                                final int OFF = grid[gridNum].moveLeft();
                                if(OFF!=-1){
                                    this.gridNum-=1;
                                    grid[gridNum].setX(19);
                                    grid[gridNum].setY(OFF);
                                }
                            } else if (k.getCode() == KeyCode.S) {
                                final int OFF = grid[gridNum].moveDown();
                                if(OFF!=-1){
                                    gridNum+=2;
                                    grid[gridNum].setX(OFF);
                                    grid[gridNum].setY(0);
                                }
                            }
                            if (k.getCode() == KeyCode.D) {
                                final int OFF = grid[gridNum].moveRight();
                                if(OFF!=-1){
                                    gridNum+=1;
                                    grid[gridNum].setX(0);
                                    grid[gridNum].setY(OFF);
                                }
                            }
                            
                            try {
                                File file = new File("\\Simon Bakan Joshua Persaud Final ISP Draft 1\\mainChar.png");
                                Image image = new Image(file.toURI().toString());
                                mainChar.setImage(image);
                                mainChar.setX(30 * grid[gridNum].getX());
                                mainChar.setY(30 * grid[gridNum].getY());
                            } catch (Exception e) {}
                            view.getChildren().clear();
                            view.getChildren().add(gr[gridNum]);
                            view.getChildren().add(mainChar);
                            scene.setRoot(view);
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }

    public Scene instructions(Stage stage) throws IOException {
        screenNum = 3;

        ImageView introBorderImageView = new ImageView(new Image(introBorderFile.getPath()));
        introBorderImageView.setPreserveRatio(true);
        introBorderImageView.setSmooth(true);
        introBorderImageView.setX(0);
        introBorderImageView.setY(0);
        introBorderImageView.setFitWidth(600);

        ImageView whiteInstructionsTitleImageView = new ImageView(new Image(whiteInstructionsTitleFile.getPath()));
        whiteInstructionsTitleImageView.setPreserveRatio(true);
        whiteInstructionsTitleImageView.setSmooth(true);
        whiteInstructionsTitleImageView.setX(50);
        whiteInstructionsTitleImageView.setY(85);
        whiteInstructionsTitleImageView.setFitWidth(300);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        ImageView blackInstructionsTextImageView = new ImageView(new Image(blackInstructionsTextFile.getPath()));
        blackInstructionsTextImageView.setPreserveRatio(true);
        blackInstructionsTextImageView.setSmooth(true);
        blackInstructionsTextImageView.setX(25);
        blackInstructionsTextImageView.setY(190);
        blackInstructionsTextImageView.setFitWidth(550);

        ImageView backButtonImageView = new ImageView(new Image(backButtonFile.getPath()));
        backButtonImageView.setPreserveRatio(true);
        backButtonImageView.setSmooth(true);
        backButtonImageView.setX(390);
        backButtonImageView.setY(512);
        backButtonImageView.setFitWidth(130);

        Rectangle redRectangleAroundBackButton = new Rectangle(389, 516, 132, 42);
        redRectangleAroundBackButton.setStroke(Paint.valueOf("rgb(255,0,0)"));
        redRectangleAroundBackButton.setStrokeWidth(2);
        redRectangleAroundBackButton.setVisible(true);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().add(whiteInstructionsTitleImageView);
        nodesToAdd.getChildren().add(logoImageView);
        nodesToAdd.getChildren().add(blackInstructionsTextImageView);
        nodesToAdd.getChildren().add(redRectangleAroundBackButton);
        nodesToAdd.getChildren().add(backButtonImageView);
        nodesToAdd.getChildren().add(introBorderImageView);

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= 390 && xVal <= 520 && yVal >= 512 && yVal <= 560) {
                    scene.setCursor(Cursor.HAND);
                } else {
                    scene.setCursor(Cursor.DEFAULT);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= 390 && xVal <= 520 && yVal >= 512 && yVal <= 560) {
                    redRectangleAroundBackButton.setVisible(true);
                } else {
                    redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= 390 && xVal <= 520 && yVal >= 512 && yVal <= 560) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    public Scene quitGame(Stage stage) throws IOException {
        screenNum = 5;

        ImageView introBorderImageView = new ImageView(new Image(introBorderFile.getPath()));
        introBorderImageView.setPreserveRatio(true);
        introBorderImageView.setSmooth(true);
        introBorderImageView.setX(0);
        introBorderImageView.setY(0);
        introBorderImageView.setFitWidth(600);

        ImageView whiteInstructionsTitleImageView = new ImageView(new Image(whiteInstructionsTitleFile.getPath()));
        whiteInstructionsTitleImageView.setPreserveRatio(true);
        whiteInstructionsTitleImageView.setSmooth(true);
        whiteInstructionsTitleImageView.setX(50);
        whiteInstructionsTitleImageView.setY(85);
        whiteInstructionsTitleImageView.setFitWidth(300);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().add(introBorderImageView);
        nodesToAdd.getChildren().add(whiteInstructionsTitleImageView);
        nodesToAdd.getChildren().add(logoImageView);

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    /**
     * Public non-static method used to run the entire GUI.
     * <p>
     * This public non-static method is void and it will be used to run the
     * various methods that each do a section of the overall game. This
     * method is overriding the start() method that is present in the
     * Application.java class.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.initializeStageSettings(stage);
        this.introAnimationScene = this.introAnimation(stage);
        this.mainMenuScene = this.mainMenu(stage);
        this.instructionsScene = this.instructions(stage);
        this.level1Scene = this.level1(stage);
        this.screenNum = 0;
        stage.setScene(this.introAnimationScene);
        stage.show();
    }

    // This is the main method, which is public, static, and has a void return type. This will be used to execute the program.

    /**
     * Public static method used to run program.
     * <p>
     * This is the main method, which is a public static method
     * that will be used to execute the program.
     *
     * @param args Arguments from the command line.
     */
    public static void main(String[] args) {
        Application.launch();
    } // End of the main() method
} // End of the MainApplication.java class