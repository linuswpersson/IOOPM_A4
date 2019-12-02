package org.ioopm.calculator.parserTests;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;
import java.io.IOException;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;

public class ParserTest extends TestCase {

    @Test
    public void testParseConstant1() {
	SymbolicExpression f1 = new Constant(20);
	String expression = f1.toString();
	CalculatorParser p = new CalculatorParser(expression);
	try {
	    SymbolicExpression result = p.parse();
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
	SymbolicExpression f1 = new Constant(40);
	String expression = f1.toString();
	CalculatorParser p = new CalculatorParser(expression);
	try {
	    SymbolicExpression result = p.parse();
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
	SymbolicExpression f1 = new Variable("foo");
	String expression = f1.toString();
	CalculatorParser p = new CalculatorParser(expression);
	try {
	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Variable("bar");
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Namedconstant(3.141592653589793, "pi");
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Namedconstant(42.0, "Answer");
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Sin(new Constant(45.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Sin(new Variable("foo"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Sin(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Log(new Constant(5.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Log(new Variable("bar"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Log(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Exp(new Constant(50.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Exp(new Variable("y"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Exp(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Cos(new Constant(2.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Cos(new Variable("varr"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Cos(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Negation(new Constant(80.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Negation(new Variable("N"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Negation(new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Sin(new Cos(new Exp(new Log(new Sin(new Cos(new Negation(new Cos(new Exp(new Constant(5.0))))))))));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Addition(new Constant(4.0), new Variable("foo"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Addition(new Addition(new Variable("t"), new Constant(5.0)), new Variable("z"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Addition(new Addition(new Addition(new Constant(30.0), new Constant(5.0)), new Namedconstant(3.141592653589793, "pi")), new Variable("x"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Subtraction(new Variable("bar"), new Constant(10.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Subtraction(new Subtraction(new Variable("foo"), new Constant(40.0)), new Constant(10.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Subtraction(new Subtraction(new Subtraction(new Namedconstant(42.0, "Answer"), new Constant(40.0)), new Variable("bar")), new Constant(0.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Division(new Constant(40.0), new Variable("xyz"));
	    String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Division(new Division(new Constant(60.0), new Constant(20.0)), new Variable("ssp"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Division(new Division(new Division(new Division(new Namedconstant(42.0, "Answer"), new Constant(40.0)), new Constant(3.0)), new Namedconstant(3.141592653589793, "pi")), new Variable("mbk"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Multiplication(new Variable("bar"), new Constant(6.0));
	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Multiplication(new Multiplication(new Constant(50.0), new Variable("f")), new Constant(10.0));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
    	SymbolicExpression f1 = new Multiplication(new Multiplication(new Multiplication(new Multiplication(new Constant(50.0), new Constant(40.0)), new Variable("foo")), new Constant(3.0)), new Namedconstant(42.0, "Answer"));
    	String expression = f1.toString();
    	CalculatorParser p = new CalculatorParser(expression);
    	try {
    	    SymbolicExpression result = p.parse();
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
