package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Game game = new Game();
    static final String FILE_NAME = "newgame.json";
    public static void main(String[] args) {
        loadGame();
        System.out.println("In order to save or load game type /save or /load");

        boolean keepRunning = true;
        while (keepRunning) {
            game.chooseName();
            game.chooseDeveloper();
            game.chooseType();
            game.chooseYear();
            game.chooseGenre();
        }
    }

    static String customLine() {
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            switch (line) {
                case "/save":
                    saveGame();
                    break;
                case "/load":
                    loadGame();
                    break;
                default:
                    System.out.println("Invalid Command");
            }
            line = scanner.nextLine();
        }
        return line;
    }

    static void saveGame() {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(game);
        File f = new File(FILE_NAME);
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (Exception e) {
            System.out.println("Cannot save");
        }
    }

    static void loadGame() {
        File f = new File(FILE_NAME);
        FileReader fr;
        try {
            fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents, 0, fileSize);
            JsonParser parser = new JsonParser();
            game = parser.parse(contents, Game.class);
        } catch(Exception e) {
            System.out.println("Cannot load");
        }
        System.out.printf("Game name: %s\n",game.name);
        System.out.printf("Game developer: %s\n",game.developer);
        System.out.printf("Game type: %s\n",game.type);
        System.out.printf("Game year release: %s\n",game.yearRelease);
        System.out.printf("Game genre: %s\n",game.genre);
    }
}
