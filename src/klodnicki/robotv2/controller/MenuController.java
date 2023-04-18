package klodnicki.robotv2.controller;

import klodnicki.robotv2.Menu;
import klodnicki.robotv2.Workshop;
import klodnicki.robotv2.command.*;
import klodnicki.robotv2.model.Robot;
import klodnicki.robotv2.service.ChargerService;
import klodnicki.robotv2.service.RobotService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private String name;

    private RobotService robotService = new RobotService();
    private RobotController robotController = new RobotController();
    private Scanner scanner = new Scanner(System.in);
    private Workshop workshop = new Workshop();
    private List<Robot> robots = new ArrayList<>();
    private Robot robot = new Robot(name);
    private ChargerService chargerService = new ChargerService(robot);


    MenuCommand[] mainMenuCommands = {
            // new RobotRelatedCommands()

            new CreateRobot(workshop, robotService, robotController),
            new CreateCharger(),
            new TurnOnTheRobot(robots, robot, robotService, robotController, chargerService),
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
