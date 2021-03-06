package sml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RegistersTest {

  Registers registers;
  Registers otherReg;
  int[] regValues;
  int regLength = 32;

  @BeforeEach
  void setUp() {
    registers = new Registers();
    otherReg = new Registers();
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

  /**
   * Created a new Registers object otherReg and set it with the same values as 'registers'.
   * Tested that they are equal and various other cases were they are and aren't equal.
   */
  @Test
  void equals() {
    assertFalse(registers.equals(otherReg));
    otherReg.setRegisters(regValues);
    assertTrue(registers.equals(otherReg));
    assertTrue(registers.equals(registers));
    otherReg.setRegister(0, 0);
    assertFalse(registers.equals(otherReg));

  }

  /**
   * Created a hascode 'result' from registers in the same way as the hashCode method.
   * Tested equality between 'result' and registers hashCode. Also tested against
   * otherReg.
   */
  @Test
  void hashCodeTest() {
    int hashCode = Arrays.hashCode(registers.getRegisters());
    int prime = 59;
    int result = 1;
    result = result * prime + hashCode;
    assertEquals(result, registers.hashCode());
    assertNotEquals(registers.hashCode(), otherReg.hashCode());
    otherReg = registers;
    assertEquals(registers.hashCode(), otherReg.hashCode());
  }

  /**
   * Created new Registers object to test canEqual. Tested new registers object,
   * registers itself, and against another object.
   */
  @Test
  void canEqual() {
    Registers otherRegs = new Registers();
    assertTrue(registers.canEqual(otherRegs));
    assertFalse(registers.canEqual(regValues));
    assertTrue(registers.canEqual(registers));
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