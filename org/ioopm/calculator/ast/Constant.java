package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 *Represents a constant with a double value
 */
public class Constant extends Atom{
    private double value;

    public Constant(double value) {
	this.value = value;
    }

    public int isConstant() {
	return 1;
    }

    public double getValue() {
        return this.value;
    }

    public String toString() {
	return String.valueOf(this.value);
    }

    /**
     *Equal functions that compares a constant to an Object
     *@param other, constant to compare
     *@return false if other is not an instance of Constant otherwise true
     */
    public boolean equals(Object other) {
	if (other instanceof Constant) {
	    return this.equals((Constant) other);
	} else {
	    return false;
	}
    }

    public boolean equals(Constant other) {
	return this.value == other.value;
    }
    
    public SymbolicExpression eval(Environment vars) {
	return new Constant(this.value);
    }

}
