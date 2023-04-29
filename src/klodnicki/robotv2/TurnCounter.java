package klodnicki.robotv2;

import java.util.ArrayList;
import java.util.List;

public class TurnCounter {

    // numer tury
    private static int turn = 0;

    // liczenie która to tura
    public static void count() {
        turn++;
    }

    public static int getTurn() {
        return turn;
    }
}
