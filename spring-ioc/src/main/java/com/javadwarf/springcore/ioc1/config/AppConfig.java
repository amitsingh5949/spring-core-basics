package com.javadwarf.springcore.ioc1.config;

import com.javadwarf.springcore.ioc1.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfig.class)
// multiple config classes can be imported by passing an array of config files @Import({,}),
//@ImportResource() use to import configuration from xm file
// if importing then you need to use @Autowired or pass the bean in constructor of the bean that is going to use it

public class AppConfig {

    @Autowired
    DataSource dataSource1;
    // bean datasource is coming from DataSourceConfig
    // Autowired is autowired by type first, if a single bean of the autowired type is available then it works
    // but if multiple beans of same type are found, autowire doesn't work


    @Bean
    Game getGame(DataSource dataSource){ // bean datasource is coming from DataSourceConfig
        BasketBall game =  new BasketBall(getCubs(), getRedSoxs());
        game.setDataSource(dataSource);// setting datasource by autowire or constructor both will work
        game.setDataSource(dataSource1);
        return game;
    }

    @Bean
    Team getRedSoxs(){
        return new RedSoxs();
    }

    @Bean
    Team getCubs(){
        return new Cubs();
    }


}
