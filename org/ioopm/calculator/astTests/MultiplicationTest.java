package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class MultiplicationTest extends TestCase {

    @Test
    public void testGetValue() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	try{
	    double ignore = m1.getValue();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testIsConstant() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	assertEquals(0, m1.isConstant());
    }

    @Test
    public void testgetLhs() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(25.0);
	assertEquals(c1, m1.getLhs());
    }

    @Test
    public void testgetRhs() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(5.0);
	assertEquals(c1, m1.getRhs());
    }

    @Test
    public void testGetName() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	assertEquals("*", m1.getName());
    }

    @Test
    public void testIsCommand() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	assertFalse(m1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	assertEquals(2, m1.getPriority());
    }

    @Test
    public void testNoParenthesesConstantsToString() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	assertEquals("25.0 * 5.0", m1.toString());
    }

    @Test
    public void testNoParenthesesSamePriorityToString() {
	Multiplication m1 = new Multiplication(new Variable("foo"), new Constant(5.0));
	Multiplication m2 = new Multiplication(new Constant(25.0), m1);
	assertEquals("25.0 * foo * 5.0", m2.toString());
    }

    @Test
    public void testParenthesesDiffrentPriorityToString() {
        Addition a1 = new Addition(new Variable("foo"), new Constant(5.0));
	Multiplication m1 = new Multiplication(new Constant(25.0), a1);
	assertEquals("25.0 * (foo + 5.0)", m1.toString());
    }

    @Test
    public void testTrueEquals() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Variable("bar"));
        Multiplication m2 = new Multiplication(new Constant(25.0), new Variable("bar"));
	assertTrue(m1.equals(m2));
    }

    @Test
    public void testFalseValEquals() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
        Multiplication m2 = new Multiplication(new Constant(25.0), new Constant(10.0));
	assertFalse(m1.equals(m2));
    }

    @Test
    public void testFalseClassEquals() {
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(125.0);
	assertFalse(m1.equals(c1));
    }

    @Test
    public void testCalculableEval() {
	Environment vars = new Environment();
        Multiplication m1 = new Multiplication(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(125.0);
	assertEquals(c1, m1.eval(vars));
    }

    @Test
    public void testNonCalculableEval() {
	Environment vars = new Environment();
        Multiplication m1 = new Multiplication(new Constant(25.0), new Variable("foo"));
        Multiplication m2 = new Multiplication(new Constant(25.0), new Variable("foo"));
	assertEquals(m2, m1.eval(vars));
    }
}
