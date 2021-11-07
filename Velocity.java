/**
 * Created by user on 06/04/2017.
 */
public class Velocity {
    //members.
    private double dx;
    private double dy;

    /**
     * constructor a velocity with dx and dy.
     * @param dx the edition to x.
     * @param dy the edition to y.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * creates a new point given by adding dx to x and dy to y.
     * @param p the original point.
     * @return p1, the new point.
     */
    public Point applyToPoint(Point p) {
        Point p1 = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return p1;
    }

    /**
     * gives back the dx value.
     * @return dx, dx value.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * gives back the dy value.
     * @return dy, dy value.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * changes dx to -dx.
     * @param xdx the original dx.
     */
    public void setDx(double xdx) {
        this.dx = -dx;
    }

    /**
     * changes dy to -dy.
     * @param ydy the original dy.
     */
    public void setDy(double ydy) {
        this.dy = -dy;
    }


    /**
     * changing velocity in angle and speed terms to velocity in dx and dy terms.
     * @param angle the angles in degree.
     * @param speed the speed of the ball.
     * @return velocity with dx and dy.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = angle + 270;
        angle = Math.toRadians(angle);
        double dx = Math.cos(angle) * speed;
        double dy = Math.sin(angle) * speed;
        return new Velocity(dx, dy);
    }

    /**
     *
     * @return speed.
     */
    public double getSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }
}
