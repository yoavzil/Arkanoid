import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 01/06/2017.
 */
public class Level2 implements LevelInformation {
    private double dt;

    /**
     *
     * @param dt
     */
    public Level2(double dt) {
        this.dt = dt;
    }
    /**
     * the number of balls in this level.
     *
     * @return the number.
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * creates a velocities list (used to create the balls) and return it.
     *
     * @return the list.
     */
    public List<Velocity> initialBallVelocities() {
        List list = new ArrayList();
        for (int i = 1; i < 6; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(10 * i, 5 * this.dt * 60);
            list.add(v);
        }
        for (int i = 1; i < 6; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(360 - (10 * i), 5 * this.dt * 60);
            list.add(v);
        }
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
        return 500;
    }

    /**
     * the name of the level.
     *
     * @return the name (in a string).
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * the Background of the level.
     *
     * @return the relevant Background (sprite).
     */
    public Sprite getBackground() {
        return new Background2();

    }

    /**
     * creates a list that contains the blocks of this level.
     *
     * @return the list.
     */
    public List<Block> blocks() {
        List list = new ArrayList();
        for (int i = 0; i < 2; i++) {
            Point p = new Point(20 + (i * 50), 250);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.red, 1);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Point p = new Point(120 + (i * 50), 250);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.orange, 1);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Point p = new Point(220 + (i * 50), 250);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.yellow, 1);
            list.add(block);
        }
        for (int i = 0; i < 3; i++) {
            Point p = new Point(320 + (i * 50), 250);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.green, 1);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Point p = new Point(470 + (i * 50), 250);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.blue, 1);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Point p = new Point(570 + (i * 50), 250);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.pink, 1);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Point p = new Point(670 + (i * 50), 250);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.cyan, 1);
            list.add(block);
        }
        return list;
    }

    /**
     * the number of blocks in this level.
     *
     * @return the number.
     */
    public  int numberOfBlocksToRemove() {
        return 15;
    }
}
