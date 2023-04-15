package klodnicki.robotv2;

import java.util.ArrayList;
import java.util.List;

// taka nasza klasa "serwisowa" -> service
public class Workshop {
    private List<Robot> robots = new ArrayList<>();
    private List<Charger> chargers;

    public void showListOfRobotsAndEnergyLevel () {
        for (int i =0; i< robots.size(); i++) {
            if (robots.isEmpty()) {
                System.out.println("The list of robots is empty");
                break;
            }
            System.out.println("List of robots and energy level.");
            System.out.println(i + ". " + robots.get(i).getName() + " " + robots.get(i).getEnergyLevel() + "%.");
        }
    }





}
