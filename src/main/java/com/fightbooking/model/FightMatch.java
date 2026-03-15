package com.fightbooking.model;

public class FightMatch {

    private String fighterRed;
    private String fighterBlue;
    private String time;

    public FightMatch(String fighterRed, String fighterBlue, String time) {
        this.fighterRed = fighterRed;
        this.fighterBlue = fighterBlue;
        this.time = time;
    }

    public String getFighterRed() {
        return fighterRed;
    }

    public String getFighterBlue() {
        return fighterBlue;
    }

    public String getTime() {
        return time;
    }
}