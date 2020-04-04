package org.ioopm.calculator.ast;
import java.util.*;
/**
 * Class for functionDeclarations.
 */
public class FunctionDeclaration extends SymbolicExpression{
    private String name;
    private LinkedList<SymbolicExpression> argList;
    private Sequence body;
    
    public FunctionDeclaration(String name, LinkedList<SymbolicExpression> argList) {
	this.name = name;
	this.argList = argList;
	this.body = body;
    }

    @Override
    public boolean isFuncDec(){
	return true;
    }

    public void addBody(Sequence newBody){
	this.body = newBody;
    }

    public Sequence getBody(){
	return this.body;
    }

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
