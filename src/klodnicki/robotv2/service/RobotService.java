package klodnicki.robotv2.service;

import klodnicki.robotv2.Database;
import klodnicki.robotv2.RobotMovement;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.model.Robot;

import java.util.ArrayList;
import java.util.List;

public class RobotService {
    private final Database database = new Database();

    // Tutaj jest rzeczywiste tworzenie tego robota
    public void create(String robotName) {
        // tutaj najpierw walidacja
        Robot foundRobot = database.findRobot(robotName); //TODO:

        if (foundRobot != null) {
            System.out.println("This name already exist.");
        }
        // cała "logika biznesowa" -> walidacja
        Robot robot = new Robot(robotName);
        database.add(robot);
    }

    public List<Robot> getListOfRobots() {
//        database.showListOfRobotsAndEnergyLevel();
        return database.getRobots();
    }

    public void robotCreatedInfo() {
        System.out.println("Robot has been created.");
    }

    public void robotTurnedOnInfo() {
        System.out.println("Robot has been turned on.");
    }

    public boolean isRobotIsNull(Robot robot) {
        if (robot == null) {
            return true;
        }
        return false;
    }

    public List<String> prepareListOfRobotNamesWithEnergy() {
        List<Robot> robots = database.getRobots();
        List<String> rows = new ArrayList<>();
        for (Robot robot : robots) {
            rows.add(robot.getName() + ". Energy = " + robot.getEnergyLevel());
        }
        return rows;
    }

    public String move(String chosenRobot, String chosenMovement) {
        for (RobotMovement movement : RobotMovement.values()) {
            if (movement.getName().equals(chosenMovement)) {
                try {
                    return database.findRobot(chosenRobot).move(movement);
                } catch (RobotNotTurnedOnException | TooLowEnergyException e) {
                    return e.getMessage();
                }
            }
        }
        return "Unknown command.";
    }

    public void turnOff(String robotName) {
        Robot foundRobot = database.findRobot(robotName); //TODO:

        try {
            foundRobot.turnOff();
        } catch (NullPointerException e) {
            System.out.println("Robot has not been found.");
        }
    }

    public void turnOn(String robotName) {
        Robot foundRobot = database.findRobot(robotName);
        foundRobot.turnOn();
    }

}
