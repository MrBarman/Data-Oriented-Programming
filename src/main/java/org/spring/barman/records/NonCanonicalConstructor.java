package org.spring.barman.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/*
*  Non-canonical constructor - a constructor with a different signature than the record’s components
*  very useful for optional input
* */
public class NonCanonicalConstructor {

    private static final Logger log = LoggerFactory.getLogger(NonCanonicalConstructor.class);

    record Task(String title, String author, String desription,
                LocalDate createdAt){

       // different signature than the record’s components
        Task(String title, String author){//pass only few param
            //directly pass values of remaining param to canonical Constructor
           this(title, author, "title by barman", LocalDate.now());
        }

    }


    public static void main(String[] args) {

        var task = new Task("Submit report","barman");

        log.info("{}", task);


    }

}