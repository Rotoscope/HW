package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * target for branches i.e GOTO, CALL, FALSEBRANCH
 */

public class LabelCode extends ByteCode {
    String label;
    
    public LabelCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	label = n.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
    }
    
    @Override
    public String getLabel() {
	return label;
    }
}
