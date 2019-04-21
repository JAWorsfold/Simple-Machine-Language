package sml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LabelsTest {

  Labels labels;
  String labelOne;
  String labelTwo;
  String labelThree;

  @BeforeEach
  void setUp() {
    labels = new Labels();
    labelOne = "One";
    labelTwo = "Two";
    labelThree = "Three";
  }

  @AfterEach
  void tearDown() {
    labels = null;
  }

  /**
   * Test that addLabel adds the String and returns the index of the added String.
   */
  @Test
  void addLabel() {
    assertEquals(0, labels.addLabel(labelOne));
    assertEquals(1, labels.addLabel(labelTwo));
    assertEquals(2, labels.addLabel(labelThree));
  }

  @Test
  void indexOf() {
  }

  @Test
  void toStringTest() {
  }

  @Test
  void reset() {
  }
}