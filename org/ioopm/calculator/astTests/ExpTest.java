package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class ExpTest extends TestCase {

    @Test
    public void testIsConstant() {
        Exp e1 = new Exp(new Constant(20.0));
	assertEquals(0, e1.isConstant());
    }

    @Test
    public void testIsCommand() {
        Exp e1 = new Exp(new Constant(20.0));
	assertFalse(e1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Exp e1 = new Exp(new Constant(20.0));
	assertEquals(0, e1.getPriority());
    }

    @Test
    public void testGetName() {
        Exp e1 = new Exp(new Constant(20.0));
	assertEquals("10^", e1.getName());
    }

    @Test
    public void testConstantToString() {
        Exp e1 = new Exp(new Constant(20.0));
	assertEquals("10^ 20.0", e1.toString());
    }

    @Test
    public void testParenthesesToString() {
        Exp e1 = new Exp(new Addition(new Constant(40.0), new Variable("x")));
	assertEquals("10^ (40.0 + x)", e1.toString());
    }

    @Test
    public void testTrueEquals() {
        Exp e1 = new Exp(new Constant(20.0));
        Exp e2 = new Exp(new Constant(20.0));
	assertTrue(e1.equals(e2));
    }

    @Test
    public void testFalseValEquals() {
        Exp e1 = new Exp(new Constant(20.0));
        Exp e2 = new Exp(new Constant(40.0));
	assertFalse(e1.equals(e2));
    }

    @Test
    public void testFalseUnaryEquals() {
        Exp e1 = new Exp(new Constant(20.0));
        Cos c1 = new Cos(new Constant(20.0));
	assertFalse(e1.equals(c1));
    }

    @Test
    public void testFalseClassEquals() {
        Exp e1 = new Exp(new Constant(20.0));
        Constant c1 = new Constant(20.0);
	assertFalse(e1.equals(c1));
    }

    @Test
    public void testConstantEval() {
	Environment vars = new Environment();
        Exp e1 = new Exp(new Constant(2.0));
	assertEquals(new Constant(100), e1.eval(vars));
    }

    @Test
    public void testNonConstantEval() {
	Environment vars = new Environment();
	Exp e1 = new Exp(new Variable("x"));
	Exp e2 = new Exp(new Variable("x"));
	assertEquals(e2, e1.eval(vars));
    }
}
