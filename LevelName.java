import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Created by user on 02/06/2017.
 */
public class LevelName implements Sprite {
    private String string;

    /**
     *construct a LevelName using string.
     * @param string the name of the level.
     */
    public LevelName(String string) {
        this.string = string;
    }

    /**
     *draw the Sprite.
     * @param surface the surface which we draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.lightGray);
        surface.fillRectangle(600, 0, 300, 20);
        surface.setColor(Color.black);
        surface.drawText(500, 0 + 13, "Level Name:" + this.string, 15);
    }
    /**
     *we don't use it.
     * @param dt dt.
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
