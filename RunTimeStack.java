package interpreter;

import java.util.*;

public class RunTimeStack {
    Stack framePointers;
    Vector<Integer> runStack;
    
    public RunTimeStack() {
	framePointers = new Stack();
	runStack = new Vector();
	framePointers.push(0);
    }
    
    public void dump() {
	
    }
    
    public int peek() {
	return runStack.lastElement();
    }
    
    public int pop() {
	return runStack.remove(runStack.size() - 1);
    }
    
    public int push(int i) {
	runStack.add(i);
	return i;
    }
    
    public void newFrameAt(int offset) {
	framePointers.push(offset);
    }
    
    public void popFrame() {
	framePointers.pop();
    }
    
    public int store(int offset) {
	return 1;
    }
    
    public int load(int offset) {
	return 1;
    }
    
    public Integer push(Integer i) {
	return i;
    }
}
