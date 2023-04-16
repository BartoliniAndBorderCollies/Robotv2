package klodnicki.robotv2;

import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// taka nasza klasa "serwisowa" -> service
public class Workshop {
    private List<Robot> robots = new ArrayList<>();
    private List<Charger> chargers;

    private Scanner scanner;


    public void showListOfRobotsAndEnergyLevel () {
        for (int i =0; i< robots.size(); i++) {
            if (robots.isEmpty()) {
                System.out.println("The list of robots is empty");
                break;
            }
            System.out.println("List of robots and energy level.");
            System.out.println(i + ". " + robots.get(i).getName() + " " + robots.get(i).getEnergyLevel() + "%.");
        }
    }

    public String getUserInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public Robot findRobot(List<Robot> robots, String robotName) {
        Robot robot = null;

        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i).getName().equals(robotName)) {
                robot = robots.get(i);
                break;
            }
        }
        return robot;
    }

    public boolean isRobotIsNull(Robot robot) {
        if (robot == null) {
            System.out.println("Robot has not been found.");
            return true;
        }
        return false;
    }

    public void isRobotOnTheChargersList() {
        boolean isRobotOnTheChargersList = false;

        for (int i = 0; i < chargers.size(); i++) {

            if (chargers.get(i).getPluggedRobots().contains(robots.get(i))) {
                isRobotOnTheChargersList = true;
                break;
            }
        }
        if (isRobotOnTheChargersList) {
            System.out.println("Unplug robot from the charger first.");
            //TODO: go back to main menu
        }
    }








}
