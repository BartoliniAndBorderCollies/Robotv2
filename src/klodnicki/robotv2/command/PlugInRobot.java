package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.ChargerController;

public class PlugInRobot implements MenuCommand{

    private final ChargerController chargerController;

    public PlugInRobot(ChargerController chargerController) {
        this.chargerController = chargerController;
    }

    @Override
    public String getName() {
        return "Plug robot";
    }

    @Override
    public void execute() {
        chargerController.plugIn(); //TODO: its not possible to plug robot in. all the time info that robot must be turn off
    }
}
