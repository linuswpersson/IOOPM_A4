package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class CosTest extends TestCase {

    @Test
    public void testIsConstant() {
        Cos c1 = new Cos(new Constant(20.0));
	assertEquals(0, c1.isConstant());
    }

    @Test
    public void testIsCommand() {
        Cos c1 = new Cos(new Constant(20.0));
	assertFalse(c1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Cos c1 = new Cos(new Constant(20.0));
	assertEquals(0, c1.getPriority());
    }

    @Test
    public void testGetHs() {
        Cos c1 = new Cos(new Constant(25.0));
	Constant con1 = new Constant(25.0);
	assertEquals(con1, c1.getHs());
    }

    @Test
    public void testGetName() {
        Cos c1 = new Cos(new Constant(20.0));
	assertEquals("cos", c1.getName());
    }

    @Test
    public void testConstantToString() {
        Cos c1 = new Cos(new Constant(20.0));
	assertEquals("cos 20.0", c1.toString());
    }

    @Test
    public void testParenthesesToString() {
        Cos c1 = new Cos(new Addition(new Constant(40.0), new Variable("x")));
	assertEquals("cos (40.0 + x)", c1.toString());
    }

    @Test
    public void testTrueEquals() {
        Cos c1 = new Cos(new Constant(20.0));
        Cos c2 = new Cos(new Constant(20.0));
	assertTrue(c1.equals(c2));
    }

    @Test
    public void testFalseValEquals() {
        Cos c1 = new Cos(new Constant(20.0));
        Cos c2 = new Cos(new Constant(40.0));
	assertFalse(c1.equals(c2));
    }

    @Test
    public void testFalseUnaryEquals() {
        Cos c1 = new Cos(new Constant(20.0));
        Sin s1 = new Sin(new Constant(20.0));
	assertFalse(c1.equals(s1));
    }

    @Test
    public void testFalseClassEquals() {
        Cos c1 = new Cos(new Constant(20.0));
        Constant con1 = new Constant(20.0);
	assertFalse(c1.equals(con1));
    }

    @Test
    public void testConstantEval() {
	Environment vars = new Environment();
        Cos c1 = new Cos(new Constant(0));
	assertEquals(new Constant(1.0), c1.eval(vars));
    }

    @Test
    public void testNonConstantEval() {
	Environment vars = new Environment();
        Cos c1 = new Cos(new Variable("x"));
	Cos c2 = new Cos(new Variable("x"));
	assertEquals(c2, c1.eval(vars));
    }
}
