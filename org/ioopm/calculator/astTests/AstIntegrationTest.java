package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class AstIntegrationTest extends TestCase {

    @Test
    public void testAcceptMultipleAssignment() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
	Variable v1 = new Variable("foo");
	Variable v2 = new Variable("bar");
        Constant c1 = new Constant(45);
	SymbolicExpression f1 = new Assignment(c1, v1);
        SymbolicExpression f2 = new Assignment(f1, v2);
        assertEquals(c1, evaluator.evaluate(f1, vars));
        assertEquals(c1, evaluator.evaluate(f2, vars));
    }

    @Test
    public void testAcceptMultipleAssignmentExpression() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
	Constant c1 = new Constant(5);
	Constant c2 = new Constant(2);
	Constant c3 = new Constant(90);
        Constant c4 = new Constant(95);
	Multiplication m1 = new Multiplication(c1, c2);
	Subtraction s1 = new Subtraction(c3,c1);
	Variable v1 = new Variable("foo");
	Variable v2 = new Variable("bar");
	SymbolicExpression f1 = new Assignment(s1, v1);
        SymbolicExpression f2 = new Assignment(m1, v2);
	SymbolicExpression f3 = new Assignment(new Addition(f1,f2), new Variable("ex"));
        assertEquals(c4, evaluator.evaluate(f3, vars));
    }

    @Test
    public void testAcceptNegativeUnary() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
        Constant c1 = new Constant(0);
        Constant c2 = new Constant(30);
        Constant c3 = new Constant(-30);
	SymbolicExpression f2 = new Subtraction(new Sin(c1), c2);
	assertEquals(c3, evaluator.evaluate(f2, vars));
    }

    @Test
    public void testAcceptNonCalculableAssignment() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
	SymbolicExpression f1 = new Addition(new Variable("bar"), new Constant(35));
	SymbolicExpression f2 = new Assignment(f1, new Variable("foo"));
	assertEquals(f1, evaluator.evaluate(f2, vars));
    }

    @Test
    public void testAcceptCommand() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
	SymbolicExpression f1 = new Addition(new Subtraction(Quit.instance(), new Variable("foo")), new Addition(new Constant(45), new Constant(30)));
	try{
	    SymbolicExpression ignore = evaluator.evaluate(f1, vars);
	} catch(IllegalArgumentException ex) {
	    assertTrue(ex instanceof IllegalArgumentException);
	}
    }

    @Test
    public void testAcceptSeveralNegative() {
	Environment vars = new Environment();
	EvaluationVisitor evaluator = new EvaluationVisitor();
	SymbolicExpression f1 = new Negation(new Negation(new Negation(new Negation(new Negation(new Negation(new Negation(new Constant(-45))))))));
	Constant c1 = new Constant(45);
	assertEquals(c1, evaluator.evaluate(f1, vars));
    }    
}
