package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.ChargerController;
import klodnicki.robotv2.controller.RobotController;

public class MoveRobot implements MenuCommand{

    private final RobotController robotController;
    private final ChargerController chargerController;

    public MoveRobot(RobotController robotController, ChargerController chargerController) {
        this.robotController = robotController;
        this.chargerController = chargerController;
    }

    @Override
    public String getName() {
        return "Move robot";
    }

    @Override
    public void execute() {
        robotController.moveRobot();
        chargerController.chargeRobots();
    }
}
