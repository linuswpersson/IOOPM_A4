package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class LogTest extends TestCase {

    @Test
    public void testIsConstant() {
        Log l1 = new Log(new Constant(20.0));
	assertEquals(0, l1.isConstant());
    }

    @Test
    public void testIsCommand() {
        Log l1 = new Log(new Constant(20.0));
	assertFalse(l1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Log l1 = new Log(new Constant(20.0));
	assertEquals(0, l1.getPriority());
    }

    @Test
    public void testGetHs() {
        Log l1 = new Log(new Constant(25.0));
	Constant con1 = new Constant(25.0);
	assertEquals(con1, l1.getHs());
    }

    @Test
    public void testGetName() {
        Log l1 = new Log(new Constant(20.0));
	assertEquals("log", l1.getName());
    }

    @Test
    public void testConstantToString() {
        Log l1 = new Log(new Constant(20.0));
	assertEquals("log 20.0", l1.toString());
    }

    @Test
    public void testParenthesesToString() {
        Log l1 = new Log(new Addition(new Constant(40.0), new Variable("x")));
	assertEquals("log (40.0 + x)", l1.toString());
    }

    @Test
    public void testTrueEquals() {
        Log l1 = new Log(new Constant(20.0));
        Log l2 = new Log(new Constant(20.0));
	assertTrue(l1.equals(l2));
    }

    @Test
    public void testFalseValEquals() {
        Log l1 = new Log(new Constant(20.0));
        Log l2 = new Log(new Constant(40.0));
	assertFalse(l1.equals(l2));
    }

    @Test
    public void testFalseUnaryEquals() {
        Log l1 = new Log(new Constant(20.0));
        Cos c1 = new Cos(new Constant(20.0));
	assertFalse(l1.equals(c1));
    }

    @Test
    public void testFalseClassEquals() {
        Log l1 = new Log(new Constant(20.0));
        Constant c1 = new Constant(20.0);
	assertFalse(l1.equals(c1));
    }

    @Test
    public void testConstantEval() {
	Environment vars = new Environment();
        Log l1 = new Log(new Constant(100));
	assertEquals(new Constant(2), l1.eval(vars));
    }

    @Test
    public void testNonConstantEval() {
	Environment vars = new Environment();
        Log l1 = new Log(new Variable("x"));
	Log l2 = new Log(new Variable("x"));
	assertEquals(l2, l1.eval(vars));
    }
}
