package klodnicki.robotv2.service;

import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Robot;

import java.util.ArrayList;
import java.util.List;

public class ChargerService {

    List<Charger> chargers = new ArrayList<>();

    private Robot robot;

    public ChargerService(Robot robot) {
        this.robot = robot;
    }

    public boolean isRobotOnTheChargersList() {
        boolean isRobotOnTheChargersList = false;

        for (int i = 0; i < chargers.size(); i++) {

            if (chargers.get(i).getPluggedRobots().contains(robot)) {
                isRobotOnTheChargersList = true;
                System.out.println("Unplug the robot first");
                return true;
            }
        }
        return false;
    }


}


