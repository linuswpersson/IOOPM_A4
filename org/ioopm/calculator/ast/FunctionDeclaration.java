package org.ioopm.calculator.ast;
import java.util.*;
/**
 * Class for functionDeclarations. Used as to store info when a function is declared, and fetch function information when a functioncall is made.
 */
public class FunctionDeclaration extends SymbolicExpression{
    private String name;
    private LinkedList<SymbolicExpression> argList;        // stores the variable arguments, te.x foo,bar in max(foo,bar)
    private Sequence body;
    
    public FunctionDeclaration(String name, LinkedList<SymbolicExpression> argList) {
	this.name = name;
	this.argList = argList;
	this.body = body;
    }

    // used to check if a SymbolicExpression returned from the parser is a FunctionDeclaration.
    @Override
    public boolean isFuncDec(){
	return true;
    }

    @Override
    public String toString(){
	String arguments = "(";
	for(int i = 0; i < this.getArgSize(); i++){
	    arguments = arguments + this.argList.get(i).toString();
	    if(i != this.getArgSize()-1){
	        arguments = arguments + ",";
	    }
	}
	arguments = arguments + ")";
	return this.name + arguments; 
    }

    public void addBody(Sequence newBody){
	this.body = newBody;
    }

    public Sequence getBody(){
	return this.body;
    }
    
    @Override
    public String getName(){
	return this.name;
    }

    public LinkedList<SymbolicExpression> getArgs(){
	return this.argList;
    }

    public Integer getArgSize(){
	return this.argList.size();
    }
}
