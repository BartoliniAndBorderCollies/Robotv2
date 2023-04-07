package klodnicki.robotv2;

public class ScreenPrinter {

    // pokazuje komunikaty uzytkownikowi
    // pewnie bedzie jeszcze jedna komenda: dodaj robota.

    public void showMenu() {

        System.out.println("""
                                
                Hello, welcome to Robot command center.
                                
                What do you want to do? Type the answer:
                1. Create a robot.
                2. Create a charger to be able to recharge battery.
                3. Turn on the robot.
                4. Turn off the robot.
                5. Plug in the robot and start charging.
                6. Unplug the robot from the charger.
                7. Move the robot.
                8. Skip the turn.
                9. Close the application.
                                
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





