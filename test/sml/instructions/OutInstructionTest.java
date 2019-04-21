package sml.instructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;

import static org.junit.jupiter.api.Assertions.*;

class OutInstructionTest {

  OutInstruction outInstructionOne;
  OutInstruction outInstructionTwo;
  OutInstruction outInstructionThree;
  String label = "l1";
  String opCode = "out";
  int register1 = 1;
  int register2 = 2;
  int register3 = 3;
  int value1 = 0;
  int value2 = -83;
  int value3 = 465;

  @BeforeEach
  void setUp() {
    outInstructionOne = new OutInstruction(label, register1);
    outInstructionTwo = new OutInstruction(label, register2);
    outInstructionThree = new OutInstruction(label, register3);
  }

  @AfterEach
  void tearDown() {
    outInstructionOne = null;
    outInstructionTwo = null;
    outInstructionThree = null;
  }

  @Test
  void execute() {
    int expected;
    int actual;
    Machine machine = new Machine();
    machine.execute();
    machine.getRegisters().setRegister(register1, value1);
    outInstructionOne.execute(machine);
    actual = outInstructionOne.getRegisterContents();
    expected = value1;
    assertEquals(expected, actual);
    machine.getRegisters().setRegister(register2, value2);
    outInstructionTwo.execute(machine);
    actual = outInstructionTwo.getRegisterContents();
    expected = value2;
    assertEquals(expected, actual);
    machine.getRegisters().setRegister(register3, value3);
    outInstructionThree.execute(machine);
    actual = outInstructionThree.getRegisterContents();
    expected = value3;
    assertEquals(expected, actual);
  }

  @Test
  void toStringTest() {
    String startString = label + ": " + opCode + " register ";
    String expected = startString + register1 + " contents are " + value1;
    assertEquals(expected, outInstructionOne.toString());
    expected = startString + register2 + " contents are " + value1;
    assertEquals(expected, outInstructionTwo.toString());
    expected = startString + register3 + " contents are " + value1;
    assertEquals(expected, outInstructionThree.toString());
  }
}