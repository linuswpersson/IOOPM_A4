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

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }

    public boolean isCommand() {
	return true;
    }
}
