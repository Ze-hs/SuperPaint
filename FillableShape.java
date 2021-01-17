import java.awt.Color;
import java.awt.Graphics;
/**
 * This class is used to create a rectangle or oval shape
 * 
 * @version November 29, 2018
 */

abstract class FillableShape extends Shape{
    private boolean filled;
    public FillableShape(int x1, int y1, int x2, int y2, Color color, boolean filled){
        super(x1, y1, x2, y2, color);
        setFilled(filled);
    }
   
    /*
     * This method retrieves the value for the variable filled. It does not take any parameters
     * and returns a boolean value for the variable filled
     */
    public boolean getFilled(){
        return filled;
    }
    
    
    /* 
     * This method sets the value for the variable filled. It takes a boolean for its
     * parameters and does not return anything
     */
    public void setFilled(boolean bool){
        this.filled = bool;
    }
    
    /*
     * The method returns the x-coordinate of the upper left corner. It does not take any
     * parameters.
     */
    public int getUpperLeftX(){
        return Math.min(getX1(), getX2());
    }
    
    /*
     * The method returns the y-coordinate of the upper left corner. It does not take any
     * parameters.
     */
    public int getUpperLeftY(){
        return Math.min(getY1(), getY2());
    }
    
    /*
     * The method returns the width of the shape. It does not take any
     * parameters.
     */
    public int getWidth(){
        return Math.abs(getX1() - getX2());
    }
    
    /*
     * The method returns the height of the shape. It does not take any
     * parameters.
     */
    public int getHeight(){
        return Math.abs(getY1() - getY2());
    }

}