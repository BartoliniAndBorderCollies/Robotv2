package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.ChargerController;

public class UnplugRobot implements MenuCommand{

    private final ChargerController chargerController;

    public UnplugRobot(ChargerController chargerController) {
        this.chargerController = chargerController;
    }

    @Override
    public String getName() {
        return "Unplug robot";
    }

    @Override
    public void execute() {
        chargerController.unplug();
    }
}
