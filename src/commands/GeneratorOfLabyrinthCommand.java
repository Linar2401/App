package commands;

import Labyrinth.RandomLabyrinth;
import main.App;

public class GeneratorOfLabyrinthCommand extends Command {
    public void execute(App app){
        app = app;
        app.getCli().printWithNewLine("Enter width and height of labyrinth:");
        app.setWidth(app.getCli().enterInt());
        app.setHeight(app.getCli().enterInt());
        app.setLab(new RandomLabyrinth(app.getWidth(),app.getHeight()));
        app.getLab().makeWall();
        app.setCells(app.getLab().getCells());
        app.setCellsWitnPath(app.getLab().getCells());
    }
}
