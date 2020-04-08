package org.ioopm.calculator.ast;
import java.util.*;

public class ReassignmentChecker implements Visitor {
    private Stack<Environment> envStack = new Stack<Environment>();
    private Boolean flag = true;

    public void setFlag() {
	this.flag = false;
    }

    public Boolean getFlag() {
	return this.flag;
    }
    
    public SymbolicExpression check(SymbolicExpression topLevel) {
	this.envStack.push(new Environment());
	SymbolicExpression checked = topLevel.accept(this);
	this.envStack.clear();
	return checked;
    }

    public SymbolicExpression visit(Conditional a) {
	a.getLhs().accept(this);
	a.getRhs().accept(this);
	a.getTru().accept(this);
	a.getFal().accept(this);
	return a;
    }

    public SymbolicExpression visit(Addition a) {
	a.getLhs().accept(this);
	a.getRhs().accept(this);
	return a;
    }

    public SymbolicExpression visit(Assignment a) {
	SymbolicExpression lArg = a.getLhs().accept(this);
	SymbolicExpression rArg = a.getRhs();
	Environment currEnv = this.envStack.peek();
	if (currEnv.containsKey(rArg)){
	    this.envStack.clear();
	    throw new IllegalExpressionException("the variable " + rArg + " is reassigned.");
	}
	currEnv.put((Variable)rArg, lArg);
	return a;
    }

    public SymbolicExpression visit(Constant a) {
	return a;
    }

    public SymbolicExpression visit(Scope a) {
	this.envStack.push(new Environment());
	a.getHs().accept(this);
	envStack.pop();
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

    public SymbolicExpression visit(FunctionCall a){
	if(this.getFlag()){
	    this.setFlag();
	    Sequence body = a.getBody();
	    LinkedList<SymbolicExpression> argsList = a.getArgs();
	    LinkedList<SymbolicExpression> valsList = a.getVals();
	    LinkedList<SymbolicExpression> asignmentList = new LinkedList<SymbolicExpression>();
	    if(a.getArgSize() != 0){
		for(int i = 0; i < a.getArgSize(); i++){
		    asignmentList.addFirst(new Assignment(valsList.get(i).accept(this), argsList.get(i)));
		}
	    }
	    body.setArgs(asignmentList);
	    Scope fc = new Scope(body);
	    fc.accept(this);
	}
	return a;
    }

    public SymbolicExpression visit(Sequence a){
        LinkedList<SymbolicExpression> arg = a.getArgs();
	LinkedList<SymbolicExpression> body = a.getBody();
	int ii = 0;
	for( ; ii < arg.size(); ii++){
	    arg.get(ii).accept(this);
	}
	int i = 0;
	for( ; i < body.size(); i++){
	    if(!(body.get(i) instanceof FunctionCall)){
		body.get(i).accept(this);
	    }
	}
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

    public SymbolicExpression visit(End a) {
	return a;
    }
}
