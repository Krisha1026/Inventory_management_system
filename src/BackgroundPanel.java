import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel {
    private Image background;

    public BackgroundPanel(String imagePath) {
        try {
            background = new ImageIcon(getClass().getResource(imagePath)).getImage();
        } catch (Exception e) {
            System.out.println("Error loading background: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}