package com.javadwarf.springcore.aop1.beans;

import javax.sql.DataSource;

public class BasketBall implements Game {

    private Team home;
    private Team away;
    private DataSource dataSource;

    public BasketBall(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    public BasketBall() {}

    @Override
    public String playGame() {
        String result = Math.random() < 0.5 ? home.getName(): away.getName();
        System.out.println(result);
        return result;
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

    @Override
    public String toString(){
        return "I am game";
    }
}
