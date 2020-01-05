package org.ioopm.calculator.parser;
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
	this.st.ordinaryChar('=');
	this.st.ordinaryChar('*');
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
	this.st.ordinaryChar('=');
	this.st.ordinaryChar('*');
        this.st.eolIsSignificant(true);
    }

    /**
     * Parses a input expression.
     * @return A parsed SymbolicExpression tree of the input.
     * @throws IOException, SyntaxErrorException.
     */
    public SymbolicExpression parse() throws IOException {
	SymbolicExpression result = assignment();
	return result;
    }

    private SymbolicExpression assignment() throws IOException {
	SymbolicExpression result = expression();
	this.st.nextToken();
	while (this.st.ttype == '=') {
	    result = new Assignment(result, variable());
	    this.st.nextToken();
	}
	this.st.pushBack();
	return result;
    }

    private SymbolicExpression expression() throws IOException{
	SymbolicExpression result = term();
	this.st.nextToken();
	while (this.st.ttype == '+' || this.st.ttype == '-') {
	    int operation = this.st.ttype;
	    if (operation == '+') {
	        result = new Addition(result, term());
	    } else {
	        result = new Subtraction(result, term());
	    }
	      this.st.nextToken();
	}
	this.st.pushBack();
	return result;


    }

    private SymbolicExpression term() throws IOException {
	SymbolicExpression result = factor();
	this.st.nextToken();
	while (this.st.ttype == '*' || this.st.ttype == '/') {
	    int operation = this.st.ttype;
	    if (operation == '*') {
	        result = new Multiplication(result, factor());
	    } else {
	        result = new Division(result, factor());
	    }
	    this.st.nextToken();
	}
	this.st.pushBack();
	return result;
    }

    private SymbolicExpression factor() throws IOException {
	SymbolicExpression result;
	this.st.nextToken();
        if (this.st.ttype == '('){
            result = assignment();
            if (this.st.nextToken() != ')') {
                throw new SyntaxErrorException("expected ')'");
	    }
	} else if (this.st.ttype == '{'){
	    result = assignment();
            if (this.st.nextToken() != '}') {
                throw new SyntaxErrorException("expected '}'");
            }
        } else {
            this.st.pushBack();
            result = unary();
        }
        return result;
    }

    private SymbolicExpression unary() throws IOException {
	this.st.nextToken();
        if (this.st.sval != null) {
	    String operation = this.st.sval;
	    if (operation.equals("sin")) {
		return new Sin(factor());
	    }
	    else if (operation.equals("cos")) {
		return new Cos(factor());
	    }

	    else if (operation.equals("exp")) {
		return new Exp(factor());
	    }

	    else if (operation.equals("log")) {
		return new Log(factor());
	    }
	}
	this.st.pushBack();
	if (this.st.nextToken() == '-') {
	    return new Negation(factor());
	}
	else{
	    this.st.pushBack();
	    return number();
	}
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



    
