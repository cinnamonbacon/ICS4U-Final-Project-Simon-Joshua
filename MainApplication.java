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
import java.io.FileInputStream;

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

    /** This private non-static integer will hold the number of the screen that is currently being rendered. */
    private int screenNum; // Check to see if this variable is useful or not.

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
    
    /** This private non-static File[] variable will be used to hold onto the books that are being used in the game (one element for each book). */
    private File[] books;
    
    /** This private non-static boolean variable will be used to hold onto whether or not the game is showing a book or not. */
    private boolean showingBook;
    
    /** This private non-static integer variable will be used to keep track of the number of books the player has found. */
    private int bookNum;
    
    /** This private non-static File variable will hold onto the location of the Press Start 2P file. */
    private File pressStart2PFile;
    
    private Scene leaderboardScene;
    
    private Scene quitGameScene;

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

        this.books = new File[8];
        this.pressStart2PFile = new File("PressStart2P-Regular.ttf");
        this.books[0] = new File("Book1.png");        
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
            whiteTitleImageView,
            redRectangleAroundNewGameButton,
            newGameButtonImageView,
            redRectangleAroundInstructionsButton,
            instructionsButtonImageView,
            redRectangleAroundLeaderboardButton,
            leaderboardButtonImageView,
            redRectangleAroundQuitGameButton,
            quitGameButtonImageView,
            copyrightStatementImageView,
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
                }else if (xVal >= 20 && xVal <= 198 && yVal >= 280 && yVal <= 336) {
                    screenNum = 3;
                    stage.setScene(this.instructionsScene);
                    stage.show();
                } else if (xVal >= 20 && xVal <= 198 && yVal >= 355 && yVal <= 411) {
                    screenNum = 4;
                } else if (xVal >= 20 && xVal <= 148 && yVal >= 455 && yVal <= 501) {
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
     * This public non-static method is void and it will be used to create the
     * first level of the program. It will do this by creating 4 instances of the
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
        Grid[] grid = {new Grid(15, 15),new Grid(15, 15),new Grid(15, 15),new Grid(15, 15)};
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
        grid[3].setObject(3,12,bookTileFile.getPath());
        grid[3].setInteractable(3,12,true);
        grid[3].setMovable(3,12,false);
        grid[3].setObject(10,10,bookTileFile.getPath());
        grid[3].setInteractable(10,10,true);
        grid[3].setMovable(10,10,false);
        
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
        bookNum = 0;
        Label bookLabel = new Label(bookNum+"/"+books.length+" books found");
        
        bookLabel.setFont(this.getPressStart2PFont(20));
        bookLabel.setStyle("-fx-background-color: rgba(255,255,255,0); -fx-text-fill: rgb(0,0,0); -fx-font-size: 20px;"); //  -fx-font-family: 'Press Start 2P', cursive;
        bookLabel.setTranslateX(450);
        bookLabel.setTranslateY(12);
        
        Group view=new Group();
        view.getChildren().add(gr[gridNum]);
        view.getChildren().add(mainChar);
        view.getChildren().add(bookLabel);
        scene = new Scene(view);
        
        // Runs on a key press.
        try {
            scene.addEventFilter(KeyEvent.KEY_PRESSED,
                k -> {
                    try {
                        if(k.getCode() == KeyCode.SPACE){
                            Tile interaction = grid[gridNum].interact();
                            if(showingBook){
                                showingBook = false;
                                gr[gridNum]=grid[gridNum].draw();
                            }else if(interaction.getObject().equals(bookTileFile.getPath())){
                                showingBook = true;
                                interaction.setObject(additionalGrassTileFile.getPath());
                                interaction.setMovable(true);
                                interaction.setInteractable(false);
                                ImageView bookScene = new ImageView();
                                Image image = new Image(books[0].toURI().toString());
                                bookScene.setImage(image);
                                Group bk = new Group();
                                bk.getChildren().add(bookScene);
                                scene.setRoot(bk);
                                bookNum++;
                            }
                        }
                        if(!showingBook){
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
                            }else if (k.getCode() == KeyCode.D) {
                                final int OFF = grid[gridNum].moveRight();
                                if(OFF!=-1){
                                    gridNum+=1;
                                    grid[gridNum].setX(0);
                                    grid[gridNum].setY(OFF);
                                }
                            }
                            File file = new File("\\Simon Bakan Joshua Persaud Final ISP Draft 1\\mainChar.png");
                            Image image = new Image(file.toURI().toString());
                            mainChar.setImage(image);
                            mainChar.setX(30 * grid[gridNum].getX());
                            mainChar.setY(30 * grid[gridNum].getY());
                            view.getChildren().clear();
                            view.getChildren().add(gr[gridNum]);
                            view.getChildren().add(mainChar);
                            bookLabel.setText(bookNum+"/"+books.length+" books found");
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

        GameTitle whiteInstructionsGameTitle = new GameTitle(pressStart2PFile, "white", "Instructions", "red", 15, 50, 90, 300);
        /*
        ImageView whiteInstructionsTitleImageView = new ImageView(new Image(whiteInstructionsTitleFile.getPath()));
        whiteInstructionsTitleImageView.setPreserveRatio(true);
        whiteInstructionsTitleImageView.setSmooth(true);
        whiteInstructionsTitleImageView.setX(50);
        whiteInstructionsTitleImageView.setY(85);
        whiteInstructionsTitleImageView.setFitWidth(300);
        */

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
        
        GameButton backButton = new GameButton("Back", this.pressStart2PFile, 18, "white", "black", 390, 495, 125, 50, 0, 0);

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

                if (xVal >= 390 && xVal <= 515 && yVal >= 495 && yVal <= 545) {
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

                if (xVal >= 390 && xVal <= 515 && yVal >= 495 && yVal <= 545) {
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

                if (xVal >= 390 && xVal <= 515 && yVal >= 495 && yVal <= 545) {
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
        
        
        
        return new Scene(new Group());
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

        GameTitle whiteQuitGameGameTitle = new GameTitle(pressStart2PFile, "white", "Quit Game", "red", 15, 50, 90, 300);

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
        
        GameButton exitButton = new GameButton("Exit Game", this.pressStart2PFile, 12, "white", "black", 390, 495, 125, 50, 0, 0);
        GameButton backButton = new GameButton("Back", this.pressStart2PFile, 18, "white", "black", 85, 495, 125, 50, 0, 0);

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
                if (xVal >= 85 && xVal <= 210 && yVal >= 495 && yVal <= 545) {
                    scene.setCursor(Cursor.HAND);
                } else if (xVal >= 390 && xVal <= 515 && yVal >= 495 && yVal <= 545) {
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
                
                if (xVal >= 85 && xVal <= 210 && yVal >= 495 && yVal <= 545) {
                    backButton.cursorOverButton();
                    //backButton.getRedRectangle().setVisible(true);
                    //redRectangleAroundBackButton.setVisible(true);
                } else {
                    backButton.cursorNotOverButton();
                    //backButton.getRedRectangle().setVisible(false);
                    //redRectangleAroundBackButton.setVisible(false);
                }

                if (xVal >= 390 && xVal <= 515 && yVal >= 495 && yVal <= 545) {
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
                
                if (xVal >= 85 && xVal <= 210 && yVal >= 495 && yVal <= 545) {
                    screenNum = 1;
                    stage.setScene(this.mainMenuScene);
                    stage.show();
                } else if (xVal >= 390 && xVal <= 515 && yVal >= 495 && yVal <= 545) {
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
        this.initializeStageSettings(stage);
        this.introAnimationScene = this.introAnimation(stage);
        this.mainMenuScene = this.mainMenu(stage);
        this.instructionsScene = this.instructions(stage);
        this.leaderboardScene = this.leaderboard(stage);
        this.level1Scene = this.level1(stage);
        this.quitGameScene = this.quitGame(stage);
        
        this.screenNum = 0;
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
    
    private Font getPressStart2PFont(int fontSize) {
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