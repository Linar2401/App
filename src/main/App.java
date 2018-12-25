package main;

import Labyrinth.RandomLabyrinth;
import commands.*;
import painter.PainterCells;
import utils.CommandLineInterractor;


public class App {
    char[][] cells;
    char[][] cellsWitnPath;
    private int size;
    private RandomLabyrinth lab;
    private PainterCells painterCells;
    private CommandLineInterractor cli = new CommandLineInterractor();
    private String[] commandsNames = {"Generate labyrinth", "Show labyrinth in console", "Find path", "Show path in console",
            "Save labyrinth image on disk", "Show commandsNames", "Exit"};
    private Command[] Commands = {new GeneratorOfLabyrinthCommand(), new ShowLabyrinthInCMD(),
            new FindTheWayCommand(), new ShowPathInConsole(), new SaveLabyrinthInImageCommand(), new ShowCommandsCommand(), new ExitCommand()};

    public App() {
        Commands[5].execute(this);
        while (true) {
            cli.printWithNewLine("Enter the number of commands");
            int in = cli.enterInt();
            if (in > 0 && in <= commandsNames.length) {
                Commands[in - 1].execute(this);
            } else {
                cli.printWithNewLine("Incorrect number of command. Please try again.");
            }
        }
    }

    public String[] getCommandsNames() {
        return commandsNames;
    }

    public RandomLabyrinth getLab() {
        return lab;
    }

    public PainterCells getPainterCells() {
        return painterCells;
    }

    public void setLab(RandomLabyrinth lab) {
        this.lab = lab;
    }

    public void setPainterCells(PainterCells painterCells) {
        this.painterCells = painterCells;
    }

    public CommandLineInterractor getCli() {
        return cli;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public char[][] getCells() {
        return cells;
    }

    public void initCells() {
        cells = lab.getCells();
        cellsWitnPath = lab.getCells();
    }

    public char[][] getCellsWitnPath() {
        return cellsWitnPath;
    }
}


