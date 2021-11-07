import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Created by user on 31/05/2017.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     *construct a ScoreIndicator with score.
     * @param score the score counter of the game.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * draw the Sprite.
     *
     * @param surface the surface which we draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.lightGray);
        surface.fillRectangle(200, 0, 400, 20);
        surface.setColor(Color.black);
        surface.drawText(300, 0 + 13, "Score:" + Integer.toString(this.score.getValue()), 15);
    }

    /**
     *@param dt dt.
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

    /**
     *
     * @param scores updating score with a new value.
     */
    public void setScore(Counter scores) {
        this.score = score;
    }
}
