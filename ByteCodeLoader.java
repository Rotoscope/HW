package interpreter;

import java.io.*;
import java.util.*;
import interpreter.bytecode.*;
import java.lang.reflect.*;

public class ByteCodeLoader extends Object {
    Constructor c;
    Program prog;
    StringTokenizer st;
    File f;
    BufferedReader reader = null;
    String[] bytecodes;
    String lineData, args;
    ByteCode bytecode;
    
    public ByteCodeLoader(String programFile) throws IOException {
	try {
	    f = new File(programFile);
	    reader = new BufferedReader(new FileReader(f));
	    lineData = null;
	    int i = 0;
	    
	    while((lineData = reader.readLine()) != null) {
		st = new StringTokenizer(lineData);
		bytecodes = new String[st.countTokens()];
		while(st.hasMoreElements()) {
		    bytecodes[i] = st.nextToken();
		    i++;
		}
		String codeClass = CodeTable.get(bytecodes[0]);
	
		if(i == 3) {
		    c = Class.forName("interpreter."+codeClass).getConstructor(String.class, String.class);
		    bytecode = (ByteCode) c.newInstance(bytecodes[1], bytecodes[2]);
		} else if(i == 2) {
		    c = Class.forName("interpreter."+codeClass).getConstructor(String.class);
		    bytecode = (ByteCode) c.newInstance(bytecodes[1]);
		} else if(i == 1) {
		    c = Class.forName("interpreter."+codeClass).getConstructor();
		    bytecode = (ByteCode) c.newInstance();
		}
		
		prog.load(bytecode);
		i = 0;
	    }
	} catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
	} catch (Exception e) {
	}
    }
    
    public Program loadCodes() {
	return prog;
    }
}
