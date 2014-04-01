package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * halt execution
 */

public class HaltCode extends ByteCode {
    
    public HaltCode() {
    }

   @Override
    public void execute(VirtualMachine vm) {
	vm.halt();
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
    }
    
}
