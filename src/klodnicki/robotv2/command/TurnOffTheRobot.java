package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.ChargerController;
import klodnicki.robotv2.controller.RobotController;

public class TurnOffTheRobot implements MenuCommand {

    private final RobotController robotController;
    private final ChargerController chargerController;

    public TurnOffTheRobot(RobotController robotController, ChargerController chargerController) {
        this.robotController = robotController;
        this.chargerController = chargerController;
    }

    @Override
    public String getName() {
        return "Turn off the robot";
    }

    @Override
    public void execute() {
        robotController.turnOff();
        chargerController.chargeRobots();
    }
}
