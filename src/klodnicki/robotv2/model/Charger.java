package klodnicki.robotv2.model;

import klodnicki.robotv2.exception.MaximumEnergyLevelException;
import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;

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
        if (freeSlots > pluggedRobots.size()) {
            pluggedRobots.add(robot);
            return;
        }
        throw new NotEnoughFreeEnergySlotsException();
    }

    public void chargeRobots() {

        for (int i = 0; i < pluggedRobots.size(); i++) {
            Robot robot = pluggedRobots.get(i);
            try {
                if (robot.getEnergyLevel() > 90) {
                    robot.setEnergyLevel(100);
                } else {
                    robot.setEnergyLevel(robot.getEnergyLevel() + 10);
                }
            } catch (MaximumEnergyLevelException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // możliwość odłączenia ładowarki
    public void unplugRobot(Robot robot) {
        pluggedRobots.remove(robot);
    }

    // możliwość zwracania robotów
    public List<Robot> getRobots() {
        return pluggedRobots;
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
}
