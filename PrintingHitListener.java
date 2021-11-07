/**
 * Created by user on 30/05/2017.
 */
public class PrintingHitListener implements HitListener {
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block with " + beingHit.getHits() + " points was hit.");
    }
}
