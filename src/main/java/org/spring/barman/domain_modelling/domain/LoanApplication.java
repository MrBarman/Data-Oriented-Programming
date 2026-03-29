package org.spring.barman.domain_modelling.domain;

// ignoring validation for simplicity
public record LoanApplication(Applicant applicant,
                              LoanTerms terms) {
}