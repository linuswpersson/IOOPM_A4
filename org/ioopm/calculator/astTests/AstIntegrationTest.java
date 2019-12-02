package org.ioopm.calculator.astTests;
import org.ioopm.calculator.ast.*;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;


public class AstIntegrationTest extends TestCase {

    @Test
    public void testevalMultipleAssignment() {
	Environment vars = new Environment();
	Variable v1 = new Variable("foo");
	Variable v2 = new Variable("bar");
        Constant c1 = new Constant(45);
	SymbolicExpression f1 = new Assignment(c1, v1);
        SymbolicExpression f2 = new Assignment(f1, v2);
        assertEquals(c1, f1.eval(vars));
        assertEquals(c1, f2.eval(vars));
    }

    @Test
    public void testevalMultipleAssignmentExpression() {
	Environment vars = new Environment();
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
        assertEquals(c4, f3.eval(vars));
    }

    @Test
    public void testevalNegativeUnary() {
	Environment vars = new Environment();
        Constant c1 = new Constant(0);
        Constant c2 = new Constant(30);
        Constant c3 = new Constant(-30);
	SymbolicExpression f2 = new Subtraction(new Sin(c1), c2);
	assertEquals(c3, f2.eval(vars));
    }

    @Test
    public void testevalNonCalculableAssignment() {
	Environment vars = new Environment();
	SymbolicExpression f1 = new Addition(new Variable("bar"), new Constant(35));
	SymbolicExpression f2 = new Assignment(f1, new Variable("foo"));
	assertEquals(f1, f2.eval(vars));
    }

    @Test
    public void testevalCommand() {
	Environment vars = new Environment();
	SymbolicExpression f1 = new Addition(new Subtraction(Quit.instance(), new Variable("foo")), new Addition(new Constant(45), new Constant(30)));
	try{
	    SymbolicExpression ignore = f1.eval(vars);
	} catch(IllegalArgumentException ex) {
	    assertTrue(ex instanceof IllegalArgumentException);
	}
    }

    @Test
    public void testevalSeveralNegative() {
	Environment vars = new Environment();
	SymbolicExpression f1 = new Negation(new Negation(new Negation(new Negation(new Negation(new Negation(new Negation(new Constant(-45))))))));
	Constant c1 = new Constant(45);
	assertEquals(c1, f1.eval(vars));
    }    
}
