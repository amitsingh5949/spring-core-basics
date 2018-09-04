package com.javadwarf.springcore.ioc3.beans;

import org.springframework.stereotype.Component;

@Component
public class Cubs implements Team {

    @Override
    public String getName() {
        return "Chicago Cubs";
    }
}
