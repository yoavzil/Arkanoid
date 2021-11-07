import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * Created by user on 13/05/2017.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private biuoop.GUI gui;
    private Rectangle rectangle;
    private Rectangle borderRectangle;
    private java.awt.Color color;
    private int paddleSpeed;

    /**
     * constructor.
     *
     * @param keyboard        a KeyboardSensor for moving to the left and to the right.
     * @param gui             GUI for the keyboard.
     * @param rectangle       the borders of the paddle.
     * @param borderRectangle the borders of the big game board.
     * @param color           color of the paddle.
     * @param paddleSpeed     the speed of the paddle.
     */
    public Paddle(biuoop.KeyboardSensor keyboard, biuoop.GUI gui,
                  Rectangle rectangle, Rectangle borderRectangle, java.awt.Color color,
                  int paddleSpeed) {
        this.gui = gui;
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.borderRectangle = borderRectangle;
        this.color = color;
        this.paddleSpeed = paddleSpeed;

    }

    /**
     * move to the left method.
     *
     * @param dt dt.
     */
    public void moveLeft(double dt) {
        this.rectangle.getUpperLeft().setX(this.rectangle.getUpperLeft().getX() - (this.paddleSpeed * dt));
    }

    /**
     * move to the right method.
     *
     * @param dt dt.
     */
    public void moveRight(double dt) {
        this.rectangle.getUpperLeft().setX(this.rectangle.getUpperLeft().getX() + (this.paddleSpeed * dt));

    }

    // Sprite

    /**
     * notify if the player pressed left or right and call to the fitting method.
     *
     * @param dt dt.
     */
    public void timePassed(double dt) {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft(dt);
            if (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth()
                    <= this.borderRectangle.getUpperLeft().getX()) {
                this.rectangle.getUpperLeft().setX(this.borderRectangle.getUpperLeft().getX()
                        + this.borderRectangle.getWidth());
            }
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight(dt);
            if (this.rectangle.getUpperLeft().getX() >= this.borderRectangle.getUpperLeft().getX()
                    + this.borderRectangle.getWidth()) {
                this.rectangle.getUpperLeft().setX(this.borderRectangle.getUpperLeft().getX());
            }
        }
    }

    /**
     * drawing the block.
     *
     * @param d the object that we use to draw things.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int minx = (int) this.rectangle.getUpperLeft().getX();
        int miny = (int) this.rectangle.getUpperLeft().getY();
        int width1 = (int) this.rectangle.getWidth();
        int height1 = (int) this.rectangle.getHeight();
        d.fillRectangle(minx, miny, width1, height1);
        d.setColor(Color.black);
        d.drawRectangle(minx, miny, width1, height1);
    }

    // Collidable

    /**
     * get the borders pf this rectangle.
     *
     * @return this rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * changing the velocity according to the hit.
     *
     * @param collisionPoint  the point that the collision took place in.
     * @param currentVelocity the current velocity.
     * @param hitter          the hitting ball.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX()
                && collisionPoint.getX()
                <= this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 5) {
            currentVelocity = currentVelocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        }
        if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 5
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                + (this.rectangle.getWidth() / 5) * 2) {
            currentVelocity = currentVelocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
        }
        if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth() / 5) * 2
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                + (this.rectangle.getWidth() / 5) * 3) {
            currentVelocity = currentVelocity.fromAngleAndSpeed(0, currentVelocity.getSpeed());
        }
        if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth() / 5) * 3
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                + (this.rectangle.getWidth() / 5) * 4) {
            currentVelocity = currentVelocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
        }
        if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX() + (this.rectangle.getWidth() / 5) * 4
                && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                + (this.rectangle.getWidth() / 5) * 5) {
            currentVelocity = currentVelocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }

        return currentVelocity;
    }

    // Add this paddle to the game.

    /**
     * adding ball to game.
     *
     * @param g a Game that paddle is added to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
