import java.awt.Color;
import biuoop.DrawSurface;
/**
 * Created by user on 02/06/2017.
 */
public class Background4 implements Sprite {
    /**
     * this method draws the background on given DrawSurface.
     *
     * @param d the DrawSurface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("#0096fd"));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; i++) {
            d.drawLine(150 + 10 * i, 410, 110 + 10 * i, 600);
        }
        for (int i = 0; i < 10; i++) {
            d.drawLine(600 + 10 * i, 450, 560 + 10 * i, 600);
        }
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(175, 430, 30);
        d.fillCircle(160, 400, 25);
        d.fillCircle(625, 480, 30);
        d.fillCircle(610, 450, 25);
        d.setColor(Color.GRAY.brighter());
        d.fillCircle(200, 395, 25);
        d.fillCircle(650, 445, 25);
        d.setColor(Color.GRAY);
        d.fillCircle(230, 400, 30);
        d.fillCircle(215, 425, 20);
        d.fillCircle(680, 450, 30);
        d.fillCircle(665, 475, 20);
    }
    /**
     * this method notifies the background that a time unit has passed.
     */
    public void timePassed(double dt) {
    }
    /**
     * @param g a Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
