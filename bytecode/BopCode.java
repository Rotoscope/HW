/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    String operator;

    public BopCode(String op) {
	operator = op;
    }
    
    @Override
    public void init() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void execute(VirtualMachine vm) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
