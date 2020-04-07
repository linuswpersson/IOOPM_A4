package org.ioopm.calculator.ast;
import java.util.*;

public class EvaluationVisitor implements Visitor {
    private Stack<Environment> envStack = new Stack<Environment>();

    public SymbolicExpression evaluate(SymbolicExpression topLevel, Environment env) {
        this.envStack.push(env);
	NamedConstantChecker ncc = new NamedConstantChecker();
	ReassignmentChecker rc = new ReassignmentChecker();
        ncc.check(topLevel);
	rc.check(topLevel);
	return topLevel.accept(this);
    }

    public SymbolicExpression visit(Conditional n) {
	SymbolicExpression lArg = n.getLhs().accept(this);
	SymbolicExpression rArg = n.getRhs().accept(this);
	if(lArg.isConstant() < 1 && rArg.isConstant() < 1) {
	    throw new IllegalExpressionException("Conditional with non-constants not allowed.");
	}
	int op = n.getOp();
	if(op < 1 || op > 5){
	    throw new IllegalExpressionException("Error: invalid operation value.");
	}
        switch(op) {
	case 1:
	    if(lArg.getValue() < rArg.getValue()){
		return n.getTru().accept(this);
	    }
	    break;
	case 2:
	    if(lArg.getValue() > rArg.getValue()){
		return n.getTru().accept(this);
	    }
	    break;
	case 3:
	    if(lArg.getValue() <= rArg.getValue()){
		return n.getTru().accept(this);
	    }
	    break;
	case 4:
	    if(lArg.getValue() >= rArg.getValue()){
		return n.getTru().accept(this);
	    }
	    break;

	case 5:
	    if(lArg.getValue() == rArg.getValue()){
		return n.getTru().accept(this);
	    }
	    break;
	}
	return n.getFal().accept(this);
    }
	


    public SymbolicExpression visit(Scope n) {
	Environment newEnv = new Environment();
	envStack.push(newEnv);
	SymbolicExpression hs = n.getHs().accept(this);
	envStack.pop();
	return hs;
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
	Environment currEnv = envStack.peek();
	currEnv.put((Variable)rArg, lArg);	
	return lArg;
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
	SymbolicExpression tmp = null;
        Stack<Environment> tmpStack = new Stack<Environment>();
	Environment currEnv = null;
	while(!this.envStack.empty()) {
	    currEnv = this.envStack.peek();
	    if(currEnv.containsKey(n)) {
		tmp = currEnv.get(n);
		break;
	    }
	    tmpStack.push(this.envStack.pop());
	}
	while(!tmpStack.empty()) {
	    this.envStack.push(tmpStack.pop());
	}
	if(tmp != null) {
	    return tmp;
	}
	else{
	    return n;
	}
    }

    public SymbolicExpression visit(FunctionCall n) {

        Sequence body = n.getBody();
	LinkedList<SymbolicExpression> argsList = n.getArgs();
	LinkedList<SymbolicExpression> valsList = n.getVals();
	LinkedList<SymbolicExpression> asignmentList = new LinkedList<SymbolicExpression>();
	if(n.getArgSize() != 0){
	    for(int i = 0; i < n.getArgSize(); i++){
		asignmentList.addFirst(new Assignment(valsList.get(i).accept(this), argsList.get(i)));
	    }
	}
	body.setArgs(asignmentList);
	Scope fc = new Scope(body);
	return fc.accept(this);
    }

    public SymbolicExpression visit(Sequence n){
	LinkedList<SymbolicExpression> arg = n.getArgs();
	LinkedList<SymbolicExpression> body = n.getBody();
	int ii = 0;
	for( ; ii < arg.size(); ii++){
	    arg.get(ii).accept(this);
	}
	int i = 0;
	for( ; i < body.size()-1; i++){
	    body.get(i).accept(this);
	}
	return body.get(i++).accept(this);
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

    public SymbolicExpression visit(End n) {
	throw new IllegalArgumentException("Commands can't be evaluated.");
    }
}

