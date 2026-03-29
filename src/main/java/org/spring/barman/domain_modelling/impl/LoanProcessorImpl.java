package org.spring.barman.domain_modelling.impl;

import org.spring.barman.domain_modelling.domain.Loan;
import org.spring.barman.domain_modelling.domain.Loan.*;
import org.spring.barman.domain_modelling.domain.LoanProcessor;
import org.spring.barman.domain_modelling.domain.LoanStatus;
import org.spring.barman.domain_modelling.domain.Property.*;
import org.spring.barman.domain_modelling.domain.Vehicle.*;

public class LoanProcessorImpl implements LoanProcessor {

    private static final String DENY_MESSAGE_FORMAT = "Credit score must be at least %d and income must be at least %d";

    @Override
    public LoanStatus handle(LoanStatus.Submitted submitted) {
        return switch (submitted.loan()){
            case PersonalLoan loan -> this.review(loan, 600, 50_000);
            case AutoLoan loan -> this.review(loan, 650, 60_000);
            case PropertyLoan loan -> this.review(loan, 700, 100_000);
        };
    }

    private LoanStatus review(Loan loan, int minScore, int minIncome){
        var applicant = loan.application().applicant();
        return applicant.creditScore() >= minScore && applicant.income() >= minIncome ?
                new LoanStatus.Reviewed(loan) :
                new LoanStatus.Denied(loan, DENY_MESSAGE_FORMAT.formatted(minScore, minIncome));
    }

    @Override
    public LoanStatus handle(LoanStatus.Reviewed reviewed) {
        var loan = reviewed.loan();
        var interestRate = switch (loan) { // in the real life, you might get it from db / config file based on conditions.
            case Loan.PersonalLoan _ -> 4.5;
            case AutoLoan(_, Motorcycle(_, var cc)) when cc < 500 -> 6.00;
            case AutoLoan(_, Motorcycle _) -> 7.00;
            case AutoLoan(_, Car _) -> 5.00;
            case PropertyLoan(_, Residential(_, var rooms)) when rooms < 4 -> 6.00;
            case PropertyLoan(_, Residential _) -> 6.75;
            case PropertyLoan(_, Commercial _) -> 8.00;
        };
        return new LoanStatus.Approved(loan, interestRate);
    }

}