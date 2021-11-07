import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
/**
 * Created by user on 21/06/2017.
 */

/**
 *
 * @param <T> the type.
 */
public class MenuAnimation<T> implements Menu<T>, Task<Void> {
    private String endKey;
    private boolean stop;
    private biuoop.KeyboardSensor k;
    private List<String> keys;
    private List<String> messages;
    private List<T> tasks;
    private List<Menu<T>> subMenus;
    private T status;
    private AnimationRunner runner;
    private String title;

    /**
     * constructor.
     *
     * @param title  the title of the menu.
     * @param endKey the end key.
     * @param k      the KeyboardSensor.
     * @param runner the AnimationRunner.
     */
    public MenuAnimation(String title, String endKey, biuoop.KeyboardSensor k, AnimationRunner runner) {
        this.endKey = endKey;
        this.stop = true;
        this.k = k;
        this.tasks = new ArrayList<>();
        this.keys = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.subMenus = new ArrayList<>();
        this.runner = runner;
        this.title = title;
    }

    /**
     * drawing one frame of the EndScreen animation.
     *
     * @param d  the surface that we draw on.
     * @param dt dt.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.decode("#990000"));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.black);
        d.drawText(304, 66, this.title, 60);
        d.setColor(Color.red);
        d.drawText(302, 68, this.title, 60);
        d.setColor(Color.orange);
        d.drawText(300, 70, this.title, 60);
        d.setColor(Color.yellow);
        d.drawText(298, 72, this.title, 60);

        d.setColor(Color.yellow);
        for (int i = 0; i < this.tasks.size(); i++) {
            d.drawText(100, 150 + 50 * i, "*  Press " + this.keys.get(i) + " " + this.messages.get(i), 30);
        }
        for (int i = 0; i < this.keys.size(); i++) {
            if (this.k.isPressed(this.keys.get(i))) {
                this.stop = false;
                this.status = this.tasks.get(i);
            }
        }
    }

    /**
     * the stopping condition of the animation (changing to false when pressing space bar).
     *
     * @return true or false.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * @param key       the selection key.
     * @param message   the selection massage.
     * @param returnVal the task that we want to commit.
     */
    public void addSelection(String key, String message, T returnVal) {
        this.keys.add(key);
        this.messages.add(message);
        this.tasks.add(returnVal);

    }

    /**
     * @return this status.
     */
    public T getStatus() {
        return this.status;
    }

    /**
     *
     */
    public void reset() {
        this.status = null;
        this.stop = true;
    }

    /**
     * @param key     the submenu key.
     * @param message the submenu massage.
     * @param subMenu the task that we want to commit.
     */
    public void addSubMenu(String key, String message, Menu<T> subMenu) {
        this.keys.add(key);
        this.messages.add(message);
        this.subMenus.add(subMenu);
        //this.tasks.add(null);
    }

    /**
     * @return null.
     */
    public Void run() {
        runner.run(this);
        // wait for user selection
        Task<Void> task = (Task<Void>) this.getStatus();
        task.run();
        this.reset();
        return null;
    }
}
