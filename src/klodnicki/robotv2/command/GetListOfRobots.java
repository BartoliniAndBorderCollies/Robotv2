package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.RobotController;

public class GetListOfRobots implements MenuCommand {

    private final RobotController robotController;

    public GetListOfRobots(RobotController robotController) {
        this.robotController = robotController;
    }


    @Override
    public String getName() {
        return "Get list of robots and their energy levels";
    }

    @Override
    public void execute() {
        robotController.showListOfRobotsAndEnergyLevel();
    }
}
