package klodnicki.robotv2.command;

import klodnicki.robotv2.TurnCounter;
import klodnicki.robotv2.controller.ChargerController;

public class SkipTurn implements MenuCommand{

    private final ChargerController chargerController;

    public SkipTurn(ChargerController chargerController) {
        this.chargerController = chargerController;
    }

    @Override
    public String getName() {
        return "Skip turn";
    }

    @Override
    public void execute() {
        System.out.println("Next turn is beginning.");
        TurnCounter.count();
        chargerController.chargeRobots();
    }
}
