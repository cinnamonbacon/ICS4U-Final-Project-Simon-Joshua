/*
  Names: Simon Bakan and Joshua Persaud
  Teacher: Ms. Krasteva
  Date: May 27, 2022
  Course: ICS4U0/P
  
  Purpose: to act as a driver class and run various code in the correct order to simulate a game.
  Worked on by: Joshua and Simon
*/

import javafx.application.Application; // Imports the Application.java class, which allows the program to create a GUI and display it on the screen to the user.
import javafx.animation.Animation; // Imports the Animation.java class, which allows the program to have access to various animation variables and methods.
import javafx.animation.FadeTransition; // Imports the FadeTransition.java class, which allows the program to create a fading transition that is used in various places, such as in the loading screen.
import javafx.animation.TranslateTransition; // Imports the TranslateTransition.java class, which allows the program to create a translating transition that is used in various places, such as in the main menu.
import javafx.animation.ParallelTransition; // Imports the ParallelTransition.java class, which allows the program to have numerous transitions happening at once, such as with the three clouds in the main menu.
import javafx.event.EventHandler; // Imports the EventHandler.java class, which allows the program to recognize inputs and events that are occuring on the computer (say from user input from the mouse or keyboard).
import javafx.event.ActionEvent; // Imports the ActionEvent.java class, which allows the program to recognize inputs and actions that are occuring on the computer (say from user input from the mouse or keyboard).
import javafx.scene.Scene; // Imports the Scene.java class, which allows the program to have access to a scene on which the GUI can be added onto and displayed to the user.
import javafx.scene.Group; // Imports the Group.java class, which allows the program to have access to the group layout to organize Nodes and other graphics within (it can group various nodes together).
import javafx.scene.Cursor; // Imports the Cursor.java class, which allows the program to have access to the cursor, more specifically the icon that is used for the cursor (as it can now be changed to represent different actions, such as clicking a button).
import javafx.scene.control.Label; // Imports the Label.java class, which allows the program to create labels that hold specified text and look good (through various stylistic changes).
import javafx.scene.shape.Shape; //. Imports the Shape.java class, which allows the program to create a generic shape that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.shape.Circle; // Imports the Circle.java class, which allows the program to create a circle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create a rectangle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create specific paint colours for various parts of the GUI.
import javafx.scene.paint.Color; // Imports the Color.java class, which allows the programa to create specific colors for various parts of the GUI.
import javafx.scene.image.Image; // Imports the Image.java class, which allows the program to create images from various files that are on the user's computer.
import javafx.scene.image.ImageView; // Imports the ImageView.java class, which allows the program to create images that can act as nodes and can be added onto the scenes (and displayed to the user).
import javafx.scene.input.KeyEvent; // Imports the KeyEvent.java class, which allows the program to recognize inputs that are coming from the keyboard and act accordingly based on what key the input is coming from.
import javafx.scene.input.KeyCode; // Imports the KeyCode.java class, which allows the program to see what key the key event is coming from.
import javafx.scene.input.MouseEvent; // Imports the MouseEvent.java class, which allows the program to recognize inputs that are coming from the mouse and act accordingly.
import javafx.scene.text.Font; // Imports the Font.java class, which allows the program to access and use fonts that are installed on the computer, such as the Press Start 2P font that is used in the game.
import javafx.stage.Stage; // Imports the Stage.java class, which allows the program to have access to a stage to display the graphics within.
import javafx.stage.StageStyle; // Imports the StageStyle.java class, which allows the program to set the style of the stage (such as modifying its border).
import javafx.util.Duration; // Imports the Duration.java class, which allows the program to set the duration of time for a specific task (say how long the fading animation (so FadeTransition instance) should last for).

import java.io.File; // Imports the File.java class, which allows the program to access files that are on the user's computer.
import java.io.IOException; // Imports the IOException.java class, which allows the user to take care of the IOExceptions that are thrown by any parts of the program.

// Remember to add JavaDoc for these imports:
import javafx.scene.layout.Region;
import javafx.scene.text.Text; 
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.TextFlow;
import javafx.scene.layout.Region;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;
import javafx.scene.shape.Ellipse; // Imports the Ellipse.java class, which will allow the program to create ellipses for the graphics.

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
 * @version 5/27/2022
 * 
 * @see javafx.application.Application
 * @see javafx.animation.Animation
 * @see javafx.animation.FadeTransition
 * @see javafx.animation.TranslateTransition
 * @see javafx.animation.ParallelTransition
 * @see javafx.event.EventHandler
 * @see javafx.event.ActionEvent
 * @see javafx.scene.Scene
 * @see javafx.scene.Group
 * @see javafx.scene.Cursor
 * @see javafx.scene.control.Label
 * @see javafx.scene.shape.Shape
 * @see javafx.scene.shape.Circle
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.paint.Color
 * @see javafx.scene.image.Image
 * @see javafx.scene.image.ImageView
 * @see javafx.scene.input.KeyEvent
 * @see javafx.scene.input.KeyCode
 * @see javafx.scene.input.MouseEvent
 * @see javafx.stage.Stage
 * @see javafx.stage.StageStyle
 * @see javafx.util.Duration
 * @see java.io.File
 * @see java.io.IOException
 *
 * @since JDK1.17
 */

public class MainApplication extends Application {
    /** This private non-static File variable will hold the logo for the game. */
    private File logoFile;

    /** This private non-static File variable will hold the intro border design for the game. */
    private File introBorderFile;

    /** This private non-static File variable will hold the grass tile that will be used in the game's grid. */
    private File grassTileFile;

    /** This private non-static File variable will hold the additional grass that will be added onto the grass tile that will be used in the game's grid. */
    private File additionalGrassTileFile;

    /** This private non-static File variable will hold the design for the grass and dirt block in the main menu. */
    private File grassAndDirtBlockFile;

    /** This private non-static File variable will hold the design for the non-pixelated character in the main menu. */
    private File characterNonPixelatedFile;

    /** This private non-static integer will hold the number of the screen that is currently being rendered. */
    private int screenNum; // Check to see if this variable is useful or not.
    /*
      0 = intro animation
      1 = main menu
      2 = new game
      3 = instructions
      4 = leaderboard
      5 = quit game
    */


    /** This private non-static Scene variable will hold the scene for the introduction animation screen. */
    private Scene introAnimationScene;

    /** This private non-static Scene variable will hold the scene for the main menu screen. */
    private Scene mainMenuScene;

    /** This private non-static Scene variable will hold the scene for the instructions screen. */
    private Scene instructionsScene;

    /** This private non-static Scene variable will hold the scene for level 1 of the game screen. */
    private Scene level1Scene;

    /** This private non-static File variable will hold the water tile that will be used in the game's grid. */
    private File waterTileFile;

    /** This private non-static File variable will hold the sand tile that will be used in the game's grid. */
    private File sandTileFile;

    /** This private non-static File variable will hold the book image that will be on the tiles that will be used in the game's grid. */
    private File bookTileFile;

    /** This private non-static integer variable will hold the number of the grid that the player is currently in. */
    private int gridNum;

    /** This private non-static Group[] variable will be used to hold onto the books that are being used in the game (one element for each book). */
    private Group[] books;

    /** This private non-static boolean variable will be used to hold onto whether or not the game is showing a book or not. */
    private boolean showingBook;

    /** This private non-static integer variable will be used to keep track of the number of books the player has found. */
    private int bookNum;

    /** This private non-static File variable will hold onto the location of the Press Start 2P file. */
    private File pressStart2PFile;
    
    /** This private non-static Scene variable will hold the scene for the leaderboard of the game. */
    private Scene leaderboardScene;

    /** This private non-static File variable will hold onto the location of the first confrontation character file. */
    private File level1Confrontation;

    /** This private non-static Scene variable will hold the scene for screen when the player quits the game. */
    private Scene quitGameScene;
    
    /** This private non-static File variable will hold onto the location of the main character image file. */
    private File mainCharFile;
    
    /** This private non-static String variable will hold onto the direction of the main character during grid movement. */
    private String direction;
    
    /** This private non-static File variable will hold onto the location of the cafeteria wall file. */
    private File cafWallFile;
    
    /** This private non-static File variable will hold onto the location of the left door file. */
    private File doorLeftFile;
    
    /** This private non-static File variable will hold onto the location of the right door file. */
    private File doorRightFile;
    
    /** This private non-static File array variable will hold onto the location of the cafeteria floor files. */
    private File cafFloorFiles[];

    /** This private non-static Scene variable will hold the scene for level 2 of the game screen. */
    private Scene level2Scene;
    
    /** This private non-static Scene variable will hold the scene for level 3 of the game screen. */
    private Scene level3Scene;
    
    /** This private non-static int variable will hold onto the health of the main character during confrontations. */
    private int health;
    
    /** This private non-static int variable will hold onto the health of the enemy character during confrontations. */
    private int enemyHealth;
    
    /** This private non-static String variable will hold onto the screen that is showing during confrontations. */
    private String battleMenu;
    
    /** This private non-static String variable will hold onto the form of the main character during confrontations. */
    private String form;
    
    /** This private non-static int variable will hold onto the block of the main character during confrontations. */
    private int block;
    
    /** This private non-static File variable will hold onto the location of the blank image file. */
    private File blankFile;
    
    /** This private non-static File array variable will hold onto the location of the files for the characters of the confrontation. */
    private File[] confrontationChar;
    
    /** This private non-static Scene variable will hold the scene for text before the first confrontation of the game. */
    private Scene confrontationTextScene1;
    
    /** This private non-static Scene variable will hold the scene for text before the second confrontation of the game. */
    private Scene confrontationTextScene2;
    
    /** This private non-static Scene variable will hold the scene for text before the third confrontation of the game. */
    private Scene confrontationTextScene3;
    
    /** This private non-static Scene variable will hold the scene for text before the fourth confrontation of the game. */
    private Scene confrontationTextScene4;
    
    /** This private non-static Scene variable will hold the scene for text before the fith confrontation of the game. */
    private Scene confrontationTextScene5;
    
    /** This private non-static Scene variable will hold the scene for the first confrontation of the game. */
    private Scene confrontationBattleScene1;
    
    /** This private non-static Scene variable will hold the scene for the second confrontation of the game. */
    private Scene confrontationBattleScene2;
    
    /** This private non-static Scene variable will hold the scene for the third confrontation of the game. */
    private Scene confrontationBattleScene3;
    
