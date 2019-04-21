package sml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistersTest {

  Registers registers;
  int regLength = 32;

  @BeforeEach
  void setUp() {
    registers = new Registers();
    int[] regValues = new int[regLength];
    int regInput = 2;
    for (int i = 0; i < 32; i++) {
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

  @Test
  void getRegister() {
    assertEquals(2, registers.getRegister(0));
    assertEquals(8, registers.getRegister(3));
    assertEquals(64, registers.getRegister(31));
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> { registers.getRegister(32); });
  }

  @Test
  void getRegisters() {
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