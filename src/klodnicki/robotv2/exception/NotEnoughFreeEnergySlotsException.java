package klodnicki.robotv2.exception;

public class NotEnoughFreeEnergySlotsException extends Exception{

    private static final String MESSAGE = "Not enough energy slots(sockets)";

    public NotEnoughFreeEnergySlotsException() {
        super(MESSAGE);
    }
}
