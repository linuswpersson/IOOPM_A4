package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class ConstantTest extends TestCase {

    @Test
    public void testgetValue() {
	Constant c1 = new Constant(10);
	assertEquals(10.0, c1.getValue());
    }

    @Test
    public void testNegGetValue() {
        Constant c1 = new Constant(-50);
	assertEquals(-50.0, c1.getValue());
    }

    @Test
    public void testIsConstant() {
        Constant c1 = new Constant(15);
	assertEquals(1, c1.isConstant());
    }

    @Test
    public void testIsCommand() {
        Constant c1 = new Constant(0);
	assertFalse(c1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Constant c1 = new Constant(35);
	assertEquals(0, c1.getPriority());
    }

    @Test
    public void testGetName() {
        Constant c1 = new Constant(35);
	try{
	    String ignore = c1.getName();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testToString() {
        Constant c1 = new Constant(40);
	assertEquals("40.0", c1.toString());
    }

    @Test
    public void testTrueEquals() {
        Constant c1 = new Constant(20);
	Constant c2 = new Constant(20);
	assertTrue(c1.equals(c2));
    }

    @Test
    public void testFalseValEquals() {
        Constant c1 = new Constant(20);
	Constant c2 = new Constant(80);
	assertFalse(c1.equals(c2));
    }

    @Test
    public void testFalseClassEquals() {
        Constant c1 = new Constant(20);
	String s1 = "foo";
	assertFalse(c1.equals(s1));
    }

    @Test
    public void testEval() {
	Environment vars = new Environment();
        Constant c1 = new Constant(20);
	assertEquals(c1, c1.eval(vars));
    }
}
