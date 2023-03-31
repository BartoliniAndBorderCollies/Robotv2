import java.util.ArrayList;
import java.util.List;

public class Charger {


    // możliwośc podłączenie ładowarki do robota
    private List<Robot> robots = new ArrayList<>();

    public void plugInRobot(Robot robot) {
        robots.add(robot);
    }

    // TODO: ładowanie robota
    public void chargeRobot() {
        //robot.charge();
        // ładowanie odbywa się ileś tam procent na turę
    }

    // możliwość odłączenia ładowarki
    public void unplugRobot(Robot robot) {
        robots.remove(robot);

    }

    // możliwość zwracania robotów
    public List<Robot> getRobots() {
        return robots;
    }
}
