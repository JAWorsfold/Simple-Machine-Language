package sml;

import sml.instructions.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class ....
 * <p>
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 *
 * @author ...
 */
public final class Translator {

    private static final String PATH = "C:\\Users\\Joe Worsfold\\Documents\\StuGitHub\\SDP\\coursework-one-sml-jworsf01\\resources\\";

    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace

    private String line = "";
    private String fileName; // source file of SML code

    public Translator(String file) {
        this.fileName = PATH + file;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"

    public boolean readAndTranslate(Labels lab, List<Instruction> prog) {
        try (Scanner sc = new Scanner(new File(fileName))) {
            // Scanner attached to the file chosen by the user
            // The labels of the program being translated
            lab.reset();
            // The program to be created
            prog.clear();

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                return false;
            }

            // Each iteration processes line and reads the next line into line
            while (line != null) {
                // Store the label in label
                String label = scan();

                if (label.length() > 0) {
                    Instruction ins = getInstruction(label);
                    if (ins != null) {
                        lab.addLabel(label);
                        prog.add(ins);
                    }
                }

                try {
                    line = sc.nextLine();
                } catch (NoSuchElementException ioE) {
                    return false;
                }
            }
        } catch (IOException ioE) {
            System.err.println("File: IO error " + ioE);
            System.exit(-1);
            return false;
        }
        return true;
    }

    // line should consist of an MML instruction, with its label already
    // removed. Translate line into an instruction with label label
    // and return the instruction
    public Instruction getInstruction(String label) {

        if (line.equals("")) {
            return null;
        }

        Object[] parameters;
        String in = scan();
        char c = in.charAt(0);
        c = Character.toUpperCase(c);
        StringBuffer sb = new StringBuffer(in);
        sb.setCharAt(0, c);
        String strIn = sb.toString();
        strIn = strIn + "Instruction";

        Class reflectClass;

        try {
            reflectClass = Class.forName(strIn);
            Constructor[] constructors = reflectClass.getConstructors();
            Constructor constructor = constructors[1];
            Class[] parameterTypes = constructor.getParameterTypes();
            parameters = new Object[parameterTypes.length];

            for (int i=0; i < parameters.length; i++) {
                if ( i == 0 ) {
                    parameters[i] = label;
                } else {
                    Class tryClass = parameterTypes[i];
                    if ( tryClass.getName().equals("int") ) {
                        Integer parameter = scanInt();
                        parameters[i] = parameter;
                    } else if ( tryClass.getName().equals("java.lang.String") ) {
                        String parameter = scan();
                        parameters[i] = parameter;
                    }
                }
            }

            return (Instruction) constructor.newInstance(parameters);

        } catch (Exception e) {
            e.printStackTrace();
        }

		    return null;
    }

    /*
     * Return the first word of line and remove it from line. If there is no
     * word, return ""
     */
    private String scan() {
        line = line.trim();
        if (line.length() == 0) {
            return "";
        }

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    // Return the first word of line as an integer. If there is
    // any error, return the maximum int
    private int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }
}
