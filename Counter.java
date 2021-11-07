/**
 * Created by user on 30/05/2017.
 */
public class Counter {
private int value;

    /**
     *construct a Counter with a given value.
     * @param value the given value.
     */
    public Counter(int value) {
    this.value = value;
}

    /**
     *increasing the value of the counter by a given number.
     * @param number the given number.
     */
    void increase(int number) {
        this.value = this.value + number;
    }

    /**
     *decreasing the value of the counter by a given number.
     * @param number the given number.
     */
    void decrease(int number) {
        this.value = this.value - number;
    }

    /**
     *returns the current value of the counter.
     * @return the current value.
     */

    int getValue() {
        return this.value;
    }
}
