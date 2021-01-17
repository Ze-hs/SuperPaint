import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is used to build a SuperPaint program where the user can can interact with buttons
 * and draw shapes.
 * 
 *@version may 9, 2019
 */

public class DrawFrame extends JFrame{
    private JComboBox<String> colourChooser;
    private JComboBox<String> shapeChooser;
    private String[] colourNames = {"Black", "Gray", "Red", "Green", "Blue", "White" };
    private Color[] colourValues = { Color.BLACK, Color.GRAY, Color.RED, Color.GREEN, Color.BLUE, Color.WHITE };
    private String[] shapeNames = {"Line", "Rectangle", "Oval"};
    private JButton undoButton;
    private JButton redoButton;
    private JButton clearButton;
    private JCheckBox fillBox; 
    private JPanel buttonPanel;
    private DrawPanel drawingPanel;
    
    /*
     * This constructor does not have any arguments and is solely used to insantiate
     * some widgets for later use
     */
    public DrawFrame(){
        super("SuperPaint Application");
        //Creating buttons and boxes for user configuration
        buttonPanel = new JPanel();
        drawingPanel = new DrawPanel(); 
        buttonPanel.setLayout(new GridLayout(1,20, 5, 1));
        
        undoButton = new JButton("Undo");
        buttonPanel.add(undoButton);
        redoButton = new JButton("Redo");
        buttonPanel.add(redoButton);
        clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        
        colourChooser = new JComboBox<String>( colourNames );
        colourChooser.setMaximumRowCount( 6 );
        buttonPanel.add(colourChooser);
        shapeChooser = new JComboBox<String>( shapeNames );
        shapeChooser.setMaximumRowCount( 3 );
        buttonPanel.add(shapeChooser);
        
        fillBox = new JCheckBox("Filled");
        buttonPanel.add(fillBox);
        fillBox.setEnabled(false);
        
        //Allows user to interact with the boxes and buttons
        ActionListener eventListener = new ButtonEventListener();
        undoButton.addActionListener( eventListener ); 
        redoButton.addActionListener( eventListener ); 
        clearButton.addActionListener( eventListener ); 
        
        ItemListener boxListener = new boxEventListener();
        fillBox.addItemListener(boxListener);
        colourChooser.addItemListener(boxListener);
        shapeChooser.addItemListener(boxListener);

        add(drawingPanel, BorderLayout.CENTER ); 
        add( buttonPanel, BorderLayout.NORTH ); 
    }
    
    /*
     * An inner class that allows user to interact with the buttons.
     */
    class ButtonEventListener implements ActionListener {
        /*
         * This method is used when a button is pressed on and it does not return anything
         */
        @Override 
        //Determines which button was pressed on and apply it to the program
        public void actionPerformed( ActionEvent e ) {
            if ( e.getSource() == undoButton ) {
                drawingPanel.undo();
            }
            else if(e.getSource() == redoButton) {
                drawingPanel.redo(); 
            }
            else{
                drawingPanel.clear();
            }
            //Paints the shapes onto the panel everytime they press a button
            drawingPanel.repaint();
        }
    }
    
    /*
     * This inner class allows drop down menus and checkboxes to be interacted with,
     */
    class boxEventListener implements ItemListener {
        
        @Override 
        /*
         * This method is called when one of the widgets apecified above is interacted with
         * it does not return anything.
         */
        public void itemStateChanged( ItemEvent e ) {
            //Controls the fill of a shape
            if (e.getSource() == fillBox && fillBox.isSelected() ) {
                drawingPanel.setFilled( true );
            } 
            else if(e.getSource() == fillBox && !fillBox.isSelected()){
                drawingPanel.setFilled( false );
            }
            //Controls the color of the shape
            else if(e.getSource() == colourChooser){
                drawingPanel.setColor(colourValues[ colourChooser.getSelectedIndex()]);   
            }
            //Controls the shape and locks down the fill box if shape cannot be applied to it.
            else if(e.getSource() == shapeChooser){
                drawingPanel.setShapeType(shapeNames[shapeChooser.getSelectedIndex()]); 
                if(shapeChooser.getSelectedItem() == "Line"){
                    fillBox.setEnabled(false);
                }
                else{
                    fillBox.setEnabled(true);
                }
            }
        }         
    }
}