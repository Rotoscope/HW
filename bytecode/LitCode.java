package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Load the literal value n
 * if it comes in the form of: LIT 0 i
 * it loads 0 on the stack to initialize the variable i to 0 and reserve
 * space on the runtime stack for i
 */

public class LitCode extends ByteCode {
    int value;
    String id;
    
    public LitCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	value = Integer.parseInt(n.get(1));
	if(n.size() == 3)
	    id = n.get(2);
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.pushRunStack(value);
    }
}
