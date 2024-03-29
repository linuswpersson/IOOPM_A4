package org.ioopm.calculator.ast;
import java.util.*;
/**
 * class for functionCalls.
 */
public class FunctionCall extends SymbolicExpression {
    private String name;
    private LinkedList<SymbolicExpression> valList;
    private HashMap<String, FunctionDeclaration> functionMap;       // pointer to global(in scope) hashtable with all FunctionDeclarations stored.
    
    public FunctionCall(String name, LinkedList<SymbolicExpression> valList, HashMap<String, FunctionDeclaration> functionMap) {
	this.name = name;
	this.valList = valList;
	this.functionMap = functionMap;
    }

    @Override
    public String toString() {
	return this.name;
    }

    @Override
    public String getName() {
	return this.name;
    }

    // fetches the body from the functionMap pointer.
    public Sequence getBody(){
	return functionMap.get(this.name).getBody();
    }

    @Override
    public LinkedList<SymbolicExpression> getArgs(){
	return this.functionMap.get(this.name).getArgs();
    }

    public LinkedList<SymbolicExpression> getVals(){
	return this.valList;
    }

    public Integer getArgSize(){
	return this.getArgs().size();
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
