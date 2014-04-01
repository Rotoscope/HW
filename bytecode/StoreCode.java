package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Pops the top of the stack
 * Stores that value into the offset n from the start of the current frame
 */

public class StoreCode extends ByteCode {
    int offset;
    String id;
    
    public StoreCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	offset = Integer.parseInt(n.get(1));
	id = n.get(2);
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.store(offset);
    }
    
}
