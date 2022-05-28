/*
  Names: Simon Bakan and Joshua Persaud
  Teacher: Ms. Krasteva
  Date: May 20, 2022
  Course: ICS4U0/P
  Purpose: to act as a variable type for a tile in the graphics of the game.
  Worked on by: Fully Simon
  Eddited May 23-27
*/

/**
 * Create a Tile datatype that will represent the tiles in the game's graphics.
 * <p>
 * This class will be used to create tiles that will be on the
 * grid of the game. Each tile will have a certain image on it,
 * to represent the different textures (grass, sand, water, etc).
 * It may also have a object on it that the user can interact
 * with (such as a book or a person).
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: to act as a variable type for a tile in the graphics
 * of the game.
 * <p>
 * Filename: Tile.java
 *
 * @author Simon Bakan
 * @version 5/20/2022
 *
 * @since JDK1.17
 */
public class Tile {
    /** This private non-static String will hold the pathway of the image file for the tile. */
    private String file;

    /** This private non-static String will hold the pathway of the image file for the object. */
    private String object;

    /** This private non-static boolean will hold whether the player can move to the tile. */
    private boolean movable;

    /** This private non-static boolean will hold whether there is something to interact with on the tile. */
    private boolean interactable;

    /**
     * An instance of the Tile class will be created using this constructor.
     * 
     * @param file A String, which will be path to the tile's design.
     * @param object A String, which will be the path to the object
     *               that is on the tile's design.
     * @param movable A boolean, which is whether or not the player
     *                can move to this tile.
     * @param interactable A boolean, which is whether or not the
     *                     player can interact with this tile.
     */
    public Tile(String file, String object, boolean movable, boolean interactable) {
        this.file = file;
        this.object = object;
        this.movable = movable;
        this.interactable = interactable;

    }

    /**
     * Private non-static return method used get the value of movable.
     * <p>
     * This private non-static return method will be used as an accesor method
     * for the movable attribute of the tile.
     *
     * @return  A boolean, which is the status of the movable boolean.
     */
    public boolean canMove() {
        return movable;
    }

    /**
     * Private non-static return method used get the value of interactable.
     * <p>
     * This private non-static return method will be used as an accessor method 
     * for the interactable attribute of the tile.
     *
     * @return  A boolean, which is the status of the interactable boolean.
     */
    public boolean isInteractable() {
        return interactable;
    }
    
    /**
     * Private non-static return method used get the value of file.
     * <p>
     * This private non-static return method will be used as an accessor method 
     * for the file attribute of the tile which has the pathway for the image.
     *
     * @return  A String, which is the pathway for the image for the tile.
     */
    public String getFile() {
        return file;
    }

    /**
     * Private non-static return method used get the value of object.
     * <p>
     * This private non-static return method will be used as an accessor method 
     * for the object attribute of the tile which has the pathway for the image
     * for the object on the tile.
     *
     * @return  A String, which is the pathway for the image for the object
     * on the tile.
     */
    public String getObject() {
        return object;
    }
    
    /**
     * Private non-static method used change the value of interactable.
     * <p>
     * This private non-static method to act as a accessor method allowing other 
     * classes to make a tile interactable or not.
     *
     * @param interactable A boolean to change the interactable variable to.
     */
    public void setInteractable(boolean interactable) {
        // Simon Bakan May 23-27 changed from just making the tile interactable to setting it
        this.interactable = interactable;
    }

    
    // Everything after is added by Simon Bakan from May 23-27 taking half an hour.
    
    /**
     * Private non-static method used change the value of object.
     * <p>
     * This private non-static method to act as a accessor method allowing other 
     * classes to change the object string of the tile.
     *
     * @param object A String to change the object variable to. This will be
     *        the path of a file.
     */
    public void setObject(String object) {
        this.object=object;
    }
    
    /**
     * Private non-static method used change the value of movable.
     * <p>
     * This private non-static method to act as a accessor method allowing other 
     * classes to make a tile movablee or not.
     *
     * @param movable A boolean to change the movable variable to.
     */
    public void setMovable(boolean movable) {
        this.movable=movable;
    }

} // End of the Tile.java class