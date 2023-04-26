package klodnicki.robotv2.controller;

import klodnicki.robotv2.RobotMovement;
import klodnicki.robotv2.exception.ObjectNotFoundException;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.model.Robot;
import klodnicki.robotv2.service.RobotService;

import java.util.List;
import java.util.Scanner;

public class RobotController {
    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    public void createRobot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the robot name.");
        try {
            robotService.create(scanner.nextLine());
            System.out.println("Robot has been created.");
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showListOfRobotsAndEnergyLevel() {
        List<String> rows = robotService.prepareListOfRobotNamesWithEnergy();
        for (String row : rows) {
            System.out.println(row);
        }
        if (rows.isEmpty()) {
            System.out.println("There is no robots on the list.");
        }
    }

    public void moveRobot() {
        if(robotService.prepareListOfRobotNamesWithEnergy().isEmpty()) {
            System.out.println("There is no robot on the list.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Below is the list of robots:");
        System.out.println(robotService.prepareListOfRobotNamesWithEnergy());
        System.out.println("Type the name of robot which you want to move:");
        String chosenRobot = scanner.nextLine(); //TODO: można wybrać robota z poza listy i nic sie nie dzieje
        System.out.println("Type the move you want to make:");
        for (RobotMovement move : RobotMovement.values()) {
            System.out.println(move.getName());
        }
        String chosenMovement = scanner.nextLine();
        try {
            robotService.move(chosenRobot, chosenMovement);
        } catch (ObjectNotFoundException | RobotNotTurnedOnException | TooLowEnergyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void turnOff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(robotService.prepareListOfRobotNamesWithEnergy());
        System.out.println("Type the name of robot you want to turn off:");
        String robotToTurnOff = scanner.nextLine();
        try {
            robotService.turnOff(robotToTurnOff);
            System.out.println("Robot " + robotToTurnOff + " has been turned off.");
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void turnOn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(robotService.prepareListOfRobotNamesWithEnergy());
        System.out.println("Type the name of robot you want to turn on:");
        String robotToTurnOn = scanner.nextLine();
        try {
            robotService.turnOn(robotToTurnOn);
            System.out.println("Robot " + robotToTurnOn + " has been turned on.");
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isOn(String robotName) {
        return robotService.isOn(robotName);
    }


}
