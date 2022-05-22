import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Translate;
import javafx.scene.transform.Scale;

public class Cloud extends Shape {

    private double xVal;
    
    private double yVal;
    
    private double scale;
    
    private Paint colour;
        
    public Cloud () {
        this(0.0, 0.0, 1.0, Paint.valueOf("rgb(255, 255, 255)"));
    }
    
    public Cloud (double centerX, double centerY) {
        this(centerX, centerY, 1.0, Paint.valueOf("rgb(255, 255, 255)"));
    }
    
    public Cloud (double centerX, double centerY, double scale) {
        this(centerX, centerY, scale, Paint.valueOf("rgb(255, 255, 255)"));
    }
    
    public Cloud (double centerX, double centerY, double scale, Paint fill) {
        this.xVal = centerX;
        this.yVal = centerY;
        this.scale = scale;
        this.colour = fill;
    }
    
    public double getX() {
        return this.xVal;
    }
    
    public void setX(double newXValue) {
        this.xVal = newXValue;
    }
    
    public double getY() {
        return this.yVal;
    }
    
    public void setY(double newYValue) {
        this.yVal = newYValue;
    }
    
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