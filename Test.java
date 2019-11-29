import org.ioopm.calculator.ast.*;
import java.util.HashMap;

public class Test {

    public static void testPrinting(String expected, SymbolicExpression e) {
	if (expected.equals("" + e)) {
	    System.out.println("Passed: " + e);
	} else {
	    System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
	}
    }

    public static void testEvaluating(SymbolicExpression expected, SymbolicExpression e, Environment  vars) {
	SymbolicExpression r = e.eval(vars);
	if (r.equals(expected)) {
	    System.out.println("Passed: " + r);
	} else {
	    System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
	}
    }


    public static void test1(Environment vars) {
	Constant c1 = new Constant(5);
	Constant c2 = new Constant(2);
	Variable v1 = new Variable("foo");
	Multiplication m1 = new Multiplication(v1, c2);
	testPrinting("foo * 2.0", m1);
    }

    public static void test2(Environment vars) {
	Constant c1 = new Constant(5);
	testPrinting("5.0", c1);
    }

    public static void test3(Environment vars) {
	Variable v1 = new Variable("foo");
	testPrinting("foo", v1);
    }

    public static void test4(Environment vars) {
        Constant c1 = new Constant(5);
	Sin s1 = new Sin(c1);
	testPrinting("sin 5.0", s1);
    }

    public static void test5(Environment vars) {
	Constant c1 = new Constant(0);
        Constant c2 = new Constant(2);
        Constant c3 = new Constant(0);
        Variable v1 = new Variable("foo");
	SymbolicExpression f1 = new Addition(c2, v1);
	SymbolicExpression f2 = new Addition(new Subtraction(c2, new Sin(c3)), v1);
	testEvaluating(f1, f2, vars);
    }

    public static void test6(Environment vars) {
        Constant c1 = new Constant(0);
        Constant c2 = new Constant(30);
	SymbolicExpression f1 = (new Constant(-30));
	SymbolicExpression f2 = new Subtraction(new Sin(c1), c2);
	testEvaluating(f1, f2, vars);
    }

    public static void test7(Environment vars) {
	Constant c1 = new Constant(50);
        SymbolicExpression f1 = new Addition(new Constant(30), new Constant(20));
        testEvaluating(c1, f1, vars);
    }

    public static void test8(Environment vars) {
	Constant c1 = new Constant(50);
        SymbolicExpression f1 = new Assignment(new Constant(50), new Variable("foo"));
        testEvaluating(c1, f1, vars);
    }

    public static void test9(Environment vars) {
        SymbolicExpression f1 = new Addition(new Variable("bar"), new Constant(35));
        SymbolicExpression f2 = new Assignment(f1, new Variable("foo"));
        testEvaluating(f1, f2, vars);
    }

    public static void test10(Environment vars) {
	Variable v1 = new Variable("foo");
	Variable v2 = new Variable("bar");
        Constant c1 = new Constant(45);
	SymbolicExpression f1 = new Assignment(c1, v1);
        SymbolicExpression f2 = new Assignment(f1, v2);
        testEvaluating(c1, f1, vars);
        testEvaluating(c1, f2, vars);
    }

    public static void test11(Environment vars) {
	Constant c1 = new Constant(5);
	Constant c2 = new Constant(2);
	Constant c3 = new Constant(90);
	Multiplication m1 = new Multiplication(c1, c2);
	Subtraction s1 = new Subtraction(c3,c1);
	Variable v1 = new Variable("foo");
	Variable v2 = new Variable("bar");
	SymbolicExpression f1 = new Assignment(s1, v1);
        SymbolicExpression f2 = new Assignment(m1, v2);
	SymbolicExpression f3 = new Assignment(new Addition(f1,f2), new Variable("ex"));
        testEvaluating(new Constant(95), f3, vars);
    }
    
    public static void main(String [] args) {

	Environment vars = new Environment();
        test1(vars);
	test2(vars);
        test3(vars);
	test4(vars);
        test5(vars);
        test6(vars);
	test7(vars);
	test8(vars);
	test9(vars);
	test10(vars);
        test11(vars);
    }
}
