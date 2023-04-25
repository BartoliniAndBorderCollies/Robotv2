package klodnicki.robotv2.service;

import klodnicki.robotv2.Database;
import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;
import klodnicki.robotv2.exception.ObjectNotFoundException;
import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Robot;

import java.util.List;

public class ChargerService {
    private final Database database;
    private final RobotService robotService;

    public ChargerService(Database database, RobotService robotService) {
        this.database = database;
        this.robotService = robotService;
    }

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
//        Charger foundCharger = database.findCharger(chargerName);
//        if (foundCharger != null) {
//
//            System.out.println("This charger name already exist.");
//        }

        Charger charger = new Charger(freeSlots, chargerName);
        database.add(charger);
    }

    public void plugIn(String chargerName, String robotName) throws ObjectNotFoundException, NotEnoughFreeEnergySlotsException {
        Charger foundCharger = findCharger(chargerName);
        Robot foundRobot = robotService.findRobot(robotName);
        foundCharger.plugInRobot(foundRobot);

    }

    public void unplug(String chargerName, String robotName) throws ObjectNotFoundException {
        Charger foundCharger = findCharger(chargerName);
        Robot foundRobot = robotService.findRobot(robotName);
        foundCharger.unplugRobot(foundRobot);
    }

    public List<Charger> getListOfChargers() {
        return database.getChargers();
    }

    public Charger findCharger(String chargerName) throws ObjectNotFoundException {
        return database.findCharger(chargerName).orElseThrow(() -> new ObjectNotFoundException(Charger.class));
    }


}


