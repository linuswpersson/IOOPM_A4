package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Subtraction extends Binary {

    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    public String getName() {
        return "-";
    }

    public int getPriority() {
	return 1;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
