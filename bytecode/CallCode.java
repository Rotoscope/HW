package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Transfer control to the indicated function
 */

public class CallCode extends ByteCode {
    String funcname;
    int resolved;
    
    public CallCode() {
    }
    
    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	funcname = n.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.pushReturnAddrs();
	vm.setPC(resolved - 1);
    }
    
    @Override
    public String getLabel() {
	return funcname;
    }
    
    @Override
    public void setResolvedAddr(int i) {
	resolved = i;
    }
}
