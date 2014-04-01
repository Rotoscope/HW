package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Turns on or off whether the VM should dump the runStack in its frames
 * and the original bytecode lines
 */

public class DumpCode extends ByteCode {
    String state;
    
    public DumpCode() {
    }

    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	state = n.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
	if(state.equals("ON"))
	    vm.dumpON();
	else
	    vm.dumpOFF();
    }
    
}
