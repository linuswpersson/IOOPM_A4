package org.ioopm.calculator.parserTests;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;
import java.io.IOException;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import java.util.*;

public class ParserTest extends TestCase {

    @Test
    public void testParseConstant1() {
        HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
	SymbolicExpression f1 = new Constant(20);
	String expression = f1.toString();
	CalculatorParser p = new CalculatorParser(expression);
	try {
	    SymbolicExpression result = p.parse(functionMap);
	    assertTrue(f1.equals(result));
	}catch(IllegalExpressionException e) {
	    System.out.print("Assignment Error: ");
	    System.out.println(e.getMessage());
	}catch(SyntaxErrorException e) {
	    System.out.print("Syntax Error: ");
	    System.out.println(e.getMessage());
	}catch(IOException e) {
	    System.err.println("IO Exception!");
	}
    }

    @Test
    public void testParseConstant2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
	SymbolicExpression f1 = new Constant(40);
	String expression = f1.toString();
	CalculatorParser p = new CalculatorParser(expression);
	try {
	    SymbolicExpression result = p.parse(functionMap);
	    assertTrue(f1.equals(result));
	}catch(IllegalExpressionException e) {
	    System.out.print("Assignment Error: ");
	    System.out.println(e.getMessage());
	}catch(SyntaxErrorException e) {
	    System.out.print("Syntax Error: ");
	    System.out.println(e.getMessage());
	}catch(IOException e) {
	    System.err.println("IO Exception!");
	}
    }

    @Test
    public void testParseVariable1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
	SymbolicExpression f1 = new Variable("foo");
	String expression = f1.toString();
	CalculatorParser p = new CalculatorParser(expression);
	try {
	    SymbolicExpression result = p.parse(functionMap);
	    assertTrue(f1.equals(result));
	}catch(IllegalExpressionException e) {
	    System.out.print("Assignment Error: ");
	    System.out.println(e.getMessage());
	}catch(SyntaxErrorException e) {
	    System.out.print("Syntax Error: ");
	    System.out.println(e.getMessage());
	}catch(IOException e) {
	    System.err.println("IO Exception!");
	}
    }

    @Test
    public void testParseVariable2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Variable("bar");
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseNamedconstant1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Namedconstant(3.141592653589793, "pi");
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseNamedconstant2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Namedconstant(42.0, "Answer");
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseSinConstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Sin(new Constant(45.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseSinVariable() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Sin(new Variable("foo"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseSinNamedconstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Sin(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseLogConstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Log(new Constant(5.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseLogVariable() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Log(new Variable("bar"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseLogNamedconstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Log(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseExpConstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Exp(new Constant(50.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseExpVariable() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Exp(new Variable("y"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseExpNamedconstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Exp(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseCosConstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Cos(new Constant(2.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseCosVariable() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Cos(new Variable("varr"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseCosNamedconstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Cos(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseNegationConstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Negation(new Constant(80.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseNegationVariable() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Negation(new Variable("N"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseNegationNamedconstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Negation(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }


    @Test
    public void testParseSeveralUnary() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Sin(new Cos(new Exp(new Log(new Sin(new Cos(new Negation(new Cos(new Exp(new Constant(5.0))))))))));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseAddition1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Addition(new Constant(4.0), new Variable("foo"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseAddition2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Addition(new Addition(new Variable("t"), new Constant(5.0)), new Variable("z"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseAddition3() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Addition(new Addition(new Addition(new Constant(30.0), new Constant(5.0)), new Namedconstant(3.141592653589793, "pi")), new Variable("x"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseSubtraction1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Subtraction(new Variable("bar"), new Constant(10.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseSubtraction2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Subtraction(new Subtraction(new Variable("foo"), new Constant(40.0)), new Constant(10.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseSubtraction3() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Subtraction(new Subtraction(new Subtraction(new Namedconstant(42.0, "Answer"), new Constant(40.0)), new Variable("bar")), new Constant(0.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseDivision1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Division(new Constant(40.0), new Variable("xyz"));
	    String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseDivision2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Division(new Division(new Constant(60.0), new Constant(20.0)), new Variable("ssp"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseDivision3() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Division(new Division(new Division(new Division(new Namedconstant(42.0, "Answer"), new Constant(40.0)), new Constant(3.0)), new Namedconstant(3.141592653589793, "pi")), new Variable("mbk"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseMultiplication1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Multiplication(new Variable("bar"), new Constant(6.0));
	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseMultiplication2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Multiplication(new Multiplication(new Constant(50.0), new Variable("f")), new Constant(10.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseMultiplication3() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Multiplication(new Multiplication(new Multiplication(new Multiplication(new Constant(50.0), new Constant(40.0)), new Variable("foo")), new Constant(3.0)), new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseAssignment1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Assignment(new Constant(5.0), new Variable("x"));
	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseAssignment2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Assignment(new Assignment(new Assignment(new Constant(45.0), new Variable("foo")), new Variable("bar")), new Variable("xyz"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseAssignmentNamedconstant() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Assignment(new Namedconstant(42.0, "Answer"), new Variable("foo"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	}catch(IllegalExpressionException e) {
    	    assertTrue(e instanceof IllegalExpressionException);
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseBrokenParentheses1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	String expression = "4 * (foo + bar";
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression ignore = p.parse(functionMap);
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    assertTrue(e instanceof SyntaxErrorException);
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    
    @Test
    public void testParseBrokenParentheses2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	String expression = "4 * (foo + sin 3+4*5+2))";
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression ignore = p.parse(functionMap);
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    assertTrue(e instanceof SyntaxErrorException);
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseMixedStresstest1() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Exp(new Subtraction(new Addition(new Addition(new Subtraction(new Addition(new Addition(new Constant(4.0), new Constant(5.0)), new Constant(7.0)), new Constant(3.0)), new Log(new Division(new Constant(7.0), new Constant(7.0)))), new Sin(new Sin(new Variable("h")))), new Negation(new Constant(6.0))));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseMixedStresstest2() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Cos(new Addition(new Assignment(new Assignment(new Constant(45.0), new Variable("x")), new Variable("g")), new Multiplication(new Division(new Division(new Variable("g"), new Variable("g")), new Constant(8.0)), new Negation(new Constant(40.0)))));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }

    @Test
    public void testParseMixedStresstest3() {
	HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
    	SymbolicExpression f1 = new Assignment(new Assignment(new Subtraction(new Addition(new Multiplication(new Multiplication(new Negation(new Assignment(new Assignment(new Subtraction(new Addition(new Multiplication(new Multiplication(new Negation(new Constant(1.0)), new Exp(new Constant(2.0))), new Log(new Constant(3.0))), new Division(new Division(new Sin(new Constant(4.0)), new Cos(new Constant(5.0))), new Constant(6.0))), new Division(new Multiplication(new Negation(new Constant(7.0)), new Negation(new Negation(new Negation(new Constant(8.0))))), new Constant(45.0))), new Variable("c")), new Variable("d"))), new Exp(new Variable("c"))), new Log(new Constant(3.0))), new Division(new Division(new Sin(new Constant(4.0)), new Cos(new Constant(5.0))), new Constant(6.0))), new Multiplication(new Division(new Multiplication(new Negation(new Constant(7.0)), new Negation(new Negation(new Negation(new Constant(8.0))))), new Namedconstant(3.141592653589793, "pi")), new Constant(2.0))), new Variable("a")), new Variable("b"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse(functionMap);
    	    assertTrue(f1.equals(result));
    	}catch(IllegalExpressionException e) {
    	    System.out.print("Assignment Error: ");
    	    System.out.println(e.getMessage());
    	}catch(SyntaxErrorException e) {
    	    System.out.print("Syntax Error: ");
    	    System.out.println(e.getMessage());
    	}catch(IOException e) {
    	    System.err.println("IO Exception!");
    	}
    }
}
