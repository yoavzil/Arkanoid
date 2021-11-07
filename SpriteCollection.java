import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/05/2017.
 */
public class SpriteCollection {
        private List list = new ArrayList();

        /**
         *
         * @return this list of Sprites.
         */
        public List getList() {
            return this.list;
        }

    /**
     *adding the Sprite to the list of Sprites.
     * @param s a Sprite to add.
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }

    /**
     *calling to TimePassed of all Sprites.
     * @param dt dt.
     */
    public void notifyAllTimePassed(double dt) {
        for (int i = 0; i < this.list.size(); i++) {
            Sprite sprite = (Sprite) this.list.get(i);
            sprite.timePassed(dt);
        }
    }

    /**
     * calling to drawOn of all Sprites.
     * @param d the object that we use to draw things.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.list.size(); i++) {
            Sprite sprite = (Sprite) this.list.get(i);
            sprite.drawOn(d);
        }
    }

}
