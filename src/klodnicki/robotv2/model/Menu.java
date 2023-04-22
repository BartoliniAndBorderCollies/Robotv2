package klodnicki.robotv2.model;

import klodnicki.robotv2.command.MenuCommand;

public class Menu {
    private MenuCommand[] menuCommands;

    public Menu(MenuCommand[] menuCommands) {
        this.menuCommands = menuCommands;
    }

    public void pressButton(int number) {
        // walidacja number
        menuCommands[number - 1].execute();
    }

    public MenuCommand[] getMenuCommands() {
        return menuCommands;
    }

    public void welcome() {
        System.out.println("""
                Welcome to Robot command center.
                    What do you want to do? Type the answer:
                """);
    }

}




