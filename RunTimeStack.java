package interpreter;

import java.util.Stack;
import java.util.Vector;

/**
 * Maintains the stack of active frames
 * Push a new frame when a function is called
 * Pop the top frame when a return from the function
 */

public class RunTimeStack {
    Stack<Integer> framePointers;   //points to the beginning of the frame 
    Vector<Integer> runStack;
    
    public RunTimeStack() {
	framePointers = new Stack();
	runStack = new Vector();
	framePointers.push(0);
    }
    
    /**
     * dumps the runtime stack with its frames
     */
    public void dump() {
	printStack();
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
    
    /**
     * 1. Stores the value at the top of the frame, which is the same as the top
     *    of the runtime stack
     * 2. Pops off the finished frame from the framePointers stack
     * 3. Removes the frame's elements from the runtime stack
     *	  This is to lower the size of the runStack
     * 4. Push the stored value from the top of the frame into the top of the
     *    runtime stack
     */
    public void popFrame() {
	int value = runStack.get(runStack.size() - 1);
	int oldFrame = framePointers.pop();
	for(int i = runStack.size(); i > oldFrame; i--) {
	    runStack.remove(i - 1);
	}
	push(value);
    }
    
    /**
     * Pops the top of the stack into the location at the start of the frame
     * added to the offset
     * @param offset
     * offset from the current frame to be added
     * @return 
     * the value popped from the top of the stack
     */
    public int store(int offset) {
	int loc = framePointers.peek() + offset;
	return(runStack.set(loc, pop()));
    }
    
    /**
     * Push the value from the location of the start of the frame added with the offset
     * onto the top of the stack
     * @param offset
     * offset from current frame to get the value
     * @return 
     * the value pushed on top of the stack
     */
    public int load(int offset) {
	int value = runStack.get(offset + framePointers.peek());
	return push(value);
    }
    
    public Integer push(Integer i) {
	runStack.add(i);
	return i;
    }
    
    public int size() {
	return runStack.size();
    }
    
    /**
     * Prints the runStack along with it's frames
     */
    public void printStack() {
	int frameStart, frameEnd, i = 0;
	Stack<Integer> temp = new Stack();
	
	/**
	 * Put the framePointers in reverse on a temp stack to know the first
	 * frame to the last in ascending order
	 */
	while(!framePointers.isEmpty()) {
	    temp.push(framePointers.pop());
	}
    
	/**
	 * temp will always have one element in the beginning, which is the 
	 * start of the program
	 * Push the value popped to restore the framePointer stack
	 */
	frameStart = temp.pop();
	framePointers.push(frameStart);
	
	do {
	    /**
	     * If the temp stack is empty, then there are no more frames so
	     * the end of the frame is the end of the runStack
	     */
	    if(temp.isEmpty()) {
		frameEnd = runStack.size();
	    } else {
		frameEnd = temp.peek() - 1;
	    }

	    /**
	     * If the frameStart is larger than the frameEnd, then it has entered
	     * a function and the original frame has nothing inside it
	     * e.g.
	     * LIT 7
	     * ARGS 1
	     * CALL funcname
	     * 
	     * This causes the frameStart to be 0 and frameEnd to be -1 for the first frame
	     * and the branching frame becomes frameStart: 0 and frameEnd: something else
	     */
	    if(frameStart > frameEnd || runStack.isEmpty()) {
		System.out.print("[] ");
	    } else {
		if(i == frameStart) {
		    System.out.print("[");
		}
		if(frameStart <= frameEnd) {
		    System.out.print(runStack.get(i));
		}
		if(i + 1 < frameEnd) {
		    System.out.print(",");
		}
		if(i + 1 >= frameEnd) {
		    System.out.print("] ");
		}
		i++;
	    }
	    if(i >= frameEnd && !temp.isEmpty()) {
		frameStart = temp.pop();
		framePointers.push(frameStart);
	    }
	}while(i < runStack.size());
	System.out.println();	//prints newline after all frames are printed
    }
}
