package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: HealthUpgradeTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class HealthUpgradeTest {
  @Test
  void getId() {
    HealthUpgrade hu = new HealthUpgrade();
    assertEquals(8, hu.getId());
  }

  @Test
  void getPrice() {
    HealthUpgrade hu = new HealthUpgrade();
    assertEquals(90, hu.getPrice());
  }

  @Test
  void getDescription() {
    HealthUpgrade hu = new HealthUpgrade();
    assertEquals("increase the maximum of health points by one heart.", hu.getDescription());
  }

}