package klodnicki.robotv2;

import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Robot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {

    public Optional<Robot> findRobot(String robotName) {
        Robot robot = null;

        String selectQuery = "select * from robots where name = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(selectQuery)) {
            preparedStatement.setString(1, robotName);
            ResultSet resultSet = preparedStatement.executeQuery(selectQuery);
            // nie znajdzie robota, czyli resultSet.next() zwróci false
            // znajdzie dokładnie jednego robota
            // znajdzie więcej niż jednego robota

            if (resultSet.next()) {
                String foundRobotName = resultSet.getString("name");
                int foundRobotEnergyLevel = resultSet.getInt("energy_level");
                boolean isFoundRobotOn = resultSet.getBoolean("is_on");
                robot = new Robot(foundRobotName, foundRobotEnergyLevel, isFoundRobotOn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(robot);
    }

    public Optional<Charger> findCharger(String chargerName) {
        Charger charger = null;

        String selectQuery = "select * from chargers where name = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(selectQuery)) {
            preparedStatement.setString(1, chargerName);
            ResultSet resultSet = preparedStatement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String foundChargerName = resultSet.getString("name");
                int foundFreeEnergySlots = resultSet.getInt("free_energy_slots");
                charger = new Charger(foundChargerName, foundFreeEnergySlots);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(charger);
    }

    public List<Robot> getRobots() {
        List<Robot> robots = new ArrayList<>();
        String selectQueryAll = "select * from robots";
        try(Statement statement = DatabaseConnection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQueryAll);
            while (resultSet.next()) {
                String foundRobotName = resultSet.getString("name");
                int foundRobotEnergyLevel = resultSet.getInt("energy_level");
                boolean isFoundRobotOn = resultSet.getBoolean("is_on");
                robots.add(new Robot(foundRobotName, foundRobotEnergyLevel, isFoundRobotOn));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return robots;
    }

    public List<Charger> getChargers() {
        List<Charger> chargers = new ArrayList<>();
        String selectQueryAll = "select * from chargers";
        try (Statement statement = DatabaseConnection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQueryAll);
            while (resultSet.next()) {
                String foundChargerName = resultSet.getString("name");
                int foundFreeEnergySlots = resultSet.getInt("free_energy_slots");
                chargers.add(new Charger(foundChargerName, foundFreeEnergySlots));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chargers;
    }

    public boolean doesRobotAlreadyExist (String robotName) {
        List<Robot> listExistingRobots = getRobots();
        List<String> listNamesOfRobots = new ArrayList<>();
        for (Robot existingRobot : listExistingRobots) {
            String existingRobotName = existingRobot.getName();
            listNamesOfRobots.add(existingRobotName);
        }
        return listNamesOfRobots.contains(robotName);
    }

    public boolean doesChargerAlreadyExist (String chargerName) {
        List<Charger> listExistingChargers = getChargers();
        List<String> listNamesOfChargers = new ArrayList<>();
        for(Charger existingCharger : listExistingChargers) {
            String existingChargerName = existingCharger.getName();
            listNamesOfChargers.add(existingChargerName);
        }
        return listNamesOfChargers.contains(chargerName);
    }

    public void create(Robot robot) {
        if (doesRobotAlreadyExist(robot.getName())) {
            return;
        }
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
            String insertQuery = "INSERT INTO chargers(name, free_energy_slots) values(?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, charger.getName());
                preparedStatement.setInt(2, charger.getFreeSlots());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
