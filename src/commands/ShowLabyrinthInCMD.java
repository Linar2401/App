package commands;

import main.App;

public class ShowLabyrinthInCMD extends Command {
    public void execute(App app){
        app.getLab().showLabyrinth();
    }
}
