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

  /**
   * Test that indexOf returns the correct index of the provided String Label.
   */
  @Test
  void indexOf() {
    assertEquals(0, labels.indexOf("One"));
    assertEquals(1, labels.indexOf("Two"));
    assertEquals(2, labels.indexOf("Three"));
    assertEquals(-1, labels.indexOf("Floppy"));
  }

  /**
   * Test that toString returns the correct String of labels.
   */
  @Test
  void toStringTest() {
    String expect = "(One, Two, Three)";
    assertEquals(expect, labels.toString());
    labels.addLabel("Floppy");
    expect = "(One, Two, Three, Floppy)";
    assertEquals(expect, labels.toString());
  }

  /**
   * Test that reset does clear the lables using exsiting label methods.
   */
  @Test
  void reset() {
    assertNotEquals("()", labels.toString());
    assertNotEquals(labels.indexOf("One"), -1);
    labels.reset();
    assertEquals("()", labels.toString());
    assertEquals(labels.indexOf("One"), -1);
  }
}