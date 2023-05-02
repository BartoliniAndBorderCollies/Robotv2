package klodnicki.robotv2.exception;

public class MaximumEnergyLevelException extends Exception{

    private static final String MESSAGE = "Maximum energy level of robot %s is 100 percentages.";

    public MaximumEnergyLevelException(String name) {
        super(String.format(MESSAGE, name));
    }
}
