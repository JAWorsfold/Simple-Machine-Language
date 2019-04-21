package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class DivInstruction extends Instruction {

  private int result;
  private int op1;
  private int op2;

  /**
   * @param label of the instruction
   * @param op    the operands
   */
  public DivInstruction(String label, String op) {
    super(label, op);
  }

  /**
   * @param label     of the instruction
   * @param res       of the computation
   * @param operator1 the first operand
   * @param operator2 the second operand
   */
  public DivInstruction(String label, int res, int operator1, int operator2) {
    this(label, "add");
    this.result = res;
    this.op1 = operator1;
    this.op2 = operator2;
  }

  /**
   * Execute the instruction, probably modifying the registers.
   *
   * @param m the machine under which the instruction executes
   */
  @Override
  public void execute(Machine m) {
    int value1 = m.getRegisters().getRegister(op1);
    int value2 = m.getRegisters().getRegister(op2);
    if (value2 != 0){
      m.getRegisters().setRegister(result, value1 / value2);
    } else {
      throw new ArithmeticException("Cannot divide by zero.");
    }
  }

  /**
   * String representation of the instruction
   *
   * @return representation of the operands and result
   */
  @Override
  public String toString() {
    return super.toString() + " " + op1 + " / " + op2 + " to " + result;
  }
}
