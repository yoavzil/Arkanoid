/**
 * Created by user on 25/05/2017.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the hited object.
     * @param hitter Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
