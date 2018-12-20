package com.javadwarf.springcore.ioc4.config;

import com.javadwarf.springcore.ioc4.beans.BasketBall;
import com.javadwarf.springcore.ioc4.beans.Game;
import com.javadwarf.springcore.ioc4.beans.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.javadwarf.springcore.ioc4") //to scan multiple packages pass array of package names
public class AppConfig {

    @Autowired
   private  Game basketball;

    @Bean
    public Game getGame(){
        return basketball;
    }
}
