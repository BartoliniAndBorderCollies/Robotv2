package klodnicki.robotv2;

public class TurnCounter {

    private static int turn = 0;

    public static void count() {
        turn++;
    }

    public static int getTurn() {
        return turn;
    }
}
