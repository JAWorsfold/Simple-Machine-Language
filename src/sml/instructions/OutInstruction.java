package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class OutInstruction extends Instruction {
  private int register;
  private int contents;

  /**
   * @param lab
   * @param op
   */
  public OutInstruction(String lab, String op) {
    super(lab, op);
  }

  /**
   * Initialise the instruction
   *
   * @param lab of the instruction
   * @param reg to work with
   */
  public OutInstruction(String lab, int reg) {
    super(lab, "out");
    this.register = reg;
  }

  /**
   * Method to use for testing as this Class only prints out to the console.
   * @return contents
   */
  public int getRegisterContents() {
    return contents;
  }

  /**
   * Execute the instruction in the context of the Machine
   *
   * @param m the machine
   */
  @Override
  public void execute(Machine m) {
    this.contents = m.getRegisters().getRegister(register);
    System.out.println(contents);
  }

  /**
   * String representation of the instruction
   *
   * @return incorporating the value
   */
  @Override
  public String toString() {
    return super.toString() + " register " + register + " contents are " + contents;
  }
}
