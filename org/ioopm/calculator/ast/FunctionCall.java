package org.ioopm.calculator.ast;
import java.util.*;
/**
 * class for functionCalls.
 */
public class FunctionCall extends SymbolicExpression {
    private String name;
    private LinkedList<SymbolicExpression> argList;
    private LinkedList<SymbolicExpression> valList;
    private Sequence body;
    
    public FunctionCall(String name, LinkedList<SymbolicExpression> argList, LinkedList<SymbolicExpression> valList, Sequence body) {
	this.name = name;
	this.argList = argList;
	this.valList = valList;
	this.body = body;
    }

    @Override
    public String toString() {
	return this.name;
    }

    // @Override
    // public boolean equals(Object other) {
    // 	if (other instanceof FunctionCall) {
    // 	    return this.equals((FunctionCall) other);
    // 	} else {
    // 	    return false;
    // 	}
    // }

    // public boolean equals(FunctionCall other) {
    // 	return this.name.equals(other.name);
    // }

    @Override
    public String getName() {
	return this.name;
    }

    public Sequence getBody(){
	return this.body;
    }


    public LinkedList<SymbolicExpression> getArgs(){
	return this.argList;
    }

    public LinkedList<SymbolicExpression> getVals(){
	return this.valList;
    }

    public Integer getArgSize(){
	return this.argList.size();
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
