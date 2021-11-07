import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Yoav Zilbertzan on 07/04/2017.
 */
public class Rectangle {
    //members.
    private  Point upperLeft;
    private double minX;
    private double minY;
    private double maxX;
    private double maxY;
    private double width;
    private double height;
    private java.awt.Color color;

    /**
     * construct a square with 4 coordinates as well as color.
     * @param minX x of the uper left corner.
     * @param minY y of the uper left corner.
     * @param maxX x of the lower right corner.
     * @param maxY y of the lower right corner.
     * @param color color of the square.
     */
    public Rectangle(double minX, double minY, double maxX, double maxY, java.awt.Color color) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.color = color;
    }

    /**
     * construct a Rectangle using upperLeft point, width and height.
     * @param upperLeft the upper left point of the Rectangle.
     * @param width the width of the Rectangle.
     * @param height the height of the Rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * gives back the x of the uper left corner.
     * @return minx, x of the uper left corner.
     */
    public double getMinX() {
        return this.minX;
    }

    /**
     * gives back the y of the uper left corner.
     * @return miny, y of the uper left corner.
     */
    public double getMinY() {
        return this.minY;
    }

    /**
     * gives back the x of the lower right corner.
     * @return maxx, x of the lower right corner.
     */
    public double getMaxX() {
        return this.maxX;
    }

    /**
     * gives back the y of the lower right corner.
     * @return maxy, y of the lower right corner.
     */
    public double getMaxY() {
        return this.maxY;
    }

    /**
     *get width value.
     * @return this width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     *get height value.
     * @return this height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     *get UpperLeft value.
     * @return this UpperLeft.
     */
    public Point getUpperLeft() {
        return  this.upperLeft;
    }



    /**
     *draws a square on the DrawSurface object.
     * @param surface the place wich the drawing take place.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        int minx = (int) this.getMinX();
        int miny = (int) this.getMinY();
        int maxx = (int) this.getMaxX();
        int maxy = (int) this.getMaxY();
        surface.fillRectangle(minx, miny, maxx - minx, maxy - miny);
    }

    /**
     *draws a square on the DrawSurface object.
     * @param surface the place wich the drawing take place.
     */
    public void drawOn2(DrawSurface surface) {
        surface.setColor(this.color);
        int minx = (int) this.upperLeft.getX();
        int miny = (int) this.upperLeft.getY();
        int width1 = (int) this.width;
        int height1 = (int) this.height;
        surface.fillRectangle(minx, miny, width1, height1);
    }

    /**
     *
     * @param line the line that intersecting the rectangle.
     * @return a list of intersection points.
     */
    public java.util.List intersectionPoints(Line line) {
        List interlist = new ArrayList();
        Line line1 = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Line line2 = new Line(this.upperLeft.getX() + this.width, this.upperLeft.getY(),
                this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        Line line3 = new Line(this.upperLeft.getX() + this.width,
                this.upperLeft.getY() + this.height, this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Line line4 = new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.height,
                this.upperLeft.getX(), this.upperLeft.getY());
        if (line1.isIntersecting(line)) {
            interlist.add(line1.intersectionWith(line));
        }
        if (line2.isIntersecting(line)) {
            interlist.add(line2.intersectionWith(line));
        }
        if (line3.isIntersecting(line)) {
            interlist.add(line3.intersectionWith(line));
        }
        if (line4.isIntersecting(line)) {
            interlist.add(line4.intersectionWith(line));
        }
        return interlist;

    }
}
