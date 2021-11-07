import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * Created by user on 01/06/2017.
 */
public class PauseScreen implements Animation {
    private biuoop.KeyboardSensor keyboard;
    private boolean stop;
    private SpriteCollection gameScreen;

    /**
     * construct an EndScreen with k, win and score.
     *
     * @param gameScreen the game's sprites.
     * @param k          KeyboardSensor, in order to recognize when pressing space bar.
     */
    public PauseScreen(KeyboardSensor k, SpriteCollection gameScreen) {
        this.keyboard = k;
        this.stop = true;
        this.gameScreen = gameScreen;
    }

    /**
     * this method gets a color and a DrawSurface
     * and draws the background on the given DrawSurface.
     *
     * @param d     the given DrawSurface.
     * @param color the given color.
     */
    public void setBackground(DrawSurface d, Color color) {
        d.setColor(color);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
    }

    /**
     * drawing one frame of the EndScreen animation.
     *
     * @param d  the surface that we draw on.
     * @param dt dt.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        this.setBackground(d, Color.BLUE);
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.red);
        d.drawText(170, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * the stopping condition of the animation (changing to false when pressing space bar).
     *
     * @return true or false.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     *
     */
    public void reset() {
    }
}
