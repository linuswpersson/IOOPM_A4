package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Division extends Binary {

    public Division(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    public String getName() {
        return "/";
    }
    
    public int getPriority() {
	return 2;
    }

    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression lArg = this.getLhs().eval(vars);
	SymbolicExpression rArg = this.getRhs().eval(vars);
	if (lArg.isConstant() > 0 && rArg.isConstant() > 0) {
	    return new Constant(lArg.getValue() / rArg.getValue());
	} else {
	    return new Division((lArg), (rArg));
	}
    }
    
}
