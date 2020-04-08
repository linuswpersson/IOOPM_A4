package org.ioopm.calculator.ast;
import java.util.*;
/**
 * Class for a sequence. Sequence contains two LinkedLists, one (body) with the body of a function where each element is one line-operations, and another (args) which before a call to accept must contain the argument assignments of a specific functionCall.
 */
public class Sequence extends SymbolicExpression {
    private LinkedList<SymbolicExpression> body = new LinkedList<SymbolicExpression>();
    private LinkedList<SymbolicExpression> args;

    public void setArgs(LinkedList<SymbolicExpression> args){
	this.args = args;
    }
    
    public void addLine(SymbolicExpression newLine){
	this.body.addLast(newLine);
    }

    public LinkedList<SymbolicExpression> getBody(){
	return this.body;
    }
    
    @Override
    public LinkedList<SymbolicExpression> getArgs(){
	return this.args;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
