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
    
    public void pushRunStack(int i) {runStack.push(i);}
    public int popRunStack() {return runStack.pop();}
    public void pushReturnAddrs() {returnAddrs.push(pc);}
    public void pushFrame(int pc) {runStack.newFrameAt(pc - 1);}
    public void popFrame() {runStack.popFrame();}
    public void halt() {isRunning = false;}
}
