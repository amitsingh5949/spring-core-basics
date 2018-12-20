package com.javadwarf.springcore.ioc4.beans;

import org.springframework.stereotype.Component;
@Component
public class Cubs implements Team {

    public Cubs(){
        System.out.println("Cubs instance created");
    }

    @Override
    public String getName() {
        return "Chicago Cubs";
    }
}
