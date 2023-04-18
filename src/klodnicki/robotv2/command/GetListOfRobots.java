package klodnicki.robotv2.command;

import klodnicki.robotv2.Database;

public class GetListOfRobots implements MenuCommand{

    private Database database;

    public GetListOfRobots(Database database) {
        this.database = database;
    }

    @Override
    public String getName() {
        return "Get list of robots and their energy levels";
    }

    @Override
    public void execute() {
        database.showListOfRobotsAndEnergyLevel();
    }
}
