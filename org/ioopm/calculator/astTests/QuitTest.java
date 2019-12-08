package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class QuitTest extends TestCase {

    @Test
    public void testIsCommand() {
	SymbolicExpression q1 = Quit.instance();
	assertTrue(q1.isCommand());
    }

    @Test
    public void testGetPriority() {
	SymbolicExpression q1 = Quit.instance();
	assertEquals(0, q1.getPriority());
    }

    @Test
    public void testIsConstant() {
	SymbolicExpression q1 = Quit.instance();
	assertEquals(0, q1.isConstant());
    }

    @Test
    public void testGetName() {
	SymbolicExpression q1 = Quit.instance();
	try{
	    String ignore = q1.getName();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testGetValue() {
	SymbolicExpression q1 = Quit.instance();
	try{
	    double ignore = q1.getValue();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testAccept() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
	SymbolicExpression q1 = Quit.instance();
	try{
	    SymbolicExpression ignore = evaluator.evaluate(q1, vars);
	} catch(IllegalArgumentException ex) {
	    assertTrue(ex instanceof IllegalArgumentException);
	}
    }
}
