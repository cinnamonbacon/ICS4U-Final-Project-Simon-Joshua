import javafx.application.*;
import javafx.animation.*;
import javafx.css.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.media.*;
import javafx.stage.*;

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import java.awt.*;

public class MainApplication extends Application {
    
    public void start (Stage primaryStage) {
        try {
            primaryStage.setTitle("Testing the title");
            
            Grid grid = new Grid(2,3);
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    grid.assign(i, j, "\\Simon Bakan Joshua Persaud Final ISP Draft 1\\Sprites\\Grass.png", "\\Simon Bakan Joshua Persaud Final ISP Draft 1\\Sprites\\AdditionalGrass.png", false, false);
                }
            }
            grid.draw(primaryStage);
            
            //primaryStage.setStage(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	public static void main(String[] args) {
		Application.launch(args);
	}
}
