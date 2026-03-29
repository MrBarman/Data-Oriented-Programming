package org.spring.barman.selead_record_pattern_matching.test3;

public class Demo3 {

    public static void main(String[] args) {

        // validate everything upfront. no surprises later
        var eMailAddress = new EMailAddress("sam@gmail.com");
        var message = new Message("Hi Sam, How are you?");
        EMailService.send(eMailAddress, message);

    }

}