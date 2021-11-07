import java.awt.Color;
import biuoop.DrawSurface;
/**
 * Created by user on 12/05/2017.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private biuoop.KeyboardSensor keyboard;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private Counter lifes;
    private AnimationRunner runner;
    private LevelInformation li;

    /**
     * construct a GameLevel with runner, score, lifes, li and keyboard.
     * @param runner the AnimationRunner to run the animation.
     * @param score the score counter of the game.
     * @param lifes the lives counter of the game.
     * @param li LevelInformation, the relevant information of the current level.
     * @param keyboard KeyboardSensor.
     */
    public GameLevel(AnimationRunner runner, Counter score,
                     Counter lifes, LevelInformation li,
                     biuoop.KeyboardSensor keyboard) {
        this.runner = runner;
        this.li = li;
        this.keyboard = keyboard;
        this.remainingBlocks = new Counter(this.li.numberOfBlocksToRemove());
        this.remainingBalls = new Counter(0);
        this.score = runner.getScore();
        this.lifes = lifes;
    }

    /**
     * adding collidables to game environment's list.
     * @param c a collidable to add to game environment.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
    *adding sprite to sprite collection's list.
     * @param s a sprite to add to sprite collection.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     *initializing the game's set ups.
     */
    public void initialize() {
        Point p1 = new Point(0, 2);
        Point p2 = new Point(798, 2);
        Point p3 = new Point(-100, 620);
        Point p4 = new Point(0, 2);

        Rectangle rectangle1 = new Rectangle(p1, 800, 20);
        Rectangle rectangle2 = new Rectangle(p2, 2, 600);
        Rectangle rectangle3 = new Rectangle(p3, 1000, 10);
        Rectangle rectangle4 = new Rectangle(p4, 2, 600);

        Block block1 = new Block(rectangle1);
        Block block2 = new Block(rectangle2);
        Block deathRegion = new Block(rectangle3);
        Block block4 = new Block(rectangle4);
        this.li.getBackground().addToGame(this);
        block1.addToGame(this);
        block2.addToGame(this);
        block4.addToGame(this);
        deathRegion.addToGame(this);

        HitListener hitListener = new BallRemover(this, this.remainingBalls);
        HitListener hl = new BlockRemover(this, this.remainingBlocks);
        HitListener hls = new ScoreTrackingListener(this.score);
        deathRegion.addHitListener(hitListener);
        for (Block i: this.li.blocks()) {
            i.addToGame(this);
            i.addHitListener(hls);
            i.addHitListener(hl);
        }

    }

    /**
     * running one turn of the game.
     */
    public void playOneTurn() {
        for (int i = 0; i < this.li.numberOfBalls(); i++) {
            addBallToGame(this.li.initialBallVelocities().get(i), this.remainingBalls);
        }
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.runner.run(this);
        if (this.remainingBlocks.getValue() <= 0) {
            this.score.increase(100);
        }
        if (this.remainingBlocks.getValue() > 0) {
            this.lifes.decrease(1);
        }
    }

    /**
     *removes a Collidable from the game.
     * @param c the Collidable.
     */
    public void removeCollidable(Collidable c) {
        for (int i = 0; i < this.environment.getList().size(); i++) {
            if (c == this.environment.getList().get(i)) {
                this.environment.getList().remove(i);
            }
        }
    }

    /**
     *removes a Sprite from the game.
     * @param s the Sprite.
     */
    public void removeSprite(Sprite s) {
        for (int i = 0; i < this.sprites.getList().size(); i++) {
            if (s == this.sprites.getList().get(i)) {
                this.sprites.getList().remove(i);
            }
        }
    }

    /**
     *adding new balls to the game.
     * @param v the ball's velocity.
     * @param remainingBall the ball counter, in order update the counter when adding a new ball.
     */
    public void addBallToGame(Velocity v, Counter remainingBall) {
        Ball ball = new Ball(400, 560, 5, Color.white, this.environment);
        ball.setVelocity(v);
        ball.addToGame(this);
        this.remainingBalls.increase(1);
    }

    /**
     * the stopping condition of this animation.
     * @return true or false.
     */
    public boolean shouldStop() {
        if (this.remainingBlocks.getValue() != 0
                && this.remainingBalls.getValue() != 0) {
            return true;
        }
        return false;
    }

    /**
     * drawing one frame of the GameLevel animation.
     * @param d the surface that we draw on.
     *          @param dt dt.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed(dt);
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard,
                    "space", new PauseScreen(this.keyboard,
                    this.sprites)));
        }
    }

    /**
     * returns RemainingBlocks.
     * @return RemainingBlocks.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * returns Li.
     * @return Li.
     */
    public LevelInformation getLi() {
        return this.li;
    }

    /**
     * returns sprites.
     * @return sprites.
     */
    public SpriteCollection getSprites() {
        return this.sprites;
    }
    /**
     *
     */
    public void reset() {
    }
}
