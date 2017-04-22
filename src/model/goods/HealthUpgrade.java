package model.goods;

/**
 * File: HealthUpgrade.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas HealthUpgrade
 */
public class HealthUpgrade extends PowerUp {
    /**
     * Constructor
     */

    public HealthUpgrade() {
        super(20, 0);
    }
    /**
     * Getter id
     * @return id dari HealthUpgrade
     */

    public int getID() {
        return id;
    }
    /**
     * Getter price
     * @return price dari HealthUpgrade
     */

    public int getPrice() {
        return price;
    }
    /**
     * Getter description
     * @return description dari HealthUpgrade
     */

    public String getDescription() {
        return "increase the maximum of health points by one heart.";
    }
    /**
     * Buy HealthUpgrade
     * @param id
     */

    @Override
    public void buy(int id) {

    }
}