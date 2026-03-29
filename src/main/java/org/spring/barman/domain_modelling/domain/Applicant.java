package org.spring.barman.domain_modelling.domain;

// ignoring validation for simplicity
public record Applicant(String name,
                        int creditScore,
                        int income) {
}