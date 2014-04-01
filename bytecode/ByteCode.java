package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

public abstract class ByteCode {
    String type = "";
    
    /**
     * Initializes the bytecode object and passes the arguments stored in the Vector
     * @param n
     */
    public abstract void init(Vector<String> n);
    public abstract void execute(VirtualMachine vm);
    public String getType() {return type;}

    /* functions for GoTo, Call, Falsebranch and Label to override */
    public String getLabel() {return "";}
    public void setResolvedAddr(int i) {}
}
