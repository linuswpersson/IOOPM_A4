package org.ioopm.calculator.parser;
import java.util.*;
import java.io.StreamTokenizer;
import java.io.IOException;
import org.ioopm.calculator.ast.*;
import java.io.StringReader;


	/**
	 * Class that parses the input expressions into SymbolicExpression-trees.
	 */
public class CalculatorParser {
    private StreamTokenizer st;
    
    	/**
	 * Creates a StreamTokenizer from input in the CalculatorParser attribute.
	 */
    public CalculatorParser(String expression) {
	this.st = new StreamTokenizer(new StringReader(expression));
        this.st.ordinaryChar('-');
	this.st.ordinaryChar('/');
	this.st.ordinaryChar('+');
	this.st.ordinaryChar('*');
	this.st.ordinaryChar('{');
	this.st.ordinaryChar('}');
	this.st.ordinaryChar(',');
	this.st.ordinaryChar('(');
	this.st.ordinaryChar(')');
        this.st.eolIsSignificant(true);
    }
    	/**
	 * Updates the StreamTokenizer from input in the CalculatorParser attribute.
	 */
    public void updateString(String expression){
	this.st = new StreamTokenizer(new StringReader(expression));
	this.st.ordinaryChar('-');
	this.st.ordinaryChar('/');
       	this.st.ordinaryChar('+');
	this.st.ordinaryChar('*');
	this.st.ordinaryChar('{');
	this.st.ordinaryChar('}');
	this.st.ordinaryChar(',');
	this.st.ordinaryChar('(');
	this.st.ordinaryChar(')');
        this.st.eolIsSignificant(true);
    }

    /**
     * Parses a input expression.
     * @return A parsed SymbolicExpression tree of the input.
     * @throws IOException, SyntaxErrorException.
     */
    public SymbolicExpression parse(HashMap<String, FunctionDeclaration> functionMap) throws IOException {
	return funcDef(functionMap);
    }

    public SymbolicExpression funcDef(HashMap<String, FunctionDeclaration> functionMap) throws IOException {
	this.st.nextToken();
        if(this.st.sval != null) {
	    String function = this.st.sval;
	    if(function.equalsIgnoreCase("function")){

		this.st.nextToken();
		if(this.st.sval == null){
		    
		}
		String funcName = this.st.sval;
		
		SymbolicExpression result;
		LinkedList<SymbolicExpression> argList = new LinkedList<SymbolicExpression>();
		this.st.nextToken();
		for(int i = 0; this.st.ttype != ')'; i++) {
		    result = number();
		    argList.add(result);
		    this.st.nextToken();
		}
		return new FunctionDeclaration(funcName, argList);
	    }
	}
	this.st.pushBack();
	return assignment(functionMap);
    }

    private SymbolicExpression assignment(HashMap<String, FunctionDeclaration> functionMap) throws IOException {
	SymbolicExpression result = expression(functionMap);
	this.st.nextToken();
	while (this.st.ttype == '=') {
	    result = new Assignment(result, variable());
	    this.st.nextToken();
	}
	this.st.pushBack();
	return result;
    }

    private SymbolicExpression expression(HashMap<String, FunctionDeclaration> functionMap) throws IOException{
	SymbolicExpression result = term(functionMap);
	this.st.nextToken();
	while (this.st.ttype == '+' || this.st.ttype == '-') {
	    int operation = this.st.ttype;
	    if (operation == '+') {
	        result = new Addition(result, term(functionMap));
	    } else {
	        result = new Subtraction(result, term(functionMap));
	    }
	      this.st.nextToken();
	}
	this.st.pushBack();
	return result;


    }

    private SymbolicExpression term(HashMap<String, FunctionDeclaration> functionMap) throws IOException {
	SymbolicExpression result = function(functionMap);
	this.st.nextToken();
	while (this.st.ttype == '*' || this.st.ttype == '/') {
	    int operation = this.st.ttype;
	    if (operation == '*') {
	        result = new Multiplication(result, function(functionMap));
	    } else {
	        result = new Division(result, function(functionMap));
	    }
	    this.st.nextToken();
	}
	this.st.pushBack();
	return result;
    }

    private SymbolicExpression function(HashMap<String, FunctionDeclaration> functionMap) throws IOException {
	this.st.nextToken();
	if (this.st.sval != null){
	    String function = this.st.sval;
	    if(functionMap.containsKey(function)) {

		SymbolicExpression result;
		FunctionDeclaration funcDec = functionMap.get(function);
		int argsSize = funcDec.getArgSize();
		LinkedList<SymbolicExpression> valList = new LinkedList<SymbolicExpression>();

		this.st.nextToken();
		int i = 0;
		for( ; this.st.ttype != ')'; i++) {
		    result = number();
		    valList.add(result);
		    this.st.nextToken();
		}

	        if(i < argsSize){
		    throw new SyntaxErrorException("Error, function " + function + " called with to few arguments. Expected " + argsSize + ", got " + i + ".");
		}
		if(i > argsSize){
		    throw new SyntaxErrorException("Error, function " + function + " called with to many arguments. Expected " + argsSize + ", got " + i + ".");
		}
	        System.out.println(valList.size());
		return new FunctionCall(function, valList, functionMap);
	    }
	}
	this.st.pushBack();
	return factor(functionMap);
    }

