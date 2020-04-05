package org.ioopm.calculator.ast;
import java.util.*;
/**
 * Class for a sequence.
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

    public LinkedList<SymbolicExpression> getArgs(){
	return this.args;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
