package org.spring.barman.selead_record_pattern_matching.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo1 {

    private static final Logger log = LoggerFactory.getLogger(Demo1.class);

    public static void main(String[] args) {

        handlePayment(new Payment.CreditCard("123-456-789", "123"));
        handlePayment(new Payment.Rupay("sam@gmail.com"));

    }

    //payment-service
    private static void handlePayment(Payment payment) {
        switch (payment){
            case Payment.CreditCard creditCard -> log.info("processing credit card {}", creditCard.number());
            case Payment.Rupay rupay -> log.info("processing rupay {}", rupay.email());
        }
    }

}