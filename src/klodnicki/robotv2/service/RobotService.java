package klodnicki.robotv2.service;
import klodnicki.robotv2.Database;
import klodnicki.robotv2.controller.MenuController;
import klodnicki.robotv2.model.Robot;

public class RobotService {
    private final Database database = new Database();

    private MenuController menuController;

    // Tutaj jest rzeczywiste tworzenie tego robota
    public void create(String robotName) {
        // tutaj najpierw walidacja
        Robot foundRobot = database.findRobot(robotName);

        if(foundRobot != null) {
            System.out.println("This name already exist.");
        }
        // cała "logika biznesowa" -> walidacja
        Robot robot = new Robot(robotName);
        database.add(robot);
    }

    public void robotCreatedInfo() {
        System.out.println("Robot has been created.");
    }

    public void robotTurnedOnInfo() {
        System.out.println("Robot has been turned on.");
    }

    public boolean isRobotIsNull(Robot robot) {
        if (robot == null) {
            return true;
        }
        return false;
    }
}
