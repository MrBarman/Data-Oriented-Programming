package org.spring.barman.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/*
*  Introspect or access record components dynamically.
*
* e.g. check if given class is a record or not
* */
public class RecordReflection {

    private static final Logger log = LoggerFactory.getLogger(RecordReflection.class);

    record Person(String name,
                  int age){
    }

    static void main(String[] args) {

        accessRecordComponents(String.class); //false as not a record
        accessRecordComponents(Person.class); // true as it is a record

        accessFieldValues("sam");//as sending only String object it will return
        accessFieldValues(new Person("sam", 10));// print params

    }

    private static <T> void accessRecordComponents(Class<T> type){

        if(!type.isRecord()){
            log.info("{} is not a record", type);
            return; //will return from here in case of String.class
        }

        Arrays.stream(type.getRecordComponents())
                //will print the type of params
                .forEach(rc -> log.info("{}-{}", rc.getName(), rc.getType()));

    }
    // need to pass object
    private static void accessFieldValues(Object object){

        if(!object.getClass().isRecord()){
            log.info("{} is not a record", object.getClass());
            return; //will return from here in case of String.class
        }

        Arrays.stream(object.getClass().getRecordComponents())
              .forEach(rc -> {
                  try {
                      // prints param name and value for each param
                      log.info("{}-{}", rc.getName(), rc.getAccessor().invoke(object));
                  } catch (IllegalAccessException | InvocationTargetException e) {
                      throw new RuntimeException(e);
                  }
              });

    }

}