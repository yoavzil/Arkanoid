import biuoop.GUI;
/**
 * Created by user on 22/06/2017.
 */
public class QuitTask implements Task<Void> {
    private GUI gui;
    /**
     * construct an ExitTask from a given GUI object.
     * @param gui the given GUI.
     */
    public QuitTask(GUI gui) {
        this.gui = gui;
    }
    /**
     * this method runs this task.
     * @return unimplemented option.
     */
    public Void run() {
        this.gui.close();
        System.exit(0);
        return null;
    }
}
