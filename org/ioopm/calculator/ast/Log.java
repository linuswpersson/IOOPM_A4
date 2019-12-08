package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Log extends Unary {

    public Log(SymbolicExpression hs) {
	super(hs);
    }

    @Override
    public String getName() {
        return "log";
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
