package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Read an integer
 * Prompt user for input
 * Put the input on the top of the stack
 */

public class ReadCode extends ByteCode {
    BufferedReader in;
    
    public ReadCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
	try {
	    System.out.print("Input: ");
	    in = new BufferedReader(new InputStreamReader(System.in));
	    String line = in.readLine();
	    vm.pushRunStack(Integer.parseInt(line));
	} catch(java.io.IOException e) {
	}
    }
    
}
