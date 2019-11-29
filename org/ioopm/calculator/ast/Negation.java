package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Negation extends Unary {

    public Negation(SymbolicExpression hs) {
	super(hs);
    }

    public String getName() {
        return "-";
    }

    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression arg = this.getHs().eval(vars);
	if (arg.isConstant() > 0) {
	    return new Constant(-arg.getValue());
	} else {
	    return new Negation(arg);
	}
    }
}
