package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class SubtractionTest extends TestCase {

    @Test
    public void testGetValue() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	try{
	    double ignore = s1.getValue();
	} catch(RuntimeException ex) {
	    assertTrue(ex instanceof RuntimeException);
	}
    }

    @Test
    public void testIsConstant() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	assertEquals(0, s1.isConstant());
    }

    @Test
    public void testgetLhs() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(25.0);
	assertEquals(c1, s1.getLhs());
    }

    @Test
    public void testgetRhs() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(5.0);
	assertEquals(c1, s1.getRhs());
    }

    @Test
    public void testGetName() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	assertEquals("-", s1.getName());
    }

    @Test
    public void testIsCommand() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	assertFalse(s1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	assertEquals(1, s1.getPriority());
    }

    @Test
    public void testNoParenthesesConstantsToString() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	assertEquals("25.0 - 5.0", s1.toString());
    }

    @Test
    public void testNoParenthesesSamePriorityToString() {
        Subtraction s1 = new Subtraction(new Variable("foo"), new Constant(5.0));
	Subtraction s2 = new Subtraction(new Constant(25.0), s1);
	assertEquals("25.0 - foo - 5.0", s2.toString());
    }

    @Test
    public void testParenthesesDiffrentPriorityToString() {
        Multiplication m1 = new Multiplication(new Variable("foo"), new Constant(5.0));
	Subtraction s2 = new Subtraction(new Constant(25.0), m1);
	assertEquals("25.0 - (foo * 5.0)", s2.toString());
    }

    @Test
    public void testTrueEquals() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Variable("bar"));
        Subtraction s2 = new Subtraction(new Constant(25.0), new Variable("bar"));
	assertTrue(s1.equals(s2));
    }

    @Test
    public void testFalseValEquals() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	Subtraction s2 = new Subtraction(new Constant(25.0), new Constant(10.0));
	assertFalse(s1.equals(s2));
    }

    @Test
    public void testFalseClassEquals() {
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(20.0);
	assertFalse(s1.equals(c1));
    }

    @Test
    public void testCalculableAccept() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
        Subtraction s1 = new Subtraction(new Constant(25.0), new Constant(5.0));
	Constant c1 = new Constant(20.0);
	assertEquals(c1, evaluator.evaluate(s1, vars));
    }

    @Test
    public void testNonCalculableAccept() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
	Subtraction s1 = new Subtraction(new Constant(25.0), new Variable("foo"));
	Subtraction s2 = new Subtraction(new Constant(25.0), new Variable("foo"));
	assertEquals(s2, evaluator.evaluate(s1, vars));
    }
}
