package commands;

import main.App;

public class ShowPathInConsole extends Command {
    public void execute(App app){
        app = app;
        for (int i = 0; i < app.getSize()*2+1; i++) {
            for (int j = 0; j < app.getSize()*2+1; j++) {
                app.getCli().print(app.getCellsWithPath()[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
