package org.ioopm.calculator.ast;

public class FullEvaluationVisitor implements Visitor {
    private Environment env = null;

    public SymbolicExpression evaluate(SymbolicExpression topLevel, Environment env) {
	this.env = env;
	NamedConstantChecker ncc = new NamedConstantChecker();
	ReassignmentChecker rc = new ReassignmentChecker();
        ncc.check(topLevel);
	rc.check(topLevel);
	return topLevel.accept(this);
    }
    
    public SymbolicExpression visit(Addition n) {
	SymbolicExpression lArg = n.getLhs().accept(this);
	SymbolicExpression rArg = n.getRhs().accept(this);
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
	    SymbolicExpression topLevel = n;
	    while(topLevel.get_parent() != null) {
		topLevel = topLevel.get_parent();
	    }
	    throw new UndefinedVariableException(" '" + n.getName() + "' is undefined in \n" + n.get_parent() + " in \n" + "    " + topLevel);
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
