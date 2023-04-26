package klodnicki.robotv2.controller;

import klodnicki.robotv2.model.Menu;
import klodnicki.robotv2.view.MenuView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {

    // Na pewno potrzeba:
    private final Menu menu;
    private final MenuView menuView;

//    private RobotService robotService = new RobotService();
//    private RobotController robotController = new RobotController();
//    private Scanner scanner = new Scanner(System.in);
//    private Workshop workshop = new Workshop();
//    private List<Robot> robots = new ArrayList<>();
////    private Robot robot = new Robot(name);
//    private ChargerService chargerService = new ChargerService(robot);

    public MenuController(Menu menu, MenuView menuView) {
        this.menu = menu;
        this.menuView = menuView;
    }

    public void updateMenuView() {
        menuView.displayMenu(menu.getMenuCommands());
    }

    public void askUserForInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose command:");
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Answer must be a number.");
        }
        menu.pressButton(input);

    }
}
