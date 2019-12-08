package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Class representation of cosinus
 */
public class Cos extends Unary{

    public Cos(SymbolicExpression hs) {
	super(hs);
    }

    @Override
    public String getName() {
        return "cos";
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
