package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * Class representing a command that prints out all user assigned variables.
 * @see Used only as a indicator.
 */
public class Vars extends Command {
    
    private static final Vars theInstance = new Vars();
    
    private Vars() {}
    
    public static Vars instance() {
	
        return theInstance;
    }

    public SymbolicExpression eval(Environment vars) {
	throw new IllegalArgumentException("Commands can't be evaluated.");
    }

    public boolean isCommand() {
	return true;
    }
}
