package org.ioopm.calculator.ast;

public class UndefinedVariableException extends RuntimeException{
    public UndefinedVariableException(){
        super();
    }
    public UndefinedVariableException(String msg) {
        super(msg);
    }
}
