import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * Created by user on 02/06/2017.
 */
public class EndScreen implements Animation {
    private biuoop.KeyboardSensor keyboard;
    private boolean stop;
    private boolean win;
    private Counter score;

    /**
     *construct an EndScreen with k, win and score.
     * @param win telling us either its a winning case or losing case.
     * @param score the final score.
     * @param k KeyboardSensor, in order to recognize when pressing space bar.
     */
    public EndScreen(KeyboardSensor k, boolean win, Counter score) {
        this.keyboard = k;
        this.win = win;
        this.score = score;
        this.stop = true;
    }

    /**
     * drawing one frame of the EndScreen animation.
     * @param d the surface that we draw on.
     *          @param dt the dt.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.decode("#990000"));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        if (win) {
            d.drawText(210, 200, "You Won", 100);
            d.setColor(Color.decode("#ffcb05"));
            d.drawText(214, 196, "You Won", 100);
        } else {
            d.drawText(210, 200, "You Lost", 100);
            d.setColor(Color.decode("#ffcb05"));
            d.drawText(214, 196, "You Lost", 100);
        }
        d.setColor(Color.BLACK);
        d.drawText(250, 580, "Press space to continue", 25);
        d.setColor(Color.WHITE);
        d.drawText(300, 350, "Final score: " + this.score.getValue(), 30);
    }

    /**
     * the stopping condition of the animation (changing to false when pressing space bar).
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
