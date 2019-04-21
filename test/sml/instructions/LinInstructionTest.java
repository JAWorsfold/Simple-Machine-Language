package sml.instructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinInstructionTest {

  LinInstruction linInstructionOne;
  LinInstruction linInstructionTwo;
  LinInstruction linInstructionThree;
  String label = "l1";
  String opCode = "lin";
  int resultReg = 0;
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
  }

  @Test
  void toStringTest() {
  }
}