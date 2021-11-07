
import java.util.List;
/**
 * Created by Yoav Zilbertzan on 02/04/2017.
 */
//members
public class Line {
    private Point start;
    private Point end;

    /**
     * Construct a Line with 2 points.
     * @param start first Point.
     * @param end last Point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     *Construct a Line with 2 coordinates of start point and 2 coordinates of end point.
     * @param x1 relates to start point.
     * @param y1 relates to start point.
     * @param x2 relates to end point.
     * @param y2 relates to end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * Calculates the length of the line, using distance function from Point.
     * @return double, the length of the line.
     */
    public double length() {
        return (this.start.distance(this.end));
    }

    /**
     * calculates coordinates of the middle point of the line.
     * @return Point, the middle point of the line.
     */
    public Point middle() {
        Point mid = new Point(((this.start.getX() + (this.end.getX())) / 2),
                ((this.start().getY() + (this.end.getY())) / 2));
        return mid;
    }

    /**
     * give back the start point of the line.
     * @return Point, the start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * give back the end point of the line.
     * @return Point, the end point.
     */
    public Point end() {
        return this.end;
    }

    /**
     *creates the slop of the line.
     * @return the slop of the line.
     */
    public double slop() {
        return (this.end().getY() - this.start.getY()) / (this.end().getX() - this.start.getX());
    }


    /**
     * checks if 2 lines are intersecting.
     * @param p the other Line that we want to check intersection with.
     * @return boolean intercheck, return true if the lines are intersecting.
     */
    public boolean doesContainPoint(Point p) {
        boolean intercheck = false;
        double difx = Math.abs(this.start.getX() - this.end.getX());
        double minx = Math.min(this.start.getX(), this.end.getX());
        double dify = Math.abs(this.start.getY() - this.end.getY());
        double miny = Math.min(this.start.getY(), this.end.getY());
        if (p.getX() >= minx && p.getX() <= minx + difx && p.getY() >= miny && p.getY() <= miny + dify) {
            intercheck = true;
        }
        return intercheck;
    }

    /**
     *checks if this line and other line have an intersection point.
     * @param other the other line that we want to check intrsection with.
     * @return true if there is intersection point.
     */
    public boolean isIntersecting(Line other) {
        if (this.equals(other)) {
            return false;
        }
        double thisSlop = this.slop();
        double otherSlop = other.slop();

        if (thisSlop == otherSlop) {
            return false;
        }

        double thisB = (((-1) * thisSlop * this.start.getX()) + this.start.getY());
        double otherB = (((-1) * otherSlop * other.start.getX()) + other.start.getY());

        double x;
        double y;
        Point p;


        if (Double.isInfinite(otherSlop)) {
            x = other.start.getX();
            y = this.slop() * x + thisB;
        } else {
            if (Double.isInfinite(thisSlop)) {
                x = this.start.getX();
                y = other.slop() * x + otherB;
            } else {
                x = (thisB - otherB) / (otherSlop - thisSlop);
                y = thisSlop * x + thisB;
            }
        }
        p = new Point(x, y);
        return (this.doesContainPoint(p) && other.doesContainPoint(p));
    }
    /**
     * calculates the intersection point between 2 lines.
     * @param other the other line that intersect with this line.
     * @return Point inter, the intersection point.
     */

    public Point intersectionWith(Line other) {
        if (this.equals(other)) {
            return null;
        }
        double thisSlop = this.slop();
        double otherSlop = other.slop();

        if (thisSlop == otherSlop) {
            return null;
        }

        double thisB = (((-1) * thisSlop * this.start.getX()) + this.start.getY());
        double otherB = (((-1) * otherSlop * other.start.getX()) + other.start.getY());

        double x;
        double y;
        Point p;
        if (Double.isInfinite(otherSlop)) {
            x = other.start.getX();
            y = this.slop() * x + thisB;
        } else {
            if (Double.isInfinite(thisSlop)) {
                x = this.start.getX();
                y = other.slop() * x + otherB;
            } else {
                x = (thisB - otherB) / (otherSlop - thisSlop);
                y = thisSlop * x + thisB;
            }
        }

        p = new Point(x, y);

        if (this.doesContainPoint(p) && other.doesContainPoint(p)) {
            return p;
        }

        return null;

    }

    /**
     * checks if 2 line are equal (have the same points).
     * @param other the other line that we want to check.
     * @return boolean equalcheck, returns true if the lines are equals.
     */
    public boolean equals(Line other) {
        boolean equalcheck = false;
        if ((this.start().getX() == other.start().getX() && this.start().getY() == other.start().getY())
                && (this.end().getX() == other.end().getX() && this.end().getY() == other.end().getY())) {
            equalcheck = true;
        }
        return equalcheck;
    }

    /**
     *gives the closest intersection point.
     * @param rect the rectangle of the collidable.
     * @return closest collision point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line line = new Line(this.start, this.end);
        List list = rect.intersectionPoints(line);
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (Point) list.get(0);
        }
        if (list.size() == 2) {
            if (line.start().distance((Point) list.get(0)) < line.start().distance((Point) list.get(1))) {
                return (Point) list.get(0);
            }
            return (Point) list.get(1);
        }
        return null;
    }
}
