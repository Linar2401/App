package commands;

import main.App;

import java.io.IOException;

public class SavePathInImage extends Command {
    public void execute(App app){
        app = app;
        boolean correctSaving = false;
        //Это место работы Арслана. Тут оно зарисовывает нужные клетки нужными цветами.
        app.getCli().print("Enter path of image");
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
