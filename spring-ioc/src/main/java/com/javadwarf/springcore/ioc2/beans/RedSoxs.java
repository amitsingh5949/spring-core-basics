package com.javadwarf.springcore.ioc2.beans;

import org.springframework.stereotype.Component;

@Component
public class RedSoxs implements Team {

    @Override
    public String getName() {
        return "RedSoxs";
    }
}
