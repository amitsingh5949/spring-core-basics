package com.javadwarf.springcore.ioc2.config;

import com.javadwarf.springcore.ioc2.beans.BasketBall;
import com.javadwarf.springcore.ioc2.beans.Game;
import com.javadwarf.springcore.ioc2.beans.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.javadwarf.springcore.ioc2") //to scan multiple packages pass array of package names
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired @Qualifier ("redSoxs")
    private  Team home;
    /*Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type
    'com.javadwarf.springcore.ioc2.beans.Team' available: expected single matching bean but found 2: cubs,redSoxs
    at org.springframework.beans.factory.config.DependencyDescriptor.resolveNotUnique*/

    //Since there are two eligible beans for team having @Component annotation, that's why we need to use qualifer
    // qualifer name should be same as class name with first letter small

    @Autowired @Qualifier ("cubs")
    private  Team away;

    @Resource
    //@Resource is autowire by name
    private  Team cubs;

    @Autowired
    List<Team> teams; // This will add all the qualifying bean in list or set, we can get cubs by teams[0] and so on

    // By default, all spring managed beans are singleton,
    // we can tell spring to gives a new bean every time by providing the scope prototype
    // in spring mvc , there are request, session and application scopes also available
    @Bean @Scope("prototype")
    Game getGame(){
        BasketBall game =  new BasketBall(home, cubs);
        game.setDataSource(dataSource);
        return game;
    }
}


/*
in xml bean instantiation, factory-method attribute is used
 if class is abstract and can not be instantiated by constructor call

 factory-method = "getInstance()"
 if getInstance() is in some other bean then use factory-bean="factoryBan" attribute to the factory-method
 from that factory bean class

 but with Annotation config, create the bean and return factorybean.factoryMethod()
 @Bean
 public NumberFormat nf(){
   return NumberFormat.newInstance();
   }
 */