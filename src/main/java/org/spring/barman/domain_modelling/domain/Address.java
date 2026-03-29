package org.spring.barman.domain_modelling.domain;

// ignoring validation for simplicity
public record Address(String street,
                      String city,
                      String zipCode) {
}