package klodnicki.robotv2;

import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Robot;

import java.sql.*;
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
    public List<Robot> getRobots() {
        return robots;
    }

    public List<Charger> getChargers() {
        return chargers;
    }

    public void create(Robot robot) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String insertQuery = "INSERT INTO robots(name, energy_level, is_on) values(?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, robot.getName());
                preparedStatement.setInt(2, robot.getEnergyLevel());
                preparedStatement.setBoolean(3, robot.isOn());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void create(Charger charger) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String insertQuery = "INSERT INTO chargers(free_slots, name) values(?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){
                preparedStatement.setInt(1, charger.getFreeSlots());
                preparedStatement.setString(2, charger.getName());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }
