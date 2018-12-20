package com.javadwarf.springcore.aop1.config;

import com.javadwarf.springcore.aop1.beans.BasketBall;
import com.javadwarf.springcore.aop1.beans.Game;
import com.javadwarf.springcore.aop1.beans.Team;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.javadwarf.springcore.aop1")
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired @Qualifier("redSoxs")
    private Team home;

    @Autowired @Qualifier("cubs")
    private Team away;

    @Bean
    Game setGame(){
        BasketBall game =  new BasketBall();
        game.setAway(away);
        game.setHome(home);
        game.setDataSource(dataSource);
        return game;
    }

    @Override
    public String toString(){
        return "I am App config";
    }
}
