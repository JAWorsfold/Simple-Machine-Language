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

  /**
   * Test setRegister by amending my existing registers array, then testing the new values.
   * Assert that an ArrayIndexOutOfBoundsException is thrown if trying to access an index above 31.
   */
  @Test
  void setRegister() {
    registers.setRegister(3, 33);
    registers.setRegister(31, 12345);
    assertEquals(33, registers.getRegister(3));
    assertEquals(12345, registers.getRegister(31));
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> { registers.setRegister(-1, 1); } );
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

  /**
   * Create a new array which is the reverse of regValues, then set registers to this new
   * array with setRegisters. Test that setRegisters worked by comparing array values.
   */
  @Test
  void setRegisters() {
    int[] reverseReg = new int[regLength];
    for (int i = 0; i < 32; i++) {
      reverseReg[i] = regValues[regLength - 1 - i];
    }
    registers.setRegisters(reverseReg);
    for (int i = 0; i < regLength; i++) {
      assertEquals(reverseReg[i], registers.getRegister(i));
    }
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

  /**
   * Built registers string using StringBuilder. Tested against the registers toString method.
   */
  @Test
  void toStringTest() {
    StringBuilder sb = new StringBuilder(" registers=[");
    for (int i = 0; i < regLength - 1; i++) {
      sb.append(registers.getRegister(i));
      sb.append(", ");
    }
    sb.append(registers.getRegister(regLength - 1));
    sb.append("]");
    assertEquals(sb.toString(), registers.toString());
  }
}