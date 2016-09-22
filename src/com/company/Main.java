package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Game> games = new ArrayList<>();
        System.out.println("Enter name of game");
        String gameName = scanner.nextLine();
        System.out.println("Enter developer of game");
        String gameDevloper = scanner.nextLine();
        System.out.println("Enter type of game");
        String gameType = scanner.nextLine();
        System.out.println("Enter year game was released");
        int gameYear = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter game genre");
        String gameGenre = scanner.nextLine();

        Game game = new Game(gameName,gameDevloper,gameType,gameYear,gameGenre);
        games.add(game);

//        for (int i = 0; i < games.size(); i++) {
//            Game game1 = games.get(i);
//            System.out.printf();
//        }

    }

    static void saveGame() throws Exception {
        Game game = new Game();
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(game);
        File f = new File("main.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    static void loadGame() throws Exception {
        File f = new File("main.json");
        FileReader fr = null;
        fr = new FileReader(f);
        int fileSize = (int) f.length();
        char[] contents = new char[fileSize];
        fr.read(contents, 0, fileSize);
        JsonParser parser = new JsonParser();
        Game game = parser.parse(contents, Game.class);
    }
}
