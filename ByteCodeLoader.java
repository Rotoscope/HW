package interpreter;


import interpreter.bytecode.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * <pre>
 * 
 * 1. Load bytecodes from file
 * 2. Get the string of the bytecodes
 * 3. Initialize an instance of that bytecode
 * 4. Store it into a Program object
 * 5. Before loading the codes into the VM, resolve any branch addresses
 * 
 * </pre>
 */

public class ByteCodeLoader extends Object {
    Program prog;
    StringTokenizer st;
    File f;
    BufferedReader reader = null;
    String lineData;
    Vector<String> args;
    ByteCode bytecode;
    
    public ByteCodeLoader(String programFile) throws IOException {
	try {
	    f = new File(programFile);
	    reader = new BufferedReader(new FileReader(f));
	    lineData = null;
	    args = new Vector();
	    prog = new Program();
	    
	    /**
	     * 1. Tokenize the bytecodes from the file
	     * 2. Put the tokens into a Vector
	     * 3. Initialize an instance of the bytecode
	     * 4. init() the bytecode object with it's arguments
	     * 5. Load the class into the Program object and reset the argument Vector
	     */
	    while((lineData = reader.readLine()) != null) {
		st = new StringTokenizer(lineData);
		while(st.hasMoreElements()) {
		    args.add((String) st.nextElement());
		}
		String codeClass = CodeTable.get(args.get(0));

		bytecode = (ByteCode)(Class.forName("interpreter.bytecode."+codeClass).newInstance());
		bytecode.init(args);

		prog.load(bytecode, lineData);
		args.removeAllElements();
	    }
	} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	}
    }
    
    /**
     * Resolve the branches before returning
     * 
     * @return the program holding the codes
     */
    public Program loadCodes() {
	prog.resolveCodes();
	return prog;
    }
}
