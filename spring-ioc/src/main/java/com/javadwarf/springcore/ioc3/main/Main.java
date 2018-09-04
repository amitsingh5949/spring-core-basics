package com.javadwarf.springcore.ioc3.main;

import com.javadwarf.springcore.ioc3.beans.Game;
import com.javadwarf.springcore.ioc3.config.AppConfig;
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
