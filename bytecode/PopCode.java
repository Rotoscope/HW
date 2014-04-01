package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Pops the top n levels of the runtime stack
 */

public class PopCode extends ByteCode {
    int popAmount;
    
    public PopCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	popAmount = Integer.parseInt(n.get(1));
    }


    @Override
    public void execute(VirtualMachine vm) {
	for(int i = 0; i < popAmount; i++) {
	    vm.popRunStack();
	}
    }
    
}
