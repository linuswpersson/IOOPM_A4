package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Node representation of Assignment
 */
public class Assignment extends Binary {
    
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs){
	super(lhs, rhs);
    }

    public String getName() {
	return "=";
    }

    public int getPriority() {
        return 3;
    }

    /**
     *Evaluates Assignment
     *@param Environment
     *@return lArg, puts lAarg in hashmap if constant
     *@throws Illegalexpressionexception if assignment to named constant
     */
    public SymbolicExpression eval(Environment vars) {
	SymbolicExpression lArg = this.getLhs().eval(vars);
	SymbolicExpression rArg = this.getRhs();
	if(rArg.isConstant() != 2) {
	    vars.put((Variable)rArg, lArg);	
	    return lArg;
	}
	else {
	    throw new IllegalExpressionException("Assignment to named constant not allowed.");
	}
    } 
}
