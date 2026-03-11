package org.spring.barman.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/*
* Records are data carriers, and their fields can be null. 
* If you want to prevent null, use a compact constructor to validate the fields 
* or use Optional to make it explicit.
* */
public class NullableFields {

    private static final Logger log = LoggerFactory.getLogger(NullableFields.class);

    record Person(String name,
                  Optional<String> nickName) {

        Person(String name){
            this(name, Optional.empty());//using compact constructor
        }

        Person(String name, String nickName){
            this(name, Optional.ofNullable(nickName));//using Optional
        }

    }

    static void main(String[] args) {

        var sam = new Person("sam");
        var williamWithNickName = new Person("william", "will");
        var williamWithNull = new Person("william", (String) null);

        log.info("{}", sam);
        log.info("{}", williamWithNickName);
        log.info("{}", williamWithNull);

    }



}