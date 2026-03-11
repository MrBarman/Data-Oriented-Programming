package org.spring.barman.records;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
*  Are records immutable? It depends!
*
* A record is immutable only if all of its components are immutable
* */
public class ImmutableRecord {

    private static final Logger log = LoggerFactory.getLogger(ImmutableRecord.class);

    record Team(String name,
                List<String> members){

        Team{
            members = List.copyOf(members);//as copyOf is immutable so the record is immutable
            //it would be mutable if we use some mutable list members like from param directly

        }

    }


    static void main(String[] args) {

        var members = new ArrayList<String>();
        members.add("sam");
        members.add("mike");

        var team = new Team("dev team", members);

        log.info("{}", team);

        members.add("jake");

        log.info("{}", team);


    }

}