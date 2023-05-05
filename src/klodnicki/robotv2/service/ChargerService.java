package klodnicki.robotv2.service;

import klodnicki.robotv2.Database;
import klodnicki.robotv2.exception.MaximumEnergyLevelException;
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

    public void create(int freeSlots, String chargerName) {

        Charger charger = new Charger(freeSlots, chargerName);
        database.create(charger);
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

    public List<Robot> getPluggedRobots(String chargerName) throws ObjectNotFoundException{
        return findCharger(chargerName).getPluggedRobots();
    }

    public void chargeRobots() throws MaximumEnergyLevelException {
        List<Charger> chargers = getListOfChargers();
        for (Charger charger : chargers) {
            charger.chargeRobots();
        }
    }
}


