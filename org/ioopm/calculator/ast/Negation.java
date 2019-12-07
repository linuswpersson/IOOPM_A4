package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Negation extends Unary {

    public Negation(SymbolicExpression hs) {
	super(hs);
    }

    public String getName() {
        return "-";
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
