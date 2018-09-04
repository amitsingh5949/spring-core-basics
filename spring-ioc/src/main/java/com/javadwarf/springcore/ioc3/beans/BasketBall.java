package com.javadwarf.springcore.ioc3.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

public class BasketBall implements Game {

    private Team home;
    private Team away;
    private DataSource dataSource;

    public BasketBall(Team home, Team away) {
        this.home = home;
        this.away = away;
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

    public Team getHome() {
        return home;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }
}
