/**
 * Created by user on 21/06/2017.
 */

/**
 *
 * @param <T> a general type.
 */
public interface Menu<T> extends Animation {
    /**
     * adding a selection to the menu.
     * @param key the key.
     * @param message the printed massage.
     * @param returnVal the task that we want to comit.
     */
    void addSelection(String key, String message, T returnVal);

    /**
     *
     * @return the status.
     */
    T getStatus();

    /**
     *adding a sub menu to the main menu.
     * @param key the key.
     * @param message the massage.
     * @param subMenu the action that we want to comit.
     */
    void addSubMenu(String key, String message, Menu<T> subMenu);
}
