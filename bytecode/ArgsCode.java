package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Used prior to calling a function
 * Creates a new frame with n args from the top of the runStack
 */

public class ArgsCode extends ByteCode {
    int numArguments;
    
    public ArgsCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	numArguments = Integer.parseInt(n.get(1));
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.pushFrame(numArguments);
    }
}
