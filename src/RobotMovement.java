public enum RobotMovement {
    STEP_LEFT(20, "step left"),
    STEP_RIGHT(20, "step right"),
    LEFT_HANDE(10, "left hand"),
    RIGHT_HAND(10, "right hand"),
    JUMP(35, "jump");

    private final int moveCost;
    private final String name;


    RobotMovement(int moveCost, String name) {
        this.moveCost = moveCost;
        this.name = name;
    }

    public int getMoveCost() {
        return moveCost;
    }
}
