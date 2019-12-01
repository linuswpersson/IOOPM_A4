package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class VarsTest extends TestCase {

    @Test
    public void testIsCommand() {
	SymbolicExpression v1 = Vars.instance();
	assertTrue(v1.isCommand());
    }

    @Test
    public void testGetPriority() {
	SymbolicExpression v1 = Vars.instance();
	assertEquals(0, v1.getPriority());
    }

    @Test
    public void testIsConstant() {
	SymbolicExpression v1 = Vars.instance();
	assertEquals(0, v1.isConstant());
    }

    @Test
    public void testGetName() {
	SymbolicExpression v1 = Vars.instance();
	try{
	    String ignore = v1.getName();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testGetValue() {
	SymbolicExpression v1 = Vars.instance();
	try{
	    double ignore = v1.getValue();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testEval() {
	Environment vars = new Environment();
	SymbolicExpression v1 = Vars.instance();
	try{
	    SymbolicExpression ignore = v1.eval(vars);
	} catch(IllegalArgumentException ex) {
	    assertTrue(ex instanceof IllegalArgumentException);
	}
    }
}
