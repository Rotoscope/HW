package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * GOTO <label>
 */

public class GoToCode extends ByteCode {
    String label;
    int resolvedAddr;
    
    public GoToCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	label = n.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.setPC(resolvedAddr - 1);
    }
    
    @Override
    public String getLabel() {
	return label;
    }
    
    @Override
    public void setResolvedAddr(int i) {
	resolvedAddr = i;
    }
}
