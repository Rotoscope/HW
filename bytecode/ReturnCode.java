package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Returns from the current function
 * Pops the current frame out
 * Pops and stores the return address stored in the vm and returns to that addr
 */

public class ReturnCode extends ByteCode {
    String funcname;	//name of current function
    
    public ReturnCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	if(n.size() == 2)
	    funcname = n.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.popFrame();
	int returnAddr = vm.popReturnAddrs();
	vm.setPC(returnAddr);
    }
    
}
