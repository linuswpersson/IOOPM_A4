package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Node representation of Scope
 */
public class Scope extends Binary {
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    @Override
    public String getName() {
	return "=";
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
