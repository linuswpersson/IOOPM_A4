package org.ioopm.calculator.ast;

public class NamedConstantChecker implements Visitor {

    public SymbolicExpression check(SymbolicExpression topLevel) {
	return topLevel.accept(this);
    }

    public SymbolicExpression visit(Addition a) {
	a.getLhs().accept(this);
	a.getRhs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Assignment a) {
	a.getLhs().accept(this);
	if (a.getRhs().isConstant() == 2) {
	    throw new IllegalExpressionException("assignment to named constant not allowed:\n" + a.toString());
	}
	return a;
    }

    public SymbolicExpression visit(Constant a) {
	return a;
    }

    public SymbolicExpression visit(Cos a) {
	a.getHs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Division a) {
	a.getLhs().accept(this);
	a.getRhs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Exp a) {
	a.getHs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Log a) {
	a.getHs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Multiplication a) {
	a.getLhs().accept(this);
	a.getRhs().accept(this);
	return a;
    }
    
    public SymbolicExpression visit(Negation a) {
	a.getHs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Sin a) {
	a.getHs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Subtraction a) {
	a.getLhs().accept(this);
	a.getRhs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Variable a) {
	return a;
    }

    public SymbolicExpression visit(Quit a) {
	return a;
    }
    
    public SymbolicExpression visit(Vars a) {
	return a;
    }
    
    public SymbolicExpression visit(Clear a) {
	return a;
    }
}
