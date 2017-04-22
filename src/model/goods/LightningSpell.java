package model.goods;

/**
 * File: LightningSpell.java
 * Author: 13515070 - Sylvia Juliana
 */

/**
 * Kelas LightningSpell
 */
public class LightningSpell extends Items {
    /**
     * Constructor
     */

    public LightningSpell() {
        super(13, 0);
    }
    /**
     * Getter id
     * @return id dari LightningSpell
     */

    public int getID() {
        return id;
    }
    /**
     * Getter price
     * @return price dari LightningSpell
     */

    public int getPrice() {
        return price;
    }
    /**
     * Getter description
     * @return description dari LightningSpell
     */

    public String getDescription() {
        return "destroy all of the words on the screen.";
    }
    /**
     * Buy LightningSpell
     * @param id
     */

    @Override
    public void buy(int id) {

    }
}
