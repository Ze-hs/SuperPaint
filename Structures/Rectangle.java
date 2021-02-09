import java.awt.Color;
import java.awt.Graphics;
 
/*
 * /**
 * This class is used to store the coordinates that make up a rectangle
 * 
 * @version may 9, 2019
 */

public class Rectangle extends FillableShape{ 
    /*
     * The constructor has 4 parameters that dictates the coordinates of the shape. It also
     * requires a Color objects.
     */
    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean filled){
        super(x1, y1, x2, y2, color, filled);
    }
    
    /*
     * Given a Graphics object (g), this method will draw the current rectangle object
     */
    @Override
    public void draw(Graphics g){
        g.setColor( getColor() );
        if (getFilled() == false){
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else{
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }

}