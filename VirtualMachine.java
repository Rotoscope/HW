package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.Stack;


public class VirtualMachine {
    RunTimeStack runStack;
    int pc; //program counter
    Stack returnAddrs;
    boolean isRunning, dump, dumpState;
    Program program;
    
    public VirtualMachine(Program prog) {
	program = prog;
	dump = false;
	dumpState = false;
    }
    
    public void executeProgram() {
	pc = 0;
	runStack = new RunTimeStack();
	returnAddrs = new Stack();
	isRunning = true;
	while(isRunning) {
		ByteCode code = program.getCode(pc);
		/**
		 * The printing of the line comes before the execution because 
		 * the branching bytecodes such as GoTo, changes the pc after
		 * its execution.
		 */
		if(dump == true) {
		    program.getBytecode(pc);
		}
		if(dump == false && dumpState == true) {
		    dumpState = false;
		}
		code.execute(this);
		
		/**
		 * dumpState is used to print out the line "DUMP ON"
		 * This is needed because the program will print the runStack
		 * and frames when dump is turned on
		 * But because the printing occurs before the execution,
		 * the line for the bytecode, DUMP when it turns on, is never
		 * printed
		 */
		if(dump == true) {
		    if(dumpState == false) {
			System.out.println("DUMP ON");
			dumpState = true;
		    }
		    runStack.dump();
		}
		pc++;
	}
    }
    
    public int getPC() {return pc;}
    public void setPC(int newPC) {pc = newPC;}

    /* Manipulates the runtime stack and the frame stack */
    public int peekRunStack() {return runStack.peek();}
    public void pushRunStack(int i) {runStack.push(i);}
    public void pushRunStack(Integer i) {runStack.push(i);}
    public int popRunStack() {return runStack.pop();}
    public void pushReturnAddrs() {returnAddrs.push(pc);}
    public int popReturnAddrs() {return (Integer) returnAddrs.pop();}
    public void pushFrame(int i) {runStack.newFrameAt(runStack.size() - i);}
    public void popFrame() {runStack.popFrame();}
    public void load(int i) {runStack.load(i);}
    public void store(int i) {runStack.store(i);}
    
    /* Manipulates the states of the vm */
    public void halt() {isRunning = false; dump = false;}
    public void dumpON() {dump = true;}
    public void dumpOFF() {dump = false;}
}
