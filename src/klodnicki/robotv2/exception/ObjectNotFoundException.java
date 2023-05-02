package klodnicki.robotv2.exception;

public class ObjectNotFoundException extends DatabaseException {

    private static final String MESSAGE = "Object of class %s has not been found.";

    public ObjectNotFoundException (Class<?> clazz) {
        super(String.format(MESSAGE, clazz.getName()));
    }
}
