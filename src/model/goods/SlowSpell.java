package model.goods;

/**
 * File: SlowSpell.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas SlowSpell
 */
public class SlowSpell extends Items {
    /**
     * Constructor
     */

    public SlowSpell() {
        super(10, 0);
    }
    /**
     * Getter id
     * @return id dari SlowSpell
     */

    public int getID() {
        return id;
    }
    /**
     * Getter price
     * @return price dari SlowSpell
     */

    public int getPrice() {
        return price;
    }
    /**
     * Getter description
     * @return description dari SlowSpell
     */

    public String getDescription() {
        return "decrease the speed of the words by 0.5.";
    }
    /**
     * Buy SlowSpell
     * @param id
     */

    @Override
    public void buy(int id) {

    }
}
