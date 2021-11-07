
/**
 * Yoav Zilbertzan 01/04/2017.
 */
//members.
public class Point {
    private double x;
    private double y;

    /**
     *Construct a point givne x and y coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance between 2 points calculator.
     * @param other the other point.
     * @return the distance calculation between 2 points.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * Checks if 2 points are equals.
     * @param other the other point.
     * @return true if equals or false if not.
     */
    public boolean equals(Point other) {
        boolean compeir;
        if (this.x == other.x && this.y == other.y) {
            compeir = true;
        } else {
            compeir = false;
        }
        return compeir;
    }

    /**
     * Gets the value of x.
     * @return the value of x.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets the value of y.
     * @return the value of y.
     */
    public double getY() {
        return this.y;
    }

    /**
     *
     * @param x1 x of the new point.
     */
    public void  setX(double x1) {
        this.x = x1;
    }
    /**
     *
     * @param y1 y of the new point.
     */
    public void  setY(double y1) {
        this.y = y1;
    }

}
