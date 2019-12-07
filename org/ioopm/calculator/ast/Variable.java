package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * Class that represents input variables.
 */
public class Variable extends Atom {
    private String identifier;

    public Variable(String identifier) {
	this.identifier = identifier;
    }

    public String toString() {
	return this.identifier;
    }

    public boolean equals(Object other) {
	if (other instanceof Variable) {
	    return this.equals((Variable) other);
	} else {
	    return false;
	}
    }

    public boolean equals(Variable other) {
	return this.identifier.equals(other.identifier);
    }

    public String getName() {
	return this.identifier;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }

    public int hashCode() {
    	String hashString = this.identifier;
    	int hash = 7;
    	for (int i = 0; i < hashString.length(); i++) {
    	    hash = hash*31 + hashString.charAt(i);
    	}
    	return hash;
    }
}
