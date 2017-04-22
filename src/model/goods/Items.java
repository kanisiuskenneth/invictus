package model.goods;

/**
 * File: Items.java
 * Author: 13515070 - Sylvia Juliana
 */

public abstract class Items extends Goods {
    /**
     * Constructor
     */

    public Items(int id, int price) {
        super(id, price);
    }
    /**
     *
     */

    public String getDescription() {
        return "";
    }
}