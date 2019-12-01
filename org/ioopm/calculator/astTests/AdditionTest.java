package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class AdditionTest extends TestCase {

    @Test
    public void testGetValue() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	try{
	    double ignore = a1.getValue();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testIsConstant() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	assertEquals(0, a1.isConstant());
    }

    @Test
    public void testgetLhs() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(25.0);
	assertEquals(c1, a1.getLhs());
    }

    @Test
    public void testgetRhs() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(5.0);
	assertEquals(c1, a1.getRhs());
    }

    @Test
    public void testGetName() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	assertEquals("+", a1.getName());
    }

    @Test
    public void testIsCommand() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	assertFalse(a1.isCommand());
    }

    @Test
    public void testGetPriority() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	assertEquals(1, a1.getPriority());
    }

    @Test
    public void testNoParenthesesConstantsToString() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	assertEquals("25.0 + 5.0", a1.toString());
    }

    @Test
    public void testNoParenthesesSamePriorityToString() {
	Addition a1 = new Addition(new Variable("foo"), new Constant(5.0));
	Addition a2 = new Addition(new Constant(25.0), a1);
	assertEquals("25.0 + foo + 5.0", a2.toString());
    }

    @Test
    public void testParenthesesDiffrentPriorityToString() {
        Multiplication a1 = new Multiplication(new Variable("foo"), new Constant(5.0));
	Addition a2 = new Addition(new Constant(25.0), a1);
	assertEquals("25.0 + (foo * 5.0)", a2.toString());
    }

        @Test
    public void testTrueEquals() {
	Addition a1 = new Addition(new Constant(25.0), new Variable("bar"));
	Addition a2 = new Addition(new Constant(25.0), new Variable("bar"));
	assertTrue(a1.equals(a2));
    }

    @Test
    public void testFalseValEquals() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	Addition a2 = new Addition(new Constant(25.0), new Constant(10.0));
	assertFalse(a1.equals(a2));
    }

    @Test
    public void testFalseClassEquals() {
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(30.0);
	assertFalse(a1.equals(c1));
    }

    @Test
    public void testCalculableEval() {
	Environment vars = new Environment();
	Addition a1 = new Addition(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(30.0);
	assertEquals(c1, a1.eval(vars));
    }

    @Test
    public void testNonCalculableEval() {
	Environment vars = new Environment();
	Addition a1 = new Addition(new Constant(25.0), new Variable("foo"));
	Addition a2 = new Addition(new Constant(25.0), new Variable("foo"));
	assertEquals(a2, a1.eval(vars));
    }
}
