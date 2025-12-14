import javax.swing.*;

public class Window extends JFrame
{

    public Window(int seed)
    {
        setTitle("Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the ImagePanel with the image
        PerlinImage img = new PerlinImage(seed);
        ImagePanel panel = new ImagePanel(img.getImage());
        add(panel);

        pack();  // size the window based on the panel's preferred size
        setLocationRelativeTo(null); // center the window on screen
        setVisible(true);
    }

}
