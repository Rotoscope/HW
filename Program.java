package interpreter;

import interpreter.bytecode.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/**
 * Holds all the instantiations of bytecodes
 * Holds the original bytecode line, the symbolic addresses
 * Maps the labels with it's line location in a HashMap
 * Resolves the symbolic addresses
 */

public class Program extends Object {
    Vector<ByteCode> prog;
    Vector<String> orig;    //original lines
    HashMap<String, Integer> resolve;
    
    public Program() {
	prog = new Vector();
	orig = new Vector();
	resolve = new HashMap();
    }
    
    /**
     * Loads the bytecode instantiations
     * If the type is a LABEL, then map it's symbolic name with its location
     * 
     * @param bytecode
     * The bytecode instantiation
     * 
     * @param origLine
     * The line that created the bytecode instantiation in its symbolic form
     * 
     * @throws IOException 
     */
    public void load(ByteCode bytecode, String origLine) throws IOException {

	/* saves the label and the line location */
	if(bytecode.getType().equals("LABEL")) {
	    resolve.put(bytecode.getLabel(), prog.size());
	}

	prog.add(bytecode);
	orig.add(origLine);	
    }
     
    /**
     * Returns the requested bytecode object
     * 
     * @param pc
     * The location of the bytecode object wanted
     * 
     * @return 
     * The bytecode at the location pc, which is also the line number
     */
     public ByteCode getCode(int pc) {
	 return prog.get(pc);
     }
     
     /**
      * Prints out the original symbolic line that created the bytecode at location pc
      * @param pc 
      */
     public void getBytecode(int pc) {
	 System.out.println(orig.get(pc));
     }
     
     /**
      * After all the codes are loaded, if the type is a branching bytecode
      * Set the resolved address in the branching bytecode by searching the
      * HashMap with its label as the key
      */
     public void resolveCodes() {
	 for(int i = 0; i < prog.size(); i++) {
	    ByteCode bytecode = prog.get(i);
	    String type = bytecode.getType();
	    if(type.equals("GOTO") ||
		    type.equals("FALSEBRANCH") ||
		    type.equals("CALL")) {
		String key = bytecode.getLabel();
		(prog.get(i)).setResolvedAddr(resolve.get(key));
	    }
	 }
     }
}
