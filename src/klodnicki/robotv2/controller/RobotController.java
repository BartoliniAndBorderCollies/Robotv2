package klodnicki.robotv2.controller;

import klodnicki.robotv2.service.RobotService;

import java.util.Scanner;

public class RobotController {
    private final RobotService robotService = new RobotService(); // TODO: czemu final?

    // Kontroler to dosłownie joystick, klawiatura
    public void createRobot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the robot name.");
        robotService.create(scanner.nextLine());
    }

    public void showListOfRobotsAndEnergyLevel() {
        robotService.showListOfRobotsAndEnergyLevel();
    }


//    public String getRobotNameFromTheUserToCreateRobot() {
//        System.out.println("What name you want to give to the robot?");
//        return scanner.nextLine();
//    }
//
//    public String getRobotNameFromTheUserToTurnRobotOn() {
//        System.out.println("Type the name of robot which you want to turn on.");
//        return scanner.nextLine();
//    }







}
