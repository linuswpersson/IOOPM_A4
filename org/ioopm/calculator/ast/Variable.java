package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * Class that represents input variables.
 */
public class Variable extends Atom implements Comparable<Variable> {
    private String identifier;

    public Variable(String identifier) {
	this.identifier = identifier;
    }

    @Override
    public String toString() {
	return this.identifier;
    }

    @Override
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

    @Override
    public int compareTo(Variable otherVariable) {
	String s1 = this.identifier;
	String s2 = otherVariable.getName();
        int l1 = s1.length();
	int l2 = s2.length();
	int min = Math.min(l1, l2);
	char c1;
	char c2;
	for(int i = 0; i < min; i++) {
	    c1 = s1.charAt(i);
	    c2 = s2.charAt(i);
	    if(c1 != c2) {
		return c1 - c2;
	    }
	}
	return l1 - l2;	    
    }

    @Override
    public String getName() {
	return this.identifier;
    }

    @Override
    public SymbolicExpression accept(Visitor v) {
	return v.visit(this);
    }

    @Override
    public int hashCode() {
    	String hashString = this.identifier;
    	int hash = 7;
    	for (int i = 0; i < hashString.length(); i++) {
    	    hash = hash*31 + hashString.charAt(i);
    	}
    	return hash;
    }
}
