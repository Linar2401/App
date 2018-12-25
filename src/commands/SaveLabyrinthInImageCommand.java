package commands;

import main.App;
import painter.PainterCells;

import java.io.IOException;

public class SaveLabyrinthInImageCommand extends Command {
    public void execute(App app){
        app = app;
        boolean correctSaving = false;
        app.setPainterCells(new PainterCells(app.getSize()*2+1));
        app.getPainterCells().paintLabyrinth(app);
        app.getCli().print("Enter path of image:");
        while(!correctSaving){
            correctSaving = true;
            try {
                app.getPainterCells().save(app.getCli().entetString());
            }
            catch (IOException e){
                app.getCli().print("Please try another path of file");
                correctSaving = false;
            }
        }
    }
}
