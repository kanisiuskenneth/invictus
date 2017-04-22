package model.goods;

/**
 * File: SlowSpell.java
 * Author: 13515063 - Kezia Suhendra
 */

public class SlowSpell extends PowerUp {
    /**
     * Constructor
     */

    public SlowSpell() {
        super(10, 0);
    }
    /**
     * Getter id
     */

    public int getID() {
        return id;
    }
    /**
     * Getter price
     */

    public int getPrice() {
        return price;
    }
    /**
     *
     */

    public String getDescription() {
        return "decrease the speed of the words by 0.5.";
    }
}
