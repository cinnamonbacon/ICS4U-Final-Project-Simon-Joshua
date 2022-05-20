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