package klodnicki.robotv2.command;

import klodnicki.robotv2.TurnCounter;
import klodnicki.robotv2.controller.ChargerController;

public class SkipTurn implements MenuCommand{

    private final ChargerController chargerController;
    private final TurnCounter turnCounter;

    public SkipTurn(ChargerController chargerController, TurnCounter turnCounter) {
        this.chargerController = chargerController;
        this.turnCounter = turnCounter;
    }

    @Override
    public String getName() {
        return "Skip turn";
    }

    @Override
    public void execute() {
        System.out.println("Next turn is beginning.");
        turnCounter.count();
        chargerController.chargeRobots();
    }
}
