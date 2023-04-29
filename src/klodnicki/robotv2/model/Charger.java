package klodnicki.robotv2.model;

import klodnicki.robotv2.exception.MaximumEnergyLevelException;
import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;
import klodnicki.robotv2.exception.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Charger {

    private int freeSlots;

    private String name;

    // możliwośc podłączenie ładowarki do robota
    private List<Robot> pluggedRobots = new ArrayList<>();

    public Charger(int freeSlots, String name) {
        this.freeSlots = freeSlots;
        this.name = name;
    }

    public void plugInRobot(Robot robot) throws NotEnoughFreeEnergySlotsException {

        if (freeSlots <= pluggedRobots.size()) {
            throw new NotEnoughFreeEnergySlotsException();
        }
        pluggedRobots.add(robot);
    }

    public void chargeRobots() throws MaximumEnergyLevelException {

        for (Robot robot : pluggedRobots) {

                if (robot.getEnergyLevel() > 90) {
                    robot.setEnergyLevel(100);
                } else {
                    robot.setEnergyLevel(robot.getEnergyLevel() + 10);
                }
        }
    }

    // możliwość odłączenia ładowarki
    public void unplugRobot(Robot robot) {
        pluggedRobots.remove(robot);
    }

    // możliwość zwracania robotów

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Charger " + name;
    }

    public List<Robot> getPluggedRobots() {
        return pluggedRobots;
    }
}
