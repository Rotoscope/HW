package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Performs a binary operation involving the top two arguments on the runStack
 * The top 2 are popped and the result is pushed back
 */

public class BopCode extends ByteCode {
    String operator;
    int opOne, opTwo;

    public BopCode() {
    }
    
    @Override
    public void init(Vector<String> n) {
	type = n.get(0);
	operator = n.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
	opTwo = vm.popRunStack();
	opOne = vm.popRunStack();
	switch(operator) {
	    case "+":
		vm.pushRunStack(opOne + opTwo);
		break;
	    case "-":
		vm.pushRunStack(opOne - opTwo);
		break;
	    case "*":
		vm.pushRunStack(opOne * opTwo);
		break;
	    case "/":
		vm.pushRunStack(opOne / opTwo);
		break;
	    case "==":
		vm.pushRunStack((opOne == opTwo)?1:0);
		break;
	    case "!=":
		vm.pushRunStack((opOne != opTwo)?1:0);
		break;
	    case "<=":
		vm.pushRunStack((opOne <= opTwo)?1:0);
		break;
	    case ">":
		vm.pushRunStack((opOne > opTwo)?1:0);
		break;
	    case ">=":
		vm.pushRunStack((opOne >= opTwo)?1:0);
		break;
	    case "<":
		vm.pushRunStack((opOne < opTwo)?1:0);
		break;
	    case "|":
		vm.pushRunStack(opOne | opTwo);
		break;
	    case "&":
		vm.pushRunStack(opOne & opTwo);
		break;
	}
    }
    
}
