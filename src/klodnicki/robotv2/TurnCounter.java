package klodnicki.robotv2;

import java.util.ArrayList;
import java.util.List;

public class TurnCounter {

    // numer tury
    private int turn;

    // liczenie która to tura
    public void count() {
        turn++;
        System.out.println("Turn: " + turn);
    }

    public void skipTurn() {
        System.out.println("Next turn is beginning. ");
    }
}
