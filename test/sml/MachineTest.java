package sml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

  Machine machine;
  Machine anotherMachine;
  Registers registers;
  Registers anotherReg;
  int[] regValues;
  int regLength = 32;
  Labels labels;


  @BeforeEach
  void setUp() {
    machine = new Machine();
    anotherMachine = new Machine();
    registers = new Registers();
    anotherReg = new Registers();
    regValues = new int[regLength];
    int regInput = 2;
    for (int i = 0; i < regLength; i++) {
      regValues[i] = regInput;
      regInput += 2;
    }
    registers.setRegisters(regValues);
    machine.setRegisters(registers);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void main() {
  }

  @Test
  void toStringTest() {
  }

  @Test
  void execute() {
  }

  @Test
  void getLabels() {
  }

  @Test
  void setLabels() {
  }

  @Test
  void getProg() {
  }

  @Test
  void setProg() {
  }

  @Test
  void getRegisters() {
    assertEquals(registers, machine.getRegisters());
    assertEquals(2, machine.getRegisters().getRegister(0));
    machine.getRegisters().setRegister(31, -2);
    assertEquals(-2, machine.getRegisters().getRegister(31));
  }

  @Test
  void setRegisters() {
    for (int i = 0; i < 32; i++) {
      assertEquals(machine.getRegisters().getRegister(i), registers.getRegister(i));
    }
    assertTrue(machine.getRegisters().equals(registers));
    machine.setRegisters(anotherReg);
    assertFalse(machine.getRegisters().equals(registers));
    assertTrue(machine.getRegisters().equals(anotherReg));
  }

  @Test
  void getPc() {
  }

  @Test
  void setPc() {
  }

  @Test
  void equals() {
  }

  @Test
  void hashCodeTest() {
    assertNotEquals(machine.hashCode(), anotherMachine.hashCode());
    machine = anotherMachine;
    assertEquals(machine.hashCode(), anotherMachine.hashCode());
  }

  @Test
  void canEqual() {
    assertTrue(machine.canEqual(anotherMachine));
    assertFalse(machine.canEqual(registers));
  }
}