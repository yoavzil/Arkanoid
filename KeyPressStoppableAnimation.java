import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Created by user on 21/06/2017.
 */
public class KeyPressStoppableAnimation implements Animation {
    private Animation animation;
    private KeyboardSensor sensor;
    private String key;
    private boolean stop;
    private boolean isAlreadyPressed;
    /**
     *constructor.
     * @param sensor the KeyboardSensor.
     * @param key the stopping key.
     * @param animation the seed animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.stop = true;
        this.isAlreadyPressed = true;
    }

    /**
     *
     * @param d the surface that we draw on.
     * @param dt the dt.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        this.animation.doOneFrame(d, dt);
        if (this.sensor.isPressed(this.key) && !this.isAlreadyPressed) {
            this.stop = false;
        }
        if (!this.sensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
    }

    /**
     *
     * @return the stopping condition (this stop).
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     *
     */
    public void reset() {
        this.stop = true;
        this.isAlreadyPressed = true;
    }
}
