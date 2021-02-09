import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * This class is part of the SuperPaint program where the user can draw
 * shapes of multiple colours.
 * 
 *@version may 9, 2019
 */

public class DrawPanel extends JPanel{
    private BorderLayout borderLayout;
    private JLabel statusBar; 
    private DynamicStack<Shape> tempShapeStack = new DynamicStack<>();
    private DynamicStack<Shape> shapeStack = new DynamicStack<>();
    private Shape currentShape;
    
    private boolean filled = false;
    private Color color = Color.BLACK;
    private String shapeType = "Line";
    
    /*
     * This constructor does not have any parameters. It initializes some basic variables
     * for later use
     * 
     */
    public DrawPanel(){
        borderLayout = new BorderLayout();
        setLayout(borderLayout);
        setBackground(Color.WHITE);
        
        statusBar = new JLabel(); 
        add( statusBar, BorderLayout.SOUTH ); 
        
        addMouseListener( new MouseEventListener() ); 
        addMouseMotionListener( new MouseEventListener() ); 
    }
    
    /*
     * A mutator:takes in a String argument and does not return anything
     */
    public void setShapeType(String shapeType){
        this.shapeType = shapeType;
    }
    
    /*
     * A mutator:takes in a Color argument and does not return anything
     */
    public void setColor(Color color){
        this.color = color;
    }
    
    /*
     * A mutator:takes in a boolean argument and does not return anything
     */
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    /*
     * The method moves the last shape drawn by the usser to another stack
     * so it will not be drawn. Does not take a parameter and does not return
     * anything
     */
    public void undo(){
        if(!shapeStack.isEmpty()){
            tempShapeStack.push(shapeStack.pop());
        }
    }
    
    /*
     * The method moves the last shape undone by the used to the main stack
     * so it will be drawn again. Does not take a parameter and does not return
     * anything
     */
    public void redo(){
        if(!tempShapeStack.isEmpty()){
            shapeStack.push(tempShapeStack.pop());
        }
    }
    
    /*
     * This method clears both the main stack that is used for drawing and
     * the temp stack used for undo and redo. It does not have any parameters
     * and does not return anything.
     */
    public void clear(){
        shapeStack.clear();
        tempShapeStack.clear();
    }
    
    /*
     * An inner class that allows the user to draw on the panel
     */
    class MouseEventListener extends MouseAdapter {
        @Override
        /*
         * The method is used when the user presses a mouse button and allows the user to create
         * a new shape. It does not release anything
         */
        public void mousePressed(MouseEvent event){
            //Clears the redo button when drawing a new shape
            tempShapeStack.clear();
            
            //draws shape based on the buttons configurations and mouse positions
            if (shapeType == "Line")
                currentShape = new Line( event.getX(), event.getY(), event.getX(), event.getY(), color);   
            else if (shapeType == "Rectangle"){
                currentShape = new Rectangle( event.getX(), event.getY(), event.getX(), event.getY(), color, filled);
            }
            else{
                currentShape = new Oval( event.getX(), event.getY(), event.getX(), event.getY(), color, filled); 
            }
            repaint();
        }
        
        /*
         * This method creates the shape and stores it in stack and is used when the mouse button is released.
         * It does not return anything.
         */
        @Override
        public void mouseReleased(MouseEvent event){
            //sets the final coordinate for the shape
            currentShape.setX2( event.getX() );
            currentShape.setY2( event.getY() );
            shapeStack.push(currentShape);
            
            //Makes the preview ready for the next shape
            currentShape = null;
            repaint();
        }
        
        /*
         * This method is used when the mouse button is pressed down and dragged around. It creates
         * a preview of the shape that is going to be drawn and updates the 
         * position of the mouse. It does not return anything.
         */
        @Override
        public void mouseDragged( MouseEvent event ) {
            statusBar.setText( String.format( "Moved at (%d, %d)", event.getX(), event.getY() ));
            currentShape.setX2( event.getX() );
            currentShape.setY2( event.getY() );
            repaint();
        }
        
        /*
         * This method is solely used to update the position of the mouse and is used when the mouse moves.
         * It does not return anything
         */
        @Override
        public void mouseMoved( MouseEvent event ) {
            statusBar.setText(String.format( "Moved at (%d, %d)", event.getX(), event.getY() ));
        } 
    }
    
    /*
     * This method allows the program to draw shapes onto the screen. It does not return anything.
     */
    @Override
    public void paintComponent( Graphics g ){
        super.paintComponent( g );
        int loops = shapeStack.size();
        
        //pushes all of the shapes into the temporary stack
        for(int index = 0; index < loops; index++){
            tempShapeStack.push(shapeStack.pop());
        }
        
        //returns some of the shapes back to the original stack and draws them
        for(int index = 0; index < loops; index++){
            Shape shape = tempShapeStack.pop();
            shapeStack.push(shape);
            shape.draw( g );
        } 
        
        //Allows the preview shape to be drawn
        if ( currentShape != null )
            currentShape.draw( g );
    }
}
