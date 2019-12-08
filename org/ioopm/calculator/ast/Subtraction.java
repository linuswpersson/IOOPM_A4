package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Subtraction extends Binary {

    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "-";
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
