package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: PotionTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class PotionTest {
  @Test
  void getId() {
    Potion p = new Potion();
    assertEquals(3, p.getId());
  }

  @Test
  void getPrice() {
    Potion p = new Potion();
    assertEquals(75, p.getPrice());
  }

  @Test
  void getDescription() {
    Potion p = new Potion();
    assertEquals("increase the current health points by one heart.", p.getDescription());
  }

}