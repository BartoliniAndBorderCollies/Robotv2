package klodnicki.robotv2;

import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Robot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {
    private final List<Robot> robots = new ArrayList<>();
    private final List<Charger> chargers = new ArrayList<>();

    public Optional<Robot> findRobot(String robotName) {
        Robot robot = null;

        for (Robot value : robots) {
            if (value.getName().equals(robotName)) {
                robot = value;
                break;
            }
        }
        return Optional.ofNullable(robot);
    }

    public Optional<Charger> findCharger(String chargerName) {
        Charger charger = null;

        for (Charger value : chargers) {
            if (value.getName().equals(chargerName)) {
                charger = value;
                break;
            }
        }
        return Optional.ofNullable(charger);
    }

    public void add(Robot robot) {
        robots.add(robot);
    }

    public void add(Charger charger) {
        chargers.add(charger);
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public List<Charger> getChargers() {
        return chargers;
    }
}
