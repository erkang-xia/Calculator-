package org.example.simplecalculator.calculator.operations;

import org.example.simplecalculator.calculator.Operation;
import org.example.simplecalculator.calculator.OperationStrategy;
import org.springframework.stereotype.Component;

@Component
public class MultiplyOperation implements OperationStrategy {
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    @Override
    public Operation getOperation(){
        return Operation.MULTIPLY;
    }
}
