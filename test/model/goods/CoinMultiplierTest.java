package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: CoinMultiPlierTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class CoinMultiplierTest {
  @Test
  void getId() {
    CoinMultiplier cm = new CoinMultiplier();
    assertEquals(6, cm.getId());
  }

  @Test
  void getPrice() {
    CoinMultiplier cm = new CoinMultiplier();
    assertEquals(100, cm.getPrice());
  }

  @Test
  void getDescription() {
    CoinMultiplier cm = new CoinMultiplier();
    assertEquals("increase the coins multiplier by 0.1 from the base multiplier.", cm.getDescription());
  }
}