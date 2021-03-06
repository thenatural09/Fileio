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

    public void chooseName() {
        System.out.println("Update name of game");
        name = Main.customLine();
        System.out.println("Name entered");
    }
    public void chooseDeveloper() {
        System.out.println("Update developer of game");
        developer = Main.customLine();
        System.out.println("Developer entered");
    }

    public void chooseType() {
        System.out.println("Update type of game");
        type = Main.customLine();
        System.out.println("Type entered");
    }

    public void chooseYear() {
        System.out.println("Update year game was released");
        yearRelease = Integer.valueOf(Main.customLine());
        System.out.println("Year entered");
    }

    public void chooseGenre() {
        System.out.println("Update game genre");
        genre = Main.customLine();
        System.out.println("Genre entered");
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getType() {
        return type;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public String getGenre() {
        return genre;
    }
}
