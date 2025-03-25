package org.example.simplecalculator.calculator;

public interface OperationStrategy {
    Number apply(Number num1, Number num2);
    Operation getOperation();
}