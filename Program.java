package interpreter;

import interpreter.bytecode.*;
import java.io.*;
import java.util.*;

public class Program extends Object {
    Vector<ByteCode> prog;
    String orig;    //original line
    
    public void load(ByteCode bytecode) throws IOException {
	return;
    }
     public void run(InputStream in, OutputStream out) {
	 
     }
     
     public ByteCode getCode(int pc) {
	 return prog.get(pc);
     }
}
