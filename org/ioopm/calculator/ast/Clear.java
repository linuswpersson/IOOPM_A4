package org.ioopm.calculator.ast;
import java.util.HashMap;
/**
 * Class representing a command that clears all user assigned variables.
 * @see Used only as a indicator.
 */
public class Clear extends Command {
    private static final Clear theInstance = new Clear();
    
    private Clear() {}
    
    public static Clear instance() {
        return theInstance;
    }

    public SymbolicExpression eval(Environment vars) {
	throw new IllegalArgumentException("Commands can't be evaluated.");
    }

    public boolean isCommand() {
	return true;
    }
    
}
