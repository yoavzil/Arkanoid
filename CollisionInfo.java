/**
 * Created by user on 04/05/2017.
 */
public class CollisionInfo {
    private Collidable collidable;
    private Line line;

    /**
     *constructor.
     * @param collidable the Collidable that we want to information about.
     * @param line a line that intersect with the collidable.
     */
    public CollisionInfo(Collidable collidable, Line line) {
        this.collidable = collidable;
        this.line = line;
    }

    /**
     *
     * @return the collision point.
     */
    public Point collisionPoint() {
        return line.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
    }

    /**
     *
     * @return the Collidable that we are talking about.
     */
    public Collidable collisionObject() {
        return collidable;
    }
}
