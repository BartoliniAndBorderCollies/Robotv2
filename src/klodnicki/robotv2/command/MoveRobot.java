package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.RobotController;

public class MoveRobot implements MenuCommand{

    private final RobotController robotController;

    public MoveRobot(RobotController robotController) {
        this.robotController = robotController;
    }

    @Override
    public String getName() {
        return "Move robot";
    }

    @Override
    public void execute() {
        robotController.moveRobot();
        //TODO: jeśli lista robotów jest pusta to powiadom

    }
}
