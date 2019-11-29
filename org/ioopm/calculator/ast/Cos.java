package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Class representation of cosinus
 */
public class Cos extends Unary{

    public Cos(SymbolicExpression hs) {
	super(hs);
    }

    public String getName() {
        return "cos";
    }

      /**
     *Evaluates cosinus
     *@param Environment
     *@return new evaluated Constant if arg is a constant, calling new Cos if
     *arg is not a constant
     */ 

    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression arg = this.getHs().eval(vars);
	if (arg.isConstant() > 0) {
	    return new Constant(Math.cos(arg.getValue()));
	} else {
	    return new Cos(arg);
	}
    }
}
