package org.ioopm.calculator.ast;
import java.util.HashMap;
/**
 * Class for a sequence.
 */
public class Sequence extends SymbolicExpression {
    private LinkedList<SymbolicExpression> body;
    
    public void addLine(SymbolicExpression newLine){
	this.body.addLast(newLine);
    }
}
