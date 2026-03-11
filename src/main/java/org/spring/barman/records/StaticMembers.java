package org.spring.barman.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticMembers {

    private static final Logger log = LoggerFactory.getLogger(StaticMembers.class);

    /**
     *
     * we can have static members and methods inside records
     * but, we can't have instance members
     */
    record Price(double amount,
                 String currency){

        private static final String USD = "$";

        static Price usd(double amount){
            return new Price(amount, USD);
        }

    }

    static void main(String[] args) {

        log.info("{}", Price.usd(10.50));

    }

}