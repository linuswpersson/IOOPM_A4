package org.ioopm.calculator.ast;
import java.util.HashMap;
/**
 * Abstract class for functionDeclarations.
 */
public class FunctionDeclaration {
    private String name;
    private LinkedList<Atom> argList;
    private Sequence body;
    
    public FunctionDeclaration(String name, LinkedList<Atom> argList) {
	this.name = name;
	this.argList = argList;
	this.body = body;
    }

    public void addBody(Sequence newBody){
	this.body = newBody;
    }

    public String getName(){
	return this.name;
    }
}
