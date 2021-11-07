import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * Created by user on 01/06/2017.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Counter score;
    private double dt;

    /**
     * construct an AnimationRunner with score.
     * @param score the score Counter of the game.
     */
    public AnimationRunner(Counter score) {
        this.gui = new GUI("Arcanoid", 800, 600);
        this.score = score;
        this.framesPerSecond = 60;
        this.dt = 1 / (double) this.framesPerSecond;
    }

    /**
     *returns the gui of the game.
     * @return the Gui of the game.
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * returns the score Counter.
     * @return the score Counter.
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     *
     * @param score1 the new score.
     */
    public void setScore(Counter score1) {
        this.score = score1;
    }

    /**
     *
     * @return this getframespersecond.
     */
    public int getFramesPerSecond() {
        return this.framesPerSecond;
    }
    /**
     *
     * @return dt
     */
    public double getDt() {
        return this.dt;
    }

    /**
     * running the given animation using it's shouldStop method
     * to stop the loop, and doOneFrame method to draw onr frame.
     * @param animation the given animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        Sleeper sleeper = new biuoop.Sleeper();
        animation.reset();
        while (animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d, this.dt);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
