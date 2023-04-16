package klodnicki.robotv2;

import klodnicki.robotv2.command.*;
import klodnicki.robotv2.controller.MenuController;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        MenuController menuController = new MenuController();
        boolean repeat = true;

        do {

            menuController.showMainMenu();

        } while(repeat);




    }

}
