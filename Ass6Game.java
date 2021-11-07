import biuoop.KeyboardSensor;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by user on 15/05/2017.
 */
public class Ass6Game {
    /**
     * the main method of ass3.
     *
     * @param args a String which we don't use it.
     */
    public static void main(String[] args) {
        Counter score = new Counter(0);
        AnimationRunner runner = new AnimationRunner(score);
        File file = new File("highscores");
        HighScoresTable highScoresTable = HighScoresTable.loadFromFile(file);
        KeyboardSensor ks = runner.getGui().getKeyboardSensor();
        KeyPressStoppableAnimation highScoresAnimation = new KeyPressStoppableAnimation(ks, "space",
                new HighScoresAnimation(highScoresTable, "space", ks));
        GameFlow gameFlow = new GameFlow(runner, highScoresTable, ks);
        InputStreamReader levelsSets = new InputStreamReader(ClassLoader.getSystemClassLoader().
                getResourceAsStream("resources/level_sets.txt"));
        BufferedReader lnr = new BufferedReader(levelsSets);
        String line = null;
        GameFlowTask easy = null;
        GameFlowTask hard = null;
        GameFlowTask special = null;
        try {
            line = lnr.readLine();
        } catch (Exception e) {
            System.out.println("cannot read level sets file");
        }
        while (line != null) {

            if (line.startsWith("e:")) {
                try {
                    line = lnr.readLine();
                } catch (Exception e) {
                    System.out.println("cannot read level sets file");
                }
                easy = new GameFlowTask(gameFlow, line);
            }
            if (line.startsWith("h:")) {
                try {
                    line = lnr.readLine();
                } catch (Exception e) {
                    System.out.println("cannot read level sets file");
                }
                hard = new GameFlowTask(gameFlow, line);
            }
            if (line.startsWith("s:")) {
                try {
                    line = lnr.readLine();
                } catch (Exception e) {
                    System.out.println("cannot read level sets file");
                }
                special = new GameFlowTask(gameFlow, line);
            }
            try {
                line = lnr.readLine();
            } catch (Exception e) {
                System.out.println("cannot read level sets file");
            }

        }
        Task<Void> showHiScoresTask = new ShowHiScoresTask(runner, highScoresAnimation);
        Task<Void> quittask = new QuitTask(runner.getGui());
        Menu<Task<Void>> menu = new MenuAnimation<Task<Void>>("Arkanoid", "space", ks, runner);
        Menu<Task<Void>> subMenu = new MenuAnimation<Task<Void>>("levels dificulty", "space", ks, runner);
        subMenu.addSelection("e", "Easy", easy);
        subMenu.addSelection("h", "Hard", hard);
        subMenu.addSelection("l", "Lord of the rings", special);
        menu.addSelection("s", "to start a new game", (Task<Void>) subMenu);
        menu.addSelection("h", "for high scores", showHiScoresTask);
        menu.addSelection("q", "to quit", quittask);
        while (true) {
            runner.run(menu);
            // wait for user selection
            Task<Void> task = menu.getStatus();
            task.run();
            menu.reset();
        }
    }
}
