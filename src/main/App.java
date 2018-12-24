package main;

import Labyrinth.RandomLabyrinth;
import commands.GeneratorOfLabyrinthCommand;
import commands.ShowCommandsCommand;
import commands.Command;
import painter.PainterCells;
import utils.CommandLineInterractor;


public class App {
    private int height;
    private int width;
    private RandomLabyrinth lab;
    private PainterCells painterCells;
    private CommandLineInterractor cli = new CommandLineInterractor();
    private String[] commandsNames = {"Generate labyrinth","Show labyrinth in console","Find path","Show path in console",
            "Save labyrinth image on disk","Show commandsNames"};
    private Command[] Commands = {new GeneratorOfLabyrinthCommand(),new ShowCommandsCommand(),new ShowCommandsCommand()};

    public App() {
        lab = new RandomLabyrinth(12,12);
        lab.makeWall();
        char[][] cells = lab.getCells();
        painterCells = new PainterCells(12*2+1,12*2+1);
        painterCells.save("image.png");

    }

    public String[] getCommandsNames() {
        return commandsNames;
    }

    public Command[] getCommands() {
        return Commands;
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

    public void setCommandsNames(String[] commandsNames) {
        this.commandsNames = commandsNames;
    }

    public void setCommands(Command[] Commands) {
        this.Commands = Commands;
    }

    public CommandLineInterractor getCli() {
        return cli;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setCli(CommandLineInterractor cli) {
        this.cli = cli;
    }
}
