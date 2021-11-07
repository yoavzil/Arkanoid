import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 01/06/2017.
 */
public class Level1 implements LevelInformation {
    private double dt;

    /**
     *
     * @param dt
     */
    public Level1(double dt) {
        this.dt = dt;
    }
    /**
     * the number of balls in this level.
     *
     * @return the number.
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * creates a velocities list (used to create the balls) and return it.
     *
     * @return the list.
     */
    public List<Velocity> initialBallVelocities() {
        Velocity v = Velocity.fromAngleAndSpeed(0, 5 * this.dt * 60);
        List list = new ArrayList();
        list.add(v);
        return list;
    }

    /**
     * the speed of the paddle.
     *
     * @return the speed.
     */
    public int paddleSpeed() {
        return 5;
    }

    /**
     * the width of the paddle.
     *
     * @return the width.
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * the name of the level.
     *
     * @return the name (in a string).
     */
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * the Background of the level.
     *
     * @return the relevant Background (sprite).
     */
    public Sprite getBackground() {
        return new Background1();

    }

    /**
     * creates a list that contains the blocks of this level.
     *
     * @return the list.
     */
    public List<Block> blocks() {
        List list = new ArrayList();
        Point p = new Point(385, 150);
        Rectangle rectangle = new Rectangle(p, 30, 30);
        Block block = new Block(rectangle, Color.red, 1);
        list.add(block);
        return list;
    }

    /**
     * the number of blocks in this level.
     *
     * @return the number.
     */
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
