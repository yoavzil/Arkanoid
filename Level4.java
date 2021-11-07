import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 01/06/2017.
 */
public class Level4 implements LevelInformation {
    private double dt;

    /**
     *
     * @param dt
     */
    public Level4(double dt) {
        this.dt = dt;
    }
    /**
     * the number of balls in this level.
     *
     * @return the number.
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * creates a velocities list (used to create the balls) and return it.
     *
     * @return the list.
     */
    public List<Velocity> initialBallVelocities() {
        List list = new ArrayList();
        Velocity v = Velocity.fromAngleAndSpeed(30, 5 * this.dt * 60);
        Velocity v1 = Velocity.fromAngleAndSpeed(320, 5 * this.dt * 60);
        Velocity v2 = Velocity.fromAngleAndSpeed(0, 5 * this.dt * 60);
        list.add(v);
        list.add(v1);
        list.add(v2);
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
        return "Final Four";
    }

    /**
     * the Background of the level.
     *
     * @return the relevant Background (sprite).
     */
    public Sprite getBackground() {
        return new Background4();

    }

    /**
     * creates a list that contains the blocks of this level.
     *
     * @return the list.
     */
    public List<Block> blocks() {
        List list = new ArrayList();
        for (int i = 0; i < 15; i++) {
            Point p = new Point(730 - (i * 50), 100);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.gray, 1);
            list.add(block);
        }
        for (int i = 0; i < 15; i++) {
            Point p = new Point(730 - (i * 50), 120);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.red, 1);
            list.add(block);
        }
        for (int i = 0; i < 15; i++) {
            Point p = new Point(730 - (i * 50), 140);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.yellow, 1);
            list.add(block);
        }
        for (int i = 0; i < 15; i++) {
            Point p = new Point(730 - (i * 50), 160);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.green, 1);
            list.add(block);
        }
        for (int i = 0; i < 15; i++) {
            Point p = new Point(730 - (i * 50), 180);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.white, 1);
            list.add(block);
        }
        for (int i = 0; i < 15; i++) {
            Point p = new Point(730 - (i * 50), 200);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.pink, 1);
            list.add(block);
        }
        for (int i = 0; i < 15; i++) {
            Point p = new Point(730 - (i * 50), 220);
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
        return 105;
    }
}
