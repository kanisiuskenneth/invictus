package util;

/**
 * File: Pair.java
 * Author: 13515033 - Andika Kusuma
 */

/**
 * Kelas Pair Generik
 * @param <K> Class first value
 * @param <V> Class second value
 */
public class Pair<K,V> {
    public K first;
    public V second;

    /**
     * Constructor Pair dengan parameter
     * @param first first value untuk Pair
     * @param second second value untuk Pair
     */
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}
