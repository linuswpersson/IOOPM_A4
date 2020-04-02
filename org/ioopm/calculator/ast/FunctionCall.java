package org.ioopm.calculator.ast;
import java.util.HashMap;
/**
 * class for functionCalls.
 */
public class FunctionCall {
    private String name;
    private LinkedList<Atom> argList;
    
    public FunctionCall(String name, LinkedList<Atom> argList) {
	this.name = name;
	this.argList = argList;
    }

    @Override
    public String toString() {
	return this.name;
    }

    @Override
    public boolean equals(Object other) {
	if (other instanceof FunctionCall) {
	    return this.equals((FunctionCall) other);
	} else {
	    return false;
	}
    }

    public boolean equals(FunctionCall other) {
	return this.name.equals(other.name);
    }

    @Override
    public String getName() {
	return this.name;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
