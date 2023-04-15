package klodnicki.robotv2.command;

import klodnicki.robotv2.TurnCounter;

public class SkipTurn implements MenuCommand{

    @Override
    public String getName() {
        return "Skip turn";
    }

    @Override
    public void execute() {
        System.out.println("Next turn is beginning.");
    }
}
