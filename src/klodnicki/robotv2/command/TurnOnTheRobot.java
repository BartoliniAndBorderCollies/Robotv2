package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.RobotController;
import klodnicki.robotv2.model.Robot;
import klodnicki.robotv2.Workshop;
import klodnicki.robotv2.service.RobotService;

import java.util.List;
import java.util.Scanner;

public class TurnOnTheRobot implements MenuCommand {

    private Workshop workshop;
    private Scanner scanner;
    private List<Robot> robots;
    private Robot robot;
    private RobotService robotService;
    private RobotController robotController;



    public TurnOnTheRobot(Workshop workshop, Scanner scanner) {
        this.workshop = workshop;
        this.scanner = scanner;

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
        //sprawdzenie czy robot nie jest na liscie ładowanych robotów
        robot.turnOn();
        robotService.robotTurnedOnInfo();
    }
}
