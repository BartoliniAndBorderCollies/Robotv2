package klodnicki.robotv2;

public class TurnCounter {

    private int turn = 0;

    public void count() {
        turn++;
    }

    public int getTurn() {
        return turn;
    }
}
