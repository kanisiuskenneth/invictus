package view.util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kennethhalim on 4/20/17.
 */
public class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}