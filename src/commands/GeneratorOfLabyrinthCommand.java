package commands;

import Labyrinth.RandomLabyrinth;
import main.App;

public class GeneratorOfLabyrinthCommand extends Command {
    public void execute(App app){
        app = app;
        app.getCli().printWithNewLine("Enter width and height of labyrinth:");
        app.setSize(Math.max(app.getCli().enterInt(),app.getCli().enterInt()));
        app.setLab(new RandomLabyrinth(app.getSize(),app.getSize()));
        app.getLab().makeWall();
        app.initCells();
    }
}
