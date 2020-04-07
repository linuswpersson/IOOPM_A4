package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * Class representing a command that quits the program.
 * @see Used only as a function end-declaration indicator.
 */
public class End extends Command {
    private static final End theInstance = new End();
    
    private End() {}
    
    public static End instance() {
        return theInstance;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }

    @Override
    public boolean isCommand() {
	return true;
    }
    
}
