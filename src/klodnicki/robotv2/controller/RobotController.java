package klodnicki.robotv2.controller;

import klodnicki.robotv2.RobotMovement;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.model.Robot;
import klodnicki.robotv2.service.RobotService;

import java.util.List;
import java.util.Scanner;

public class RobotController {
    private final RobotService robotService = new RobotService();

    // Kontroler to dosłownie joystick, klawiatura
    public void createRobot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the robot name.");
        robotService.create(scanner.nextLine());
    }

    public void showListOfRobotsAndEnergyLevel() {
        // TODO: Choose your hero
        // pobrać listę robotów
        List<Robot> listOfRobots = robotService.getListOfRobots();
        // Wyświetl listę robotów razem z ich energią
        System.out.println(listOfRobots.get(0).getName() + ". Energy = " + listOfRobots.get(0).getEnergyLevel());

        // v2:
        List<String> rows = robotService.prepareListOfRobotNamesWithEnergy();
        for (String row : rows) {
            System.out.println(row);
        }
    }

    public void moveRobot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Below is the list of robots:");
        System.out.println(robotService.prepareListOfRobotNamesWithEnergy());
        System.out.println("Type the name of robot which you want to move:");
        String chosenRobot = scanner.nextLine();
        System.out.println("Type the move you want to make:");
        for (RobotMovement move : RobotMovement.values()) {
            System.out.println(move.getName());
        }
        String inputChosenMovement = scanner.nextLine();
        robotService.move(chosenRobot, inputChosenMovement);


    }


}
