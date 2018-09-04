package com.javadwarf.springcore.ioc1.main;

import com.javadwarf.springcore.ioc1.beans.Game;
import com.javadwarf.springcore.ioc1.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Game game = context.getBean("getGame", Game.class);
        game.playGame();

        System.out.println(context.getBeanDefinitionCount() + " beans instantiated");

        for(String name : context.getBeanDefinitionNames()){
            System.out.println(name);
        }

        /* o/p
        *   Chicago Cubs
            10 beans instantiated
            org.springframework.context.annotation.internalConfigurationAnnotationProcessor
            org.springframework.context.annotation.internalAutowiredAnnotationProcessor
            org.springframework.context.annotation.internalRequiredAnnotationProcessor
            org.springframework.context.annotation.internalCommonAnnotationProcessor
            org.springframework.context.event.internalEventListenerProcessor
            org.springframework.context.event.internalEventListenerFactory
            appConfig
            getGame
            getRedSoxs
            getCubs
        *
        * */
    }
}
