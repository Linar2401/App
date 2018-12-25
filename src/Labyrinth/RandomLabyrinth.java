package Labyrinth;

import java.util.Random;
/**
 * A class for generating your own unique labyrinth.
 * Firstly you should call makeWall() method.
 * Secondly, use showLabyrinth() to see lab have generated already. You can override it, if you need to.
 * Now your labyrinth is ready to use.
 * Good luck!
 * @author Khayaleeva Izida and Shaidullina Elvina
 *
 */
public class RandomLabyrinth extends Labyrinth {
    private int width;
    private int height;
    private static final char WALL = '#';
    private static final char EMPTY = ' ';
    private static final int NOT_VISITED = -2;
    private static final int MAKE_WALL = -1;
    private char[][] cells;
    private int cur_width;       //current row
    private int cur_height;       //current column


    private int[] current;
    private int[] next;

    private int numSet;         //checking coincidence
    private Random randm;
    private int nxt;
    private int nxt2;

    /**
     *
     * @param nwidth - labyrinth's width
     * @param nheight - labyrinth's height
     */
    public RandomLabyrinth(int nwidth, int nheight){
        super(nwidth, nheight);
        cur_width = nwidth;
        cur_height = nheight;
        /* 
        We should use only odd numbers. That's why all input values are automatically converted into odd numbers.
        */

        width = cur_width * 2 + 1;
        height = cur_height * 2 + 1;

        cells = new char[width][height];
        current = new int[cur_height * 2 - 1];
        next = new int[cur_height * 2 - 1];


        /*Sets the cells to fill */
        for (int i = 0; i < cells[0].length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = WALL;
            }
        }



        for (int i = 0; i < next.length; i++) {
            next[i] = NOT_VISITED;
        }



        /* first line */
        for (int i = 0; i < current.length; i += 2) {
            current[i] = i / 2 + 1;
            if (i != current.length - 1)
                current[i + 1] = WALL;
        }
        numSet = current[current.length - 1];
    }

    @Override
    public void makeWall() {
        setRand(new Random());
        for (int q = 0; q < cur_width - 1; q++) {
            if (q != 0) {
                /* getting the current line*/
                for (int i = 0; i < current.length; i++) {
                    current[i] = next[i];
                    next[i] = NOT_VISITED;
                }
            }
            joinSets();
            makeVerticalCuts();
            /* fill other lines */
            for (int j = 0; j < current.length; j += 2) {
                if (next[j] == NOT_VISITED)
                    next[j] = ++numSet;
                if (j != current.length - 1)
                    next[j + 1] = WALL;
            }
            for (int k = 0; k < current.length; k++) {
                if (current[k] == WALL) {
                    cells[2 * q + 1][k + 1] = WALL;
                    cells[2 * q + 2][k + 1] = WALL;
                } else {
                    cells[2 * q + 1][k + 1] = EMPTY;
                    if (current[k] == next[k]) {
                        cells[2 * q + 2][k + 1] = EMPTY;
                    }
                }
            }
        }
        makeLastLine();
        makeEE();
    }

    @Override
    public void joinSets() {
        Random rand = new Random();
        for (int i = 1; i < current.length - 1; i += 2) {
            /* Checking:is it a wall between i and i+1, aren't they similar,*/
            if (current[i] == WALL && current[i - 1] != current[i + 1]
                    && rand.nextBoolean()) {
                current[i] = 0; //delete the wall
                int old = Math.max(current[i - 1], current[i + 1]);
                nxt = Math.min(current[i - 1], current[i + 1]);
                for (int j = 0; j < current.length; j++) {
                    if (current[j] == old)
                        current[j] = nxt;
                }
            }
        }
    }

    /**
     * Choosing vertical way
     */
    @Override
    public void makeVerticalCuts() {
        Random rand = new Random();
        int begining;
        int end;
        boolean madeVertical;
        int i;
        begining = 0;
        do {
            i = begining;
            while (i < current.length - 1 && current[i] == current[i + 2]) {
                i += 2;
            }
            end = i;

            madeVertical = false;
            do {
                for (int j = begining; j <= end; j += 2) {

                    if (rand.nextBoolean()) {
                        next[j] = current[j];
                        madeVertical = true;
                    }
                }
            } while (!madeVertical);

            begining = end + 2;  //go to the next

        } while (end != current.length - 1);
    }

    @Override
    public void makeLastLine() {
        /* get current line */
        for (int i = 0; i < current.length; i++) {
            current[i] = next[i];
        }
        for (int i = 1; i < current.length - 1; i += 2) {
            if (current[i] == MAKE_WALL && current[i - 1] != current[i + 1]) {
                current[i] = 0;
                int old = Math.max(current[i - 1], current[i + 1]);
                nxt2 = Math.min(current[i - 1], current[i + 1]);
                for (int j = 0; j < current.length; j++) {
                    if (current[j] == old)
                        current[j] = nxt2;
                }
            }
        }
        /* add the last line */
        for (int k = 0; k < current.length; k++) {
            if (current[k] == MAKE_WALL) {
                cells[width - 2][k + 1] = WALL;
            } else {
                cells[width - 2][k + 1] = EMPTY;
            }
        }
    }


    /**
     * making an exit and entrance/
     */
    @Override
    public void makeEE() {
        Random rand = new Random();
        //random beginning and the end
        int entrance_row = rand.nextInt(cur_width - 1) * 2 + 1;
        int exit_row = rand.nextInt(cur_width - 1) * 2 + 1;
        //empty the place
        cells[entrance_row][0] = EMPTY;
        cells[exit_row][height - 1] = EMPTY;

    }

    @Override
    public void showLabyrinth() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }

    }

    @Override
    public char[][] getCells() {
        return cells;
    }
}
