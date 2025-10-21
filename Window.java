import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        setTitle("Image Display Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a sample BufferedImage (for example purposes)
        
        // Fill the image with a color or some graphics
        

        // Create the ImagePanel with the image
        PerlinImage img = new PerlinImage();
        ImagePanel panel = new ImagePanel(img.getImage());
        add(panel);

        pack();  // size the window based on the panel's preferred size
        setLocationRelativeTo(null); // center the window on screen
        setVisible(true);
    }

}
