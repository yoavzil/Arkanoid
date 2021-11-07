import biuoop.DrawSurface;
/**
 * Created by user on 12/05/2017.
 */
public interface Sprite {
    /**
     *draw the Sprite.
     * @param d the surface which we draw on.
     */
    void drawOn(DrawSurface d);

    /**
     *@param dt dt.
     */
    void timePassed(double dt);

    /**
     *adding the Sprite to the Game.
     * @param g a Game.
     */
    void addToGame(GameLevel g);
}
