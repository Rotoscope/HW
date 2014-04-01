package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Pops the top of the stack
 * If it is 0, branch to the <label> else execute the next bytecode
 */

public class FalseBranchCode extends ByteCode {
    String labelName;
    int resolvedAddr;
    
    public FalseBranchCode() {
    }

    public void init(Vector<String> n) {
	type = n.get(0);
	labelName = n.get(1);
    }

    public void execute(VirtualMachine vm) {
	if(vm.popRunStack() == 0) {
	    vm.setPC(resolvedAddr - 1);
	}
    }
    
    public String getLabel() {
	return labelName;
    }
    
    public void setResolvedAddr(int i) {
	resolvedAddr = i;
    }
}
