package sml.instructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;

import static org.junit.jupiter.api.Assertions.*;

class LinInstructionTest {

  LinInstruction linInstructionOne;
  LinInstruction linInstructionTwo;
  LinInstruction linInstructionThree;
  String label = "l1";
  String opCode = "lin";
  int register1 = 1;
  int register2 = 2;
  int register3 = 3;
  int value1 = 0;
  int value2 = -83;
  int value3 = 465;

  @BeforeEach
  void setUp() {
    linInstructionOne = new LinInstruction(label, register1, value1);
    linInstructionTwo = new LinInstruction(label, register2, value2);
    linInstructionThree = new LinInstruction(label, register3, value3);
  }

  @AfterEach
  void tearDown() {
    linInstructionOne = null;
    linInstructionTwo = null;
    linInstructionThree = null;
  }

  @Test
  void execute() {
    int expected;
    int actual;
    Machine machine = new Machine();
    machine.execute(); // initialise machine with empty registers
    linInstructionOne.execute(machine);
    actual = machine.getRegisters().getRegister(register1);
    expected = value1;
    assertEquals(expected, actual);
    linInstructionTwo.execute(machine);
    actual = machine.getRegisters().getRegister(register2);
    expected = value2;
    assertEquals(expected, actual);
    linInstructionThree.execute(machine);
    actual = machine.getRegisters().getRegister(register3);
    expected = value3;
    assertEquals(expected, actual);
  }

  @Test
  void toStringTest() {
    String startString = label + ": " + opCode + " register ";
    String expected = startString + register1 + " value is " + value1;
    assertEquals(expected, linInstructionOne.toString());
    expected = startString + register2 + " value is " + value2;
    assertEquals(expected, linInstructionTwo.toString());
    expected = startString + register3 + " value is " + value3;
    assertEquals(expected, linInstructionThree.toString());
  }
}