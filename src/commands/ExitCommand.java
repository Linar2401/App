package commands;

import main.App;

public class ExitCommand extends Command{
    public void execute(App app){
        app = app;
        app.getCli().print("Goodbye");
        System.exit(0);
    }
}
