package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
class CoinMultiplierTest {
  @Test
  void getId() {
    CoinMultiplier cm = new CoinMultiplier();
    assertEquals(20, cm.getId());
  }

  @Test
  void getPrice() {
    CoinMultiplier cm = new CoinMultiplier();
    assertEquals(0, cm.getPrice());
  }

  @Test
  void getDescription() {
    CoinMultiplier cm = new CoinMultiplier();
    assertEquals("increase the coins multiplier by 0.1 from the base multiplier.", cm.getDescription());
  }

  @Test
  void buy() {

  }

}