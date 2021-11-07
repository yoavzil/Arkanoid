import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15/05/2017.
 */
public class Ass5Game {
    /**
     * checks if the string is a number or not.
     *
     * @param str the string.
     * @return true or false.
     */
    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * the main method of ass3.
     *
     * @param args a String which we don't use it.
     */
    public static void main(String[] args) {
        Counter score = new Counter(0);
        AnimationRunner runner = new AnimationRunner(score);
        List list = new ArrayList();
        Level1 level1 = new Level1(runner.getDt());
        Level2 level2 = new Level2(runner.getDt());
        Level3 level3 = new Level3(runner.getDt());
        Level4 level4 = new Level4(runner.getDt());
        Ass5Game ass5Game = new Ass5Game();
        if (args.length != 0) {
            for (String s : args) {
                if (ass5Game.isNumeric(s)) {
                    if (Integer.parseInt(s) == 1) {
                        list.add(level1);
                    }
                    if (Integer.parseInt(s) == 2) {
                        list.add(level2);
                    }
                    if (Integer.parseInt(s) == 3) {
                        list.add(level3);
                    }
                    if (Integer.parseInt(s) == 4) {
                        list.add(level4);
                    }
                }
            }
        } else {
            list.add(level1);
            list.add(level2);
            list.add(level3);
            list.add(level4);
        }
        GameFlow gameFlow = new GameFlow(runner);
        try {
            gameFlow.runLevels(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
