import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sky extends JFrame {
    private List<Star> stars = new ArrayList<>();

    /**
     * Constructor for Sky
     * @param star
     */
    public void placeStar(Star star) {
        stars.add(star);
    }

    /**
     * method to paint the stars
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics) {
        for (Star star : stars) {
            star.draw(graphics);
        }
    }
}