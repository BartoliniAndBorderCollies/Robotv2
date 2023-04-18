package klodnicki.robotv2.service;

import klodnicki.robotv2.Database;
import klodnicki.robotv2.model.Robot;

import java.util.List;

public class RobotService {
    private final Database database = new Database();

    // Tutaj jest rzeczywiste tworzenie tego robota
    public void create(String robotName) {
        // tutaj najpierw walidacja
        // cała "logika biznesowa" -> walidacja
        Robot robot = new Robot(robotName);
        database.add(robot);
    }

    public void robotCreatedInfo() {
        System.out.println("Robot has been created.");
    }

    public void robotTurnedOnInfo() {
        System.out.println("Robot has been turned on.");
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
}
