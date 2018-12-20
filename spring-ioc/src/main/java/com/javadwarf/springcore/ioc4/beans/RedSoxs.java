package com.javadwarf.springcore.ioc4.beans;

import org.springframework.stereotype.Component;

@Component
public class RedSoxs implements Team {

    public RedSoxs(){
        System.out.println("RedSoxs instance created");
    }

    @Override
    public String getName() {
        return "RedSoxs";
    }
}
