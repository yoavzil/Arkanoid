import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Created by user on 10/06/2017.
 */
public class HighScoresAnimation implements Animation {
    private HighScoresTable highScores;
    private String endKey;
    private boolean stop;
    private biuoop.KeyboardSensor k;

    /**
     *constructor.
     * @param highScores HighScoresTable
     * @param endKey the stopping key.
     * @param k the KeyboardSensor.
     */
    public HighScoresAnimation(HighScoresTable highScores, String endKey, biuoop.KeyboardSensor k) {
        this.highScores = highScores;
        this.endKey = endKey;
        this.stop = true;
        this.k = k;

    }
    /**
     * drawing one frame of the EndScreen animation.
     * @param d the surface that we draw on.
     *          @param dt dt.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.decode("#990000"));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.black);
        d.drawText(304, 66, "HighScores", 60);
        d.setColor(Color.red);
        d.drawText(302, 68, "HighScores", 60);
        d.setColor(Color.orange);
        d.drawText(300, 70, "HighScores", 60);
        d.setColor(Color.yellow);
        d.drawText(298, 72, "HighScores", 60);
        d.setColor(Color.yellow);
        for (int i = 3; i < this.highScores.getList().size() + 3; i++) {
            d.drawText(200, 60 * i, this.highScores.getList().get(i - 3).getName(), 30);
        }
        for (int i = 3; i < this.highScores.getList().size() + 3; i++) {
            d.drawText(500, 60 * i, Integer.toString(this.highScores.getList().get(i - 3).getScore()), 30);
        }
        d.setColor(Color.BLACK);
        d.drawText(250, 580, "Press " + this.endKey + " to continue", 25);
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
