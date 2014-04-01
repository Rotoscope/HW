package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * uses the load method in the vm, which pushes the value in the slot with offset
 * n from the start of the frame onto the top of the stack
 * the id is the variable name where the data is stored
 */

public class LoadCode extends ByteCode {
    int offset;
    String variable;
    
    public LoadCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	offset = Integer.parseInt(n.get(1));
	variable = n.get(2);
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.load(offset);
    }

 
}
