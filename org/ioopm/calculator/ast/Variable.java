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

    /**
     * Override of eval function that exchanges user assigned variables to thier corresponding value if pre-assigned.
     * @param Enviroment that holds a hashmap with all user assigned variables and thier values.
     * @return a new Variable with input variable name if no value has been bound. otherwise, returns the SymbolicExpression bound to input Variable.
     */
    public SymbolicExpression eval(Environment vars) {
	if(vars.containsKey(this)){
	    return vars.get(this);
	}else {
	    String arg = this.identifier;
	    return new Variable(arg);
	}
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
