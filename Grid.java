/*
  Names: Simon Bakan and Joshua Persaud
  Teacher: Ms. Krasteva
  Date: May 20, 2022
  Course: ICS4U0/P
  
  Purpose: to build manipulate and draw a screen with tiles that the player can move around in.
  Worked on by: Fully Simon
*/

import javafx.stage.Stage; // Imports the Stage.java class, which allows the program to have access to a stage to display the graphics within.
import javafx.scene.layout.GridPane; // Imports the GridPane.java class, which allows the program to have access to a grid layout to organize Nodes and other graphics within.
import javafx.scene.layout.VBox; // Imports the VBox.java class, which allows the program to have access to the vertical box layout to organize Nodes and other graphics.
import javafx.scene.layout.StackPane; // Imports the StackPane.java class, which allows the program to have access to the stack layout to organize Nodes and other graphics within (it can now stack the panes).
import javafx.scene.Scene; // Imports the Scene.java class, which allows the program to have access to a scene on which the GUI can be added onto and displayed to the user.
import javafx.scene.Group; // Imports the Group.java class, which allows the program to have access to the group layout to organize Nodes and other graphics within (it can group various nodes together).
import javafx.scene.image.Image; // Imports the Image.java class, which allows the program to create images from various files that are on the user's computer.
import javafx.scene.image.ImageView; // Imports the ImageView.java class, which allows the program to create images that can act as nodes and can be added onto the scenes (and displayed to the user).
import java.io.File; // Imports the File.java class, which allows the program to access files that are on the user's computer.

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
 * Filename: Grid.java
 *
 * @author Simon Bakan
 * @version 5/20/2022
 * 
 * @see javafx.stage.Stage
 * @see javafx.scene.layout.GridPane
 * @see javafx.scene.layout.VBox
 * @see javafx.scene.layout.StackPane
 * @see javafx.scene.Scene
 * @see javafx.scene.Group
 * @see javafx.scene.image.Image
 * @see javafx.scene.image.ImageView
 * @see java.io.File
 *
 * @since JDK1.17
 */

public class Grid {

    /** This private non-static 2D Tile array will hold all the tiles in the grid. */
    private Tile[][] tiles;

    /** This private non-static int will hold the x coordinate of the player. */
    private int mainX;

    /** This private non-static int will hold the y coordinate of the player. */
    private int mainY;

    /**
     * An instance of the Tile class will be created using this constructor with
     * parameters for the x and y coordinate.
     * 
     * @param x An integer, which is x coordinate of the player.
     * @param y An integer, which is y coordinate of the player.
     */
    public Grid(int x, int y) {
        tiles = new Tile[20][20];
        this.mainX = x;
        this.mainY = y;
    }

    /**
     * Public non-static return method used instantiate tiles.
     * <p>
     * This private non-static method will be used instantiate tiles in
     * the grid with specific attributes.
     *
     * @param x An int with the x coordinate of the tile.
     * @param y An int with the y coordinate of the tile.
     * @param file A String with the pathway for the image for the tile.
     * @param object A String with the pathway for the image for the object
     *               that is on the tile.
     * @param movable A boolean with the attribute of whether the player will
     *                be able to move onto this tile.
     * @param movable A boolean with the attribute of whether the player will
     *                be able to interact with this tile.
     */
    public void assign(int y, int x, String file, String object, boolean movable, boolean interactable) {
        tiles[y][x] = new Tile(file, object, movable, interactable);
    }

    /**
     * Public non-static return method used to move the player left.
     * <p>
     * This private non-static return method will be used to check if the player
     * can move left and then move them left if they can.
     *
     * @return A boolean that will say whether the player has walked off of the screen.
     */
    public int moveLeft() {
        if (mainX == 0) {
            return mainY;
        }
        if (tiles[mainY][mainX - 1].canMove()) {
            mainX -= 1;
        }
        return -1;
    }

