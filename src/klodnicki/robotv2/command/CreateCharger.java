package klodnicki.robotv2.command;

import klodnicki.robotv2.controller.ChargerController;

public class CreateCharger implements MenuCommand {

    private ChargerController chargerController;

    public CreateCharger(ChargerController chargerController) {
        this.chargerController = chargerController;
    }

    @Override
    public String getName() {
        return "Create charger";
    }

    @Override
    public void execute() {
        chargerController.createCharger();
    }
}
