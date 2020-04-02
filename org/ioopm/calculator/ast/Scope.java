package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Node representation of Scope
 */
public class Scope extends Unary {
    
    public Scope(SymbolicExpression hs){
	super(hs);
    }

    @Override
    public String toString() {
	return "{" + this.getHs().toString() + "}";
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
