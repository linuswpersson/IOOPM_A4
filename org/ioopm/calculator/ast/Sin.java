package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Sin extends Unary {

    public Sin(SymbolicExpression hs) {
	super(hs);
    }

    public String getName() {
        return "sin";
    }

    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression arg = this.getHs().eval(vars);
	if (arg.isConstant() > 0) {
	    return new Constant(Math.sin(arg.getValue()));
	} else {
	    return new Sin(arg);
	}
    }
}
