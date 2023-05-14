package klodnicki.robotv2.model;

import klodnicki.robotv2.exception.MaximumEnergyLevelException;
import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;

import java.util.ArrayList;
import java.util.List;
public class Charger {
    private int id;
    private final String name;
    private final int freeSlots;


    private List<Robot> pluggedRobots = new ArrayList<>();

    public Charger(String name, int freeSlots) {
        this.name = name;
        this.freeSlots = freeSlots;
    }

    public Charger(int id, String name, int freeSlots) {
        this.id = id;
        this.name = name;
        this.freeSlots = freeSlots;
    }

    public Charger(int id, String name, int freeSlots, List<Robot> pluggedRobots) {
        this.id = id;
        this.name = name;
        this.freeSlots = freeSlots;
        this.pluggedRobots = pluggedRobots;
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

    public void unplugRobot(Robot robot) {
        pluggedRobots.remove(robot);
    }

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

    public int getFreeSlots() {
        return freeSlots;
    }

    public int getId() {
        return id;
    }
}
