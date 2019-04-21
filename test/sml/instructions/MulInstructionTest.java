package sml.instructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;

import static org.junit.jupiter.api.Assertions.*;

class MulInstructionTest {

  MulInstruction mulInstructionOne;
  MulInstruction mulInstructionTwo;
  MulInstruction mulInstructionThree;
  MulInstruction mulInstructionFour;
  String label = "l1";
  String opCode = "mul";
  int resultReg = 0;
  int register1 = 1;
  int register2 = 2;
  int register3 = 3;
  int value1 = 0;
  int value2 = -83;
  int value3 = 465;

  @BeforeEach
  void setUp() {
    mulInstructionOne = new MulInstruction(label, resultReg, register1, register2);
    mulInstructionTwo = new MulInstruction(label, resultReg, register2, register3);
    mulInstructionThree = new MulInstruction(label, resultReg, register1, register3);
    mulInstructionFour = new MulInstruction(label, resultReg, register2, register2);
  }

  @AfterEach
  void tearDown() {
    mulInstructionOne = null;
    mulInstructionTwo = null;
    mulInstructionThree = null;
    mulInstructionFour = null;
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
    mulInstructionOne.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value1 * value2;
    assertEquals(expected, actual);
    mulInstructionTwo.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value2 * value3;
    assertEquals(expected, actual);
    mulInstructionThree.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value1 * value3;
    assertEquals(expected, actual);
    mulInstructionFour.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value2 * value2;
    assertEquals(expected, actual);
  }

  @Test
  void toStringTest() {
    String startString = label + ": " + opCode + " ";
    String expected = startString + register1 + " * " + register2 + " to " + resultReg;
    assertEquals(expected, mulInstructionOne.toString());
    expected = startString + register2 + " * " + register3 + " to " + resultReg;
    assertEquals(expected, mulInstructionTwo.toString());
    expected = startString + register1 + " * " + register3 + " to " + resultReg;
    assertEquals(expected, mulInstructionThree.toString());
    expected = startString + register2 + " * " + register2 + " to " + resultReg;
    assertEquals(expected, mulInstructionFour.toString());
  }
}