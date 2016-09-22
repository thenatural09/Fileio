package com.company;

/**
 * Created by Troy on 9/21/16.
 */
public class Game {
    String name;
    String developer;
    String type;
    int yearRelease;
    String genre;

    public Game () {

    }

    public Game(String name, String developer, String type, int yearRelease, String genre) {
        this.name = name;
        this.developer = developer;
        this.type = type;
        this.yearRelease = yearRelease;
        this.genre = genre;
    }
}
