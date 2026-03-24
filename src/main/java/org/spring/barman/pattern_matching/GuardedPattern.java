package org.spring.barman.pattern_matching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuardedPattern {

    private static final Logger log = LoggerFactory.getLogger(GuardedPattern.class);

    public static void main(String[] args) {

        patternMatch((short)5);
        patternMatch(5);
        patternMatch(-5);
        patternMatch(5.0);
        patternMatch(5.0f);
        patternMatch(5_000_000_000L);

    }

    private static void patternMatch(Object object){
        switch (object){
            case Short s -> log.info("short {}", s);
            case Double d -> log.info("double {}", d);
            case Integer i when i < 0 -> log.info("negative int {}", i);
            case Integer i -> log.info("int {}", i);//this line must come after above otherwise it would be unreachable
            case Number n -> log.info("number {}", n);
            case null, default -> log.info("null/default: {}", object);
        }
    }
}