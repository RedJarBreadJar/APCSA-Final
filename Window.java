import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        setTitle("My Window");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}