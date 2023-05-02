package klodnicki.robotv2.controller;

import klodnicki.robotv2.model.Menu;
import klodnicki.robotv2.view.MenuView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {

    private final Menu menu;
    private final MenuView menuView;

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
            System.out.println("Answer must be an integer number.");
        }
        menu.pressButton(input);
    }
}
