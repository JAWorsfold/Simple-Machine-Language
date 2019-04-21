package sml.instructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;

import static org.junit.jupiter.api.Assertions.*;

class SubInstructionTest {

  SubInstruction subInstructionOne;
  SubInstruction subInstructionTwo;
  SubInstruction subInstructionThree;
  SubInstruction subInstructionFour;
  String label = "l1";
  String opCode = "sub";
  int resultReg = 0;
  int register1 = 1;
  int register2 = 2;
  int register3 = 3;
  int value1 = 0;
  int value2 = -83;
  int value3 = 465;

  @BeforeEach
  void setUp() {
    subInstructionOne = new SubInstruction(label, resultReg, register1, register2);
    subInstructionTwo = new SubInstruction(label, resultReg, register2, register3);
    subInstructionThree = new SubInstruction(label, resultReg, register1, register3);
    subInstructionFour = new SubInstruction(label, resultReg, register2, register2);
  }

  @AfterEach
  void tearDown() {
    subInstructionOne = null;
    subInstructionTwo = null;
    subInstructionThree = null;
    subInstructionFour = null;
  }

  @Test
  void execute() {
    int expected;
    int actual;
    Machine machine = new Machine();
    machine.execute(); // initialise machine with empty registers
    machine.getRegisters().setRegister(register1, value1);
    machine.getRegisters().setRegister(register2, value2);
    machine.getRegisters().setRegister(register3, value3);
    subInstructionOne.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value1 - value2;
    assertEquals(expected, actual);
    subInstructionTwo.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value2 - value3;
    assertEquals(expected, actual);
    subInstructionThree.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value1 - value3;
    assertEquals(expected, actual);
    subInstructionFour.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value2 - value2;
    assertEquals(expected, actual);
  }

  @Test
  void toStringTest() {
    String startString = label + ": " + opCode + " ";
    String expected = startString + register1 + " - " + register2 + " to " + resultReg;
    assertEquals(expected, subInstructionOne.toString());
    expected = startString + register2 + " - " + register3 + " to " + resultReg;
    assertEquals(expected, subInstructionTwo.toString());
    expected = startString + register1 + " - " + register3 + " to " + resultReg;
    assertEquals(expected, subInstructionThree.toString());
    expected = startString + register2 + " - " + register2 + " to " + resultReg;
    assertEquals(expected, subInstructionFour.toString());
  }
}