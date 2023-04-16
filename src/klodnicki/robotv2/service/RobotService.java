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

    public void robotCreated() {
        System.out.println("Robot has been created.");
    }





}
