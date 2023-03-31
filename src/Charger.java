import java.util.ArrayList;
import java.util.List;

public class Charger {


    // możliwośc podłączenie ładowarki do robota
    private List<Robot> chargeRobots = new ArrayList<>();



    public void plugInRobot(Robot robot) {
        chargeRobots.add(robot);
    }

    // TODO: ładowanie robota
    public void chargeRobot() {
        //robot.charge();
        // ładowanie odbywa się ileś tam procent na turę
    }

    // możliwość odłączenia ładowarki
    public void unplugRobot(Robot robot) {
        chargeRobots.remove(robot);

    }

    // możliwość zwracania robotów
    public List<Robot> getRobots() {
        return chargeRobots;
    }
}
