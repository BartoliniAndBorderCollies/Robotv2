package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.ChargerController;
import klodnicki.robotv2.controller.RobotController;

public class CreateRobot implements MenuCommand {
    private final RobotController robotController;
    private final ChargerController chargerController;

    public CreateRobot(RobotController robotController, ChargerController chargerController) {
        this.robotController = robotController;
        this.chargerController = chargerController;
    }

    @Override
    public String getName() {
        return "Create robot";
    }

    @Override
    public void execute() {
        robotController.createRobot();
        chargerController.chargeRobots();
    }
}
