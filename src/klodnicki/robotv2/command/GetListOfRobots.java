package klodnicki.robotv2.command;

import klodnicki.robotv2.Workshop;

public class GetListOfRobots implements MenuCommand{
    
    Workshop workshop;

    public GetListOfRobots(Workshop workshop) {
        this.workshop = workshop;
    }

    @Override
    public String getName() {
        return "Get list of robots and their energy levels";
    }

    @Override
    public void execute() {
        workshop.showListOfRobotsAndEnergyLevel();
    }
}
