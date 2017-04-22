package model.goods;

/**
 * File: Goods.java
 * Author: 13515063 - Kezia Suhendra
 */

public abstract class Goods implements Shoppable {
    protected int id;
    protected int price;

    public Goods(int id, int price) {
        this.id = id;
        this.price = price;
    }
}
