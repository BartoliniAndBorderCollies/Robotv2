package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.RobotController;

public class TurnOnTheRobot implements MenuCommand {

    private final RobotController robotController;

    public TurnOnTheRobot(RobotController robotController) {
        this.robotController = robotController;
    }


    @Override
    public String getName() {
        return "Turn on the robot";
    }

    @Override
    public void execute() {
        robotController.turnOn();

    }
}
