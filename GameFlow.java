import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;

import biuoop.DialogManager;
import biuoop.KeyboardSensor;

/**
 * Created by user on 02/06/2017.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter score;
    private Counter lifes;
    private HighScoresTable highScoresTable;
    private File file;

    /**
     * constructing a GameFlow with given ar.
     *
     * @param ar AnimationRunner, the platform to run the animation.
     * @param highScoresTable the highScoresTable.
     * @param ks the ks.
     */
    public GameFlow(AnimationRunner ar, HighScoresTable highScoresTable, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.score = this.ar.getScore();
        this.lifes = new Counter(7);
        this.highScoresTable = highScoresTable;
        this.file = new File("highscores");
    }

    /**
     * running the game with a given Levels list, using new GameLevel for each level.
     *
     * @param levels the Levels list.
     * @exception IOException exeption.
     */
    public void runLevels(List<LevelInformation> levels) throws IOException {
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(this.ar, score, lifes, levelInfo, ks);

            level.initialize();
            ScoreIndicator scoreIn = new ScoreIndicator(this.score);
            scoreIn.addToGame(level);
            LevelName levelName = new LevelName(levelInfo.levelName());
            levelName.addToGame(level);
            Point p5 = new Point(400 - (levelInfo.paddleWidth() / 2), 570);
            Point p6 = new Point(20, 20);
            Rectangle rectangle5 = new Rectangle(p5, levelInfo.paddleWidth(), 15);
            Rectangle rectangle6 = new Rectangle(p6, 760, 580);
            Paddle paddle = new Paddle(ks, ar.getGui(), rectangle5, rectangle6, Color.yellow, levelInfo.paddleSpeed());
            paddle.addToGame(level);
            LivesIndicator livesin = new LivesIndicator(this.lifes);
            livesin.addToGame(level);

            while (level.getRemainingBlocks().getValue() != 0
                    && this.lifes.getValue() != 0) {
                level.playOneTurn();
                livesin.setLifes(this.lifes);
                paddle.getCollisionRectangle().getUpperLeft().setX(400 - (levelInfo.paddleWidth() / 2));
            }
        }
        if (this.lifes.getValue() == 0) {
            KeyPressStoppableAnimation lose = new KeyPressStoppableAnimation(ks, "space",
                    new EndScreen(ks, false, score));
            ar.run(lose);
        }
        if (this.lifes.getValue() != 0) {
            KeyPressStoppableAnimation win = new KeyPressStoppableAnimation(ks, "space",
                    new EndScreen(ks, true, score));
            ar.run(win);
        }
        if (highScoresTable.getRank(this.score.getValue())
                <= highScoresTable.getSize()) {
            DialogManager dialog = this.ar.getGui().getDialogManager();
            String name =
                    dialog.showQuestionDialog("Name", "What is your name?", "");
            ScoreInfo scoreInfo = new ScoreInfo(name, this.score.getValue());
            highScoresTable.add(scoreInfo);
        }
            KeyPressStoppableAnimation highScoresAnimation = new KeyPressStoppableAnimation(ks, "space",
                    new HighScoresAnimation(highScoresTable, "space", this.ks));
            ar.run(highScoresAnimation);
            highScoresTable.save(file);
            this.lifes = new Counter(7);
            this.ar.setScore(new Counter(0));
            this.score = this.ar.getScore();
    }
}
