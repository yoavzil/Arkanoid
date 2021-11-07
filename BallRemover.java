/**
 * Created by user on 31/05/2017.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * construct a BallRemover with gameLevel and removedBalls.
     * @param gameLevel the given gameLevel (in order to remove the ball frome the game.
     * @param removedBalls a counter of the ball so that we will know when to start anew turn.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }

    /**
     *the things that happening when hit is acuring.
     * @param beingHit the object that was hited.
     * @param hitter the object that hited beingHit.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);

    }
}
