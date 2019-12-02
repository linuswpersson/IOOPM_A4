package org.ioopm.calculator.ast;
import java.util.HashMap;

/** Evaluates subtraction
 * Specific class for given Variable-constants.
 **/
public class Namedconstant extends Atom{
    private double value;
    private String identifier;

    public Namedconstant(double value, String identifier) {
	this.value = value;
	this.identifier = identifier;
    }

    public int isConstant() {
	return 2;
    }

    public double getValue() {
        return this.value;
    }

    public String toString() {
	return this.identifier;
    }

    public boolean equals(Object other) {
	if (other instanceof Namedconstant) {
	    return this.equals((Namedconstant) other);
	} else {
	    return false;
	}
    }

    public boolean equals(Namedconstant other) {
	return this.value == other.value && this.identifier.equals(other.identifier);
    }

    public SymbolicExpression eval(Environment vars) {
	return new Namedconstant(this.value, this.identifier);
    }

}
