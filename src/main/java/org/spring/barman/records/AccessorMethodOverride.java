package org.spring.barman.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/*
* Record accessor(getter) methods can be overridden without changing their method signature.
* */
public class AccessorMethodOverride {

    private static final Logger log = LoggerFactory.getLogger(AccessorMethodOverride.class);

    record Person(String firstName,
                  String lastName){

        public String lastName(){
            return this.lastName.toUpperCase(); // can override as same signature
        }

        // public Optional<String> firstName(); Not valid as signature not same
        public Optional<String> firstNameAsOptional(){
            return Optional.ofNullable(this.firstName);
        }

    }

    public static void main(String[] args) {

        var person = new Person("john", "doe");

        log.info("{}", person);


    }


}