/**
 * Created by user on 03/05/2017.
 */
public interface Collidable {
    /**
     *get the borders of the Collidable.
     * @return this rectangle.
     */
    Rectangle getCollisionRectangle();
    /**
     * changing the velocity according to the hit.
     * @param hitter the hitting ball.
     * @param collisionPoint the point that the collision took place in.
     * @param currentVelocity the current velocity.
     * @return the new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
