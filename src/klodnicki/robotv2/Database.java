package klodnicki.robotv2;

import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

// taka nasza klasa bazodanowa
public class Database {
    private List<Robot> robots = new ArrayList<>();
    private List<Charger> chargers = new ArrayList<>();


    public void showListOfRobotsAndEnergyLevel () {
        for (int i =0; i< robots.size(); i++) {
            System.out.println("List of robots and energy level.");
            System.out.println(i + ". " + robots.get(i).getName() + " " + robots.get(i).getEnergyLevel() + "%.");
        }
    }

    public String getUserInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public Robot findRobot(String robotName) {
        Robot robot = null;


        for (Robot value : robots) {
            if (value.getName().equals(robotName)) {
                robot = value;
                break;
            }
        }
        return robot;
    }


    public Charger findCharger(String chargerName) {
        Charger charger = null; //TODO: optional to do

        for (Charger value : chargers) {
            if (value.getName().equals(chargerName)){
                charger = value;
                break;
            }
        }
        return charger;
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


    public void add(Robot robot) {
        robots.add(robot);
    }

    public void add(Charger charger) {
        chargers.add(charger);
    }


    public List<Robot> getRobots() {
        return robots;
    }

}
