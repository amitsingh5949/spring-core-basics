package com.javadwarf.springcore.ioc4.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@Configuration
public class BasketBall implements Game {

    @Autowired @Qualifier("redSoxs")
    private Team home;

    @Autowired @Qualifier("cubs")
    private Team away;

    @Autowired
    private DataSource dataSource;

    public BasketBall() {
        System.out.println("Game default constructor called");
    }

    @Override
    public void playGame() {
        System.out.println(Math.random() < 0.5 ? home.getName(): away.getName());
    }

    @PostConstruct
    public void init() {
        System.out.println("Play National Anthem");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Distribute trophy");
    }
}

/*
Two Things:

1. Setters are not needed when doing autowiring even if fields are private
2. Order of execution :
    Game default constructor called -- bean is created by calling constructor
    RedSoxs instance created  -- its autowired fields are created
    Cubs instance created -- its autowired fields are created

    Play National Anthem -- Post construct is called
    Chicago Cubs -- business logic runs
    Distribute trophy -- pre destroy is called


 */
