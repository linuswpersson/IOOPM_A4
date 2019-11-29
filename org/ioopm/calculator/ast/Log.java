package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Log extends Unary {

    public Log(SymbolicExpression hs) {
	super(hs);
    }

    public String getName() {
        return "log";
    }

    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression arg = this.getHs().eval(vars);
	if (arg.isConstant() > 0) {
	    return new Constant(Math.log10(arg.getValue()));
	} else {
	    return new Log(arg);
	}
    }
}
