/**
 * Created by user on 30/05/2017.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**
     * construct a BlockRemover with gameLevel and removedBlocks.
     * @param gameLevel the given gameLevel (in order to remove the block from the game.
     * @param removedBlocks a counter of the blocks so that we will know when the player won the level.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }
    /**
     *the things that happening when hit is acurring.
     * @param beingHit the object that was hited.
     * @param hitter the object that hited beingHit.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHits() <= 1) {
            beingHit.removeFromGame(this.gameLevel);
            this.remainingBlocks.decrease(1);
        }
    }
}
