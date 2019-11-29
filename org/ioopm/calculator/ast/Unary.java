package org.ioopm.calculator.ast;
import java.util.HashMap;
/**
 * Abstract class for Unary nodes.
 */
public abstract class Unary extends SymbolicExpression {
    private SymbolicExpression hs = null;

    public Unary(SymbolicExpression hs) {
	this.hs = hs;
    }
/**
 * Converts a unary tree to a string with perentesis if needed.
 * @return String representation of the unary tree.
 */
    public String toString() {
	if(this.hs.getPriority() > 0){
	    return this.getName() + " " + "(" + this.hs.toString() + ")"; 
	}
	return this.getName() + " " + this.hs.toString();
    }
    public boolean equals(Object other) {
	if (other instanceof Unary) {
	    return this.equals((Unary) other);
	} else {
	    return false;
	}
    }

    public boolean equals(Unary other) {
        if(this.getName() == other.getName()){ 
	    return this.hs.equals(other.hs);
	}
	else{
	    return false;
	}
    }

    public SymbolicExpression getHs() {
	return this.hs;
    }

    

}
