package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Exp extends Unary {

    public Exp(SymbolicExpression hs) {
	super(hs);
    }

    @Override
    public String getName() {
        return "exp";
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
