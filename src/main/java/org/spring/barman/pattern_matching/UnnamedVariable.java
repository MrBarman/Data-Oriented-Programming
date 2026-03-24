package org.spring.barman.pattern_matching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnnamedVariable {

    private static final Logger log = LoggerFactory.getLogger(UnnamedVariable.class);

    public static void main(String[] args) {

        patternMatch(5);
        patternMatch(5.0);
        patternMatch(5.0f);

    }

    private static void patternMatch(Object object){
        switch (object){
            // _ means we do not have any pattern variable so just match the type
            case Double _ -> log.info("received double");
            case Integer _ -> log.info("received int");
            case null, default -> log.info("null/default: {}", object); // here check for null or default
        }
    }

}