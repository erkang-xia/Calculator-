package org.example.simplecalculator.calculator;

import lombok.extern.slf4j.Slf4j;
import org.example.simplecalculator.exceptions.InvalidOperationException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class Calculator {

    private final Map<Operation, OperationStrategy> operationStrategies;
    private Number currentValue = null;

    public Calculator(Map<Operation, OperationStrategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    public Number calculate(Operation operation, Number num1, Number num2) {
        log.info("calculate {} {} {}", num1, operation, num2);
        OperationStrategy strategy = operationStrategies.get(operation);

        if (strategy == null) {
            throw new InvalidOperationException(operation);
        }

        return strategy.apply(num1, num2);
    }

    public Calculator start(Number initialValue) {
        if (initialValue == null) {
            throw new IllegalArgumentException("Initial value cannot be null.");
        }
        this.currentValue = initialValue;
        return this;
    }

    public Calculator perform(Operation operation, Number nextValue) {
        if (currentValue == null) {
            throw new IllegalStateException("Must call start() before perform().");
        }
        if (nextValue == null) {
            throw new IllegalArgumentException("Next value cannot be null.");
        }

        this.currentValue = calculate(operation, this.currentValue, nextValue);
        return this;
    }

    public Number getResult() {
        if (currentValue == null) {
            throw new IllegalStateException("No calculation performed.");
        }
        return currentValue;
    }

    public void reset() {
        this.currentValue = null;
    }
}