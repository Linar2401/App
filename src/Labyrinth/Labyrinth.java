package Labyrinth;
/**
 * @author Khayaleeva Izida and Shaidullina Elvina
 */

import java.util.Random;
/*
An abstract class for creating Labyrinth
 */
public abstract class Labyrinth implements WallMaker, SetsJoiner, VerticalCutsMaker, LabyrinthShower, LastLineMaker, EEMaker {
    private int width;
    private int height;
    private char[][] cells = new char[height][width];

    private int cur_width;       //current row
    private int cur_height;       //current column


    private int[] current;
    private int[] next;

    private int numSet;         //checking coincidence
    private Random randm;
    private int nxt;
    private int nxt2;


    /**
     * @param nheight - lab's height
     * @param nwidth - lab's width
     */
    public Labyrinth(int nwidth, int nheight) {
    }

    /**
     * @return cells
     */
    public char[][] getLabyrinth() {
        return cells;
    }

    /**
     * @return randm
     */
    public Random getRand() {
        return randm;
    }

    /**
     * @param rand - random value
     */
    public void setRand(Random rand) {
        randm = rand;
    }

    public abstract void makeEE();
    public abstract void makeWall();
    public abstract void makeVerticalCuts();

}
