package klodnicki.robotv2;

import klodnicki.robotv2.command.MenuCommand;

import java.util.List;

public class Menu {
    private MenuCommand[] menuCommands;

    public Menu(MenuCommand[] menuCommands) {
        this.menuCommands = menuCommands;
    }

    public void show() {
        for (int i = 0; i < menuCommands.length; i++) {
            // 1. Create Robot
            // 2. Create charger
            System.out.printf("%d. %s\n", i + 1, menuCommands[i].getName());
        }
    }

    public void pressButton(int number) {
        // walidacja number
        menuCommands[number-1].execute();
    }

    public void welcome(){
        System.out.println("""
                Welcome to Robot command center.
                    What do you want to do? Type the answer:
                """);
    }
    public void showCommands() {
        System.out.println("""
                What movement you want to do? Type the command:
                - step left,
                - step right,
                - left hand,
                - right hand,
                - jump.
                """);
    }



}




