package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Node representation of addition
 */ 
public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    public String getName() {
        return "+";
    }

    public int getPriority() {
	return 1;
    }

    /**
     *Evaluates addition
     *@param Environment
     *@return new Constant if lArg and rArg are constants, new Addition if not.
     */ 
    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression lArg = this.getLhs().eval(vars);
	SymbolicExpression rArg = this.getRhs().eval(vars);
	if (lArg.isConstant() > 0 && rArg.isConstant() > 0) {
	    return new Constant(lArg.getValue() + rArg.getValue());
	} else {
	    return new Addition((lArg), (rArg));
	}
    }

}
