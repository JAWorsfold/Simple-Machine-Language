package sml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistersTest {

  Registers registers;
  int[] regValues;
  int regLength = 32;

  @BeforeEach
  void setUp() {
    registers = new Registers();
    regValues = new int[regLength];
    int regInput = 2;
    for (int i = 0; i < regLength; i++) {
      regValues[i] = regInput;
      regInput += 2;
    }
    registers.setRegisters(regValues);
  }

  @AfterEach
  void tearDown() {
    registers = null;
  }

  @Test
  void setRegister() {
  }

  /**
   * Test getRegisters for my register of multiples of two.
   * Assert that an ArrayIndexOutOfBoundsException is thrown if trying to access an index above 31.
   */
  @Test
  void getRegister() {
    assertEquals(2, registers.getRegister(0));
    assertEquals(8, registers.getRegister(3));
    assertEquals(64, registers.getRegister(31));
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> { registers.getRegister(32); });
  }

  /**
   * Get registers returns int array of my 'registers' array and assigns it to testGetReg.
   * Then tests that each index value in the new array is equal to those in regValues, in
   * which the values were initially copied.
   */
  @Test
  void getRegisters() {
    int[] testGetReg = registers.getRegisters();
    for (int i = 0; i < regLength; i++) {
      assertEquals(regValues[i], testGetReg[i]);
    }
  }

  @Test
  void setRegisters() {
  }

  @Test
  void equals() {
  }

  @Test
  void hashCodeTest() {
  }

  @Test
  void canEqual() {
  }

  @Test
  void toStringTest() {
  }
}