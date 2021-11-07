import biuoop.DrawSurface;
/**
 * Created by user on 01/06/2017.
 */
public interface Animation {
    /**
     * drawing one frame of the animation, which mean that
     * all the sprites do one step.
     *@param dt the dt.
     * @param d the surface that we draw on.
     */
    void doOneFrame(DrawSurface d, double dt);

    /**
     * stoping condition of the animation (the while loop).
     *
     * @return true or false.
     */
    boolean shouldStop();

    /**
     *
     */
    void reset();

}
