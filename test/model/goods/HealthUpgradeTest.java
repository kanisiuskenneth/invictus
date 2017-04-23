package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
class HealthUpgradeTest {
  @Test
  void getId() {
    HealthUpgrade hu = new HealthUpgrade();
    assertEquals(22, hu.getId());
  }

  @Test
  void getPrice() {
    HealthUpgrade hu = new HealthUpgrade();
    assertEquals(0, hu.getPrice());
  }

  @Test
  void getDescription() {
    HealthUpgrade hu = new HealthUpgrade();
    assertEquals("increase the maximum of health points by one heart.", hu.getDescription());
  }

  @Test
  void buy() {

  }

}