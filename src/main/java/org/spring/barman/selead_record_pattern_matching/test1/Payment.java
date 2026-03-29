package org.spring.barman.selead_record_pattern_matching.test1;

/**
 * If we declare the record inside the sealed interface itself,
 * we don't need use permit keyword with these
 */
public sealed interface Payment {

    record CreditCard(String number,
                      String cvv) implements Payment {

    }

    record Rupay(String email) implements Payment {

    }

}