package com.javadwarf.springcore.aop1.main;


import com.javadwarf.springcore.aop1.beans.Game;
import com.javadwarf.springcore.aop1.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Game game = context.getBean("setGame", Game.class);
        game.playGame();

    }
}

/*
INFO: calling setGame with agrs null I am App config

note setter of cubs or redsoxs are not called as they are not managed by Spring but App config is
 */
