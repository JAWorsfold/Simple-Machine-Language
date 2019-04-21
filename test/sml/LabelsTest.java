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
    labels.addLabel(labelOne);
    labels.addLabel(labelTwo);
    labels.addLabel(labelThree);
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
    assertEquals(3, labels.addLabel("Four"));
    assertEquals(4, labels.addLabel("Five"));
    assertEquals(5, labels.addLabel("Six"));
  }

  @Test
  void indexOf() {
    assertEquals(0, labels.indexOf("One"));
    assertEquals(1, labels.indexOf("Two"));
    assertEquals(2, labels.indexOf("Three"));
  }

  @Test
  void toStringTest() {
  }

  @Test
  void reset() {
  }
}