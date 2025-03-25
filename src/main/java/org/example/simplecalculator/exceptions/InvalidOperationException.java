package org.example.simplecalculator.exceptions;

import org.example.simplecalculator.calculator.Operation;

public class InvalidOperationException extends ApplicationException{
    public InvalidOperationException(Operation op) {
        super("Invalid operation: " + op);
    }
}
