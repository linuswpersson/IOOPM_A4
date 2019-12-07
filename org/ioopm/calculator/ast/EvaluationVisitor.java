package org.ioopm.calculator.ast;

public class EvaluationVisitor implements Visitor {
    private Environment env = null;

    public SymbolicExpression evaluate(SymbolicExpression topLevel, Environment env) {
	this.env = env;
	return topLevel.accept(this);
    }

    // This method gets called from Addition.accept(Visitor v) -- you should
    // be able to see from the eval() methods how these should behave (i.e., 
    // compare this method with your Addition::eval() and Symbolic.addition) 
    public SymbolicExpression visit(Addition n) {
	// Visit the left hand side and right hand side subexpressions
	SymbolicExpression lArg = n.getLhs().accept(this);
	SymbolicExpression rArg = n.getRhs().accept(this);
	// When we come back here, the visitor has visited all subexpressions, 
	// meaning left and right point to newly created trees reduced to 
	// the extent possible (best case -- both are constants)

	// If subexpressions are fully evaluated, replace them in
	// the tree with a constant whose value is the sub of the
	// subexpressions, if not, simply construct a new addition
	// node from the new subexpressions
	if (rArg.isConstant() > 0 && lArg.isConstant() > 0) {
	    return new Constant(lArg.getValue() + rArg.getValue());
	} else {
	    return new Addition(lArg, rArg);
	}
    }

    public SymbolicExpression visit(Assignment n) {
	SymbolicExpression lArg = n.getLhs().accept(this);
	SymbolicExpression rArg = n.getRhs();
	if(rArg.isConstant() != 2) {
	    this.env.put((Variable)rArg, lArg);	
	    return lArg;
	}
	else {
	    throw new IllegalExpressionException("Assignment to named constant not allowed.");
	}
    }

    public SymbolicExpression visit(Constant n) {
	return new Constant(n.getValue());
    }

    public SymbolicExpression visit(Cos n) {
	SymbolicExpression arg = n.getHs().accept(this);
	if (arg.isConstant() > 0) {
	    return new Constant(Math.cos(arg.getValue()));
	} else {
	    return new Cos(arg);
	}
    }

    public SymbolicExpression visit(Division n) {
	SymbolicExpression lArg = n.getLhs().accept(this);
	SymbolicExpression rArg = n.getRhs().accept(this);
	if (lArg.isConstant() > 0 && rArg.isConstant() > 0) {
	    return new Constant(lArg.getValue() / rArg.getValue());
	} else {
	    return new Division((lArg), (rArg));
	}
    }

    public SymbolicExpression visit(Exp n) {
	SymbolicExpression arg = n.getHs().accept(this);
	if (arg.isConstant() > 0) {
	    return new Constant(Math.pow(10, arg.getValue()));
	} else {
	    return new Exp(arg);
	}
    }

    public SymbolicExpression visit(Log n) {
	SymbolicExpression arg = n.getHs().accept(this);
	if (arg.isConstant() > 0) {
	    return new Constant(Math.log10(arg.getValue()));
	} else {
	    return new Log(arg);
	}
    }

    public SymbolicExpression visit(Multiplication n) {
	SymbolicExpression lArg = n.getLhs().accept(this);
	SymbolicExpression rArg = n.getRhs().accept(this);
	if (lArg.isConstant() > 0 && rArg.isConstant() > 0) {
	    return new Constant(lArg.getValue() * rArg.getValue());
	} else {
	    return new Multiplication((lArg), (rArg));
	}
    }

    public SymbolicExpression visit(Negation n) {
	SymbolicExpression arg = n.getHs().accept(this);
	if (arg.isConstant() > 0) {
	    return new Constant(-arg.getValue());
	} else {
	    return new Negation(arg);
	}
    }

    public SymbolicExpression visit(Sin n) {
	SymbolicExpression arg = n.getHs().accept(this);
	if (arg.isConstant() > 0) {
	    return new Constant(Math.sin(arg.getValue()));
	} else {
	    return new Sin(arg);
	}
    }

    public SymbolicExpression visit(Subtraction n) {
	SymbolicExpression lArg = n.getLhs().accept(this);
	SymbolicExpression rArg = n.getRhs().accept(this);
	if (lArg.isConstant() > 0 && rArg.isConstant() > 0) {
	    return new Constant(lArg.getValue() - rArg.getValue());
	} else {
	    return new Subtraction((lArg), (rArg));
	}
    }

    public SymbolicExpression visit(Variable n) {
	if(this.env.containsKey(n)){
	    return this.env.get(n);
	}else {
	    String arg = n.getName();
	    return new Variable(arg);
	}
    }

    public SymbolicExpression visit(Quit n) {
	throw new IllegalArgumentException("Commands can't be evaluated.");
    }
    
    public SymbolicExpression visit(Vars n) {
	throw new IllegalArgumentException("Commands can't be evaluated.");
    }

    public SymbolicExpression visit(Clear n) {
	throw new IllegalArgumentException("Commands can't be evaluated.");
    }
}
