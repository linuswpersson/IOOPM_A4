package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Exp extends Unary {

    public Exp(SymbolicExpression hs) {
	super(hs);
    }

    public String getName() {
        return "10^";
    }

    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression arg = this.getHs().eval(vars);
	if (arg.isConstant() > 0) {
	    return new Constant(Math.pow(10, arg.getValue()));
	} else {
	    return new Exp(arg);
	}
    }

}
