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
        String foundRobotName = "";
        int foundRobotEnergyLevel = 0;
        boolean isFoundRobotOn = true;
        String selectQuery = "select * from robots where name = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(selectQuery)) {
            preparedStatement.setString(1, robotName);
            ResultSet resultSet = preparedStatement.executeQuery(selectQuery);
            while (resultSet.next()) {
                foundRobotName = resultSet.getString("name");
                foundRobotEnergyLevel = resultSet.getInt("energy_level");
                isFoundRobotOn = resultSet.getBoolean("is_on");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(new Robot(foundRobotName, foundRobotEnergyLevel, isFoundRobotOn));
    }

    public Optional<Charger> findCharger(String chargerName) {
        Charger charger = null;
        String foundChargerName = "";
        int foundFreeEnergySlots = 0;

        String selectQuery = "select * from chargers where name = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(selectQuery)) {
            preparedStatement.setString(1, chargerName);
            ResultSet resultSet = preparedStatement.executeQuery(selectQuery);
            while (resultSet.next()) {
                foundChargerName = resultSet.getString("name");
                foundFreeEnergySlots = resultSet.getInt("free_energy_slots");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(new Charger(foundChargerName, foundFreeEnergySlots));
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
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, charger.getFreeSlots());
                preparedStatement.setString(2, charger.getName());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
