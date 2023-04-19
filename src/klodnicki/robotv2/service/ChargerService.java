package klodnicki.robotv2.service;

import klodnicki.robotv2.Database;
import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Robot;

import java.util.ArrayList;
import java.util.List;

public class ChargerService {
    private final Database database = new Database();

//    private Robot robot;



//    public boolean isRobotOnTheChargersList() {
//        boolean isRobotOnTheChargersList = false;
//
//        for (int i = 0; i < chargers.size(); i++) {
//
//            if (chargers.get(i).getPluggedRobots().contains(robot)) {
//                isRobotOnTheChargersList = true;
//                System.out.println("Unplug the robot first");
//                return true;
//            }
//        }
//        return false;
//    }

    public void create(int freeSlots, String chargerName) {
        //walidacja jeśli w worku z ładowarkami ładowarka o takim imieniu już jest
        Charger foundCharger = database.findCharger(chargerName);
        if (foundCharger != null) {

            System.out.println("This charger name already exist.");
        }

        Charger charger = new Charger(freeSlots, chargerName);
        database.add(charger);
    }


}


