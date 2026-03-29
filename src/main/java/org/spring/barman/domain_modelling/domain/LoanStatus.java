package org.spring.barman.domain_modelling.domain;

public sealed interface LoanStatus {

    Loan loan();

    record Submitted(Loan loan) implements LoanStatus {

    }

    record Reviewed(Loan loan) implements LoanStatus {

    }

    record Approved(Loan loan,
                    double interestRate) implements LoanStatus {

    }

    record Denied(Loan loan,
                  String reason) implements LoanStatus {

    }

}