    /**
     * Public non-static return method used to move the player right.
     * <p>
     * This private non-static return method will be used to check if the player
     * can move left and then move them right if they can.
     *
     * @return A boolean that will say whether the player has walked off of the screen.
     */
    public int moveRight() {
        if (mainX == tiles[0].length-1) {
            return mainY;
        }
        if (tiles[mainY][mainX + 1].canMove()) {
            mainX += 1;
        }
        return -1;
    }

    /**
     * Public non-static return method used to move the player up.
     * <p>
     * This private non-static return method will be used to check if the player
     * can move left and then move them up if they can.
     *
     * @return A boolean that will say whether the player has walked off of the screen.
     */
    public int moveUp() {
        if (mainY == 0) {
            return mainX;
        }
        if (tiles[mainY - 1][mainX].canMove()) {
            mainY -= 1;
        }
        return -1;
    }

    /**
     * Public non-static return method used to move the player down.
     * <p>
     * This private non-static return method will be used to check if the player
     * can move left and then move them down if they can.
     *
     * @return A boolean that will say whether the player has walked off of the screen.
     */
    public int moveDown() {
        if (mainY == tiles.length-1) {
            return mainX;
        }
        if (tiles[mainY + 1][mainX].canMove()) {
            mainY += 1;
        }
        return -1;
    }

    /**
     * Public non-static method used to draw the grid on the passed scene.
     * <p>
     * This private non-static method will be used draw a grid of tiles and
     * then their given objects followed by an image for the playeron a scene
     * and set the stage to be that scene.
     *
     * @param st The Stage that the grid will be drawn on.
     */
    public Group draw() {
        GridPane screen = new GridPane();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[0].length; col++) {
                try {
                    ImageView imageView = new ImageView();
                    File file = new File(tiles[row][col].getFile());
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView.setFitWidth(30);
                    imageView.setFitHeight(30);
                    VBox vb = new VBox();
                    vb.getChildren().add(imageView);
                    screen.add(vb, col, row);
                } catch (Exception e) {}
            }
        }
        GridPane objects = new GridPane();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[0].length; col++) {
                try {
                    ImageView imageView = new ImageView();
                    File file = new File(tiles[row][col].getObject());
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView.setFitWidth(30);
                    imageView.setFitHeight(30);
                    objects.add(imageView, col, row);
                } catch (Exception e) {}
            }
        }
        /*ImageView mainChar = new ImageView();
        try {
            File file = new File("\\Simon Bakan Joshua Persaud Final ISP Draft 1\\mainChar.png");
            Image image = new Image(file.toURI().toString());
            mainChar.setImage(image);
            mainChar.setX(30 * mainX);
            mainChar.setY(30 * mainY);
        } catch (Exception e) {}
        */
        Group g = new Group();
        g.getChildren().add(screen);
        g.getChildren().add(objects);
        return g;
    }

    /**
     * Public non-static method used change interactable for tiles.
     * <p>
     * This private non-static method will be make the boolean interactable
     * true for the all tiles with a certain object on them.
     *
     * @param obj A String with the object the program is looking for to make
     *           tiles interactable.
     */
     
    public String interact() {
        if(tiles[mainY-1][mainX].isInteractable()){
            return tiles[mainY-1][mainX].getFile();
        }else if(tiles[mainY+1][mainX].isInteractable()){
            return tiles[mainY+1][mainX].getFile();
        }else if(tiles[mainY][mainX-1].isInteractable()){
            return tiles[mainY][mainX-1].getFile();
        }else if(tiles[mainY][mainX+1].isInteractable()){
            return tiles[mainY][mainX+1].getFile();
        }else{
            return "";
        }
    }
    
    public void setX(int x){
        this.mainX = x;
    }
    public void setY(int y){
        this.mainY = y;
    }
    public int getX(){
        return mainX;
    }
    public int getY(){
        return mainY;
    }
    public void setObject(int y, int x, String object) {
        tiles[y][x].setObject(object);
    }
    public void setInteractable(int y, int x, boolean interactable) {
        tiles[y][x].setInteractable(interactable);
    }
    public void setMovable(int y, int x, boolean movable) {
        tiles[y][x].setMovable(movable);
    }


} // End of the Grid.java class