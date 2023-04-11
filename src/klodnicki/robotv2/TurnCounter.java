package klodnicki.robotv2;

import java.util.ArrayList;
import java.util.List;

public class TurnCounter {

    // numer tury
    private int turn = 0;

    // liczenie która to tura
    public void count() {
        turn++;
    }

    public int getTurn() {
        return turn;
    }
}
