package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Conditional extends Binary {
    private SymbolicExpression tru = null;
    private SymbolicExpression fal = null;
    private int op = 0;

    public Conditional(SymbolicExpression lhs, SymbolicExpression rhs, SymbolicExpression tru, SymbolicExpression fal, int op) {
	super(lhs, rhs);
	this.tru = tru;
	this.fal = fal;
	this.op = op;
    }

    @Override
    public String toString() {
	String operation = "";
	switch(this.op) {
	case 1:
	    operation = "<";
	    break;
	case 2:
	    operation = ">";
	    break;
	case 3:
	    operation = "<=";
	    break;
	case 4:
	    operation = ">=";
	    break;
	case 5:
	    operation = "==";
	    break;
	}
	return "if" + this.getLhs().toString() + operation + this.getRhs().toString() + "{" + tru.toString() + "}" + "else" + "{" + fal.toString() + "}";
    }

    public SymbolicExpression getTru() {
	return this.tru;
    }

    public SymbolicExpression getFal() {
	return this.fal;
    }

    public int getOp() {
	return this.op;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }
}
