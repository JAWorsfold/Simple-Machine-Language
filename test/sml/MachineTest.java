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
    anotherReg = new Registers();

    // Set registers
    registers = new Registers();
    regValues = new int[regLength];
    int regInput = 2;
    for (int i = 0; i < regLength; i++) {
      regValues[i] = regInput;
      regInput += 2;
    }
    registers.setRegisters(regValues);
    machine.setRegisters(registers);

    // Set labels
    labels = new Labels();
    labels.addLabel("One");
    labels.addLabel("Two");
    labels.addLabel("Three");
    machine.setLabels(labels);

    // Set

  }

  @AfterEach
  void tearDown() {
    machine = null;
    anotherMachine = null;
    registers = null;
    anotherReg = null;
    labels = null;
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
    assertEquals(labels, machine.getLabels());
    assertEquals(0, machine.getLabels().indexOf("One"));
    assertEquals(2, machine.getLabels().indexOf("Three"));
  }

  @Test
  void setLabels() {
    assertEquals(labels, machine.getLabels());
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
  void setPcGetPc() {
    assertEquals(0, machine.getPc());
    machine.setPc(3);
    assertEquals(3, machine.getPc());
    machine.setPc(33);
    assertEquals(33, machine.getPc());
    machine.setPc(-13);
    assertEquals(-13, machine.getPc());
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