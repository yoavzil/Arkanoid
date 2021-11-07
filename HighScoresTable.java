import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08/06/2017.
 */
public class HighScoresTable implements Serializable {
   private int size;
   private List<ScoreInfo> list = new ArrayList<>();

    /**
     *constructor.
     * @param size tabke size.
     */
    public HighScoresTable(int size) {
        this.size = size;
    }

    /**
     *adding score to the table.
     * @param score the score.
     */
    public void add(ScoreInfo score) {
        int rank = getRank(score.getScore());
        if (rank > this.size) {
            return;
        }
        while (this.list.size() > this.size) {
            this.list.remove(this.list.size() - 1);
        }
        this.list.add(rank - 1, score);
    }

    /**
     *
     * @return this size.
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return the HighScores list.
     */
    public List<ScoreInfo> getHighScores() {
        return this.list;
    }

    /**
     *return the rank of the given score.
     * @param score the given score.
     * @return the rank.
     */
    public int getRank(int score) {
        int i;
        for (i = 0; i < this.list.size(); i++) {
            if (score > this.list.get(i).getScore()) {
                break;
            }
        }
        return i + 1;
    }

    /**
     *
     */
    public void clear() {
        this.list.clear();
    }

    /**
     * loading from the file.
     * @param filename the filename.
     * @throws IOException exeption.
     */
    public void load(File filename) throws IOException {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            HighScoresTable highScoresTable;
            highScoresTable = (HighScoresTable) objectInputStream.readObject();
            this.list = highScoresTable.list;
            this.size = highScoresTable.size;
        } catch (ClassNotFoundException e) {
            System.err.println("Unable to find class for object in file: "
                    + filename);
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find file: " + filename);
            HighScoresTable emptyTable = new HighScoresTable(5);
            emptyTable.save(filename);
            this.list = emptyTable.list;
            this.size = emptyTable.size;
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Failed closing file: "
                        + filename);
            }
        }
    }

    /**
     * saving the table to a given file.
     * @param filename the file.
     * @throws IOException exeption.
     */
    public void save(File filename) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filename));
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            System.err.println("Failed saving object");
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Failed closing file: "
                        + filename.getName());
            }
        }
    }

    /**
     * loading a table from file, or return empty table.
     * @param filename the file.
     * @return the HighScoresTable.
     */
    public static HighScoresTable loadFromFile(File filename) {
        HighScoresTable emptyTable = new HighScoresTable(5);
        try {
            if (!filename.exists()) {
                return emptyTable;
            }
            emptyTable.load(filename);
        } catch (IOException e) {
            System.err.println("Failed closing file: " + filename);
            return new HighScoresTable(5);
        }
        return emptyTable;
    }

    /**
     *
     * @return this list.
     */
    public List<ScoreInfo> getList() {
        return this.list;
    }
}
