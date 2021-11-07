/**
 * Created by user on 31/05/2017.
 */
public class BallAdder implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     *constructor.
     * @param gameLevel a game level.
     * @param removedBalls a removedBalls counter.
     */
    public BallAdder(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }

    /**
     *hit event.
     * @param beingHit the hited block.
     * @param hitter the hitting ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        Velocity v = Velocity.fromAngleAndSpeed(180, 7);
        this.gameLevel.addBallToGame(v, this.remainingBalls);
    }
}