    /** This private non-static Scene variable will hold the scene for the fourth confrontation of the game. */
    private Scene confrontationBattleScene4;
    
    private Scene confrontationBattleScene5;
    
    private int confrontations;
    
    private Group level2Group;
    
    private Group level3Group;
    
    private File fatherUpperFile;
    
    private File fatherLowerFile;
    
    private File motherUpperFile;
    
    private File motherLowerFile;
    
    private File houseFloorFile;
    
    private File houseWallFile;
    
    private String questionMenu;
    
    private Scene winScene;
    
    private Scene loseScene;
    
    private int score;
    
    private Scene confrontationAfterTextScene2;
    
    private Scene confrontationAfterTextScene3;
    
    private Scene confrontationAfterTextScene4;
    
    private Scene confrontationAfterTextScene5;
    
    /**
     * An instance of the MainApplication class will be created using this no parameter constructor.
     */
    public MainApplication() {
        this.logoFile = new File("ICS ISP - Single Star Games Logo.png");
        this.introBorderFile = new File("ICS ISP - Border for Intro Screens.png");
        this.grassTileFile = new File("Grass.png");
        this.waterTileFile = new File("Water.png");
        this.sandTileFile = new File("Sand.png");
        this.bookTileFile = new File("Book.png");
        this.additionalGrassTileFile = new File("AdditionalGrass.png");
        this.grassAndDirtBlockFile = new File("ICS ISP - Design for Grass and Dirt Block.png");
        this.characterNonPixelatedFile = new File("ICS ISP - Design for Character (Non-pixelated).png");
        this.level1Confrontation = new File("Level1Confrontation.png");
        
        this.mainCharFile = new File("MainChar.png");
        this.cafWallFile = new File("CafWall.png");
        this.doorLeftFile = new File("DoorLeft.png");
        this.doorRightFile = new File("DoorRight.png");
        this.blankFile = new File("Blank.png");
        this.fatherUpperFile = new File("FatherUpper.png");
        this.fatherLowerFile = new File("FatherLower.png");
        this.motherUpperFile = new File("MotherUpper.png");
        this.motherLowerFile = new File("MotherLower.png");
        this.houseFloorFile = new File("HouseFloor.png");
        this.houseWallFile = new File("HouseWall.png");
        
        this.cafFloorFiles = new File[2];
        this.cafFloorFiles[0] = new File("cafFloor1.png");
        this.cafFloorFiles[1] = new File("cafFloor2.png");
        
        this.books = new Group[9];
        this.pressStart2PFile = new File("PressStart2P-Regular.ttf");
        this.screenNum = 0;
        
        this.confrontationChar = new File[5];
        this.confrontationChar[0] = new File("Level1Confrontation.png");
        this.confrontationChar[1] = new File("Confrontation2.png");
        this.confrontationChar[2] = new File("Confrontation3.png");
        this.confrontationChar[3] = new File("Confrontation4.png");
        this.confrontationChar[4] = new File("Confrontation5.png");
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
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
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
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the introduction animation.
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

        ImageView introBorderImageView = this.getIntroBorderImageView();

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            logoImageView,
            introBorderImageView
        );

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
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the main menu.
     * @throws IOException
     */
    public Scene mainMenu(Stage stage) throws IOException {
        screenNum = 1;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        Rectangle blackRectangleUnderOptions = new Rectangle(10, 10, 200, 580);
        blackRectangleUnderOptions.setFill(Paint.valueOf("rgb(0,0,0)"));

        Rectangle greyRectangleUnderTitle = new Rectangle(10, 50, 200, 75);
        greyRectangleUnderTitle.setFill(Paint.valueOf("rgb(96,96,96)"));

        GameTitle whiteTitleGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "The Awakening", 30, 56, 14);	
        whiteTitleGameTitle.setWidth(160);	
        whiteTitleGameTitle.setSpacing(10);	
        whiteTitleGameTitle.getUnderlineRectangle().setTranslateY(-13);
        //System.out.println(Region.USE_COMPUTED_SIZE);

        GameButton newGameGameButton = new GameButton(this.pressStart2PFile, "New Game", 30, 205, 17);

        GameButton instructionsGameButton = new GameButton(this.pressStart2PFile, "Instructions", 30, 275, 12);	
        instructionsGameButton.setTextTranslationY(2);	

        GameButton leaderboardGameButton = new GameButton(this.pressStart2PFile, "Leaderboard", 30, 350, 13);	
        leaderboardGameButton.setTextTranslationY(2);

        GameButton quitGameGameButton = new GameButton(this.pressStart2PFile, "Quit Game", 30, 435, 12);
        quitGameGameButton.setWidth(125);	
        quitGameGameButton.setHeight(40);
        
        Text copyrightStatementText = new Text(0, 0, "© 2022 Single Star Games");
        copyrightStatementText.setFont(this.getPressStart2PFont(6.5));
        copyrightStatementText.setFill(Paint.valueOf("white"));

        TextFlow copyrightStatementTextFlow = new TextFlow();
        copyrightStatementTextFlow.getChildren().addAll(
            copyrightStatementText
        );
        copyrightStatementTextFlow.setTranslateX(30);
        copyrightStatementTextFlow.setTranslateY(530);
        copyrightStatementTextFlow.setPrefWidth(160);
        copyrightStatementTextFlow.setPrefHeight(30);


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

        ImageView characterNonPixelatedImageView = new ImageView(new Image(mainCharFile.getPath()));
        characterNonPixelatedImageView.setPreserveRatio(true);
        characterNonPixelatedImageView.setSmooth(true);
        characterNonPixelatedImageView.setX(230);
        characterNonPixelatedImageView.setY(380);
        characterNonPixelatedImageView.setFitWidth(120);

