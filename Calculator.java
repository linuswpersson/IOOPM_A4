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

	final HashMap<String, FunctionDeclaration> functionMap = new HashMap<String, FunctionDeclaration>();
	
        Environment vars = new Environment();
	boolean event = true;
	System.out.println("Welcome to the parser!");
       	System.out.print("Please enter an expression: ");
	Scanner sc = new Scanner(System.in);
	String expression = sc.nextLine();
	CalculatorParser p = new CalculatorParser(expression);
        final EvaluationVisitor eval = new EvaluationVisitor();
	while(event) {
	    try {
		SymbolicExpression result = p.parse(functionMap);
		if (result.isCommand()) {
		    if(result == Quit.instance()) {
			event = false;
		    }
		    else if (result == Vars.instance()) {
			System.out.println(vars);
		    }
		    else if(result == End.instance()){
			
		    }
		    else{
		        vars.clear();
			System.out.println("Variables cleared.");
		    }
		}
	
		else if(result.isFuncDec()){
		    FunctionDeclaration funcDec = new FunctionDeclaration(result.getName(), result.getArgs());
		    
		    functionMap.put(funcDec.getName(), funcDec);
	    
		    SymbolicExpression newLine;
		    Sequence body = new Sequence();

		    String str1 = sc.nextLine();
		    p.updateString(str1);
		    newLine = p.parse(functionMap);
		    while(newLine != End.instance()){
			body.addLine(newLine);
			String str2 = sc.nextLine();
			p.updateString(str2);
			newLine = p.parse(functionMap);
		    }
		    if(body.getBody().size() == 0){
			throw new SyntaxErrorException("Empty function not allowed.");
		    }
		    funcDec.addBody(body);
		    functionMap.put(funcDec.getName(), funcDec);
		}
		else {
		    
		    SymbolicExpression evaluation;
		    evaluation = eval.evaluate(result, vars);
		    successEvaluated++;
		    if (evaluation.isConstant() > 0){
		    	fullyEvaluated++;
		    }
		    System.out.println(evaluation);
		}
	    }catch(UndefinedVariableException e) {
	        System.out.print("Error:");
	        System.out.println(e.getMessage());
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
	        System.out.println("Please enter an expression: ");
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
