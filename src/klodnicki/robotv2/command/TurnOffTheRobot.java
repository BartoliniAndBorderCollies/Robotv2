package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.RobotController;

public class TurnOffTheRobot implements MenuCommand {

    private final RobotController robotController;

    public TurnOffTheRobot(RobotController robotController) {
        this.robotController = robotController;
    }

    @Override
    public String getName() {
        return "Turn off the robot";
    }

    @Override
    public void execute() {
        robotController.turnOff();

    }
}
