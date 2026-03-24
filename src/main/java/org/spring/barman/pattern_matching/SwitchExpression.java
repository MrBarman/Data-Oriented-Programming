package org.spring.barman.pattern_matching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwitchExpression {

    private static final Logger log = LoggerFactory.getLogger(SwitchExpression.class);

    static void main(String[] args) {

        log.info("{}", getTax("US", 100));
        log.info("{}", getTax("UK", 100));
        log.info("{}", getTax("CA", 100));
        log.info("{}", getTax("AU", 100));
        log.info("{}", getTax(null, 100));

    }

    private static double getTax(String country, Integer price){
        var taxRate = switch (country){
            case "US" -> 0.05;
            case "UK", "AU" -> 0.06;
            case null -> throw new IllegalArgumentException("country can not be null");
            default -> {
                log.info("default tax rate is used for country: {}", country);
                //The yield keyword in Java is used within a switch expression to produce a value for that expression.
                // It acts as a return statement for the switch block itself, rather than the entire method
                yield  0.08;
            }
        };
        log.info("country: {}, taxRate: {}", country, taxRate);
        return taxRate * price;
    }

}