package klodnicki.robotv2;

import klodnicki.robotv2.command.*;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        // DESIGN PATTERN COMMAND

        MenuCommand[] mainMenuCommands = {
                // new RobotRelatedCommands()
                new CreateRobot(),
                new CreateCharger(),
                new TurnOnTheRobot(),
                new TurnOffTheRobot(),
                new PlugInRobot(),
                new UnplugRobot(),
                new GetListOfRobots(),
                new MoveRobot(),
                new SkipTurn(),
                new CloseApplication(),

        };

        Menu mainMenu = new Menu(mainMenuCommands);
        Scanner scanner = new Scanner(System.in);

        mainMenu.show();
        mainMenu.pressButton(scanner.nextInt());

    }
}
