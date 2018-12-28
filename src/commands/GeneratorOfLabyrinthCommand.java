package commands;

import Labyrinth.RandomLabyrinth;
import exceptions.BigSizeException;
import main.App;

public class GeneratorOfLabyrinthCommand extends Command {
    public void execute(App app){
        try {
            app = app;
            app.getCli().printWithNewLine("Enter size of labyrinth:");
            int size = app.getCli().enterInt();
            if (size > 286){
                throw new BigSizeException();
            }
            app.setSize(size);
            app.setLab(new RandomLabyrinth(app.getSize(),app.getSize()));
            app.getLab().makeWall();
            app.initCells();
        }
        catch (BigSizeException e){
            app.getCli().printWithNewLine("Too big size!!!");
        }
    }
}
