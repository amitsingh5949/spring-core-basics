package com.javadwarf.springcore.ioc3.config;

import com.javadwarf.springcore.ioc3.beans.BasketBall;
import com.javadwarf.springcore.ioc3.beans.Game;
import com.javadwarf.springcore.ioc3.beans.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.javadwarf.springcore.ioc3") //to scan multiple packages pass array of package names
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired @Qualifier("redSoxs")
    private Team home;

    @Autowired @Qualifier("cubs")
    private Team away;

    @Bean(initMethod = "init", destroyMethod = "destroy")
    // 1. We can also use PostConstruct and PreDestroy which are same are init and destroy Methods above
    // the difference is, calling init-method we cannot pass argument while @PostConstruct supports argument passing
    // also if the init() is not defined in our bean or we calling library class then we cannot use @post or @pre
    // 2. Calling both init-method and PostConstruct on same method will not make it run twice
    // 3. @PreDestroy() or destroy-method does not gets called unless we call context.close()
    // Destroy will also  not be called even after context close if the scope of bean is prototype
    Game getGame(){
        BasketBall game =  new BasketBall(home, away);
        game.setDataSource(dataSource);
        return game;
    }
}
