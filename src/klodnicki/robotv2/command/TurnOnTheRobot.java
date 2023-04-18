package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.RobotController;
import klodnicki.robotv2.model.Robot;
import klodnicki.robotv2.service.ChargerService;
import klodnicki.robotv2.service.RobotService;

import java.util.List;

public class TurnOnTheRobot implements MenuCommand {

    private List<Robot> robots;
    private Robot robot;
    private RobotService robotService;
    private RobotController robotController;
    private ChargerService chargerService;


    public TurnOnTheRobot(List<Robot> robots, Robot robot, RobotService robotService, RobotController robotController, ChargerService chargerService) {

        this.robots = robots;
        this.robot = robot;
        this.robotService = robotService;
        this.robotController = robotController;
        this.chargerService = chargerService;
    }

    @Override
    public String getName() {
        return "Turn on the robot";
    }

    @Override
    public void execute() {


        robotController.getRobotNameFromTheUserToTurnRobotOn();
        robotService.findRobot(robots, robotController.getRobotNameFromTheUserToTurnRobotOn());
        //sprawdzenie czy robot nie jest nullem
        if(robotService.isRobotIsNull(robot)) {
            //TODO: go back to menu.
        };
        //sprawdzenie czy robot nie jest na liscie ładowanych robotów
        if(chargerService.isRobotOnTheChargersList()) {
            //TODO: go back to menu.
        };

        robot.turnOn();
        robotService.robotTurnedOnInfo();
    }
}
