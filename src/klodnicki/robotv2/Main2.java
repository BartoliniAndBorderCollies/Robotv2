package klodnicki.robotv2;

import klodnicki.robotv2.command.*;
import klodnicki.robotv2.controller.ChargerController;
import klodnicki.robotv2.controller.MenuController;
import klodnicki.robotv2.controller.RobotController;
import klodnicki.robotv2.model.Menu;
import klodnicki.robotv2.service.ChargerService;
import klodnicki.robotv2.service.RobotService;
import klodnicki.robotv2.view.GUI;
import klodnicki.robotv2.view.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2 implements ActionListener {

//    private static JTextField textField;
//    private static JTextField passwordField;
//
//    private static JLabel successLabel;
    public static void main(String[] args) {

        GUI gui = new GUI();
        gui.showLogin();

        Database database = new Database();
        RobotService robotService = new RobotService(database);
        ChargerService chargerService = new ChargerService(database, robotService);
        TurnCounter turnCounter = new TurnCounter();
        RobotController robotController = new RobotController(robotService, turnCounter);
        ChargerController chargerController = new ChargerController(chargerService, robotController, turnCounter);

        MenuCommand[] mainMenuCommands = {

                new CreateRobot(robotController, chargerController),
                new CreateCharger(chargerController),
                new TurnOnTheRobot(robotController, chargerController),
                new TurnOffTheRobot(robotController, chargerController),
                new PlugInRobot(chargerController),
                new UnplugRobot(chargerController),
                new GetListOfRobotsAndTheirEnergy(robotController),
                new MoveRobot(robotController, chargerController),
                new SkipTurn(chargerController, turnCounter),
                new CloseApplication(),
        };
        Menu mainMenu = new Menu(mainMenuCommands);
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(mainMenu, menuView, turnCounter);

        menuView.welcome();

        do {
            menuController.updateMenuView();
            menuController.askUserForInput();

        } while (true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//        String user = textField.getText();
//        String password = passwordField.getText();
//
//        if(user.equals("lala") && password.equals("password")) {
//            successLabel.setText("Login successful.");
//        }

    }
}
