package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Division extends Binary {

    public Division(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override
    public int getPriority() {
	return 2;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
