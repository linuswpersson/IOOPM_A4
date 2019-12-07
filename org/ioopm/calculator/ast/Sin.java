package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Sin extends Unary {

    public Sin(SymbolicExpression hs) {
	super(hs);
    }

    public String getName() {
        return "sin";
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
