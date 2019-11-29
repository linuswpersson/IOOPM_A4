package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class VariableTest extends TestCase {

    @Test
    public void testIsConstant() {
        Variable v1 = new Variable("foo");
	assertEquals(0, v1.isConstant());
    }

    @Test
    public void testIsCommand() {
        Variable v1 = new Variable("foo");
	assertFalse(v1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Variable v1 = new Variable("bar");
	assertEquals(0, v1.getPriority());
    }

    @Test
    public void testGetName() {
        Variable v1 = new Variable("bar");
	try{
	    String ignore = v1.getName();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testToString() {
        Variable v1 = new Variable("foo");
	assertEquals("foo", v1.toString());
    }

    @Test
    public void testTrueEquals() {
        Variable v1 = new Variable("bar");
        Variable v2 = new Variable("bar");
	assertTrue(v1.equals(v2));
    }

    @Test
    public void testFalseValEquals() {
        Variable v1 = new Variable("bar");
        Variable v2 = new Variable("foo");
	assertFalse(v1.equals(v2));
    }

    @Test
    public void testFalseClassEquals() {
        Variable v1 = new Variable("foo");
        String s1 = "foo";
	assertFalse(v1.equals(s1));
    }

    @Test
    public void testEvalNoAssignment() {
	Environment vars = new Environment();
        Variable v1 = new Variable("foo");
	assertEquals(v1, v1.eval(vars));
    }

    @Test
    public void testEvalWithAssignmentInEnvironment() {
	Environment vars = new Environment();
	SymbolicExpression v1 = new Variable("foo");
	SymbolicExpression assignment = new Constant(45);
	vars.put((Variable)v1, assignment);
        Variable v2 = new Variable("foo");
	Constant c1 = new Constant(45);
	assertEquals(c1, v2.eval(vars));
    }
}
