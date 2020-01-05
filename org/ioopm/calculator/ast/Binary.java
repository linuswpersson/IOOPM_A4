package org.ioopm.calculator.ast;

/**
 *Node representation of Binary
 */

public abstract class Binary extends SymbolicExpression {
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs){
	this.lhs = lhs;
	this.lhs.set_parent(this);
	this.rhs = rhs;
	this.rhs.set_parent(this);
    }

    /**Checks if parenthesis are needed in binary expression and converts to string
     *@return string representation with paranthesis if needed
     */
    @Override
    public String toString() {
	int P = this.getPriority();
	String leftString = this.lhs.toString();
	String rightString = this.rhs.toString();
	if (P >= 0) {
	    if (P != this.lhs.getPriority() && this.lhs.getPriority() > 0){
		leftString = "(" + leftString + ")"; 
	    }
	    if (P != this.rhs.getPriority() && this.rhs.getPriority() > 0){
		rightString = "(" + rightString + ")";   
	    }
	}
	return leftString + " " + this.getName() + " " + rightString;	
    }

    /**
     *Equal functions that compares a binary and it's subtrees to an Object
     *@param other (left or right side of binary expression)
     *@return false if other is not an instance of binary otherwise true
     */
    @Override
    public boolean equals(Object other) {
	if (other instanceof Binary) {
	    return this.equals((Binary) other);
	} else {
	    return false;
	}
    }

    public boolean equals(Binary other) {
	if(this.getName() == other.getName()){
	    return (this.lhs.equals(other.lhs) && (this.rhs.equals(other.rhs)));
	}
        else{
	    return false;
	}
    }

    public SymbolicExpression getLhs() {
	return this.lhs;
    }

    public SymbolicExpression getRhs() {
	return this.rhs;
    }

}
