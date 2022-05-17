import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import java.util.*;
import java.io.*;
import java.awt.image.*;
import javafx.scene.image.*;
public class Grid{
    private Tile[][] tiles;
    private int mainX;
    private int mainY;
    public Grid(int x, int y){
        tiles = new Tile[20][20];
        this.mainX=x;
        this.mainY=y;
    }
    public void assign(int x, int y, String file, String object, boolean movable, boolean interactable){
        tiles[y][x] = new Tile(file,object,movable,interactable);
    }
    public boolean moveLeft(){
        if(mainX==0){
            return true;
        }
        if(tiles[mainY][mainX-1].canMove()){
            mainX-=1;
        }
        return false;
    }
    public boolean moveRight(){
        if(mainX==tiles[0].length){
            return true;
        }
        if(tiles[mainY][mainX+1].canMove()){
            mainX+=1;
        }
        return false;
    }
    public boolean moveUp(){
        if(mainY==0){
            return true;
        }
        if(tiles[mainY-1][mainX].canMove()){
            mainY-=1;
        }
        return false;
    }
    public boolean moveDown(){
        if(mainY==tiles.length){
            return true;
        }
        if(tiles[mainY+1][mainX].canMove()){
            mainY+=1;
        }
        return false;
    }
    public void draw(Stage st){
        HBox[] roots =  new HBox[tiles[0].length];
        
        for(int row=0;row<tiles.length;row++){
            for(int col=0;col<tiles[0].length;col++){
                //String path = "E:\\Simon Bakan Joshua Persaud Final ISP Draft 1\\Sprites"+"\\"+tiles[row][col].getFile();
                ImageView imageView = new ImageView();
                Image image = new Image(getClass().getResource(tiles[row][col].getFile()).toExternalForm());
                imageView.setImage(image);
                roots[row].getChildren().add(imageView);
            }
        }
        VBox output =  new VBox();
        for(HBox hb : roots){
            output.getChildren().add(hb);
        }
        Scene scene = new Scene(output,600,600);
        st.setScene(scene);
    }
    public void makeInteractable(String st){
        for(int row=0;row<tiles.length;row++){
            for(int col=0;col<tiles[0].length;col++){
                if (tiles[row][col].getObject().equals(st)){
                    tiles[row][col].makeInteractable();
                }
            }
        }
    }
}