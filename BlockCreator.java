/**
 * Created by user on 23/06/2017.
 */
public interface BlockCreator {
    /**
     *
     * @param xpos coordinates.
     * @param ypos coordinates.
     * @return the created block.
     */
    Block create(int xpos, int ypos);
}
