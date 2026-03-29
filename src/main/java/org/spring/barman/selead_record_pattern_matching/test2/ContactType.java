package org.spring.barman.selead_record_pattern_matching.test2;

public sealed interface ContactType {

    record EMail(String address) implements ContactType {

    }

    record Phone(String countryCode,
                 String number) implements ContactType {

    }

}