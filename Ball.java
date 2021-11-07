import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Created by Yoav Zilbertzan on 06/04/2017.
 */
//members.
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private GameEnvironment ge;
    private Velocity ve;

    /**
     *construct a Ball with Point, radius and color.
     * @param center the center Point of the ball.
     * @param r the size of the ball.
     * @param color the color of the ball.
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }
    /**
     *another way to construct a Ball with 2 coordinates, radius and color.
     * @param x1 the x of the center point of the ball.
     * @param y1 the y of the center point of the ball.
     * @param r the size of the ball.
     * @param color the color of the ball.
     */
    public Ball(double x1, double y1, int r, java.awt.Color color) {
      this(new Point(x1, y1), r, color);
    }

    /**
     *another way to construct a Ball with 2 coordinates, radius, color and square.
     * @param x2 the x of the center point of the ball.
     * @param y2 the y of the center point of the ball.
     * @param r the size of the ball.
     * @param color the color of the ball.
     * @param ge the area which the ball is allowed to be (used in moveOneStep).
     */
    public Ball(double x2, double y2, int r, java.awt.Color color, GameEnvironment ge) {
        this(new Point(x2, y2), r, color);
        this.ge = ge;
    }
    /**
     *give back the x of center.
     * @return x of this center.
     */
    public int getX() {
        int x = (int) this.center.getX();
        return x;
    }

    /**
     *give back the y of center.
     * @return y of this center.
     */
    public int getY() {
        int y = (int) this.center.getY();
        return y;
    }

    /**
     *give back the size of the ball.
     * @return r, the size of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     *
     * @param r1 the new size of the ball.
     */
    public void  setR(int r1) {
        this.r = r1;
    }

    /**
     *give back the color of the ball.
     * @return the color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     *draws a ball on the DrawSurface object.
     * @param surface the place wich the drawing take place.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     *entering value to Velocity by dx and dy.
     * @param dx the dx of the velocity.
     * @param dy the dy of the velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.ve = new Velocity(dx, dy);
    }

    /**
     *another way to enter value to Velocity by velocity.
     * @param v a velocity.
     */
    public void setVelocity(Velocity v) {
        this.ve = v;
    }

    /**
     *gives back the velocity's value.
     * @return this velocity.
     */
    public Velocity getVelocity() {
        return this.ve;
    }

    /**
     *the ball is moving one step considering hitting a collidable.
     * @param dt the dt.
     */
    public void  moveOneStep(double dt) {
        Velocity velocity = new Velocity(ve.getDx() * dt, ve.getDy() * dt);
        this.setVelocity(velocity);
        if (this.ve.getDx() < 0) {
            Line line = new Line(this.center.getX() - r, this.center.getY() + r,
                    this.center.getX() + this.ve.getDx() - r, this.center.getY() + this.ve.getDy() + r);
            if (this.ge.getClosestCollision(line) != null) {
                setVelocity(this.ge.getClosestCollision(line).collisionObject().
                        hit(this, this.ge.getClosestCollision(line).collisionPoint(), this.ve));
            }
        }
              if (this.ve.getDx() > 0) {
            Line line = new Line(this.center.getX() + r, this.center.getY() + r,
                    this.center.getX() + this.ve.getDx() + r, this.center.getY() + this.ve.getDy() + r);
            if (this.ge.getClosestCollision(line) != null) {
                setVelocity(this.ge.getClosestCollision(line).collisionObject().
                        hit(this, this.ge.getClosestCollision(line).collisionPoint(), this.ve));
            }
        }
        if (this.ve.getDy() < 0) {
            Line line = new Line(this.center.getX() + r, this.center.getY() - r,
                    this.center.getX() + this.ve.getDx() + r, this.center.getY() + this.ve.getDy() - r);
            if (this.ge.getClosestCollision(line) != null) {
                setVelocity(this.ge.getClosestCollision(line).collisionObject().
                        hit(this, this.ge.getClosestCollision(line).collisionPoint(), this.ve));
            }
        }
        if (this.ve.getDx() > 0) {
            Line line = new Line(this.center.getX() + r, this.center.getY() + r,
                    this.center.getX() + this.ve.getDx() + r, this.center.getY() + this.ve.getDy() + r);
            if (this.ge.getClosestCollision(line) != null) {
                setVelocity(this.ge.getClosestCollision(line).collisionObject().
                        hit(this, this.ge.getClosestCollision(line).collisionPoint(), this.ve));
            }
        }

        this.center = this.getVelocity().applyToPoint(this.center);
        Velocity ov = new Velocity(this.ve.getDx() / dt, this.ve.getDy() / dt);
        this.setVelocity(ov);
    }
    /**
     *@param dt the dt.
     */
    public void timePassed(double dt) {
       this.moveOneStep(dt);
    }

    /**
     *adding ball to game.
     * @param g a Game that ball is added to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     *
     * @param game the game that we want to remove from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}

