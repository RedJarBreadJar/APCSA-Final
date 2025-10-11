import javax.swing.*;
import java.awt.image.BufferedImage;

import java.awt.Color;



public class Window extends JFrame {
    private int width = 800;
    private int height = 600;
    
    public Window() {
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.RED);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        add(panel);


        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = 3;
                int g = 255;
                int b = 128;
                int rgb = (r << 16) | (g << 8) | b;
                img.setRGB(x, y, rgb);
            }
        }

        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);
        panel.add(label);
    }
}
