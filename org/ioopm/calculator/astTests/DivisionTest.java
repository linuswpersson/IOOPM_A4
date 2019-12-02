package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class DivisionTest extends TestCase {

    @Test
    public void testGetValue() {
        Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	try{
	    double ignore = d1.getValue();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testIsConstant() {
        Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	assertEquals(0, d1.isConstant());
    }

    @Test
    public void testgetLhs() {
        Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(25.0);
	assertEquals(c1, d1.getLhs());
    }

    @Test
    public void testgetRhs() {
        Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(5.0);
	assertEquals(c1, d1.getRhs());
    }

    @Test
    public void testGetName() {
        Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	assertEquals("/", d1.getName());
    }

    @Test
    public void testIsCommand() {
        Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	assertFalse(d1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	assertEquals(2, d1.getPriority());
    }

    @Test
    public void testNoParenthesesConstantsToString() {
        Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	assertEquals("25.0 / 5.0", d1.toString());
    }

    @Test
    public void testNoParenthesesSamePriorityToString() {
        Division d1 = new Division(new Variable("foo"), new Constant(5.0));
        Division d2 = new Division(new Constant(25.0), d1);
	assertEquals("25.0 / foo / 5.0", d2.toString());
    }

    @Test
    public void testParenthesesDiffrentPriorityToString() {
        Addition a1 = new Addition(new Variable("foo"), new Constant(5.0));
	Division d1 = new Division(new Constant(25.0), a1);
	assertEquals("25.0 / (foo + 5.0)", d1.toString());
    }

        @Test
    public void testTrueEquals() {
        Division d1 = new Division(new Constant(25.0), new Variable("bar"));
        Division d2 = new Division(new Constant(25.0), new Variable("bar"));
	assertTrue(d1.equals(d2));
    }

    @Test
    public void testFalseValEquals() {
	Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	Division d2 = new Division(new Constant(25.0), new Constant(10.0));
	assertFalse(d1.equals(d2));
    }

    @Test
    public void testFalseClassEquals() {
	Division d1 = new Division(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(30.0);
	assertFalse(d1.equals(c1));
    }

    @Test
    public void testCalculableEval() {
	Environment vars = new Environment();
	Division d1 = new Division(new Constant(30.0), new Constant(5.0));
	Constant c1 = new Constant(6.0);
	assertEquals(c1, d1.eval(vars));
    }

    @Test
    public void testNonCalculableEval() {
	Environment vars = new Environment();
        Division d1 = new Division(new Constant(25.0), new Variable("bar"));
        Division d2 = new Division(new Constant(25.0), new Variable("bar"));
	assertEquals(d2, d1.eval(vars));
    }
}
