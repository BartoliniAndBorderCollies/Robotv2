package klodnicki.robotv2;

import klodnicki.robotv2.command.*;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        // DESIGN PATTERN COMMAND
        Workshop workshop = new Workshop();


        MenuCommand[] mainMenuCommands = {
                // new RobotRelatedCommands()
                new CreateRobot(),
                new CreateCharger(),
                new TurnOnTheRobot(),
                new TurnOffTheRobot(),
                new PlugInRobot(),
                new UnplugRobot(),
                new GetListOfRobots(workshop),
                new MoveRobot(),
                new SkipTurn(),
                new CloseApplication(),
        };

        boolean repeat = true;
        Scanner userInput = new Scanner(System.in);
        Menu mainMenu = new Menu(mainMenuCommands);
        TurnCounter turnCounter = new TurnCounter();


        do {
            turnCounter.count();
            System.out.println("Turn: " + turnCounter.getTurn());
            mainMenu.welcome();
            mainMenu.show();
            mainMenu.pressButton(userInput.nextInt()); //TODO: ArrayIndexOutOfBoundsException | InputMismatchException

        } while (repeat);

    }

}
