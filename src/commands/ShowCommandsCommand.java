package commands;

import main.App;

public class ShowCommandsCommand extends Command {
    public void execute(App app){
        app = app;
        System.out.print(" | ");
        for (int i = 0; i < app.getCommandsNames().length; i++){
            System.out.print(app.getCommandsNames()[i]+" | ");
        }
        System.out.println();
    }
}
