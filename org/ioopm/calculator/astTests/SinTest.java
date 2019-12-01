package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class SinTest extends TestCase {

    @Test
    public void testIsConstant() {
        Sin s1 = new Sin(new Constant(20.0));
	assertEquals(0, s1.isConstant());
    }

    @Test
    public void testIsCommand() {
        Sin s1 = new Sin(new Constant(20.0));
	assertFalse(s1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Sin s1 = new Sin(new Constant(20.0));
	assertEquals(0, s1.getPriority());
    }

    @Test
    public void testGetHs() {
        Sin s1 = new Sin(new Constant(25.0));
	Constant con1 = new Constant(25.0);
	assertEquals(con1, s1.getHs());
    }

    @Test
    public void testGetName() {
        Sin s1 = new Sin(new Constant(20.0));
	assertEquals("sin", s1.getName());
    }

    @Test
    public void testConstantToString() {
        Sin s1 = new Sin(new Constant(20.0));
	assertEquals("sin 20.0", s1.toString());
    }

    @Test
    public void testParenthesesToString() {
        Sin s1 = new Sin(new Addition(new Constant(40.0), new Variable("x")));
	assertEquals("sin (40.0 + x)", s1.toString());
    }

    @Test
    public void testTrueEquals() {
        Sin s1 = new Sin(new Constant(20.0));
        Sin s2 = new Sin(new Constant(20.0));
	assertTrue(s1.equals(s2));
    }

    @Test
    public void testFalseValEquals() {
        Sin s1 = new Sin(new Constant(20.0));
        Sin s2 = new Sin(new Constant(40.0));
	assertFalse(s1.equals(s2));
    }

    @Test
    public void testFalseUnaryEquals() {
        Sin s1 = new Sin(new Constant(20.0));
        Cos c1 = new Cos(new Constant(20.0));
	assertFalse(s1.equals(c1));
    }

    @Test
    public void testFalseClassEquals() {
        Sin s1 = new Sin(new Constant(20.0));
        Constant c1 = new Constant(20.0);
	assertFalse(s1.equals(c1));
    }

    @Test
    public void testConstantEval() {
	Environment vars = new Environment();
        Sin s1 = new Sin(new Constant(0));
	assertEquals(new Constant(0), s1.eval(vars));
    }

    @Test
    public void testNonConstantEval() {
	Environment vars = new Environment();
        Sin s1 = new Sin(new Variable("x"));
	Sin s2 = new Sin(new Variable("x"));
	assertEquals(s2, s1.eval(vars));
    }
}
