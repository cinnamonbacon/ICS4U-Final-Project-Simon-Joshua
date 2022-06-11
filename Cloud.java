import javafx.scene.shape.Shape; //. Imports the Shape.java class, which allows the program to create a generic shape that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.shape.Circle; // Imports the Circle.java class, which allows the program to create a circle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.shape.Rectangle; // Imports the Rectangle.java class, which allows the program to create a rectangle that will be shown to the user (by being added as a node to the current scene).
import javafx.scene.paint.Paint; // Imports the Paint.java class, which allows the program to create specific paint colours for various parts of the GUI.
import javafx.scene.transform.Translate; // Imports the Translate.java class, which allows the program to translate the cloud shape.
import javafx.scene.transform.Scale; // Imports the Scale.java class, which allows the program to scale the cloud to the specified shape.

/**
 * Helper class that will create cloud shapes.
 * <p>
 * This class will be used to create a cloud shape. It
 * will do so by using various shape classes that are
 * found under the javafx.scene.shape package.
 * 
 * This was made fully by Joshua Persaud.
 * <p>
 * Course: ICS 4U0/P
 * <p>
 * Teacher Name: Ms. Krasteva
 * <p>
 * Purpose: a helper class to create cloud shapes.
 * <p>
 * Filename: Cloud.java
 *
 * @author Joshua Persaud
 * @version 6/10/2022
 * 
 * @see javafx.scene.shape.Shape
 * @see javafx.scene.shape.Circle
 * @see javafx.scene.shape.Rectangle
 * @see javafx.scene.paint.Paint
 * @see javafx.scene.transform.Translate
 * @see javafx.scene.transform.Scale
 *
 * @since JDK1.17
 */

public class Cloud extends Shape {

    /** Private non-static double variable used to hold the x-coordinate of the cloud. */
    private double xVal;
    
    /** Private non-static double variable used to hold the y-coordinate of the cloud. */
    private double yVal;
    
    /** Private non-static double variable used to hold the amount of scaling for the created cloud shape. */
    private double scale;
    
    /** Private non-static class reference variable for the Paint.java class. It will hold onto the colour that will fill up the inside of the cloud. */
    private Paint colour;
    
   /**
    * No parameter constructor for the Cloud.java class.
    */
    public Cloud () {
        this(0.0, 0.0, 1.0, Paint.valueOf("rgb(255, 255, 255)"));
    }
    
   /**
    * Two parameter constructor for the Cloud.java class. It will take in the x- and y-coordinates of the cloud shape.
    * 
    * @param centerX A double, which is the x-coordinate for the center of the cloud.
    * @param centerY A double, which is the y-coordinate for the center of the cloud.
    */
    public Cloud (double centerX, double centerY) {
        this(centerX, centerY, 1.0, Paint.valueOf("rgb(255, 255, 255)"));
    }
    
   /**
    * Three parameter constructor for the Cloud.java class. It will take in the x- and y-coordinates of the cloud shape as well as the colour that should fill the inside of the cloud.
    * 
    * @param centerX A double, which is the x-coordinate for the center of the cloud.
    * @param centerY A double, which is the y-coordinate for the center of the cloud.
    * @param scale A double, which is the amount of scale for the cloud's size.
    */
    public Cloud (double centerX, double centerY, double scale) {
        this(centerX, centerY, scale, Paint.valueOf("rgb(255, 255, 255)"));
    }
    
   /**
    * Four parameter constructor for the Cloud.java class. It will take in the x- and y-coordinates of the cloud shape as well as the scale for the size of the cloud and the colour that should fill the inside of the cloud.
    * 
    * @param centerX A double, which is the x-coordinate for the center of the cloud.
    * @param centerY A double, which is the y-coordinate for the center of the cloud.
    * @param scale A double, which is the amount of scale for the cloud's size.
    * @param fill An instance of the Paint.java class, which is the colour that will fill the inside of the cloud.
    */
    public Cloud (double centerX, double centerY, double scale, Paint fill) {
        this.xVal = centerX;
        this.yVal = centerY;
        this.scale = scale;
        this.colour = fill;
    }
    
