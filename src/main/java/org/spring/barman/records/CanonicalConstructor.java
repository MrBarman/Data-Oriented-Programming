package org.spring.barman.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CanonicalConstructor {

    private static final Logger log = LoggerFactory.getLogger(CanonicalConstructor.class);
    record Person(String firstName,
                  String lastName){

        //we must set all the params of constructor even if one param require change
        public Person(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName.toUpperCase();
        }

    }

    public static void main(String[] args) {

        var person = new Person("john", "doe");

        log.info("{}", person);


    }

}
