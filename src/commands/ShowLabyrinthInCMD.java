package commands;

import main.App;

public class ShowLabyrinthInCMD extends Command {
    public void execute(App app){
        if (app.getLab().getCells().equals(null)){
            app.getCli().print("Please generate labyrinth first");
        }
        else {
            app.getLab().showLabyrinth();
        }
    }
}
