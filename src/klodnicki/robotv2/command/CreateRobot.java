package klodnicki.robotv2.command;

import klodnicki.robotv2.Workshop;
import klodnicki.robotv2.controller.RobotController;
import klodnicki.robotv2.model.Robot;
import klodnicki.robotv2.service.RobotService;

import java.util.Scanner;

public class CreateRobot implements MenuCommand {

    private Workshop workshop;
    private RobotService robotService;
    private RobotController robotController;


    public CreateRobot(Workshop workshop, RobotService robotService, RobotController robotController) {
        this.workshop = workshop;
        this.robotService = robotService;
        this.robotController = robotController;
    }

    @Override
    public String getName() {
        return "Create robot";
    }

    @Override
    public void execute() {

        robotService.createRobot(robotController.getRobotNameFromTheUserToCreateRobot());
        robotService.robotCreatedInfo();
    }
}
