package org.ioopm.calculator.ast;
import java.util.*;

public class ReassignmentChecker implements Visitor {
    private LinkedList<String> list = null;
    
    public SymbolicExpression check(SymbolicExpression topLevel) {
	this.list = new LinkedList<String>();
	return topLevel.accept(this);
    }

    public SymbolicExpression visit(Addition a) {
	a.getLhs().accept(this);
	a.getRhs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Assignment a) {
	a.getLhs().accept(this);
	String rhs = a.getRhs().toString();
	if (this.list.contains(rhs)){
	    throw new IllegalExpressionException("the variable " + rhs + " is reassigned.");
	}
	this.list.add(rhs);
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
