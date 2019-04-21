package sml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.instructions.AddInstruction;
import sml.instructions.LinInstruction;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

  Machine machine;
  Machine anotherMachine;
  Registers registers;
  Registers anotherReg;
  Instruction addInstruction;
  Instruction linInstruction;
  ArrayList<Instruction> instructions;
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

    // Set prog
    addInstruction = new AddInstruction("l1", 0, 1, 2);
    linInstruction = new LinInstruction("l2", 0, 1);
    instructions = new ArrayList<>();
    instructions.add(addInstruction);
    instructions.add(linInstruction);
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
    machine.setProg(instructions);
    assertEquals(addInstruction, machine.getProg().get(0));
    assertEquals(linInstruction, machine.getProg().get(1));
  }

  @Test
  void setProg() {
    machine.setProg(instructions);
    assertEquals(instructions, machine.getProg());
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