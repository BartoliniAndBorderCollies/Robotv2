package klodnicki.robotv2.controller;

import klodnicki.robotv2.RobotMovement;
import klodnicki.robotv2.TurnCounter;
import klodnicki.robotv2.exception.ObjectNotFoundException;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.service.RobotService;

import java.util.List;
import java.util.Scanner;

public class RobotController {
    private final RobotService robotService;
    private final TurnCounter turnCounter;

    public RobotController(RobotService robotService, TurnCounter turnCounter) {
        this.robotService = robotService;
        this.turnCounter = turnCounter;
    }

    public void createRobot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the robot name.");
        String name = scanner.nextLine();
        try {
            if (robotService.doesRobotAlreadyExist(name)) {
                System.out.println("This robot already exist.");
                return;
            }
            robotService.create(name);
            System.out.println("Robot has been created.");
            turnCounter.count();
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> showListOfRobotsAndEnergyLevel() {
        List<String> rows = robotService.prepareListOfRobotNamesWithEnergy();
        for (String row : rows) {
            System.out.println(row);
        }
        if (rows.isEmpty()) {
            System.out.println("There is no robots on the list.");
        }
        return rows;
    }

    public void moveRobot() {
        List<String> rows = robotService.prepareListOfRobotNamesWithEnergy();
        if (rows.isEmpty()) {
            System.out.println("There is no robot on the list.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Below is the list of robots:");
        for (String row : rows) {
            System.out.println(row);
        }
        System.out.println("Type the name of robot which you want to move:");
        String chosenRobot = scanner.nextLine();

        System.out.println("Type the move you want to make:");
        for (RobotMovement move : RobotMovement.values()) {
            System.out.println(move.getName());
        }
        String chosenMovement = scanner.nextLine();
        try {
            System.out.println(robotService.move(chosenRobot, chosenMovement));
            turnCounter.count();

        } catch (ObjectNotFoundException | RobotNotTurnedOnException | TooLowEnergyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void turnOff() {
        List<String> robotsNames = robotService.prepareListOfRobotNamesWithEnergy();
        for (String robotName: robotsNames) {
            System.out.println(robotName);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name of robot you want to turn off:");
        String robotToTurnOff = scanner.nextLine();
        try {
            robotService.turnOff(robotToTurnOff);
            System.out.println("Robot " + robotToTurnOff + " has been turned off.");
            turnCounter.count();
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void turnOn() {
        List<String> robotsNames = robotService.prepareListOfRobotNamesWithEnergy();

        for (String robotName : robotsNames) {
            System.out.println(robotName);

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name of robot you want to turn on:");
        String robotToTurnOn = scanner.nextLine();
        try {
            robotService.turnOn(robotToTurnOn);
            System.out.println("Robot " + robotToTurnOn + " has been turned on.");
            turnCounter.count();
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isOn(String robotName) {
        try {
            return robotService.isOn(robotName);
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
