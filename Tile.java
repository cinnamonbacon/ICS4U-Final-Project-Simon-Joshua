/*
  Names: Simon Bakan and Joshua Persaud
  Teacher: Ms. Krasteva
  Date: May 20, 2022
  Course: ICS4U0/P
  Purpose: To act as a variable type for a tile in the graphics of the game.
  Worked on by: Fully Simon
*/

public class Tile{
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
     */
   public Tile(String file, String object, boolean movable, boolean interactable){
      this.file=file;
      this.object=object;
      this.movable=movable;
      this.interactable=interactable;
      
   }
   
   /**
     * Public non-static return method used get the value of movable.
     * <p>
     * This private non-static return method will be used as an accesor method
     * for the movable attribute of the tile.
     *
     * @return  A boolean that will be the status of the movable boolean.
     */
   public boolean canMove(){
      return movable;
   }
   
   /**
     * Public non-static return method used get the value of interactable.
     * <p>
     * This private non-static return method will be used as an accessor method 
     * for the interactable attribute of the tile.
     *
     * @return  A boolean that will be the status of the interactable boolean.
     */
   public boolean isInteractable(){
      return interactable;
   }
   
   /**
     * Public non-static method used change the value of interactable.
     * <p>
     * This private non-static method to act as a accessor method allowing other 
     * classes to make a tile interactable.
     */
   public void makeInteractable(){
      interactable=true;
   }
   
   /**
     * Public non-static return method used get the value of file.
     * <p>
     * This private non-static return method will be used as an accessor method 
     * for the file attribute of the tile which has the pathway for the image.
     *
     * @return  A String that will be the pathway for the image for the tile.
     */
   public String getFile(){
      return file;
   }
   
   /**
     * Public non-static return method used get the value of object.
     * <p>
     * This private non-static return method will be used as an accessor method 
     * for the object attribute of the tile which has the pathway for the image
     * for the object on the tile.
     *
     * @return  A String that will be the pathway for the image for the object
     * on the tile.
     */
   public String getObject(){
      return object;
   }
}