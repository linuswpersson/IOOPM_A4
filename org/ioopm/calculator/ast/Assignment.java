package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Node representation of Assignment
 */
public class Assignment extends Binary {
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    public String getName() {
	return "=";
    }

    public int getPriority() {
        return 3;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
