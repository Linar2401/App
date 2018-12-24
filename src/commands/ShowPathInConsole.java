package commands;

import main.App;

public class ShowPathInConsole extends Command {
    public void execute(App app){
        app = app;
        for (int i = 0; i < app.getWidth(); i++) {
            for (int j = 0; j < app.getHeight(); j++) {
                app.getCli().print(app.getCellsWitnPath()[i][j]);
            }
            System.out.println();
        }
    }
}
