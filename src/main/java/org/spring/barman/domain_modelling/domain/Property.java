package org.spring.barman.domain_modelling.domain;

public sealed interface Property {

    Address address();

    record Residential(Address address,
                       int rooms) implements Property {

    }

    record Commercial(Address address,
                      BusinessType businessType) implements Property {

    }

}