   /**
    * Public non-static method used to get the x-coordinate of the cloud.
    * <p>
    * This public non-static method will return a double, which will be the
    * x-coordinate of the cloud (the value that is stored in the global 
    * variable xVal).
    *
    * @return  A double, which is the x-coordinate of the cloud shape.
    */
    public double getX() {
        return this.xVal;
    }
    
   /**
    * Public non-static method used to set the x-coordinate of the cloud.
    * <p>
    * This public non-static method will take in a double as a parameter,
    * and this double will be the new x-coordinate of the cloud shape.
    *
    * @param newXValue A double, which is the new x-coordinate of the cloud.
    */
    public void setX(double newXValue) {
        this.xVal = newXValue;
    }
    
   /**
    * Public non-static method used to get the y-coordinate of the cloud.
    * <p>
    * This public non-static method will return a double, which will be the
    * y-coordinate of the cloud (the value that is stored in the global 
    * variable xVal).
    *
    * @return  A double, which is the y-coordinate of the cloud shape.
    */
    public double getY() {
        return this.yVal;
    }
    
   /**
    * Public non-static method used to set the y-coordinate of the cloud.
    * <p>
    * This public non-static method will take in a double as a parameter,
    * and this double will be the new y-coordinate of the cloud shape.
    *
    * @param newYValue A double, which is the new y-coordinate of the cloud.
    */
    public void setY(double newYValue) {
        this.yVal = newYValue;
    }
    
    /**
    * Public non-static method used to get the scale of the cloud.
    * <p>
    * This public non-static method will be used to return the scale
    * factor that is used on the cloud.
    *
    * @return  A double, which is the scale factor of the cloud.
    */
    public double getScale() {
        return this.scale;
    }
    
    /**
    * Public non-static method used to set the scale of the cloud.
    * <p>
    * This public non-static method will be used to take in a double,
    * which will be the new scale factor for the cloud instance.
    *
    * @param newScale A double, which is the new scale factor of the cloud.
    */
    public void setScale(double newScale) {
        this.scale = newScale;
    }
    
    /**
    * Public non-static method used to get the fill colour of the cloud.
    * <p>
    * This public non-static method will be used to return an instance of
    * the Paint.java class, which is the colour that fills the cloud.
    *
    * @return  An instance of the Paint.java class, which is the colour
    *          of the inside of the cloud.
    */
    public Paint getCloudFill() {
        return this.colour;
    }
    
    /**
    * Public non-static method used to set the fill colour of the cloud.
    * <p>
    * This public non-static method will take in an instance of the Paint.java
    * class, and this will be the colour that fills the inside of the cloud.
    *
    * @param newColour  An instance of the Paint.java class, which is the new
    *                   colour of the inside of the cloud.
    */
    public void setCloudFill(Paint newColour) {
        this.colour = newColour;
    }
    
   /**
    * Public non-static method used to get the actual cloud shape.
    * <p>
    * This public non-static method will return a Shape.java object,
    * and this will be the actual cloud shape.
    *
    * @return  An instance of the Shape.java class, which is the
    *          cloud shape.
    */
    public Shape getShape() {
        Shape returnedShape;
        
        Circle leftSideCircle = new Circle(-50.0, 0.0, 35.0);
        Circle middleCircle = new Circle(0.0, -25.0, 50.0);
        Circle rightSideCircle = new Circle(50.0, 0.0, 35.0);
        Rectangle bottomRectangle = new Rectangle(-50.0, 0.0, 100.0, 35.0);
        returnedShape = Shape.union(Shape.union(Shape.union(leftSideCircle, middleCircle), rightSideCircle), bottomRectangle); // This line of code just takes all of the shapes and adds each one of them together
        returnedShape.setFill(this.colour);
        returnedShape.getTransforms().add(new Translate(this.xVal, this.yVal));
        returnedShape.getTransforms().add(new Scale(this.scale, this.scale));
        return returnedShape;
    }
}