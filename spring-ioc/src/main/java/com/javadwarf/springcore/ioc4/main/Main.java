package com.javadwarf.springcore.ioc4.main;

import com.javadwarf.springcore.ioc4.beans.Game;
import com.javadwarf.springcore.ioc4.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Game game = context.getBean("getGame", Game.class);
        game.playGame();
        ((AnnotationConfigApplicationContext)context).close();


    }
}
