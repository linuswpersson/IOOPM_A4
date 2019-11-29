package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * Class representing a command that quits the program.
 * @see Used only as a indicator.
 */
public class Quit extends Command {
    private static final Quit theInstance = new Quit();
    
    private Quit() {}
    
    public static Quit instance() {
        return theInstance;
    }

    public SymbolicExpression eval(Environment vars) {
	throw new IllegalArgumentException("Commands can't be evaluated.");
    }

    public boolean isCommand() {
	return true;
    }
    
}
