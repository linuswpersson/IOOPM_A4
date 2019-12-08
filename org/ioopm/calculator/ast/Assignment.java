package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Node representation of Assignment
 */
public class Assignment extends Binary {
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    @Override
    public String getName() {
	return "=";
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
