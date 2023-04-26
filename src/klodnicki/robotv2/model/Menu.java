package klodnicki.robotv2.model;

import klodnicki.robotv2.command.MenuCommand;

public class Menu {
    private final MenuCommand[] menuCommands;

    public Menu(MenuCommand[] menuCommands) {
        this.menuCommands = menuCommands;
    }

    public void pressButton(int number) {
        if(number > menuCommands.length || number <= 0) {
            System.out.println("Number must be in the range of menu.");
            return;
        }
        menuCommands[number - 1].execute();
    }

    public MenuCommand[] getMenuCommands() {
        return menuCommands;
    }
}




