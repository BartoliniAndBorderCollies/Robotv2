package klodnicki.robotv2.exception;

import java.security.MessageDigest;

public class MaximumEnergyLevelException extends Exception{

    private static final String MESSAGE = "Maximum energy level of robot %s is 100%.";


    public MaximumEnergyLevelException(String name) {
        super(String.format(MESSAGE, name)); //TODO: czemu malformed?

    }
}
