package main;

import Labyrinth.RandomLabyrinth;

public class App {
    public static void main(String[] args) {
        RandomLabyrinth lab = new RandomLabyrinth(12,12);
        lab.makeWall();
        lab.showLabyrinth();
    }
}
