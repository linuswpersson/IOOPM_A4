package org.ioopm.calculator.ast;
import java.util.HashMap;

/** 
 * Top-class of the AST that all other node-types inherites from.
 */
public abstract class SymbolicExpression {
    private SymbolicExpression parent = null;

    /** 
     *  Used to check whether a SymbolicExpression is a variable, namedconstant, or other.
     * @return 0 if other, 1 if constant, or 2 if namedconstant.
     */
    public int isConstant() {
	return 0;
    }

    /** 
     * gets the name (or symbol) of a perticular SymbolicExpression.
     * @return the name(or symbol) of the SymbolicExpression as a string. Commands will throw exception.
     * @throws RuntimeException.
     */
    public String getName() {
	throw new RuntimeException("getName() called on expression with no operator");
    }
    
    /** 
     * Returns the priority of a preticular SymbolicExpression. Used for correct parenthasis placement.
     * @return int representing SymbolicExpression priority.
     */
    public int getPriority() {
	return 0;
    }

    /** 
     * Fetches the numeric value of a SymbolicExpression if able.
     * @return double with SymbolicExpression value if able.
     * @throws RuntimeException.
     */
    public double getValue() {
	throw new RuntimeException("getValue() called on non-constant");
    }

    public SymbolicExpression accept(Visitor v) {
        return this;
    }

    public boolean isCommand() {
	return false;
    }

    public void set_parent(SymbolicExpression parent) {
	this.parent = parent;
    }

    public SymbolicExpression get_parent() {
	return this.parent;
    }
}
