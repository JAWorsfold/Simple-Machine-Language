package sml.instructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Machine;

import static org.junit.jupiter.api.Assertions.*;

class DivInstructionTest {

  DivInstruction divInstructionOne;
  DivInstruction divInstructionTwo;
  DivInstruction divInstructionThree;
  DivInstruction divInstructionFour;
  String label = "l1";
  String opCode = "div";
  int resultReg = 0;
  int register1 = 1;
  int register2 = 2;
  int register3 = 3;
  int value1 = 0;
  int value2 = -83;
  int value3 = 465;

  @BeforeEach
  void setUp() {
    divInstructionOne = new DivInstruction(label, resultReg, register1, register2);
    divInstructionTwo = new DivInstruction(label, resultReg, register2, register3);
    divInstructionThree = new DivInstruction(label, resultReg, register1, register3);
    divInstructionFour = new DivInstruction(label, resultReg, register2, register2);
  }

  @AfterEach
  void tearDown() {
    divInstructionOne = null;
    divInstructionTwo = null;
    divInstructionThree = null;
    divInstructionFour = null;
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
    divInstructionOne.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value1 / value2;
    assertEquals(expected, actual);
    divInstructionTwo.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value2 / value3;
    assertEquals(expected, actual);
    divInstructionThree.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value1 / value3;
    assertEquals(expected, actual);
    divInstructionFour.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value2 / value2;
    assertEquals(expected, actual);
  }

  @Test
  void toStringTest() {
    String startString = label + ": " + opCode + " ";
    String expected = startString + register1 + " / " + register2 + " to " + resultReg;
    assertEquals(expected, divInstructionOne.toString());
    expected = startString + register2 + " / " + register3 + " to " + resultReg;
    assertEquals(expected, divInstructionTwo.toString());
    expected = startString + register1 + " / " + register3 + " to " + resultReg;
    assertEquals(expected, divInstructionThree.toString());
    expected = startString + register2 + " / " + register2 + " to " + resultReg;
    assertEquals(expected, divInstructionFour.toString());
  }
}