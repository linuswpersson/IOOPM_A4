package org.ioopm.calculator.ast;
import java.util.*;
/**
 * Class for a sequence.
 */
public class Sequence extends SymbolicExpression {
    private LinkedList<SymbolicExpression> body;
    
    public void addLine(SymbolicExpression newLine){
	this.body.addLast(newLine);
    }

    public void addFirst(SymbolicExpression newLine){
	this.body.addFirst(newLine);
    }

    public LinkedList<SymbolicExpression> getBody(){
	return this.body;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