    private SymbolicExpression factor(HashMap<String, FunctionDeclaration> functionMap) throws IOException {
	SymbolicExpression result;
	this.st.nextToken();
        if (this.st.ttype == '('){
            result = assignment(functionMap);
            if (this.st.nextToken() != ')') {
                throw new SyntaxErrorException("expected ')'");
	    }
        } else {
            this.st.pushBack();
            result = unary(functionMap);
        }
        return result;
    }

    private SymbolicExpression unary(HashMap<String, FunctionDeclaration> functionMap) throws IOException {
	this.st.nextToken();
        if (this.st.sval != null) {
	    String operation = this.st.sval;
	    if (operation.equals("sin")) {
		return new Sin(factor(functionMap));
	    }
	    else if (operation.equals("cos")) {
		return new Cos(factor(functionMap));
	    }

	    else if (operation.equals("exp")) {
		return new Exp(factor(functionMap));
	    }

	    else if (operation.equals("log")) {
		return new Log(factor(functionMap));
	    }
	    
	}
	this.st.pushBack();
	if (this.st.nextToken() == '-') {
	    return new Negation(factor(functionMap));
	}
	
	else if (this.st.ttype == '{'){
	    SymbolicExpression result;
	    result = assignment(functionMap);
	    if (this.st.nextToken() != '}') {
		throw new SyntaxErrorException("expected '}'");
	    }
	    return new Scope(result);
	}
	else {
	    this.st.pushBack();
	    return conditional(functionMap);
	}
    }

    private SymbolicExpression conditional(HashMap<String, FunctionDeclaration> functionMap) throws IOException {
	this.st.nextToken();
	if(this.st.sval != null) {
	    String tmpS = this.st.sval;
	    if(tmpS.equals("if")) {
	        SymbolicExpression lhs;
		lhs = expression(functionMap);
		int op = opHelper();
		SymbolicExpression rhs;
		rhs = expression(functionMap);
		if(this.st.nextToken() != '{') {
		    throw new SyntaxErrorException("expected '{'");
		}
		SymbolicExpression tru;
		tru = assignment(functionMap);
		if(this.st.nextToken() != '}') {
		    System.out.println(this.st.sval);
		    System.out.println(this.st.ttype);
		    throw new SyntaxErrorException("expected '}'");
		}
		this.st.nextToken();
		if(this.st.sval != null) {
		    tmpS = this.st.sval;
		    if(!tmpS.equals("else")) {
			throw new SyntaxErrorException("expected 'else'");
		    }
		    else{
			if(this.st.nextToken() != '{') {
			    throw new SyntaxErrorException("expected '{'");
			}
			SymbolicExpression fal;
			fal = assignment(functionMap);
			if(this.st.nextToken() != '}') {
			    System.out.println(this.st.sval);
			    System.out.println(this.st.ttype);
			    throw new SyntaxErrorException("expected '}'");
			}
			return new Conditional(lhs, rhs, tru, fal, op);
		    }
		}
		else{
		    throw new SyntaxErrorException("expected 'else'");
		}		
	    }
	}
	this.st.pushBack();
	return number();
    }	

    private int opHelper() throws IOException {
	this.st.nextToken();
	int op = 0;
	int tmpC = this.st.ttype;
	switch(tmpC) {
	case '<':
	    if(this.st.nextToken() == '=') {
		op = 3;
	        return op;
	    }
	    this.st.pushBack();
	    tmpC = this.st.ttype;
	    op = 1;
	    return op;
	case '>':
	    if(this.st.nextToken() == '=') {
		op = 4;
		return op;
	    }
	    this.st.pushBack();
	    op = 2;
	    return op;
	case '=':
	    if(this.st.nextToken() == '=') {
		op = 5;
		return op;
	    }
	}
        throw new SyntaxErrorException("Invalid conditional input.");
    }

    private SymbolicExpression number() throws IOException {
	if (this.st.nextToken() == this.st.TT_NUMBER) {
	    return new Constant(this.st.nval);
	} else {
	    this.st.pushBack();
	    return variable();
	}
    }

    private SymbolicExpression variable() throws IOException {
	this.st.nextToken();
        if (this.st.sval != null) {
	    String operation = this.st.sval;
	    if (operation.equalsIgnoreCase("quit")) {
		return Quit.instance();
	    }
	    else if(operation.equalsIgnoreCase("vars")) {
		return Vars.instance();
	    }
	    else if(operation.equalsIgnoreCase("clear")) {
		return Clear.instance();
	    }
	    else if(Constants.namedConstants.containsKey(operation)) {
		return new Namedconstant(Constants.namedConstants.get(operation), operation);
	    }
	    else{
		return new Variable(this.st.sval);
	    }
	}
	throw new SyntaxErrorException("Invalid input");
    }
}



    
