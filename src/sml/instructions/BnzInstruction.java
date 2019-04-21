package sml.instructions;

import sml.Instruction;
import sml.Machine;

public class BnzInstruction extends Instruction {
  private int register;
  private int value;
  private String toLab;

  /**
   * @param lab
   * @param op
   */
  public BnzInstruction(String lab, String op) {
    super(lab, op);
  }

  /**
   * Initialise the instruction
   *
   * @param lab of the instruction
   * @param reg to work with
   * @param toLab to jump to
   */
  public BnzInstruction(String lab, int reg, String toLab) {
    super(lab, "bnz");
    this.register = reg;
    this.toLab = toLab;
  }

  /**
   * Execute the instruction in the context of the Machine
   *
   * @param m the machine
   */
  @Override
  public void execute(Machine m) {
    value = m.getRegisters().getRegister(register);
    if ( value!=0 ) {
      m.setPc(m.getLabels().indexOf(toLab));
    }
  }

  /**
   * String representation of the instruction
   *
   * @return incorporating the value
   */
  @Override
  public String toString() {
    return super.toString() + " register " + register + " value is " + value;
  }
}
