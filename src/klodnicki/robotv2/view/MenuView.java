package klodnicki.robotv2.view;

import klodnicki.robotv2.command.MenuCommand;

public class MenuView {
    public void displayMenu(MenuCommand[] menuCommands) {
        for (int i = 0; i < menuCommands.length; i++) {
            // 1. Create Robot
            // 2. Create charger
            System.out.printf("%d. %s\n", i + 1, menuCommands[i].getName());
        }
    }
}
