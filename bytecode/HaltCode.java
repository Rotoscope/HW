package interpreter.bytecode;

import interpreter.VirtualMachine;


public class HaltCode extends ByteCode {

    @Override
    public void init() {
	
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.halt();
    }
    
}
