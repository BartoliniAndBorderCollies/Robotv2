package klodnicki.robotv2.exception;

public class RobotNotTurnedOnException extends Exception{

    private static final String MESSAGE = "Robot is not turned on.";

    public RobotNotTurnedOnException() {
        super(MESSAGE);
    }
}
