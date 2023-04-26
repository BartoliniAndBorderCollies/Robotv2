package klodnicki.robotv2.service;

import klodnicki.robotv2.Database;
import klodnicki.robotv2.RobotMovement;
import klodnicki.robotv2.exception.ObjectNotFoundException;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.model.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RobotService {
    private final Database database;

    public RobotService(Database database) {
        this.database = database;
    }

    // Tutaj jest rzeczywiste tworzenie tego robota
    public void create(String robotName) throws ObjectNotFoundException { //TODO: do poprawki
        // tutaj najpierw walidacja
//        Robot foundRobot = findRobot(robotName);
//
//
//        if (foundRobot != null) {
//            System.out.println("This name already exist.");
//        }
        // cała "logika biznesowa" -> walidacja
        Robot robot = new Robot(robotName);
        database.add(robot);
    }

    public List<Robot> getListOfRobots() {
//        database.showListOfRobotsAndEnergyLevel();
        return database.getRobots();
    }

    public List<String> prepareListOfRobotNamesWithEnergy() {
        List<Robot> robots = database.getRobots();
        List<String> rows = new ArrayList<>();
        for (Robot robot : robots) {
            rows.add("Robot name: " + robot.getName() + ". Energy level = " + robot.getEnergyLevel());
        }
        return rows;
    }

    public String move(String robotName, String movementName) throws ObjectNotFoundException, RobotNotTurnedOnException, TooLowEnergyException {
        for (RobotMovement movement : RobotMovement.values()) {
            if (movement.getName().equals(movementName)) {
                return findRobot(robotName).move(movement);
            }
        }
        return "Unknown command.";
    }

    public void turnOff(String robotName) throws ObjectNotFoundException {
        Robot foundRobot = findRobot(robotName);

        foundRobot.turnOff();
    }

    public void turnOn(String robotName) throws ObjectNotFoundException {

        Robot foundRobot = findRobot(robotName);
        foundRobot.turnOn();
    }

    public Robot findRobot(String name) throws ObjectNotFoundException {
        return database.findRobot(name).orElseThrow(() -> new ObjectNotFoundException(Robot.class));
    }


    public boolean isOn(String robotName) throws ObjectNotFoundException{
        Robot robot = findRobot(robotName);
        return robot.isOn();
    }

}
