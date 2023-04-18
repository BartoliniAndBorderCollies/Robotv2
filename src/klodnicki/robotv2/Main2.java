package klodnicki.robotv2;

import klodnicki.robotv2.command.*;
import klodnicki.robotv2.controller.MenuController;
import klodnicki.robotv2.controller.RobotController;
import klodnicki.robotv2.model.Menu;
import klodnicki.robotv2.view.MenuView;

public class Main2 {
    public static void main(String[] args) {

        // MVC - Model View Controller -> software architectural pattern
        // Command Pattern -> software design pattern
        // USER -> używa -> CONTROLLER -> przekierowuje zapytanie do -> SERVICE -> bazuje/działa na -> MODEL -> SERVICE zwraca odpowiedź do -> CONTROLLER -> updateuje widok -> VIEW -> pokazuje się -> USER

        // JDBC -> Bazy danych

        MenuCommand[] mainMenuCommands = {
                // new RobotRelatedCommands()

                new CreateRobot(new RobotController()),
                new CreateCharger(),
//                new TurnOnTheRobot(robots, robot, robotService, robotController, chargerService),
                new TurnOffTheRobot(),
                new PlugInRobot(),
                new UnplugRobot(),
//                new GetListOfRobots(workshop),
                new MoveRobot(),
                new SkipTurn(),
                new CloseApplication(),
        };
        Menu mainMenu = new Menu(mainMenuCommands);
        MenuView menuView = new MenuView();
        // stworzenie service
        // przekazanie service
        MenuController menuController = new MenuController(mainMenu, menuView);

        // showWelcome()

        do {
            menuController.updateMenuView();
            menuController.askUserForInput();
            // logika na input
        } while(true);
    }
}
