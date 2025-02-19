import startypes.*;
import java.awt.Graphics;

public class Star {

    private int x;
    private int y;
    StarType starType;

    /**
     * Constructor for Star
     * @param x
     * @param y
     * @param starType
     */
    public Star(int x, int y, StarType starType) {
        this.x = x;
        this.y = y;
        this.starType = starType;
    }

    /**
     * method to draw the star
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(starType.getColor());
        g.fillOval(x, y , starType.getSize(), starType.getSize());
    }

}
