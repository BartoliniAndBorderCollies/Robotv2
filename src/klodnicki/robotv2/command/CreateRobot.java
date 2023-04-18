package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.RobotController;

public class CreateRobot implements MenuCommand {
    private final RobotController robotController;

    public CreateRobot(RobotController robotController) {
        this.robotController = robotController;
    }

    @Override
    public String getName() {
        return "Create robot";
    }

    @Override
    public void execute() {
        robotController.createRobot();
    }
}
