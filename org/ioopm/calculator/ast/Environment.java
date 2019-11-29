package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * class used to store a hashtable with Variable-keys and SymbolicExpression-values. Used for more readable code. no other functionality.
 */
public class Environment extends HashMap<Variable, SymbolicExpression> {}