        Circle yellowCircleForSun = new Circle(600, 0, 100, Paint.valueOf("rgb(255,255,0)"));
        yellowCircleForSun.setStroke(Paint.valueOf("rgb(0,0,0)"));
        //System.out.println(yellowCircleForSun);

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
        nodesToAdd.getChildren().addAll(
            yellowCircleForSun,
            cloudShapeTop,
            cloudShapeMiddle,
            cloudShapeBottom,
            blackRectangleUnderOptions,
            greyRectangleUnderTitle,
            whiteTitleGameTitle.getTitle(),
            newGameGameButton.getButton(),
            instructionsGameButton.getButton(),
            leaderboardGameButton.getButton(),
            quitGameGameButton.getButton(),
            copyrightStatementTextFlow,
            grassAndDirtBlocksGroup,
            characterNonPixelatedImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        // Keep these two split or else the cursor will not work as expected
        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= newGameGameButton.getLeftX() && xVal <= newGameGameButton.getRightX() && yVal >= newGameGameButton.getTopY() && yVal <= newGameGameButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= instructionsGameButton.getLeftX() && xVal <= instructionsGameButton.getRightX() && yVal >= instructionsGameButton.getTopY() && yVal <= instructionsGameButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= leaderboardGameButton.getLeftX() && xVal <= leaderboardGameButton.getRightX() && yVal >= leaderboardGameButton.getTopY() && yVal <= leaderboardGameButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= quitGameGameButton.getLeftX() && xVal <= quitGameGameButton.getRightX() && yVal >= quitGameGameButton.getTopY() && yVal <= quitGameGameButton.getBottomY()) {
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

                if (xVal >= newGameGameButton.getLeftX() && xVal <= newGameGameButton.getRightX() && yVal >= newGameGameButton.getTopY() && yVal <= newGameGameButton.getBottomY()) {
                    newGameGameButton.cursorOverButton();
                    //redRectangleAroundNewGameButton.setVisible(true);
                } else {
                    newGameGameButton.cursorNotOverButton();
                    //redRectangleAroundNewGameButton.setVisible(false);
                }

                if (xVal >= instructionsGameButton.getLeftX() && xVal <= instructionsGameButton.getRightX() && yVal >= instructionsGameButton.getTopY() && yVal <= instructionsGameButton.getBottomY()) {
                    instructionsGameButton.cursorOverButton();
                    //redRectangleAroundInstructionsButton.setVisible(true);
                } else {
                    instructionsGameButton.cursorNotOverButton();
                    //redRectangleAroundInstructionsButton.setVisible(false);
                }

                if (xVal >= leaderboardGameButton.getLeftX() && xVal <= leaderboardGameButton.getRightX() && yVal >= leaderboardGameButton.getTopY() && yVal <= leaderboardGameButton.getBottomY()) {
                    leaderboardGameButton.cursorOverButton();
                    //redRectangleAroundLeaderboardButton.setVisible(true);
                } else {
                    leaderboardGameButton.cursorNotOverButton();
                    //redRectangleAroundLeaderboardButton.setVisible(false);
                }

                if (xVal >= quitGameGameButton.getLeftX() && xVal <= quitGameGameButton.getRightX() && yVal >= quitGameGameButton.getTopY() && yVal <= quitGameGameButton.getBottomY()) {
                    quitGameGameButton.cursorOverButton();
                    //redRectangleAroundQuitGameButton.setVisible(true);
                } else {
                    quitGameGameButton.cursorNotOverButton();
                    //redRectangleAroundQuitGameButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= newGameGameButton.getLeftX() && xVal <= newGameGameButton.getRightX() && yVal >= newGameGameButton.getTopY() && yVal <= newGameGameButton.getBottomY()) {
                    screenNum = 2;
                    stage.setScene(this.level1Scene);
                    stage.show();
                } else if (xVal >= instructionsGameButton.getLeftX() && xVal <= instructionsGameButton.getRightX() && yVal >= instructionsGameButton.getTopY() && yVal <= instructionsGameButton.getBottomY()) {
                    screenNum = 3;
                    stage.setScene(this.instructionsScene);
                    stage.show();
                } else if (xVal >= leaderboardGameButton.getLeftX() && xVal <= leaderboardGameButton.getRightX() && yVal >= leaderboardGameButton.getTopY() && yVal <= leaderboardGameButton.getBottomY()) {
                    screenNum = 4;
                    stage.setScene(this.leaderboardScene);
                    stage.show();
                } else if (xVal >= quitGameGameButton.getLeftX() && xVal <= quitGameGameButton.getRightX() && yVal >= quitGameGameButton.getTopY() && yVal <= quitGameGameButton.getBottomY()) {
                    screenNum = 5;
                    stage.setScene(this.quitGameScene);
                    stage.show();
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    /**
     * Public non-static method used to create the first level for the actual game.
     * <p>
     * This public non-static method will be used to create the first level of the
     * program and return it as a scene. It will do this by creating 4 instances of the
     * Grid.java class to simulate the grid and it also has an action listener
     * for moving, and interaction with books. It draws this on a scene that it
     * returns with the draw method in the Grid instance and a photo at the location
     * of the mainX and mainY coordinates of the Grid instance.
     * <p>
     * Done by: Simon
     * Simon Bakan May 23-27 spent 5 hours: completely re-did grid instantiation,
     * added books, added interaction with books, added label for number of books
     * collected, and added multiple grids. 
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show level 1 of the game.
     * @throws IOException
     */
    public Scene level1(Stage stage) throws IOException {
        screenNum = 2;
        Grid[] grid = {
            new Grid(15, 15),
            new Grid(15, 15),
            new Grid(15, 15),
            new Grid(15, 15)
        };
        Scene scene;
        showingBook = false;

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
            int i = 2;
            grid[0].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            int j = 2;
            grid[0].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            for (int j = 3; j < 20; j++) {
                grid[0].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[0].setObject(17, 13, bookTileFile.getPath());
        grid[0].setInteractable(17, 13, true);
        grid[0].setMovable(17, 13, false);
        grid[0].setObject(5, 10, bookTileFile.getPath());
        grid[0].setInteractable(5, 10, true);
        grid[0].setMovable(5, 10, false);

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
            int i = 2;
            grid[1].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            int j = 17;
            grid[1].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 3; i < 20; i++) {
            for (int j = 0; j < 17; j++) {
                grid[1].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[1].setObject(8, 13, bookTileFile.getPath());
        grid[1].setInteractable(8, 13, true);
        grid[1].setMovable(8, 13, false);
        grid[1].setObject(15, 7, bookTileFile.getPath());
        grid[1].setInteractable(15, 7, true);
        grid[1].setMovable(15, 7, false);

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
            int i = 17;
            grid[2].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            int j = 2;
            grid[2].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            for (int j = 3; j < 20; j++) {
                grid[2].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[2].setObject(3, 17, bookTileFile.getPath());
        grid[2].setInteractable(3, 17, true);
        grid[2].setMovable(3, 17, false);
        grid[2].setObject(10, 10, bookTileFile.getPath());
        grid[2].setInteractable(10, 10, true);
        grid[2].setMovable(10, 10, false);

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
            int i = 17;
            grid[3].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            int j = 17;
            grid[3].assign(i, j, sandTileFile.getPath(), "", true, false);
        }
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                grid[3].assign(i, j, grassTileFile.getPath(), additionalGrassTileFile.getPath(), true, false);
            }
        }
        grid[3].setObject(3, 12, bookTileFile.getPath());
        grid[3].setInteractable(3, 12, true);
        grid[3].setMovable(3, 12, false);
        grid[3].setObject(10, 10, bookTileFile.getPath());
        grid[3].setInteractable(10, 10, true);
        grid[3].setMovable(10, 10, false);
        grid[3].setObject(15, 8, bookTileFile.getPath());
        grid[3].setInteractable(15, 8, true);
        grid[3].setMovable(15, 8, false);

        this.gridNum = 0;
        Group[] gr = new Group[4];
        for (int i = 0; i < 4; i++) {
            gr[i] = grid[i].draw();
        }
        
        direction = "right";
        ImageView mainChar = new ImageView();
        try {
            Image image = new Image(mainCharFile.toURI().toString());
            mainChar.setImage(image);
            mainChar.setX(30 * grid[gridNum].getX());
            mainChar.setY(30 * grid[gridNum].getY()-15);
        } catch (Exception e) {}
        bookNum = 0;
        Label bookLabel = new Label(bookNum + "/" + books.length + " books found");

        bookLabel.setFont(this.getPressStart2PFont(1)); // It doesn't matter what font size I put here so I will default it to 1.
        bookLabel.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: rgba(255,255,255,0); -fx-text-fill: rgb(0,0,0); -fx-font-size: 15px;");
        bookLabel.setTranslateX(375);
        bookLabel.setTranslateY(12);

        Group view = new Group();
        view.getChildren().addAll(
            gr[gridNum],
            mainChar,
            bookLabel
        );
        scene = new Scene(view);

        // Runs on a key press.
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.SPACE) {
                            Tile interaction = grid[gridNum].interact();
                            if (showingBook) {
                                showingBook = false;
                                gr[gridNum] = grid[gridNum].draw();
                            } else if (interaction.getObject().equals(bookTileFile.getPath())) {
                                showingBook = true;
                                interaction.setObject(additionalGrassTileFile.getPath());
                                interaction.setMovable(true);
                                interaction.setInteractable(false);
                                scene.setRoot(books[bookNum]);
                                bookNum++;
                                if (bookNum == books.length) {
                                    grid[0].setObject(15, 15, level1Confrontation.getPath());
                                    grid[0].setMovable(15, 15, false);
                                    grid[0].setInteractable(15, 15, true);
                                    gr[0] = grid[0].draw();
                                }
                            } else if (interaction.getObject().equals(level1Confrontation.getPath())) {
                                stage.setScene(confrontationTextScene1);
                            }
                        }
                        if (!showingBook) {
                            if (k.getCode() == KeyCode.W) {
                                final int OFF = grid[gridNum].moveUp();
                                if (OFF != -1) {
                                    this.gridNum -= 2;
                                    grid[gridNum].setX(OFF);
                                    grid[gridNum].setY(19);
                                }
                            } else if (k.getCode() == KeyCode.A) {
                                final int OFF = grid[gridNum].moveLeft();
                                if (OFF != -1) {
                                    this.gridNum -= 1;
                                    grid[gridNum].setX(19);
                                    grid[gridNum].setY(OFF);
                                }
                                direction = "left";
                            } else if (k.getCode() == KeyCode.S) {
                                final int OFF = grid[gridNum].moveDown();
                                if (OFF != -1) {
                                    gridNum += 2;
                                    grid[gridNum].setX(OFF);
                                    grid[gridNum].setY(0);
                                }
                            } else if (k.getCode() == KeyCode.D) {
                                final int OFF = grid[gridNum].moveRight();
                                if (OFF != -1) {
                                    gridNum += 1;
                                    grid[gridNum].setX(0);
                                    grid[gridNum].setY(OFF);
                                }
                                direction = "right";
                            }
                            
                            Image image = new Image(mainCharFile.toURI().toString());
                            mainChar.setImage(image);
                            mainChar.setX(30 * grid[gridNum].getX());
                            mainChar.setY(30 * grid[gridNum].getY()-15);
                            if(direction.equals("left")){
                                mainChar.setScaleX(-1);
                            }else{
                                mainChar.setScaleX(1);
                            }
                            view.getChildren().clear();
                            view.getChildren().add(gr[gridNum]);
                            view.getChildren().add(mainChar);
                            bookLabel.setText(bookNum + "/" + books.length + " books found");
                            view.getChildren().add(bookLabel);
                            scene.setRoot(view);
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    
    /**
     * Public non-static method used to create the second level for the actual game.
     * <p>
     * This public non-static method will be used to create the second level of the
     * program and return it as a scene. It will do this by creating an instance of the
     * Grid.java class to simulate the grid and it also has an action listener
     * for moving, and interaction with books. It draws this on a scene that it
     * returns with the draw method in the Grid instance and a photo at the location
     * of the mainX and mainY coordinates of the Grid instance.
     * <p>
     * Done by: Simon May 30 - June 3
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show level 2 of the game.
     * @throws IOException
     */
    public Scene level2(Stage stage) throws IOException {
        
        //By Simon May 30-June 3 for 1 hour
        screenNum = 2;
        Grid grid = new Grid(15, 15);
        Scene scene;
        health = 100;
        
        // Grid
        for (int i = 0; i < 20; i++) {
            int j=0;
            grid.assign(i, j, cafWallFile.getPath(), "", false, false);
            j=19;
            grid.assign(i, j, cafWallFile.getPath(), "", false, false);
        }
        for (int j = 1; j < 19; j++) {
            int i = 0;
            grid.assign(i, j, cafWallFile.getPath(), "", false, false);
            i = 19;
            grid.assign(i, j, cafWallFile.getPath(), "", false, false);
        }
        for (int i = 1; i < 19; i++) {
            for (int j = 1; j < 19; j++) {
                grid.assign(i, j, cafFloorFiles[(i+j)%2].getPath(), "", true, false);
            }
        }
        
        grid.setObject(10, 5, confrontationChar[1].getPath());
        grid.setInteractable(10, 5, true);
        grid.setMovable(10, 5, false);
        grid.setObject(16, 12, confrontationChar[2].getPath());
        grid.setInteractable(16, 12, true);
        grid.setMovable(16, 12, false);
        grid.setObject(5, 16, confrontationChar[3].getPath());
        grid.setInteractable(5, 16, true);
        grid.setMovable(5, 16, false);

        level2Group = grid.draw();
        
        direction = "right";
        ImageView mainChar = new ImageView();
        try {
            Image image = new Image(mainCharFile.toURI().toString());
            mainChar.setImage(image);
            mainChar.setX(30 * grid.getX());
            mainChar.setY(30 * grid.getY()-15);
        } catch (Exception e) {}
        bookNum = 0;

        Group view = new Group();
        view.getChildren().addAll(
            level2Group,
            mainChar
        );
        scene = new Scene(view);

        // Runs on a key press.
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.W) {
                            grid.moveUp();
                        } else if (k.getCode() == KeyCode.A) {
                            grid.moveLeft();
                            direction = "left";
                        } else if (k.getCode() == KeyCode.S) {
                            grid.moveDown();
                        } else if (k.getCode() == KeyCode.D) {
                            grid.moveRight();
                            direction = "right";
                        } else if (k.getCode() == KeyCode.SPACE) {
                            Tile interaction = grid.interact();
                            if(interaction.getObject().equals(confrontationChar[1].getPath())){
                                interaction.setObject("");
                                interaction.setMovable(true);
                                interaction.setInteractable(false);
                                level2Group = grid.draw();
                                enemyHealth = 100;
                                battleMenu = "main";
                                form = "";
                                block=0;
                                questionMenu = "startText";
                                this.confrontationTextScene2 = this.confrontation2Text(stage);
                                stage.setScene(confrontationTextScene2);
                            }else if(interaction.getObject().equals(confrontationChar[2].getPath())){
                                interaction.setObject("");
                                interaction.setMovable(true);
                                interaction.setInteractable(false);
                                level2Group = grid.draw();
                                enemyHealth = 100;
                                battleMenu = "main";
                                form = "";
                                block=0;
                                questionMenu = "startText";
                                this.confrontationTextScene3 = this.confrontation3Text(stage);
                                stage.setScene(confrontationTextScene3);
                            }else if(interaction.getObject().equals(confrontationChar[3].getPath())){
                                interaction.setObject("");
                                interaction.setMovable(true);
                                interaction.setInteractable(false);
                                level2Group = grid.draw();
                                enemyHealth = 100;
                                battleMenu = "main";
                                form = "";
                                block=0;
                                questionMenu = "startText";
                                this.confrontationTextScene4 = this.confrontation4Text(stage);
                                stage.setScene(confrontationTextScene4);
                            }
                        }
                            
                        Image image = new Image(mainCharFile.toURI().toString());
                        mainChar.setImage(image);
                        mainChar.setX(30 * grid.getX());
                        mainChar.setY(30 * grid.getY()-15);
                        if(direction.equals("left")){
                            mainChar.setScaleX(-1);
                        }else{
                            mainChar.setScaleX(1);
                        }
                        view.getChildren().clear();
                        view.getChildren().add(level2Group);
                        view.getChildren().add(mainChar);
                        scene.setRoot(view);
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the third level for the actual game.
     * <p>
     * This public non-static method will be used to create the third level of the
     * program and return it as a scene. It will do this by creating an instance of the
     * Grid.java class to simulate the grid and it also has an action listener
     * for moving. It draws this on a scene that it returns with the draw method in the 
     * Grid instance and a photo at the location of the mainX and mainY coordinates of 
     * the Grid instance.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show level 3 of the game.
     * @throws IOException
     */
    public Scene level3(Stage stage) throws IOException {
        screenNum = 2;
        Grid grid = new Grid(15, 15);
        Scene scene;
        health = 100;
        
        // Grid
        for (int i = 0; i < 20; i++) {
            int j=0;
            grid.assign(i, j, houseWallFile.getPath(), "", false, false);
            j=19;
            grid.assign(i, j, houseWallFile.getPath(), "", false, false);
        }
        for (int j = 1; j < 19; j++) {
            int i = 0;
            grid.assign(i, j, houseWallFile.getPath(), "", false, false);
            i = 19;
            grid.assign(i, j, houseWallFile.getPath(), "", false, false);
        }
        for (int i = 1; i < 19; i++) {
            for (int j = 1; j < 19; j++) {
                grid.assign(i, j, houseFloorFile.getPath(), "", true, false);
            }
        }
        
        grid.setObject(9, 14, motherUpperFile.getPath());
        grid.setInteractable(9, 14, true);
        grid.setMovable(9, 14, false);
        grid.setObject(10, 14, motherLowerFile.getPath());
        grid.setInteractable(10, 14, true);
        grid.setMovable(10, 14, false);
        grid.setObject(9, 15, fatherUpperFile.getPath());
        grid.setInteractable(9, 15, false);
        grid.setMovable(9, 15, false);
        grid.setObject(10, 15, fatherLowerFile.getPath());
        grid.setInteractable(10, 15, false);
        grid.setMovable(10, 15, false);

        level3Group = grid.draw();
        
        direction = "right";
        ImageView mainChar = new ImageView();
        try {
            Image image = new Image(mainCharFile.toURI().toString());
            mainChar.setImage(image);
            mainChar.setX(30 * grid.getX());
            mainChar.setY(30 * grid.getY()-15);
        } catch (Exception e) {}
        bookNum = 0;

        Group view = new Group();
        view.getChildren().addAll(
            level3Group,
            mainChar
        );
        scene = new Scene(view);

        // Runs on a key press.
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.W) {
                            grid.moveUp();
                        } else if (k.getCode() == KeyCode.A) {
                            grid.moveLeft();
                            direction = "left";
                        } else if (k.getCode() == KeyCode.S) {
                            grid.moveDown();
                        } else if (k.getCode() == KeyCode.D) {
                            grid.moveRight();
                            direction = "right";
                        } else if (k.getCode() == KeyCode.SPACE) {
                            Tile interaction = grid.interact();
                            if(interaction!=null){
                                enemyHealth = 100;
                                battleMenu = "main";
                                form = "";
                                questionMenu = "startText";
                                stage.setScene(confrontationTextScene5);
                            }
                        }
                            
                        Image image = new Image(mainCharFile.toURI().toString());
                        mainChar.setImage(image);
                        mainChar.setX(30 * grid.getX());
                        mainChar.setY(30 * grid.getY()-15);
                        if(direction.equals("left")){
                            mainChar.setScaleX(-1);
                        }else{
                            mainChar.setScaleX(1);
                        }
                        view.getChildren().clear();
                        view.getChildren().add(level3Group);
                        view.getChildren().add(mainChar);
                        scene.setRoot(view);
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    
    /**
     * Public non-static method used to create the first encounter text.
     * <p>
     * This public non-static method will be used to create the text for the first
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon May 30 - June 3: 1 hour
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation1Text(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[0]))), "Yourself:", "I think I may be transgendered, but I'm scared. How will people see me. Maybe its better If I just repress it.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.SPACE) {
                            stage.setScene(confrontationBattleScene1);
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the first encounter text.
     * <p>
     * This public non-static method will be used to create the text for the first
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text. It will also ask if what the the enemy is saying is transphobic and 
     * use buttons to get the answer from the user.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation2Text(Stage stage) throws IOException {
        Scene scene;
        GameButton yesButton = new GameButton(this.pressStart2PFile, "Yes", 85, 470, 17);	
        	
        GameButton noButton = new GameButton(this.pressStart2PFile, "No", 390, 470, 17);	
        
        questionMenu="startText";
        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))), "Thomas:", "That so trans. You don’t even look like a girl. You should stop trying to be something you are not.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());
                
        try{
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    if(questionMenu.equals("question")){
                        if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
    
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    //System.out.println(xVal + " " + yVal);
                    
                    if(questionMenu.equals("question")){
                        if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                            yesButton.cursorOverButton();
                            //redRectangleAroundNewGameButton.setVisible(true);
                        } else {
                            yesButton.cursorNotOverButton();
                            //redRectangleAroundNewGameButton.setVisible(false);
                        }
        
                        if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                            noButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            noButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                    }                
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e -> {
                    try{
                        final double xVal = e.getX();
                        final double yVal = e.getY();
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                score += 50;
                                ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))), "You answered yes:", "That is correct! Thomas was talking about your physique and telling you that you are not the gender you are. This is very transphobic.", health, enemyHealth);
                                scene.setRoot(answerTxt.getScene());
                                stage.show();
                                questionMenu = "endText";
                            } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))), "You answered no:", "That is incorrect! Thomas was talking about your physique and telling you that you are not the gender you are. This is very transphobic.", health, enemyHealth);
                                scene.setRoot(answerTxt.getScene());
                                stage.show();
                                questionMenu = "endText";
                            }
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (questionMenu.equals("startText")) {
                            ConfrontationScene questionButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))),"Is Thomas Being transphobic?", yesButton, noButton);
                            scene.setRoot(questionButtons.getScene());
                            stage.show();
                            questionMenu = "question";
                        }else if(questionMenu.equals("endText")){
                            this.confrontationBattleScene2 = this.confrontationBattle(stage,2);
                            stage.setScene(confrontationBattleScene2);
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the first encounter text.
     * <p>
     * This public non-static method will be used to create the text for the first
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text. It will also ask if what the the enemy is saying is transphobic and 
     * use buttons to get the answer from the user.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation3Text(Stage stage) throws IOException {
        Scene scene;
        GameButton yesButton = new GameButton(this.pressStart2PFile, "Yes", 85, 470, 17);	
        	
        GameButton noButton = new GameButton(this.pressStart2PFile, "No", 390, 470, 17);	
        
        questionMenu="startText";
        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))), "Sarah:", "I really love skirts. Don’t you like them too?", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());
                
        try{
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    if(questionMenu.equals("question")){
                        if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
    
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    //System.out.println(xVal + " " + yVal);
                    
                    if(questionMenu.equals("question")){
                        if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                            yesButton.cursorOverButton();
                            //redRectangleAroundNewGameButton.setVisible(true);
                        } else {
                            yesButton.cursorNotOverButton();
                            //redRectangleAroundNewGameButton.setVisible(false);
                        }
        
                        if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                            noButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            noButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                    }                
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e -> {
                    try{
                        final double xVal = e.getX();
                        final double yVal = e.getY();
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))), "You answered yes:", "That is incorrect! Sarah is just trying to talk about something she likes. Even though she might unknowingly be pressuring you to wear a skirt it is not her intention.", health, enemyHealth);
                                scene.setRoot(answerTxt.getScene());
                                stage.show();
                                questionMenu = "endText";
                            } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                score += 50;
                                ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))), "You answered no:", "That is correct! Sarah is just trying to talk about something she likes. Even though she might unknowingly be pressuring you to wear a skirt it is not her intention.", health, enemyHealth);
                                scene.setRoot(answerTxt.getScene());
                                stage.show();
                                questionMenu = "endText";
                            }
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (questionMenu.equals("startText")) {
                            ConfrontationScene questionButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))),"Is Sarah Being transphobic?", yesButton, noButton);
                            scene.setRoot(questionButtons.getScene());
                            stage.show();
                            questionMenu = "question";
                        }else if(questionMenu.equals("endText")){
                            this.confrontationBattleScene3 = this.confrontationBattle(stage,3);
                            stage.setScene(confrontationBattleScene3);
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the first encounter text.
     * <p>
     * This public non-static method will be used to create the text for the first
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text. It will also ask if what the the enemy is saying is transphobic and 
     * use buttons to get the answer from the user.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation4Text(Stage stage) throws IOException {
        Scene scene;
        GameButton yesButton = new GameButton(this.pressStart2PFile, "Yes", 85, 470, 17);	
        	
        GameButton noButton = new GameButton(this.pressStart2PFile, "No", 390, 470, 17);	
        
        questionMenu="startText";
        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))), "Karen:", "You are not a real girl.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());
                
        try{
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    if(questionMenu.equals("question")){
                        if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
    
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    //System.out.println(xVal + " " + yVal);
                    
                    if(questionMenu.equals("question")){
                        if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                            yesButton.cursorOverButton();
                            //redRectangleAroundNewGameButton.setVisible(true);
                        } else {
                            yesButton.cursorNotOverButton();
                            //redRectangleAroundNewGameButton.setVisible(false);
                        }
        
                        if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                            noButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            noButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                    }                
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e -> {
                    try{
                        final double xVal = e.getX();
                        final double yVal = e.getY();
                        if(questionMenu.equals("question")){
                            if (xVal >= yesButton.getLeftX() && xVal <= yesButton.getRightX() && yVal >= yesButton.getTopY() && yVal <= yesButton.getBottomY()) {
                                ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))), "You answered yes:", "That is correct! Karen said that you are not a “real girl” which is very transphobic. A just because your gender is not the same as your gender assigned at birth does not mean you are not the gender you are.", health, enemyHealth);
                                score += 50;
                                scene.setRoot(answerTxt.getScene());
                                stage.show();
                                questionMenu = "endText";
                            } else if (xVal >= noButton.getLeftX() && xVal <= noButton.getRightX() && yVal >= noButton.getTopY() && yVal <= noButton.getBottomY()) {
                                ConfrontationScene answerTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))), "You answered no:", "That is incorrect! Karen said that you are not a “real girl” which is very transphobic. A just because your gender is not the same as your gender assigned at birth does not mean you are not the gender you are.", health, enemyHealth);
                                scene.setRoot(answerTxt.getScene());
                                stage.show();
                                questionMenu = "endText";
                            }
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (questionMenu.equals("startText")) {
                            ConfrontationScene questionButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))),"Is Karen Being transphobic?", yesButton, noButton);
                            scene.setRoot(questionButtons.getScene());
                            stage.show();
                            questionMenu = "question";
                        }else if(questionMenu.equals("endText")){
                            this.confrontationBattleScene4 = this.confrontationBattle(stage,4);
                            stage.setScene(confrontationBattleScene4);
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the first encounter text.
     * <p>
     * This public non-static method will be used to create the text for the fith
     * conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation5Text(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[4]))), "You:", "I have something to tell you...", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.SPACE) {
                            stage.setScene(confrontationBattleScene5);
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the second encounter text after confrontation.
     * <p>
     * This public non-static method will be used to create the text for after the
     * second conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation2AfterText(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[1]))), "Sarah:", "Thank you for playing with me!", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.SPACE) {
                            if(confrontations<4){
                                stage.setScene(level2Scene);
                            }else{
                                stage.setScene(level3Scene);
                            }
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }

    
    /**
     * Public non-static method used to create the third encounter text after confrontation.
     * <p>
     * This public non-static method will be used to create the text for after the
     * third conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation3AfterText(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[2]))), "Thomas:", "I'm sorry I said those things, I'm just having a really bad day.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.SPACE) {
                            if(confrontations<4){
                                stage.setScene(level2Scene);
                            }else{
                                stage.setScene(level3Scene);
                            }
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the fourth encounter text after confrontation.
     * <p>
     * This public non-static method will be used to create the text for after the
     * fourth conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation4AfterText(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[3]))), "Karen:", "I'm sorry I said those things, I can't tell you what you are.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.SPACE) {
                            if(confrontations<4){
                                stage.setScene(level2Scene);
                            }else{
                                stage.setScene(level3Scene);
                            }
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }
    
    /**
     * Public non-static method used to create the fith encounter text after confrontation.
     * <p>
     * This public non-static method will be used to create the text for after the
     * fith conflict. It will do this by creating an instance of the ConfrontationScene
     * class which will draw a scene with the main character, the enemy, and the
     * text.
     * <p>
     * Done by: Simon June 6-10
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontation5AfterText(Stage stage) throws IOException {
        Scene scene;

        
        ConfrontationScene encounterTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[4]))), "Parents:", "We might need to take some time to process it but you know we love you no matter what.", health, enemyHealth);	
        encounterTxt.getTitle().setFont(encounterTxt.getFontFromFile(18));	
        encounterTxt.getTitle().setFill(Paint.valueOf("Black"));	
        encounterTxt.getBody().setFont(encounterTxt.getFontFromFile(12));	
        encounterTxt.getBody().setFill(Paint.valueOf("Black"));
        scene = new Scene(encounterTxt.getScene());

        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if (k.getCode() == KeyCode.SPACE) {
                            stage.setScene(winScene);
                        }
                    } catch (Exception e) {}
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scene;
    }


    
    /**
     * Public non-static method used to create the combat element of all encounters.
     * <p>
     * This public non-static method will be used to create the game for all the 
     * conflicts. It will do this by creating aseveral GameButton instances and 
     * displaying them ConfrontationScene class which will draw a scene with the 
     * main character, the enemy, and the button or text that is being displayed.
     * It will use these buttons to get user input for the player to change forms or
     * perform actions.
     * <p>
     * Done by: Simon May 30 - June 3: 4 hours
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the text of the first encounter of the game.
     * @throws IOException
     */
    public Scene confrontationBattle(Stage stage, int encounterNum) throws IOException {
        //health = 100;
        enemyHealth = 100;
        Scene scene;
        battleMenu = "main";
        form = "";
        
        /*Rectangle char1HealthBarFront = new Rectangle(5, 5, Paint.valueOf("yellow"));
        char1HealthBarFront.setStrokeWidth(1.0);
        char1HealthBarFront.setStroke(Paint.valueOf("black"));
        Rectangle char1HealthBarBack = new Rectangle(5, 5, Paint.valueOf("black"));
        char1HealthBarBack.setStrokeWidth(1.0);
        char1HealthBarBack.setStroke(Paint.valueOf("black"));
        Rectangle char2HealthBarFront = new Rectangle(5, 5, Paint.valueOf("yellow"));
        char2HealthBarFront.setStrokeWidth(1.0);
        char2HealthBarFront.setStroke(Paint.valueOf("black"));
        Rectangle char2HealthBarBack = new Rectangle(5, 5, Paint.valueOf("black"));
        char2HealthBarBack.setStrokeWidth(1.0);
        char2HealthBarBack.setStroke(Paint.valueOf("black"));
        
        Ellipse closeCharPlat = new Ellipse(5, 5);
        closeCharPlat.setFill(Paint.valueOf("red"));
        Ellipse farCharPlat = new Ellipse(5, 5);
        farCharPlat.setFill(Paint.valueOf("blue"));
        */
        GameButton actionButton = new GameButton(this.pressStart2PFile, "Action", 85, 470, 17);	
        	
        GameButton formButton = new GameButton(this.pressStart2PFile, "Form", 390, 470, 17);	
        	
        GameButton debateButton = new GameButton(this.pressStart2PFile, "Debate", 85, 470, 17);	
        	
        GameButton defendButton = new GameButton(this.pressStart2PFile, "Defend", 390, 470, 17);
        
        GameButton actionBackButton = new GameButton(this.pressStart2PFile, "Back", 85, 540, 17);	
        	
        GameButton defensiveButton = new GameButton(this.pressStart2PFile, "Defensive", 85, 470, 17);	
        	
        GameButton assertiveButton = new GameButton(this.pressStart2PFile, "Assertive", 390, 470, 17);	
        	
        GameButton empatheticButton = new GameButton(this.pressStart2PFile, "Empathetic", 85, 540, 17);
        
        GameButton formBackButton = new GameButton(this.pressStart2PFile, "Back", 390, 540, 17);
        
        ConfrontationScene startButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), actionButton, null, formButton, null, health, enemyHealth);                   
        scene = new Scene(startButtons.getScene());
        try{
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    if(battleMenu.equals("main")){
                        if (xVal >= actionButton.getLeftX() && xVal <= actionButton.getRightX() && yVal >= actionButton.getTopY() && yVal <= actionButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= formButton.getLeftX() && xVal <= formButton.getRightX() && yVal >= formButton.getTopY() && yVal <= formButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }else if(battleMenu.equals("action")){
                        if (xVal >= debateButton.getLeftX() && xVal <= debateButton.getRightX() && yVal >= debateButton.getTopY() && yVal <= debateButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= defendButton.getLeftX() && xVal <= defendButton.getRightX() && yVal >= defendButton.getTopY() && yVal <= defendButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= actionBackButton.getLeftX() && xVal <= actionBackButton.getRightX() && yVal >= actionBackButton.getTopY() && yVal <= actionBackButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }else if(battleMenu.equals("form")){
                        if (xVal >= defensiveButton.getLeftX() && xVal <= defensiveButton.getRightX() && yVal >= defensiveButton.getTopY() && yVal <= defensiveButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= assertiveButton.getLeftX() && xVal <= assertiveButton.getRightX() && yVal >= assertiveButton.getTopY() && yVal <= assertiveButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= empatheticButton.getLeftX() && xVal <= empatheticButton.getRightX() && yVal >= empatheticButton.getTopY() && yVal <= empatheticButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else if (xVal >= formBackButton.getLeftX() && xVal <= formBackButton.getRightX() && yVal >= formBackButton.getTopY() && yVal <= formBackButton.getBottomY()) {
                            scene.setCursor(Cursor.HAND);
                        } else {
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_MOVED,
                e -> {
    
                    final double xVal = e.getX();
                    final double yVal = e.getY();
                    
                    //System.out.println(xVal + " " + yVal);
                    
                    if(battleMenu.equals("main")){
                        if (xVal >= actionButton.getLeftX() && xVal <= actionButton.getRightX() && yVal >= actionButton.getTopY() && yVal <= actionButton.getBottomY()) {
                            actionButton.cursorOverButton();
                            //redRectangleAroundNewGameButton.setVisible(true);
                        } else {
                            actionButton.cursorNotOverButton();
                            //redRectangleAroundNewGameButton.setVisible(false);
                        }
        
                        if (xVal >= formButton.getLeftX() && xVal <= formButton.getRightX() && yVal >= formButton.getTopY() && yVal <= formButton.getBottomY()) {
                            formButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            formButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                    }else if(battleMenu.equals("action")){
                        if (xVal >= debateButton.getLeftX() && xVal <= debateButton.getRightX() && yVal >= debateButton.getTopY() && yVal <= debateButton.getBottomY()) {
                            debateButton.cursorOverButton();
                            //redRectangleAroundNewGameButton.setVisible(true);
                        } else {
                            debateButton.cursorNotOverButton();
                            //redRectangleAroundNewGameButton.setVisible(false);
                        }
        
                        if (xVal >= defendButton.getLeftX() && xVal <= defendButton.getRightX() && yVal >= defendButton.getTopY() && yVal <= defendButton.getBottomY()) {
                            defendButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            defendButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                        
                        if (xVal >= actionBackButton.getLeftX() && xVal <= actionBackButton.getRightX() && yVal >= actionBackButton.getTopY() && yVal <= actionBackButton.getBottomY()) {
                            actionBackButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            actionBackButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                    }else if(battleMenu.equals("form")){
                        if (xVal >= defensiveButton.getLeftX() && xVal <= defensiveButton.getRightX() && yVal >= defensiveButton.getTopY() && yVal <= defensiveButton.getBottomY()) {
                            defensiveButton.cursorOverButton();
                            //redRectangleAroundNewGameButton.setVisible(true);
                        } else {
                            defensiveButton.cursorNotOverButton();
                            //redRectangleAroundNewGameButton.setVisible(false);
                        }
        
                        if (xVal >= assertiveButton.getLeftX() && xVal <= assertiveButton.getRightX() && yVal >= assertiveButton.getTopY() && yVal <= assertiveButton.getBottomY()) {
                            assertiveButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            assertiveButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                        
                        if (xVal >= empatheticButton.getLeftX() && xVal <= empatheticButton.getRightX() && yVal >= empatheticButton.getTopY() && yVal <= empatheticButton.getBottomY()) {
                            empatheticButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            empatheticButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                        
                        if (xVal >= formBackButton.getLeftX() && xVal <= formBackButton.getRightX() && yVal >= formBackButton.getTopY() && yVal <= formBackButton.getBottomY()) {
                            formBackButton.cursorOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(true);
                        } else {
                            formBackButton.cursorNotOverButton();
                            //redRectangleAroundInstructionsButton.setVisible(false);
                        }
                    }
                }
            );
    
            scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e -> {
                    try{
                        final double xVal = e.getX();
                        final double yVal = e.getY();
                        if(battleMenu.equals("main")){
                            if (xVal >= actionButton.getLeftX() && xVal <= actionButton.getRightX() && yVal >= actionButton.getTopY() && yVal <= actionButton.getBottomY()) {
                                ConfrontationScene act = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), debateButton, actionBackButton, defendButton, null, health, enemyHealth);
                                scene.setRoot(act.getScene());
                                stage.show();
                                battleMenu = "action";
                            } else if (xVal >= formButton.getLeftX() && xVal <= formButton.getRightX() && yVal >= formButton.getTopY() && yVal <= formButton.getBottomY()) {
                                ConfrontationScene formSc = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), defensiveButton, empatheticButton, assertiveButton, formBackButton, health, enemyHealth);
                                scene.setRoot(formSc.getScene());
                                stage.show();
                                battleMenu = "form";
                            }
                        }else if(battleMenu.equals("action")){
                            if (xVal >= debateButton.getLeftX() && xVal <= debateButton.getRightX() && yVal >= debateButton.getTopY() && yVal <= debateButton.getBottomY()) {
                                final int damage = (int)(20*Math.random()+10);
                                enemyHealth-=damage;
                                if (form.equals("defensive")){
                                    block+=10;
                                }else if (form.equals("assertive")){
                                    enemyHealth-=damage;
                                }else if (form.equals("empathetic")){
                                    block+=damage;
                                }
                                Text title = new Text("Damage");
                                title.setFont(this.getPressStart2PFont(18));
                                title.setFill(Paint.valueOf("Black"));
                                Text body;
                                ConfrontationScene damageTxt;	
                                if(form.equals("assertive")){ 
                                    damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Damage", "You dealt "+(damage*2)+" damage and you have "+block+" block", health, enemyHealth);
                                }
                                else{
                                    damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Damage", "You dealt "+damage+" damage and you have "+block+" block", health, enemyHealth);
                                }	
                                damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                scene.setRoot(damageTxt.getScene());
                                battleMenu = "damageText";
                                }else if(xVal >= defendButton.getLeftX() && xVal <= defendButton.getRightX() && yVal >= defendButton.getTopY() && yVal <= defendButton.getBottomY()){
                                block+=15;
                                if (form.equals("defensive")){
                                    block+=10;
                                }
                                Text title = new Text("Defend");
                                title.setFont(this.getPressStart2PFont(18));
                                title.setFill(Paint.valueOf("Black"));
                                Text body = new Text("You Defended and you now have "+block+" block");
                                body.setFont(this.getPressStart2PFont(12));
                                body.setFill(Paint.valueOf("Black"));
                                
                                ConfrontationScene damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Defend", "You defended and you now have "+block+" block", health, enemyHealth);	
                                damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                scene.setRoot(damageTxt.getScene());
                                
                                battleMenu = "damageText";
                            } else if(xVal >= actionBackButton.getLeftX() && xVal <= actionBackButton.getRightX() && yVal >= actionBackButton.getTopY() && yVal <= actionBackButton.getBottomY()){
                                ConfrontationScene mainButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), actionButton, null, formButton, null, health, enemyHealth);                   
                                scene.setRoot(mainButtons.getScene());
                                battleMenu = "main";
                            }
                        }else if(battleMenu.equals("form")){
                            if (xVal >= defensiveButton.getLeftX() && xVal <= defensiveButton.getRightX() && yVal >= defensiveButton.getTopY() && yVal <= defensiveButton.getBottomY()) {
                                // Set Scene to damage text
                                form = "defensive";
                                block+=10;
                                battleMenu = "damageText";
                                
                                Text title = new Text("Form Change");
                                title.setFont(this.getPressStart2PFont(18));
                                title.setFill(Paint.valueOf("Black"));
                                Text body = new Text("You changed to "+form+" form and you have "+block+" block");
                                body.setFont(this.getPressStart2PFont(12));
                                body.setFill(Paint.valueOf("Black"));
                                
                                ConfrontationScene damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Form Change", "You changed to "+form+" form and you have "+block+" block", health, enemyHealth);	
                                damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                scene.setRoot(damageTxt.getScene());
                                
                            } else if (xVal >= assertiveButton.getLeftX() && xVal <= assertiveButton.getRightX() && yVal >= assertiveButton.getTopY() && yVal <= assertiveButton.getBottomY()) {
                                // Set Scene to damage text
                                form = "assertive";
                                battleMenu = "damageText";
                                
                                Text title = new Text("Form Change");
                                title.setFont(this.getPressStart2PFont(18));
                                title.setFill(Paint.valueOf("Black"));
                                Text body = new Text("You changed to "+form+" form and you have "+block+" block");
                                body.setFont(this.getPressStart2PFont(12));
                                body.setFill(Paint.valueOf("Black"));
                                
                                ConfrontationScene damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Form Change", "You changed to "+form+" form and you have "+block+" block", health, enemyHealth);	
                                damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                scene.setRoot(damageTxt.getScene());
                            } else if (xVal >= empatheticButton.getLeftX() && xVal <= empatheticButton.getRightX() && yVal >= empatheticButton.getTopY() && yVal <= empatheticButton.getBottomY()) {
                                // Set Scene to damage text
                                form = "empathetic";
                                battleMenu = "damageText";
                                
                                Text title = new Text("Form Change");
                                title.setFont(this.getPressStart2PFont(18));
                                title.setFill(Paint.valueOf("Black"));
                                Text body = new Text("You changed to "+form+" form and you have "+block+" block");
                                body.setFont(this.getPressStart2PFont(12));
                                body.setFill(Paint.valueOf("Black"));
                                
                                ConfrontationScene damageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Form Change", "You changed to "+form+" form and you have "+block+" block", health, enemyHealth);	
                                damageTxt.getTitle().setFont(damageTxt.getFontFromFile(18));	
                                damageTxt.getTitle().setFill(Paint.valueOf("Black"));	
                                damageTxt.getBody().setFont(damageTxt.getFontFromFile(12));	
                                damageTxt.getBody().setFill(Paint.valueOf("Black"));
                                scene.setRoot(damageTxt.getScene());
                            } else if(xVal >= formBackButton.getLeftX() && xVal <= formBackButton.getRightX() && yVal >= formBackButton.getTopY() && yVal <= formBackButton.getBottomY()){
                                ConfrontationScene mainButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), actionButton, null, formButton, null, health, enemyHealth);                   
                                scene.setRoot(mainButtons.getScene());
                                battleMenu = "main";
                            }
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            );
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try{
                        if(battleMenu.equals("damageText")){
                            if(encounterNum==1){
                                if(enemyHealth<=0){
                                    confrontations += 1;
                                    score -= (100-health)/5;
                                    stage.setScene(level2Scene);
                                }else{
                                    final int damage = (int)(10*Math.random()+10);
                                    final int damageTaken = damage-block;
                                    if(damage-block>=0){
                                        block = 0;
                                        health-=damageTaken;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }else{
                                        block-=damage;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }
                                }
                            }else if(encounterNum==2){
                                if(enemyHealth<=0){
                                    confrontations += 1;
                                    if(confrontations==4){
                                        score -= (100-health)/5;
                                    }
                                    this.confrontationAfterTextScene2 = confrontation2AfterText(stage);
                                    stage.setScene(confrontationAfterTextScene2);
                                }else{
                                    final int damage = (int)(10*Math.random()+10);
                                    final int damageTaken = damage-block;
                                    if(damage-block>=0){
                                        block = 0;
                                        health-=damageTaken;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }else{
                                        block-=damage;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }                                
                                }
                            }else if(encounterNum==3){
                                if(enemyHealth<=0){
                                    confrontations += 1;
                                    if(confrontations==4){
                                        score -= (100-health)/5;
                                    }
                                    this.confrontationAfterTextScene3 = confrontation3AfterText(stage);
                                    stage.setScene(confrontationAfterTextScene3);
                                }else{
                                    final int damage = (int)(10*Math.random()+10);
                                    final int damageTaken = damage-block;
                                    if(damage-block>=0){
                                        block = 0;
                                        health-=damageTaken;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }else{
                                        block-=damage;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }
                                }
                            }else if(encounterNum==4){
                                if(enemyHealth<=0){
                                    confrontations += 1;
                                    if(confrontations==4){
                                        score -= (100-health)/5;
                                    }
                                    this.confrontationAfterTextScene4 = confrontation4AfterText(stage);
                                    stage.setScene(confrontationAfterTextScene4);
                                }else{
                                    final int damage = (int)(10*Math.random()+10);
                                    final int damageTaken = damage-block;
                                    if(damage-block>=0){
                                        block = 0;
                                        health-=damageTaken;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }else{
                                        block-=damage;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }
                                }
                            }else if(encounterNum==5){
                                if(enemyHealth<=0){
                                    confrontations = 0;
                                    score -= (100-health)/5;
                                    health = 100;
                                    enemyHealth = 100;
                                    this.winScene = this.winGame(stage);
                                    this.confrontationAfterTextScene5 = confrontation5AfterText(stage);
                                    stage.setScene(confrontationAfterTextScene5);
                                }else{
                                    final int damage = (int)(10*Math.random()+20);
                                    final int damageTaken = damage-block;
                                    if(damage-block>=0){
                                        block = 0;
                                        health-=damageTaken;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but "+block+" was blocked block so you took " + damageTaken + " damage. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }else{
                                        block-=damage;
                                        ConfrontationScene enemyDamageTxt = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), "Enemy Damage", "The enemy did "+damage+" damage but all of it was blocked blocked. You now have " + block + " block. Press any key to continue...", health, enemyHealth);	
                                        enemyDamageTxt.getTitle().setFont(enemyDamageTxt.getFontFromFile(18));	
                                        enemyDamageTxt.getTitle().setFill(Paint.valueOf("Red"));	
                                        enemyDamageTxt.getBody().setFont(enemyDamageTxt.getFontFromFile(12));	
                                        enemyDamageTxt.getBody().setFill(Paint.valueOf("Red"));
                                        scene.setRoot(enemyDamageTxt.getScene());
                                    }
                                }
                            }
                            if(health<=0){
                                stage.setScene(loseScene);
                                confrontations = 0;
                            }else{
                                battleMenu = "enemyText";
                            }
                        }else if(battleMenu.equals("enemyText")){
                            ConfrontationScene mainButtons = new ConfrontationScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream(this.blankFile))), new ImageView(new Image(new FileInputStream(this.mainCharFile))), new ImageView(new Image(new FileInputStream(this.confrontationChar[encounterNum-1]))), actionButton, null, formButton, null, health, enemyHealth);                   
                            scene.setRoot(mainButtons.getScene());
                            battleMenu = "main";
                        }
                    }catch(Exception e){}
                }
            );
        }catch(Exception e){}
        return scene;
    }

    /**
     * Public non-static method used to create the main menu for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * instructions screen for the game. It will show the logo of the game as
     * well as instructions for the game. There will also be a "Back" button
     * that will allow the user to go back to the main menu.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the instructions screen.
     * @throws IOException
     */
    public Scene instructions(Stage stage) throws IOException {
        screenNum = 3;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteInstructionsGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "Instructions", 50, 90, 24);	
        whiteInstructionsGameTitle.setWidth(300);	
        whiteInstructionsGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Text instructionsText = new Text("\"Trans-form:The Awakening\" is a game about combating transphobia. You play as a transgender kid who has to come out to themself, confront transphobia at their school, and then come out to their parents.\n\nMove with WASD and interact with space. You can always press escape to pause the game or quit. Good luck combating transphobia!");
        instructionsText.setFont(this.getPressStart2PFont(18));
        instructionsText.setFill(Paint.valueOf("rgb(0,0,0)"));
        instructionsText.setWrappingWidth(500);
        instructionsText.setX(50);
        instructionsText.setY(250);

        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            instructionsText,
            backButton.getButton(),
            whiteInstructionsGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
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

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    public Scene leaderboard(Stage stage) throws IOException {
        screenNum = 4;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        GameTitle whiteLeaderboardGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "Leaderboard", 50, 90, 24);	
        whiteLeaderboardGameTitle.setWidth(300);	
        whiteLeaderboardGameTitle.setSpacing(15);

        Rectangle scoresBackground = new Rectangle(100, 225, 400, 250);
        scoresBackground.setFill(Paint.valueOf("rgb(193,154,107)"));
        scoresBackground.setStrokeType(StrokeType.OUTSIDE);
        scoresBackground.setStrokeWidth(10.0);
        scoresBackground.setStroke(Paint.valueOf("rgb(66,47,33)"));
        scoresBackground.setStrokeLineJoin(StrokeLineJoin.ROUND);


        //Leaderboard leaderboard = new Leaderboard();
        //Text scoresText = new Text(leaderboard.getLeaderboard());
        //scoresText.setFill(Paint.valueOf("white"));

        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            backButton.getButton(),
            //scoresText,
            scoresBackground,
            whiteLeaderboardGameTitle.getTitle(),
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
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

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                }
            }
        );

        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }

    /**
     * Public non-static method used to create the quit game screen for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * quit game screen for the game. This screen will show the user the logo
     * of the game as well as text saying who made this game. They will also
     * have a button that they can press to leave the game.
     * <p>
     * Done by: Joshua
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the quit game screen.
     * @throws IOException
     */
    public Scene quitGame(Stage stage) throws IOException {
        screenNum = 5;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteQuitGameGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "Quit Game", 50, 90, 24);	
        whiteQuitGameGameTitle.setWidth(300);	
        whiteQuitGameGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Text quitGameText = new Text("Thank you for playing Trans-form: The Awakening!\n\nThis game was made by Simon Bakan and Joshua Persaud (with a special thanks to Valentina Krasteva).\n\n");
        quitGameText.setFont(this.getPressStart2PFont(24));
        quitGameText.setFill(Paint.valueOf("rgb(0,0,0)"));
        quitGameText.setWrappingWidth(500);
        quitGameText.setX(50);
        quitGameText.setY(250);

        GameButton exitButton = new GameButton(this.pressStart2PFile, "Exit Game", 85, 495, 11);	
        exitButton.setWidth(125);	
        exitButton.setTextTranslationX(-1);	
        exitButton.setTextTranslationY(4);	
        	
        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            quitGameText,
            exitButton.getButton(),
            backButton.getButton(),
            whiteQuitGameGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
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

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }

                if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    exitButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    exitButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    System.exit(0);
                }
            }
        );


        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }
    
    /**
     * Public non-static method used to create the win game screen for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * win game screen for the game. They will also have a button that they can 
     * press to leave the game or to go back to main.
     * <p>
     * Done by: Simon
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the quit game screen.
     * @throws IOException
     */
    public Scene winGame(Stage stage) throws IOException {
        screenNum = 6;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteWinGameGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "You won!", 50, 90, 24);	
        whiteWinGameGameTitle.getSubheadingText().setFill(Paint.valueOf("Green"));
        whiteWinGameGameTitle.setWidth(300);	
        whiteWinGameGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Text quitGameText = new Text("Thank you for playing Trans-form: The Awakening!\n\nThis game was made by Simon Bakan and Joshua Persaud (with a special thanks to Valentina Krasteva).\n\n Your Score was "+score);
        quitGameText.setFont(this.getPressStart2PFont(24));
        quitGameText.setFill(Paint.valueOf("rgb(0,0,0)"));
        quitGameText.setWrappingWidth(500);
        quitGameText.setX(50);
        quitGameText.setY(250);

        GameButton exitButton = new GameButton(this.pressStart2PFile, "Exit Game", 85, 495, 11);	
        exitButton.setWidth(125);	
        exitButton.setTextTranslationX(-1);	
        exitButton.setTextTranslationY(4);	
        	
        GameButton backButton = new GameButton(this.pressStart2PFile, "Menu", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            quitGameText,
            exitButton.getButton(),
            backButton.getButton(),
            whiteWinGameGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
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

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }

                if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    exitButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    exitButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    System.exit(0);
                }
            }
        );


        scene.setFill(Color.DEEPSKYBLUE);

        return scene;
    }
    
    
    
    /**
     * Public non-static method used to create the lose game screen for the game.
     * <p>
     * This public non-static method is void and it will be used to create the
     * lose game screen for the game. They will also have a button that they can 
     * press to leave the game or to go back to main.
     * <p>
     * Done by: Simon
     * 
     * @param stage An instance of the Stage.java class, which will be the main
     *              stage that the program will use and display to the user.
     * @return  An instance of the Scene.java class, which will be the scene
     *          that will show the quit game screen.
     * @throws IOException
     */
    public Scene loseGame(Stage stage) throws IOException {
        screenNum = 6;

        ImageView introBorderImageView = this.getIntroBorderImageView();

        GameTitle whiteLoseGameGameTitle = new GameTitle(this.pressStart2PFile, "Trans-form:", "You lost :(", 50, 90, 24);	
        whiteLoseGameGameTitle.getSubheadingText().setFill(Paint.valueOf("Red"));
        whiteLoseGameGameTitle.setWidth(300);	
        whiteLoseGameGameTitle.setSpacing(15);

        ImageView logoImageView = new ImageView(new Image(logoFile.getPath()));
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setX(400);
        logoImageView.setY(50);
        logoImageView.setFitWidth(150);

        Text quitGameText = new Text("Thank you for playing Trans-form: The Awakening!\n\nThis game was made by Simon Bakan and Joshua Persaud (with a special thanks to Valentina Krasteva).\n\n");
        quitGameText.setFont(this.getPressStart2PFont(24));
        quitGameText.setFill(Paint.valueOf("rgb(0,0,0)"));
        quitGameText.setWrappingWidth(500);
        quitGameText.setX(50);
        quitGameText.setY(250);

        GameButton exitButton = new GameButton(this.pressStart2PFile, "Exit Game", 85, 495, 11);	
        exitButton.setWidth(125);	
        exitButton.setTextTranslationX(-1);	
        exitButton.setTextTranslationY(4);	
        	
        GameButton backButton = new GameButton(this.pressStart2PFile, "Menu", 390, 495, 18);	
        backButton.setWidth(125);	
        backButton.setTextTranslationX(1);

        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            quitGameText,
            exitButton.getButton(),
            backButton.getButton(),
            whiteLoseGameGameTitle.getTitle(),
            //whiteInstructionsTitleImageView,
            logoImageView,
            introBorderImageView
        );

        Scene scene = new Scene(nodesToAdd, 600, 600);

        scene.addEventFilter(MouseEvent.MOUSE_MOVED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                //System.out.println(xVal + " " + yVal);
                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
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

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }

                if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    exitButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    exitButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }
            }
        );

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
            e -> {

                final double xVal = e.getX();
                final double yVal = e.getY();

                if (xVal >= backButton.getLeftX() && xVal <= backButton.getRightX() && yVal >= backButton.getTopY() && yVal <= backButton.getBottomY()) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                } else if (xVal >= exitButton.getLeftX() && xVal <= exitButton.getRightX() && yVal >= exitButton.getTopY() && yVal <= exitButton.getBottomY()) {
                    System.exit(0);
                }
            }
        );


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
        this.enemyHealth=100;
        this.initializeStageSettings(stage);
        this.introAnimationScene = this.introAnimation(stage);
        this.mainMenuScene = this.mainMenu(stage);
        this.instructionsScene = this.instructions(stage);
        this.leaderboardScene = this.leaderboard(stage);
        this.level1Scene = this.level1(stage);
        this.level2Scene = this.level2(stage);
        this.level3Scene = this.level3(stage);
        this.confrontationTextScene1 = this.confrontation1Text(stage);
        this.confrontationTextScene5 = this.confrontation5Text(stage);
        this.confrontationBattleScene1 = this.confrontationBattle(stage,1);
        this.confrontationBattleScene5 = this.confrontationBattle(stage,5);
        this.quitGameScene = this.quitGame(stage);
        this.loseScene = this.loseGame(stage);
        
        this.screenNum = 0;
        this.confrontations = 0;
        stage.setScene(this.introAnimationScene);

        /*
        //GameButton test = new GameButton("New Game", pressStart2PFile, 24, "white", "black", 50, 50, 210, 75, 0, 0);
        //GameTitle test = new GameTitle(pressStart2PFile, "Trans-form:", 24, "black", "Instructions", 24, "blue", 100, 50, 10, 0, 2);
        //Rectangle rect = new Rectangle(50, 50, 1, 1);
        Group nodesToAdd = new Group();
        nodesToAdd.getChildren().addAll(
            //test.getButton()
            //rect
            test.getTitle()
        );
        Scene scene = new Scene(nodesToAdd, 600, 600);
        //scene.setFill(Color.BLACK);
        stage.setScene(scene);
        */
        
        /*
        ImageView mainChar = new ImageView(new Image(new FileInputStream(new File("MainChar.png"))));
        ImageView mainCharV2 = new ImageView(new Image(new FileInputStream(new File("MainChar.png"))));
        mainCharV2.setScaleY(-1.0);
        ImageView background = new ImageView(new Image(new FileInputStream(new File("Background.png"))));
        GameButton test1 = new GameButton("Test", this.pressStart2PFile, 24, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test2 = new GameButton("Test", this.pressStart2PFile, 24, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test3 = new GameButton("Test", this.pressStart2PFile, 24, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test4 = new GameButton("Test", this.pressStart2PFile, 24, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        
        ConfrontationScene cs = new ConfrontationScene(this.pressStart2PFile, background, mainChar, mainCharV2, test1, test2, test3, test4, new Rectangle(500, 200, Paint.valueOf("grey")), "red", "blue", false, 0.0, 0.0);
        // Paint closeEllipsePaint, Paint farEllipsePaint, boolean setHealth, double healthChar1, double healthChar2
        */
        
        /*
        ImageView background = new ImageView(new Image(new FileInputStream(new File("Water.png"))));
        ImageView mainChar = new ImageView(new Image(new FileInputStream(new File("MainChar.png"))));
        ImageView mainCharV2 = new ImageView(new Image(new FileInputStream(new File("MainChar.png"))));
        mainCharV2.setScaleX(-1.0);
        Ellipse closeCharPlat = new Ellipse(5, 5);
        closeCharPlat.setFill(Paint.valueOf("red"));
        Ellipse farCharPlat = new Ellipse(5, 5);
        farCharPlat.setFill(Paint.valueOf("blue"));
        Rectangle rect = new Rectangle(5, 5, Paint.valueOf("blue"));
        rect.setStrokeWidth(3.0);
        rect.setStroke(Paint.valueOf("black"));
        GameButton test1 = new GameButton("Top Left Button", this.pressStart2PFile, 15, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test2 = new GameButton("Bottom Left Button", this.pressStart2PFile, 15, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test3 = new GameButton("Top Right Button", this.pressStart2PFile, 15, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        GameButton test4 = new GameButton("Bottom Right Button", this.pressStart2PFile, 15, "rgb(255,255,255)", "rgb(0,0,0)", "red", 0, 0, 125, 50, 1, 16);
        Rectangle char1HealthBarFront = new Rectangle(5, 5, Paint.valueOf("yellow"));
        char1HealthBarFront.setStrokeWidth(1.0);
        char1HealthBarFront.setStroke(Paint.valueOf("black"));
        Rectangle char1HealthBarBack = new Rectangle(5, 5, Paint.valueOf("black"));
        char1HealthBarBack.setStrokeWidth(1.0);
        char1HealthBarBack.setStroke(Paint.valueOf("black"));
        Rectangle char2HealthBarFront = new Rectangle(5, 5, Paint.valueOf("yellow"));
        char2HealthBarFront.setStrokeWidth(1.0);
        char2HealthBarFront.setStroke(Paint.valueOf("black"));
        Rectangle char2HealthBarBack = new Rectangle(5, 5, Paint.valueOf("black"));
        char2HealthBarBack.setStrokeWidth(1.0);
        char2HealthBarBack.setStroke(Paint.valueOf("black"));
        //mainCharV2.setTranslateX(0);
        //ImageView background = new ImageView(new Image(new FileInputStream(new File("RedBackgroundRectangle.svg"))));
        //ImageView background = new ImageView("https://upload.wikimedia.org/wikipedia/commons/e/e6/Red_rectangle.svg");
        ConfrontationScene cs = new ConfrontationScene(this.pressStart2PFile, background, closeCharPlat, farCharPlat, mainChar, mainCharV2, rect, test1, test2, test3, test4, 50, char1HealthBarFront, char1HealthBarBack, 50, char2HealthBarFront, char2HealthBarBack);
        
        Scene scene = cs.getScene();
        stage.setScene(scene);
        */
        
        
        GameButton backButton = new GameButton(this.pressStart2PFile, "Back", 0, 0, 17);
        
        BookScene firstBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "What is transphobia?", "Transphobia is caused by a person being harmful and negative towards a transgender person on the basis of them being transgender.\n\nThis issue can also be seen as systemic because of how people are not taught that gender is actually fluid and not as rigid as being only male or only female.", true, backButton, 11);
        BookScene secondBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "How do I come out to my parents/friends?", "Coming out as a trans person is never an easy task. Here are some things to know before coming out:\n\n- It should be done when you feel safe coming out and it is useful to think through how you are going to do it\n\n- People might need some time to process the information\n\n- The majority of people will be accepting of your outcoming", false, backButton, 4.25);
        BookScene thirdBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "What are common types of transphobia?", "Transphobia is very common in our everyday lives. Some examples are:\n\n- Using derogatory terms against trans people.\n\n- Excluding transgender people on the basis of their sexuality\n\n- Refusing to use proper pronouns", false, backButton, 12);
        BookScene fourthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "What are common types of transphobia?", "More examples of transphobia are:\n\n- Not using a trans person's preferred name\n\n- Bullying a trans person because they are transgender\n\n- Spreading misinformation about trans people (such as by saying that they are in a \"teenage phase\")", true, backButton, 11);
        BookScene fifthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "How do you combat transphobia?", "A proactive approach is needed to help combat the transphobia that is prevalent within our society.\n\nSome steps you can take are to:\n\n- Recognize and confront internal transphobia\n\n- Call out those who are not using someone's preferred pronouns or name", false, backButton, 9);
        BookScene sixthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "How do you combat transphobia?", "More steps that you can take are:\n\n- Ask people for their pronouns (you can also use generalized pronouns like they/them)\n\n- Avoid using slurs against trans people\n\n- Call out those that are making transphobic jokes or remarks", true, backButton, 11);
        BookScene seventhBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "Statistics on transgender people", "The topic of transgender people has been buzzing for some time now. It is important to know the facts about trans people to get a better understanding of why they are in such dire need.\n\nSome important statistics are:\n\n- 22% - 43% of transgender people have attempted suicide in their lives\n\n- 67% of transgender people have thought less about suicide after transitioning whereas 3% of transgender people have thought about suicide more.", true, backButton, 2.5);
        BookScene eighthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "Statistics on transgender people", "Here are some more stats on trans people:\n\n- 15 percent of transgender-related online posts are transphobic\n\n- Over one in four transgender people have lost a job due to bias in their workplace\n\n- One in five transgender people have been homeless at least once in their life\n\n- Over one in ten transgender people have been evicted from their homes as a result of being transgender", false, backButton, 3.5);
        BookScene ninthBookScene = new BookScene(this.pressStart2PFile, new ImageView(new Image(new FileInputStream("CryingWomanOnPhone.png"))), "What should I do if I am being bullied?", "If you are being bullied on the basis of being transgender, then you should talk to your friends about it (they will help support you in your outcoming)\n\nIf you are ever feeling suicidal, know that there are still people who love you. You should also call your local suicide hotline, such as 833-456-4566 for the Canada Suicide Prevention Service.", true, backButton, 7.5);
        
        books[0] = firstBookScene.getScene();
        books[1] = secondBookScene.getScene();
        books[2] = thirdBookScene.getScene();
        books[3] = fourthBookScene.getScene();
        books[4] = fifthBookScene.getScene();
        books[5] = sixthBookScene.getScene();
        books[6] = seventhBookScene.getScene();
        books[7] = eighthBookScene.getScene();
        books[8] = ninthBookScene.getScene();
        
        stage.show();
    }

    private ImageView getIntroBorderImageView() {
        ImageView introBorderImageView = new ImageView(new Image(introBorderFile.getPath()));
        introBorderImageView.setPreserveRatio(true);
        introBorderImageView.setSmooth(true);
        introBorderImageView.setX(0);
        introBorderImageView.setY(0);
        introBorderImageView.setFitWidth(600);
        return introBorderImageView;
    }

    private Font getPressStart2PFont(double fontSize) {
        Font fontFont = new Font(1); // It doesn't matter what size font I put, so I will default it to 1.
        try {
            FileInputStream fontFIS = new FileInputStream(this.pressStart2PFile);
            fontFont = Font.loadFont(fontFIS, fontSize);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return fontFont;
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
        Application.launch(args);
    } // End of the main() method
} // End of the MainApplication.java class