package org.spring.barman.pattern_matching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatternLabelDominance {

    private static final Logger log = LoggerFactory.getLogger(PatternLabelDominance.class);

    static void main(String[] args) {

        patternMatch((short)5);
        patternMatch(5);
        patternMatch(5.0);
        patternMatch(5.0f);
        patternMatch(5_000_000_000L);

    }

    private static void patternMatch(Object object){
        switch (object){
            /** In Java pattern matching switch, cases are checked top to bottom,
             * and subtypes must come before supertypes. But Short, Double, and Integer are all subclasses of Number.
             * So in first case which is commented, It already matches Short, Double, Integer,
             * So the later cases become unreachable, which is a compile-time error.
             */
       //   case Number n -> log.info("number {}", n);
            case Short s -> log.info("short {}", s);
            case Double d -> log.info("double {}", d);
            case Integer i -> log.info("int {}", i);
            case Number n -> log.info("number {}", n);
            case null, default -> log.info("null/default: {}", object);
        }
    }
}