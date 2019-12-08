package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class ClearTest extends TestCase {

    @Test
    public void testIsCommand() {
	SymbolicExpression c1 = Clear.instance();
	assertTrue(c1.isCommand());
    }

    @Test
    public void testGetPriority() {
	SymbolicExpression c1 = Clear.instance();
	assertEquals(0, c1.getPriority());
    }

    @Test
    public void testIsConstant() {
	SymbolicExpression c1 = Clear.instance();
	assertEquals(0, c1.isConstant());
    }

    @Test
    public void testGetName() {
	SymbolicExpression c1 = Clear.instance();
	try{
	    String ignore = c1.getName();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testGetValue() {
	SymbolicExpression c1 = Clear.instance();
	try{
	    double ignore = c1.getValue();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testAccept() {
	Environment vars = new Environment();
        EvaluationVisitor evaluator = new EvaluationVisitor();
	SymbolicExpression c1 = Clear.instance();
	try{
	    SymbolicExpression ignore = evaluator.evaluate(c1, vars);
	} catch(IllegalArgumentException ex) {
	    assertTrue(ex instanceof IllegalArgumentException);
	}
    }
}
