import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel
{
    private BufferedImage image;

    public ImagePanel(BufferedImage image)
    {
        this.image = image;
        // Optional: set preferred size based on image dimensions
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // Draw the buffered image at (0,0)
        if (image != null)
        {
            g.drawImage(image, 0, 0, this);
        }
    }
}