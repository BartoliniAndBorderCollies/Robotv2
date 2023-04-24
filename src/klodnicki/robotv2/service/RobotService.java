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
    private final Database database = new Database();

    // Tutaj jest rzeczywiste tworzenie tego robota
    public void create(String robotName) throws ObjectNotFoundException {
        // tutaj najpierw walidacja
        Robot foundRobot = findRobot(robotName);

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

}
