package model.goods;

/**
 * File: Shield.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas Shield
 */
public class Shield extends Items {
    /**
     * Constructor
     */

    public Shield() {
        super(14, 0);
    }
    /**
     * Getter id
     * @return id dari Shield
     */

    public int getID() {
        return id;
    }
    /**
     * Getter price
     * @return price dari Shield
     */

    public int getPrice() {
        return price;
    }
    /**
     * Getter description
     * @return description dari Shield
     */

    public String getDescription() {
        return "prevents the health points from reducing for 10 seconds.";
    }
    /**
     * Buy Shield
     * @param id
     */

    @Override
    public void buy(int id) {

    }
}
