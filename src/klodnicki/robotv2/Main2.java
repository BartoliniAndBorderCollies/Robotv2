package klodnicki.robotv2;

import klodnicki.robotv2.command.*;
import klodnicki.robotv2.controller.ChargerController;
import klodnicki.robotv2.controller.MenuController;
import klodnicki.robotv2.controller.RobotController;
import klodnicki.robotv2.model.Menu;
import klodnicki.robotv2.service.ChargerService;
import klodnicki.robotv2.service.RobotService;
import klodnicki.robotv2.view.MenuView;

public class Main2 {
    public static void main(String[] args) {

        Database database = new Database();
        RobotService robotService = new RobotService(database);
        ChargerService chargerService = new ChargerService(database, robotService);
        TurnCounter turnCounter = new TurnCounter();
        RobotController robotController = new RobotController(robotService);
        ChargerController chargerController = new ChargerController(chargerService, robotController);


        MenuCommand[] mainMenuCommands = {

                new CreateRobot(robotController, chargerController),
                new CreateCharger(chargerController),
                new TurnOnTheRobot(robotController, chargerController),
                new TurnOffTheRobot(robotController, chargerController),
                new PlugInRobot(chargerController),
                new UnplugRobot(chargerController),
                new GetListOfRobotsAndTheirEnergy(robotController),
                new MoveRobot(robotController, chargerController),
                new SkipTurn(chargerController),
                new CloseApplication(),
        };
        Menu mainMenu = new Menu(mainMenuCommands);
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(mainMenu, menuView);

        menuView.welcome();

        do {
            menuController.updateMenuView();
            menuController.askUserForInput();

        } while (true);
    }
}
