package org.spring.barman.domain_modelling.domain;

public sealed interface Vehicle {

    String make();

    record Car(String make,
               int year) implements Vehicle {

    }

    record Motorcycle(String make,
                      int engineCC) implements Vehicle {

    }

}