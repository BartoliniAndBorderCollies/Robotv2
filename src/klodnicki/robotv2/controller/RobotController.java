package klodnicki.robotv2.controller;

import klodnicki.robotv2.service.RobotService;

import java.util.Scanner;

public class RobotController {

    private Scanner scanner = new Scanner(System.in);
    private final RobotService robotService = new RobotService();

    // Kontroler to dosłownie joystick, klawiatura
    public void createRobot() {
        System.out.println("Podaj nazwę dla robota:");
        robotService.create(scanner.nextLine());
    }


    public String getRobotNameFromTheUserToCreateRobot() {
        System.out.println("What name you want to give to the robot?");
        return scanner.nextLine();
    }

    public String getRobotNameFromTheUserToTurnRobotOn() {
        System.out.println("Type the name of robot which you want to turn on.");
        return scanner.nextLine();
    }







}
