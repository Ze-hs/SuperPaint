import javax.swing.JFrame;
/*
 *@version May 9, 2019
 * 
 * This is a test program for a JavaPaint application
 */
class JavaPaint {
    public static void main(String[] args) {
        DrawFrame application = new DrawFrame();
        
        application.setSize( 480, 320 );
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.setVisible( true );
    }
}