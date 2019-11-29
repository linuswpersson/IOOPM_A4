package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Multiplication extends Binary {
    
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    public String getName() {
        return "*";
    }

    public int getPriority() {
	return 2;
    }
    
    /** Evaluates Multiplication
     *@param Enviorment.
     *@return new multiplication if lArg and rArg are mulstiplication,  if not.
     */
    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression lArg = this.getLhs().eval(vars);
	SymbolicExpression rArg = this.getRhs().eval(vars);
	if (lArg.isConstant() > 0 && rArg.isConstant() > 0) {
	    return new Constant(lArg.getValue() * rArg.getValue());
	} else {
	    return new Multiplication((lArg), (rArg));
	}
    }
}
