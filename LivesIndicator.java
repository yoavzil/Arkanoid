import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Created by user on 01/06/2017.
 */
public class LivesIndicator implements Sprite {
    private Counter lifes;

    /**
     * construct a LivesIndicator with lifes.
     *
     * @param lifes the lives counter.
     */
    public LivesIndicator(Counter lifes) {
        this.lifes = lifes;
    }

    /**
     * draw the Sprite.
     *
     * @param surface the surface which we draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.lightGray);
        surface.fillRectangle(0, 0, 200, 20);
        surface.setColor(Color.black);
        surface.drawText(0 + 50, 0 + 13, "Lives:" + Integer.toString(this.lifes.getValue()), 15);
    }

    /**
     *@param dt dt.
     */
    public void timePassed(double dt) {
    }

    /**
     * @param g a Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * @param lives updating lifes with a new value.
     */
    public void setLifes(Counter lives) {
        this.lifes = lifes;
    }
}
