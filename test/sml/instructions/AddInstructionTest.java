package sml.instructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.*;

import static org.junit.jupiter.api.Assertions.*;

class AddInstructionTest {

  AddInstruction addInstructionOne;
  AddInstruction addInstructionTwo;
  AddInstruction addInstructionThree;
  AddInstruction addInstructionFour;
  String label = "l1";
  String opCode = "add";
  int resultReg = 0;
  int register1 = 1;
  int register2 = 2;
  int register3 = 3;
  int value1 = 0;
  int value2 = -83;
  int value3 = 465;

  @BeforeEach
  void setUp() {
    addInstructionOne = new AddInstruction(label, resultReg, register1, register2);
    addInstructionTwo = new AddInstruction(label, resultReg, register2, register3);
    addInstructionThree = new AddInstruction(label, resultReg, register1, register3);
    addInstructionFour = new AddInstruction(label, resultReg, register2, register2);
  }

  @AfterEach
  void tearDown() {
    addInstructionOne = null;
    addInstructionTwo = null;
    addInstructionThree = null;
    addInstructionFour = null;
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
    addInstructionOne.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value1 + value2;
    assertEquals(expected, actual);
    addInstructionTwo.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value2 + value3;
    assertEquals(expected, actual);
    addInstructionThree.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value1 + value3;
    assertEquals(expected, actual);
    addInstructionFour.execute(machine);
    actual = machine.getRegisters().getRegister(resultReg);
    expected = value2 + value2;
    assertEquals(expected, actual);
  }

  @Test
  void toStringTest() {
    String startString = label + ": " + opCode + " ";
    String expected = startString + register1 + " + " + register2 + " to " + resultReg;
    assertEquals(expected, addInstructionOne.toString());
    expected = startString + register2 + " + " + register3 + " to " + resultReg;
    assertEquals(expected, addInstructionTwo.toString());
    expected = startString + register1 + " + " + register3 + " to " + resultReg;
    assertEquals(expected, addInstructionThree.toString());
    expected = startString + register2 + " + " + register2 + " to " + resultReg;
    assertEquals(expected, addInstructionFour.toString());
  }
}