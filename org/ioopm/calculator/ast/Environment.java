package org.ioopm.calculator.ast;
import java.util.*; 
import java.util.HashMap;

/**
 * class used to store a hashtable with Variable-keys and SymbolicExpression-values.
 */
public class Environment extends HashMap<Variable, SymbolicExpression> {

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Variables: ");
	TreeSet<Variable> vars = new TreeSet<>(this.keySet());
        for (Iterator<Variable> iter = vars.iterator(); iter.hasNext(); ) {
	    Variable v = iter.next();
	    sb.append(v.getName());
	    sb.append(" = ");
	    sb.append(this.get(v));
	    sb.append(", ");
	}
	return sb.toString();
    }
}
