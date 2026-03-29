package org.spring.barman.domain_modelling.domain;

// ignoring validation for simplicity as it has been discussed already
public record LoanTerms(int amount,
                        int duration) {
}