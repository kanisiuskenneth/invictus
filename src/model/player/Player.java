package model.player;

import model.main.MainModel;

/**
 * File: Player.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas Player
 */
public class Player {
    private int current_health;
    private int score;
    /**
     * Constructor
     */

    public Player() {
        current_health = MainModel.health_maximum;
        score = 0;
    }
    /**
     *  Mengurangi current health points player.
     */

    public void reducedHealth() {
        --current_health;
    }
}
