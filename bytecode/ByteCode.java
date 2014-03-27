package interpreter.bytecode;

import java.util.*;
import interpreter.*;

public abstract class ByteCode {
    Vector args;
    
    public abstract void init();
    public abstract void execute(VirtualMachine vm);
    
}
