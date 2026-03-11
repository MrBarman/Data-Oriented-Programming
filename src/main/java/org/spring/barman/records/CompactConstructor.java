package org.spring.barman.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/*
 * Compact constructors are good to add validation/processing logic
 * */
public class CompactConstructor {

    private static final Logger log = LoggerFactory.getLogger(CompactConstructor.class);

    record Person(String firstName,
                  String lastName){

        // shorthand version of canonical constructor
        // not required to set each param this way
        Person {//no param require as well
            //validation
            Objects.requireNonNull(lastName, "Lastname can not be null");
            lastName = lastName.toUpperCase();
        }

    }

    public static void main(String[] args) {

        var person = new Person("john", "doe");

        log.info("{}", person);

    }


}