import java.awt.Color;
import java.awt.Graphics;
 
/**
 * This class is used to draw a line 
 * 
 * @version may 9, 2019
 */
public class Line extends Shape{

    /*
     * The constructor has 4 parameters that dictates the coordinates of the shape. It also
     * requires a Color objects.
     */
    public Line( int x1, int y1, int x2, int y2, Color color ){
        super(x1,y1,x2,y2,color);
    } 
    
    /*
     * Given a Graphics object (g), this method will draw the current Line object
     */
    public void draw( Graphics g ) {
        g.setColor( getColor() );
        g.drawLine( getX1(), getY1(), getX2(), getY2());
    } 
} 