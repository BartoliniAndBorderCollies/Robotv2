package klodnicki.robotv2.controller;

import klodnicki.robotv2.Menu;
import klodnicki.robotv2.Workshop;
import klodnicki.robotv2.command.*;
import klodnicki.robotv2.service.ChargerService;
import klodnicki.robotv2.service.RobotService;

import java.util.Scanner;

public class MenuController {

    private RobotService robotService;
    private ChargerService chargerService;

    Scanner scanner = new Scanner(System.in);
    Workshop workshop = new Workshop();


    MenuCommand[] mainMenuCommands = {
            // new RobotRelatedCommands()

            new CreateRobot(),
            new CreateCharger(),
            new TurnOnTheRobot(workshop, scanner),
            new TurnOffTheRobot(),
            new PlugInRobot(),
            new UnplugRobot(),
            new GetListOfRobots(workshop),
            new MoveRobot(),
            new SkipTurn(),
            new CloseApplication(),
    };

    public void showMainMenu() {
        Menu mainMenu = new Menu(mainMenuCommands);
        mainMenu.welcome();
        mainMenu.show();
        mainMenu.pressButton(scanner.nextInt()); //TODO: ArrayIndexOutOfBoundsException | InputMismatchException
    }

}
