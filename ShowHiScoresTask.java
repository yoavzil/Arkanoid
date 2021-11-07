/**
 * Created by user on 22/06/2017.
 */
public class ShowHiScoresTask implements Task<Void> {
    private AnimationRunner runner;
    private Animation highScoresAnimation;

    /**
     *constructor.
     * @param runner the AnimationRunner.
     * @param highScoresAnimation the animation.
     */
    public ShowHiScoresTask(AnimationRunner runner, Animation highScoresAnimation) {
        this.runner = runner;
        this.highScoresAnimation = highScoresAnimation;
    }

    /**
     *
     * @return null.
     */
    public Void run() {
        this.runner.run(this.highScoresAnimation);
        return null;
    }
}
