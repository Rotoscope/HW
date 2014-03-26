package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.*;

public class VirtualMachine {
    RunTimeStack runStack;
    int pc; //program counter
    Stack returnAddrs;
    boolean isRunning;
    Program program;
    
    public VirtualMachine(Program prog) {
	program = prog;
    }
    
    public void executeProgram() {
	pc = 0;
	runStack = new RunTimeStack();
	returnAddrs = new Stack();
	isRunning = true;
	while(isRunning) {
		ByteCode code = program.getCode(pc);
		code.execute(this);
		//runStack.dump();
		pc++;
	}
    }
}
