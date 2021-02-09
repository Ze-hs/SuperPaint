import java.awt.Color;
import java.awt.Graphics;

/**
 *@version March 31, 2019
 * 
 * An abstract class that forms the basis to draw shapes such as rectangles, ovals and lines
 */

abstract class Shape{
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Color color;
    
    /*
     * The constructor has 4 parameters that dictates the coordinates of the shape. It also
     * requires a Color objects.
     */
    public Shape(int x1, int y1, int x2, int y2, Color color){
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setColor(color);
    }
    
    /*
     * An accesor that returns the first coordiante in the x-axis as the parameter and does
     * not return anything. 
     */
    public int getX1(){
        return x1;
    }
    
    /*
     * An accesor that returns the second coordiante in the x-axis as the parameter and does
     * not return anything. 
     */
    public int getX2(){
        return x2;
    }
   
    /*
     * An accesor that returns the first coordiante in the y-axis as the parameter and does
     * not return anything. 
     */
    public int getY1(){
        return y1;
    }
    
    /*
     * An accesor that returns the first coordiante in the x-axis as the parameter and does
     * not return anything. 
     */
    public int getY2(){
        return y2;
    }
    
    /*
     * An accesor that returns the a Color object, it not return anything. 
     */
    public Color getColor(){
        return color;
    }
    
    
    public void setX1(int num){
        x1 = num;
    }
    
    public void setX2(int num){
        x2 = num;
    }
    
    public void setY1(int num){
        y1 = num;
    }
    
    public void setY2(int num){
        y2 = num;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    private boolean isLessThanZero(int checkNum){
        if (checkNum < 0){
            System.err.print("Number cannot be set to less than 0\n");
            return true;
        }
        return false;
    }
    
    abstract void draw(Graphics g);
}