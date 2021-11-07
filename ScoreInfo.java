import java.io.Serializable;

/**
 * Created by user on 08/06/2017.
 */
public class ScoreInfo implements Serializable {
    private String name;
    private int score;

    /**
     *
     * @param name the player's name.
     * @param score the player's score.
     */
    public ScoreInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     *
     * @return this name.
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return this score.
     */
    public int getScore() {
        return this.score;
    }
}
