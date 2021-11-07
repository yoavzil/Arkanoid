import java.awt.Color;
import biuoop.DrawSurface;
/**
 * Created by user on 02/06/2017.
 */
public class Background2 implements Sprite {
    /**
     * this method draws the background on given DrawSurface.
     *
     * @param d the DrawSurface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.decode("#fff08b"));
        for (int i = 0; i < 100; i++) {
            d.drawLine(150, 130, 8 * i, 250);
        }
        d.fillCircle(150, 130, 60);
        d.setColor(Color.decode("#ffe42f"));
        d.fillCircle(150, 130, 50);
        d.setColor(Color.YELLOW);
        d.fillCircle(150, 130, 40);
    }
    /**
     * this method notifies the background that a time unit has passed.
     */
    public void timePassed(double dt) {
    }

    /**
     *
     * @param g a Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
