package org.spring.barman.domain_modelling.domain;

public sealed interface Loan {

    LoanApplication application();

    //the argument name must be same i.e. it should be application as declared above
    record PersonalLoan(LoanApplication application) implements Loan {

    }

    record PropertyLoan(LoanApplication application,
                        Property property) implements Loan {

    }

    record AutoLoan(LoanApplication application,
                    Vehicle vehicle) implements Loan {

    }

}