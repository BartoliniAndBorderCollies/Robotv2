package klodnicki.robotv2;

import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;

import java.util.ArrayList;
import java.util.List;

public class Charger {

    private int freeSlots;

    // możliwośc podłączenie ładowarki do robota
    private List<Robot> pluggedRobots = new ArrayList<>();

    public Charger(int freeSlots) {
        this.freeSlots = freeSlots;
    }

    public void plugInRobot(Robot robot) throws NotEnoughFreeEnergySlotsException {
        if (freeSlots > pluggedRobots.size()) {
            pluggedRobots.add(robot);
        }
            throw new NotEnoughFreeEnergySlotsException();
    }

    public void chargeRobots() {

        for (int i = 0; i < pluggedRobots.size(); i++) {
            Robot robot = pluggedRobots.get(i);
            robot.setEnergyLevel(robot.getEnergyLevel() + 10);
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


}
