/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    int numArguments;
    String name;
    
    public ArgsCode(String n) {
	numArguments = Integer.parseInt(n);
    }

    @Override
    public void init() {
	name = "ARGS";
    }

    @Override
    public void execute(VirtualMachine vm) {
	vm.popRunStack();
    }
    
}
