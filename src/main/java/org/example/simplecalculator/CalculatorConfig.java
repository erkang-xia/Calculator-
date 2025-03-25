package org.example.simplecalculator;

import org.example.simplecalculator.calculator.Operation;
import org.example.simplecalculator.calculator.OperationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class CalculatorConfig {

    @Bean
    public Map<Operation, OperationStrategy> operationStrategies(List<OperationStrategy> strategies) {
        return strategies.stream()
                .collect(Collectors.toMap(OperationStrategy::getOperation, strategy -> strategy));
    }
}
