package klodnicki.robotv2;

import klodnicki.robotv2.command.*;
import klodnicki.robotv2.controller.ChargerController;
import klodnicki.robotv2.controller.MenuController;
import klodnicki.robotv2.controller.RobotController;
import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.model.Menu;
import klodnicki.robotv2.service.ChargerService;
import klodnicki.robotv2.service.RobotService;
import klodnicki.robotv2.view.MenuView;

public class Main2 {
    public static void main(String[] args) {

        // MVC - Model View Controller -> software architectural pattern
        // Command Pattern -> software design pattern
        // USER -> używa -> CONTROLLER -> przekierowuje zapytanie do -> SERVICE -> bazuje/działa na -> MODEL -> SERVICE zwraca odpowiedź do -> CONTROLLER -> updateuje widok -> VIEW -> pokazuje się -> USER

        // JDBC -> Bazy danych
        Database database = new Database();
        RobotService robotService = new RobotService(database);
        ChargerService chargerService = new ChargerService(database, robotService);
        RobotController robotController = new RobotController(robotService);
        ChargerController chargerController = new ChargerController(chargerService, robotController);
        TurnCounter turnCounter = new TurnCounter();


        MenuCommand[] mainMenuCommands = {
                // new RobotRelatedCommands()

                new CreateRobot(robotController),
                new CreateCharger(chargerController),
                new TurnOnTheRobot(robotController),
                new TurnOffTheRobot(robotController),
                new PlugInRobot(chargerController),
                new UnplugRobot(chargerController),
                new GetListOfRobotsAndTheirEnergy(robotController),
                new MoveRobot(robotController),
                new SkipTurn(),
                new CloseApplication(),
        };
        Menu mainMenu = new Menu(mainMenuCommands);
        MenuView menuView = new MenuView();
        // stworzenie service
        // przekazanie service
        MenuController menuController = new MenuController(mainMenu, menuView);

        menuView.welcome();

        do {
            turnCounter.count();
            System.out.println("Turn: " + turnCounter.getTurn());
            menuController.updateMenuView();
            menuController.askUserForInput();

            // logika na input
        } while (true);
    }
}
