package klodnicki.robotv2.exception;

public class TooLowEnergyException extends Exception {

    private static final String MESSAGE = "Not enough energy to make a movement. Current: %d. Required: %d";

    public TooLowEnergyException(int currentEnergyLevel, int requiredEnergyLevel) {
        super(String.format(MESSAGE, currentEnergyLevel, requiredEnergyLevel));
    }
}
