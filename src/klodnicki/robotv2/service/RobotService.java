package klodnicki.robotv2.service;

import klodnicki.robotv2.model.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotService {

    private List<Robot> robots = new ArrayList<>();




    public Robot createRobot(String robotName) {
        Robot robot = new Robot(robotName);
        robots.add(robot);
        return robot;
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





}
