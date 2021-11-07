import biuoop.DrawSurface;
import java.awt.Color;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by user on 03/05/2017.
 */
public class Block implements Collidable, Sprite, HitNotifier, BlockCreator {
    private Rectangle rectangle;
    private Map<Integer, Color> colors;
    private Map<Integer, Image> images;
    private Color color;
    private boolean hasBorder;
    private int hits;
    private String string;
    private List<HitListener> hitListeners = new ArrayList();


    /**
     * construct a Block with rectangle, color and number of hits.
     */
    public Block() {
        this.rectangle = new Rectangle(new Point(0, 0), 1, 1);
        this.color = Color.black;
        this.hits = 0;
        this.hasBorder = false;
        this.colors = new TreeMap<Integer, Color>();
        this.images = new TreeMap<Integer, Image>();
    }

    /**
     * construct a new block from a given block according to its' parameters,
     * a new hitListener object is generated anyway.
     *
     * @param other the given block.
     */
    public Block(Block other) {
        this.rectangle = other.rectangle;
        this.colors = other.colors;
        this.images = other.images;
        this.color = other.color;
        this.hasBorder = other.hasBorder;
        this.hits = other.hits;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     *constructor.
     * @param rectangle a given rectangle.
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.color = color;
        this.hits = hits;
        this.hasBorder = false;
        this.colors = new TreeMap<Integer, Color>();
        this.images = new TreeMap<Integer, Image>();
        this.color = Color.gray;
        this.hits = 0;
    }
    /**
     * @return Rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * changing the velocity according to the hit.
     *
     * @param hitter          the hitting ball.
     * @param collisionPoint  the point that the collision took place in.
     * @param currentVelocity the current velocity.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (collisionPoint.getX() == this.rectangle.getUpperLeft().getX()) {
            currentVelocity.setDx(currentVelocity.getDx());
            this.notifyHit(hitter);
            this.setHits();
        }
        if (collisionPoint.getX() == this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth()) {
            currentVelocity.setDx(currentVelocity.getDx());
            this.notifyHit(hitter);
            this.setHits();
        }
        if (collisionPoint.getY() == this.rectangle.getUpperLeft().getY()) {
            currentVelocity.setDy(currentVelocity.getDy());
            this.notifyHit(hitter);
            this.setHits();
        }
        if (collisionPoint.getY() == this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight()) {
            currentVelocity.setDy(currentVelocity.getDy());
            this.notifyHit(hitter);
            this.setHits();
        }
        return currentVelocity;
    }

    /**
     * drawing the block.
     *
     * @param surface the object that we use to draw things.
     */
    public void drawOn(DrawSurface surface) {
        if (this.images.containsKey(this.hits)) {
            surface.drawImage(
                    (int) Math.round(this.rectangle.getUpperLeft().getX()),
                    (int) Math.round(this.rectangle.getUpperLeft().getY()),
                    this.images.get(this.hits));
        } else if (this.colors.containsKey(this.hits)) {
            surface.setColor(this.colors.get(this.hits));
            surface.fillRectangle(
                    (int) Math.round(this.rectangle.getUpperLeft().getX()),
                    (int) Math.round(this.rectangle.getUpperLeft().getY()),
                    (int) Math.round(this.rectangle.getWidth()),
                    (int) Math.round(this.rectangle.getHeight()));
        } else if (this.images.containsKey(0)) {
            surface.drawImage(
                    (int) Math.round(this.rectangle.getUpperLeft().getX()),
                    (int) Math.round(this.rectangle.getUpperLeft().getY()),
                    this.images.get(0));
        } else if (this.colors.containsKey(0)) {
            surface.setColor(this.colors.get(0));
            surface.fillRectangle(
                    (int) Math.round(this.rectangle.getUpperLeft().getX()),
                    (int) Math.round(this.rectangle.getUpperLeft().getY()),
                    (int) Math.round(this.rectangle.getWidth()),
                    (int) Math.round(this.rectangle.getHeight()));
        }
        if (this.hasBorder) {
            surface.setColor(this.color);
            surface.drawRectangle(
                    (int) Math.round(this.rectangle.getUpperLeft().getX()),
                    (int) Math.round(this.rectangle.getUpperLeft().getY()),
                    (int) Math.round(this.rectangle.getWidth()),
                    (int) Math.round(this.rectangle.getHeight()));
        }
    }

    /**
     * @return hits.
     */
    public int getHits() {
        return this.hits;
    }

    /**
     * updating hits.
     */
    public void setHits() {
        this.hits = hits - 1;
    }

    /**
     * entering the value of hits to the string.
     */
    public void intilizingString() {
        if (this.hits > 0) {
            this.string = Integer.toString(this.hits);
        } else {
            this.string = "X";
        }
    }

    /**
     *@param dt dt.
     */
    public void timePassed(double dt) {
        this.intilizingString();
    }

    /**
     * adding block to game.
     *
     * @param g a Game that ball is added to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * removing this block from game.
     *
     * @param game the game that we want to remove from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * adding hit listener to this block.
     *
     * @param hl the given hit listener.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * removing hit listener to this block.
     *
     * @param hl the given hit listener.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notifying when hit was happen and calling hitEvent.
     *
     * @param hitter the hitting ball (we will use it in hitEvent).
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * this method sets the location of this block.
     *
     * @param upperLeft the new location of the upper left corner of the block.
     */
    public void setUpperLeft(Point upperLeft) {
        this.rectangle = new Rectangle(upperLeft, this.rectangle.getWidth(),
                this.rectangle.getHeight());
    }

    /**
     * this method sets the location of this block.
     *
     * @param x the x coordinate of the upper left corner of the block.
     * @param y the y coordinate of the upper left corner of the block.
     */
    public void setUpperLeft(double x, double y) {
        Point upperLeft = new Point(x, y);
        this.setUpperLeft(upperLeft);
    }

    /**
     * this method sets the width of this block.
     *
     * @param width the new width.
     */
    public void setWidth(int width) {
        this.rectangle = new Rectangle(this.rectangle.getUpperLeft(),
                width, this.rectangle.getHeight());
    }

    /**
     * this method sets the height of this block.
     *
     * @param height the new height.
     */
    public void setHeight(int height) {
        this.rectangle = new Rectangle(this.rectangle.getUpperLeft(),
                this.rectangle.getWidth(), height);
    }

    /**
     * this method sets the number of hits of this block.
     *
     * @param numberOfhits the number of hits.
     */
    public void setHits(int numberOfhits) {
        this.hits = numberOfhits;
    }

    /**
     * this method sets the color of this block's borders.
     *
     * @param bordersColor the given color.
     */
    public void setBorderColor(Color bordersColor) {
        this.color = bordersColor;
    }

    /**
     * this method sets the available colors of this block's filling.
     *
     * @param filling the given colors.
     */
    public void setColors(Map<Integer, Color> filling) {
        this.colors = filling;
    }

    /**
     * this method sets the available images of this block's filling.
     *
     * @param filling the given images.
     */
    public void setImages(Map<Integer, Image> filling) {
        this.images = filling;
    }

    /**
     * this method determines if this block has borders or not.
     *
     * @param isHasBorder the wanted option.
     */
    public void setBorder(boolean isHasBorder) {
        this.hasBorder = isHasBorder;
    }

    /**
     *
     * @param xpos coordinates.
     * @param ypos coordinates.
     * @return this block.
     */
    public Block create(int xpos, int ypos) {
        return this;
    }
}

