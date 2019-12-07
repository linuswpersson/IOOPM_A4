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

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }

    public boolean isCommand() {
	return true;
    }
    
}
