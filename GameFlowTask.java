import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by user on 22/06/2017.
 */
public class GameFlowTask implements Task<Void> {
    private GameFlow gameFlow;
    private List<LevelInformation> list;
    private String path;

    /**
     *@param path the path to the file.
     * @param gameFlow a gameflow.
     */
    public GameFlowTask(GameFlow gameFlow, String path) {
        this.gameFlow = gameFlow;
        this.path = path;
        this.list = null;

    }

    /**
     *
     * @return null n.
     */
    public Void run() {
        try {
            try {
                this.list = LevelSpecificationReader.fromReader(new InputStreamReader(
                        ClassLoader.getSystemClassLoader().
                                getResourceAsStream(this.path)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gameFlow.runLevels(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
