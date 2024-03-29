package org.ioopm.calculator.ast;

/**
 *Node representation of addition
 */ 
public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "+";
    }

    @Override
    public int getPriority() {
	return 1;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
