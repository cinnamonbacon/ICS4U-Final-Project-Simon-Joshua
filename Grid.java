/*
  Names: Simon Bakan and Joshua Persaud
  Teacher: Ms. Krasteva
  Date: May 20, 2022
  Course: ICS4U0/P
  Purpose: To build manipulate and draw a screen with tiles that the player can move around in.
  Worked on by: Fully Simon
*/

import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.Group;
import java.util.*;
import java.io.*;
import java.awt.image.*;
import javafx.scene.image.*;
import javax.imageio.*;
import javafx.embed.swing.*;

public class Grid{

   /** This private non-static 2D Tile array will hold all the tiles in the grid. */
   private Tile[][] tiles;
   
   /** This private non-static int will hold the x coordinate of the player. */
   private int mainX;
   
   /** This private non-static int will hold the y coordinate of the player. */
   private int mainY;
   
   /**
     * An instance of the Tile class will be created using this constructor with
     * parameters for the x and y coordinate.
     */
   public Grid(int x, int y){
      tiles = new Tile[20][20];
      this.mainX=x;
      this.mainY=y;
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
   public void assign(int x, int y, String file, String object, boolean movable, boolean interactable){
      tiles[y][x] = new Tile(file,object,movable,interactable);
   }
   
   /**
     * Public non-static return method used to move the player left.
     * <p>
     * This private non-static return method will be used to check if the player
     * can move left and then move them left if they can.
     *
     * @return A boolean that will say whether the player has walked off of the screen.
     */
   public boolean moveLeft(){
      if(mainX==0){
         return true;
      }
      if(tiles[mainY][mainX-1].canMove()){
         mainX-=1;
      }
      return false;
   }
   
   /**
     * Public non-static return method used to move the player right.
     * <p>
     * This private non-static return method will be used to check if the player
     * can move left and then move them right if they can.
     *
     * @return A boolean that will say whether the player has walked off of the screen.
     */
   public boolean moveRight(){
      if(mainX==tiles[0].length){
         return true;
      }
      if(tiles[mainY][mainX+1].canMove()){
         mainX+=1;
      }
      return false;
   }
   
   /**
     * Public non-static return method used to move the player up.
     * <p>
     * This private non-static return method will be used to check if the player
     * can move left and then move them up if they can.
     *
     * @return A boolean that will say whether the player has walked off of the screen.
     */
   public boolean moveUp(){
      if(mainY==0){
         return true;
      }
      if(tiles[mainY-1][mainX].canMove()){
         mainY-=1;
      }
      return false;
   }
   
   /**
     * Public non-static return method used to move the player down.
     * <p>
     * This private non-static return method will be used to check if the player
     * can move left and then move them down if they can.
     *
     * @return A boolean that will say whether the player has walked off of the screen.
     */
   public boolean moveDown(){
      if(mainY==tiles.length){
         return true;
      }
      if(tiles[mainY+1][mainX].canMove()){
         mainY+=1;
      }
      return false;
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
   public void draw(Stage st){
      GridPane screen =  new GridPane();
      for(int row=0;row<tiles.length;row++){
         for(int col=0;col<tiles[0].length;col++){
            try{
               ImageView imageView = new ImageView();
               File file = new File(tiles[row][col].getFile());
               Image image = new Image(file.toURI().toString());
               imageView.setImage(image);
               imageView.setFitWidth(30);
               imageView.setFitHeight(30);
               VBox vb = new VBox();
               vb.getChildren().add(imageView);
               screen.add(vb,col,row);
            }catch(Exception e){}
         }
      }
      GridPane objects =  new GridPane();
      for(int row=0;row<tiles.length;row++){
         for(int col=0;col<tiles[0].length;col++){
            try{
               ImageView imageView = new ImageView();
               File file = new File(tiles[row][col].getObject());
               Image image = new Image(file.toURI().toString());
               imageView.setImage(image);
               imageView.setFitWidth(30);
               imageView.setFitHeight(30);
               objects.add(imageView,col,row);
            }catch(Exception e){}
         }
      }
      ImageView mainChar = new ImageView();
      try{
         File file = new File("\\Simon Bakan Joshua Persaud Final ISP Draft 1\\MainChar.png");
         Image image = new Image(file.toURI().toString());
         mainChar.setImage(image);
         mainChar.setX(30*mainX);
         mainChar.setY(30*mainY);
      }catch(Exception e){}
      StackPane stack =  new StackPane(screen,objects,mainChar);
      Group g = new Group();
      g.getChildren().add(stack);
      g.getChildren().add(mainChar);
      Scene scene = new Scene(g,600,600);
      st.setScene(scene);
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
   public void makeInteractable(String obj){
      for(int row=0;row<tiles.length;row++){
         for(int col=0;col<tiles[0].length;col++){
            if (tiles[row][col].getObject().equals(obj)){
               tiles[row][col].makeInteractable();
            }
         }
      }
   }
}