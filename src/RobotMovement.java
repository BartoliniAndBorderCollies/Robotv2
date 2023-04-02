public enum RobotMovement {

    LEFT_FOOT(20, "step left", "Robot moved left foot."),
    RIGHT_FOOT(20, "step right", "Robot moved right foot."),
    LEFT_HAND(10, "left hand", "Robot moved left hand."),
    RIGHT_HAND(10, "right hand", "Robot moved right hand."),
    JUMP(35, "jump", "Robot jumped.");

    private final int moveCost;
    private final String name;
    private final String action;

    RobotMovement(int moveCost, String name, String action) {
        this.moveCost = moveCost;
        this.name = name;
        this.action = action;
    }

    public int getMoveCost() {
        return moveCost;
    }

    public String getAction() {
        return action;
    }

    public String getName() {
        return name;
    }
}
