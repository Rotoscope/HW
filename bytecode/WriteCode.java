package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Write the value on the top of the stack to the output
 */

public class WriteCode extends ByteCode {
    
    public WriteCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
	System.out.println(vm.peekRunStack());
    }
    
}
