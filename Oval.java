import java.awt.Color;
import java.awt.Graphics;
 
/**
 * This class is used to create an oval object
 * 
 * @version November 29, 2018
 */

public class Oval extends FillableShape{ 
    /*
     * The constructor has 4 parameters that dictates the coordinates of the shape. It also
     * requires a Color objects.
     */
    public Oval(int x1, int y1, int x2, int y2, Color color, boolean filled){
        super(x1, y1, x2, y2, color, filled);
    }
    
    /*
    Given a Graphics object (g), this method will draw the current oval object
    */
    @Override 
    public void draw(Graphics g){
        g.setColor( getColor() );
        if (getFilled() == false){
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else{
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }
}