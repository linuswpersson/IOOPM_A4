package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class NegationTest extends TestCase {

    @Test
    public void testIsConstant() {
        Negation n1 = new Negation(new Constant(20.0));
	assertEquals(0, n1.isConstant());
    }

    @Test
    public void testIsCommand() {
        Negation n1 = new Negation(new Constant(20.0));
	assertFalse(n1.isCommand());
    }

    @Test
    public void testGetPriority() {
        Negation n1 = new Negation(new Constant(20.0));
	assertEquals(0, n1.getPriority());
    }

    @Test
    public void testGetHs() {
        Negation n1 = new Negation(new Constant(25.0));
	Constant con1 = new Constant(25.0);
	assertEquals(con1, n1.getHs());
    }

    @Test
    public void testGetName() {
        Negation n1 = new Negation(new Constant(20.0));
	assertEquals("-", n1.getName());
    }

    @Test
    public void testConstantToString() {
        Negation n1 = new Negation(new Constant(20.0));
	assertEquals("- 20.0", n1.toString());
    }

    @Test
    public void testParenthesesToString() {
        Negation n1 = new Negation(new Addition(new Constant(40.0), new Variable("x")));
	assertEquals("- (40.0 + x)", n1.toString());
    }

    @Test
    public void testTrueEquals() {
        Negation n1 = new Negation(new Constant(20.0));
        Negation n2 = new Negation(new Constant(20.0));
	assertTrue(n1.equals(n2));
    }

    @Test
    public void testFalseValEquals() {
        Negation n1 = new Negation(new Constant(20.0));
        Negation n2 = new Negation(new Constant(40.0));
	assertFalse(n1.equals(n2));
    }

    @Test
    public void testFalseUnaryEquals() {
	Negation n1 = new Negation(new Constant(20.0));
        Sin s1 = new Sin(new Constant(20.0));
	assertFalse(n1.equals(s1));
    }

    @Test
    public void testFalseClassEquals() {
        Negation n1 = new Negation(new Constant(20.0));
        Constant c1 = new Constant(20.0);
	assertFalse(n1.equals(c1));
    }

    @Test
    public void testConstantAccept() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
        Negation n1 = new Negation(new Constant(50.0));
	Constant c1 = new Constant(-50);
	assertEquals(c1, evaluator.evaluate(n1, vars));
    }

    @Test
    public void testNonConstantAccept() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
        Negation n1 = new Negation(new Variable("x"));
        Negation n2 = new Negation(new Variable("x"));
	assertEquals(n2, evaluator.evaluate(n1, vars));
    }
}
