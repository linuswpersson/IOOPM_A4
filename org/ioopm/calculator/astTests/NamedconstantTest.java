package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class NamedconstantTest extends TestCase {

    @Test
    public void testIsConstant() {
        Namedconstant n1 = new Namedconstant(20.0, "foo");
	assertEquals(2, n1.isConstant());
    }

    @Test
    public void testIsCommand() {
        Namedconstant n1 = new Namedconstant(20.0, "foo");
	assertFalse(n1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Namedconstant n1 = new Namedconstant(20.0, "foo");
	assertEquals(0, n1.getPriority());
    }

    @Test
    public void testGetName() {
        Namedconstant n1 = new Namedconstant(20.0, "foo");
	try{
	    String ignore = n1.getName();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testToString() {
        Namedconstant n1 = new Namedconstant(20.0, "foo");
	assertEquals("foo", n1.toString());
    }

    @Test
    public void testTrueEquals() {
        Namedconstant n1 = new Namedconstant(100.0, "foo");
        Namedconstant n2 = new Namedconstant(100.0, "foo");
	assertTrue(n1.equals(n2));
    }

    @Test
    public void testFalseValEquals() {
        Namedconstant n1 = new Namedconstant(100.0, "foo");
        Namedconstant n2 = new Namedconstant(50.0, "foo");
	assertFalse(n1.equals(n2));
    }

    @Test
    public void testFalseIdentifierEquals() {
        Namedconstant n1 = new Namedconstant(100.0, "foo");
        Namedconstant n2 = new Namedconstant(100.0, "bar");
	assertFalse(n1.equals(n2));
    }

    @Test
    public void testFalseClassEquals() {
        Namedconstant n1 = new Namedconstant(100.0, "foo");
        Variable v1 = new Variable("foo");
	assertFalse(n1.equals(v1));
    }
}
