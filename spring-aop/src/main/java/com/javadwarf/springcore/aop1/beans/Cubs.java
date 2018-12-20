package com.javadwarf.springcore.aop1.beans;

import org.springframework.stereotype.Component;

@Component
public class Cubs implements Team{

    @Override
    public String getName() {
        return "Chicago Cubs";
    }
}
