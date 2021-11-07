/**
 * Created by user on 31/05/2017.
 */
    public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     *construct a ScoreIndicator with scoreCounter.
     * @param scoreCounter the score counter of the game.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     *the things that happening when hit is acurring.
     * @param beingHit the hited object.
     * @param hitter Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHits() <= 1) {
            this.currentScore.increase(10);
        } else {
            this.currentScore.increase(5);
        }
    }
}
