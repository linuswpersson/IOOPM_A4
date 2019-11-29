package org.ioopm.calculator;
import org.ioopm.calculator.parser.*;
import org.ioopm.calculator.ast.*;
import java.util.HashMap;
import java.io.IOException;
import java.util.Scanner;
import java.io.StringReader;
import java.io.*;
import java.util.*;

/**
 * Class that initializes the necessary data and runs the calculator. 
 */
class Calculator {
    private static int expressionsEntered = 0;
    private static int successEvaluated = 0;
    private static int fullyEvaluated = 0;

    
    	/**
	 * Main function for the calculator.
	 */
    public static void main(String[] args) {
        Environment vars = new Environment();
	boolean event = true;
	System.out.println("Welcome to the parser!");
       	System.out.print("Please enter an expression: ");
	Scanner sc = new Scanner(System.in);
	String expression = sc.nextLine();
	CalculatorParser p = new CalculatorParser(expression);
	while(event) {
	    try {
		SymbolicExpression result = p.parse();

		if (result.isCommand()) {
		    if(result == Quit.instance()) {
			event = false;
		    }
		    else if (result == Vars.instance()) {
			System.out.println(vars);
		    }
		    else{
		        vars.clear();
		    }
		}
		else {
		    SymbolicExpression evaluation = result.eval(vars);
		    successEvaluated++;
		    if (evaluation.isConstant() > 0){
			fullyEvaluated++;
		    }
		    System.out.println(evaluation);
		    System.out.println("Please enter an expression: ");
		}
	    }catch(IllegalExpressionException e) {
		System.out.print("Assignment Error: ");
	        System.out.println(e.getMessage());
	    }catch(SyntaxErrorException e) {
		System.out.print("Syntax Error: ");
		System.out.println(e.getMessage());
	    }catch(IOException e) {
		System.err.println("IO Exception!");
	    }
	    if(event){
		String str = sc.nextLine();
		expressionsEntered++;
		p.updateString(str);
	    }
	}
	System.out.println("\nprogram terminated.\n"
			   +"\n------Statistics------\n"
			   +"Expressions entered: " + expressionsEntered
			   +"\nSuccessfully evaluated: " + successEvaluated
			   +"\nFully evaluated: " + fullyEvaluated);
    }
}
