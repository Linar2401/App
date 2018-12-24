package commands;

import main.App;

public abstract class Command {
    App app;
    public abstract void execute(App app);

}
