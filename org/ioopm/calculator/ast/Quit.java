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

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }

    public boolean isCommand() {
	return true;
    }
    
}
