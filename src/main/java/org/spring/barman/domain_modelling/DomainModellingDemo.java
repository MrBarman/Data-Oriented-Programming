package org.spring.barman.domain_modelling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.barman.domain_modelling.domain.*;
import org.spring.barman.domain_modelling.impl.LoanProcessorImpl;

import java.util.stream.Stream;

public class DomainModellingDemo {

    private static final Logger log = LoggerFactory.getLogger(DomainModellingDemo.class);

    public static void main(String[] args) {

        var service = new LoanService(new LoanProcessorImpl());

        var applicant = new Applicant("sam", 700, 120_000);
        var loanTerms = new LoanTerms(60000, 10);
        var loanApplication = new LoanApplication(applicant, loanTerms);
        var address = new Address("123 main street", "atlanta", "30005");

        var personalLoan = new Loan.PersonalLoan(loanApplication);
        var carLoan = new Loan.AutoLoan(loanApplication, new Vehicle.Car("Honda", 2025));
        var motorcycleLoan = new Loan.AutoLoan(loanApplication, new Vehicle.Motorcycle("Harley Davidson", 600));
        var residentialLoan = new Loan.PropertyLoan(loanApplication, new Property.Residential(address, 5));
        var commercialLoan = new Loan.PropertyLoan(loanApplication, new Property.Commercial(address, BusinessType.OFFICE));

        Stream.of(personalLoan, carLoan, motorcycleLoan, residentialLoan, commercialLoan)
                .forEach(service::apply);

    }


    private static class LoanService {

        private final LoanProcessor loanProcessor;

        public LoanService(LoanProcessor loanProcessor) {
            this.loanProcessor = loanProcessor;
        }

        void apply(Loan loan){
            var submitted = new LoanStatus.Submitted(loan);
            var loanStatus = this.loanProcessor.process(submitted);
            log.info("status: {}", loanStatus);
        }

    }

}