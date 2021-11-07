import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 01/06/2017.
 */
public class Level3 implements LevelInformation {
    private double dt;

    /**
     *
     * @param dt
     */
    public Level3(double dt) {
        this.dt = dt;
    }
    /**
     * the number of balls in this level.
     *
     * @return the number.
     */
    public int numberOfBalls() {
        return 2;
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
        list.add(v);
        list.add(v1);
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
        return "Green 3";
    }

    /**
     * the Background of the level.
     *
     * @return the relevant Background (sprite).
     */
    public Sprite getBackground() {
        return new Background3();

    }

    /**
     * creates a list that contains the blocks of this level.
     *
     * @return the list.
     */
    public List<Block> blocks() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Point p = new Point(730 - (i * 50), 150);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.gray, 1);
            list.add(block);
        }
        for (int i = 0; i < 9; i++) {
            Point p = new Point(730 - (i * 50), 170);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.red, 1);
            list.add(block);
        }
        for (int i = 0; i < 8; i++) {
            Point p = new Point(730 - (i * 50), 190);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.yellow, 1);
            list.add(block);
        }
        for (int i = 0; i < 7; i++) {
            Point p = new Point(730 - (i * 50), 210);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.blue, 1);
            list.add(block);
        }
        for (int i = 0; i < 6; i++) {
            Point p = new Point(730 - (i * 50), 230);
            Rectangle rectangle = new Rectangle(p, 50, 20);
            Block block = new Block(rectangle, Color.white, 1);
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
        return 40;
    }
}
