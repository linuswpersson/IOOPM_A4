package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Subtraction extends Binary {

    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    public String getName() {
        return "-";
    }

    public int getPriority() {
	return 1;
    }

    /** Evaluates subtraction
     *@param Enviorment.
     *@return new subtraction if lArg and rArg are constant, new Subtraction if not.
     */
    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression lArg = this.getLhs().eval(vars);
	SymbolicExpression rArg = this.getRhs().eval(vars);
	if (lArg.isConstant() > 0 && rArg.isConstant() > 0) {
	    return new Constant(lArg.getValue() - rArg.getValue());
	} else {
	    return new Subtraction((lArg), (rArg));
	}
    }
}
