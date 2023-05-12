package klodnicki.robotv2.service;

import klodnicki.robotv2.Database;
import klodnicki.robotv2.RobotMovement;
import klodnicki.robotv2.exception.ObjectNotFoundException;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.model.Robot;

import java.util.ArrayList;
import java.util.List;

public class RobotService {
    private final Database database;

    public RobotService(Database database) {
        this.database = database;
    }

    public void create(String robotName) throws ObjectNotFoundException {

        Robot robot = new Robot(robotName);
        database.create(robot);
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
                Robot foundRobot = findRobot(robotName);
                String movementDone = foundRobot.move(movement);
                database.updateEnergyLevel(foundRobot);
                return movementDone;
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

    public boolean doesRobotAlreadyExist(String robotName) {
        return database.doesRobotAlreadyExist(robotName);
    }

    public void addRobotToPluggedRobots(Robot robot) {
        database.addRobotToPluggedRobots(robot);
    }

    public void removeRobotFromPluggedRobots(Robot robot) {
        database.removeRobotFromPluggedRobots(robot);
    }

}
