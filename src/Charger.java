import java.util.ArrayList;
import java.util.List;

public class Charger {

    private int freeSlots;


    // możliwośc podłączenie ładowarki do robota
    private List<Robot> chargeRobots = new ArrayList<>();

    public Charger(int freeSlots) {
        this.freeSlots = freeSlots;
    }

    public boolean plugInRobot(Robot robot) {
        if(freeSlots>chargeRobots.size()) {
            chargeRobots.add(robot);
            return true;
        }
        return false;
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
