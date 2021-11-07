import java.util.ArrayList;
import java.util.List;
/**
 * Created by user on 04/05/2017.
 */
public class GameEnvironment {
    private List list = new ArrayList();

    /**
     *get this list.
     * @return this list.
     */
    public List getList() {
    return this.list;
}
    /**
     * adding collidables to game environment's list.
     * @param c a collidable to add to game environment.
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }

    /**
     *checking if there is an intersection with a collidable and return the collisionInfo of that collidable.
     * @param trajectory the line that we check intersection with.
     * @return collisionInfo of the collidable that we have intersection with.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        for (int i = 0; i < list.size(); i++) {
            Collidable coll = (Collidable) list.get(i);
            if (trajectory.closestIntersectionToStartOfLine(coll.getCollisionRectangle()) != null) {
                CollisionInfo collisionInfo = new CollisionInfo(coll, trajectory);
                return collisionInfo;
            }
        }
        return null;
    }
}
