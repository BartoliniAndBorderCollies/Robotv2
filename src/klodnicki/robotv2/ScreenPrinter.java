package klodnicki.robotv2;

public class ScreenPrinter {

    // pokazuje komunikaty uzytkownikowi
    // pewnie bedzie jeszcze jedna komenda: dodaj robota.

    public void showMenu() {

        System.out.println("""
                                
                Hello, welcome to Robot command center.
                                
                What do you want to do? Type the answer:
                1. Create a robot.
                2. Show the list of robots.
                3. Create a charger to be able to recharge battery.
                4. Turn on the robot.
                5. Turn off the robot.
                6. Plug in the robot and start charging.
                7. Unplug the robot from the charger.
                8. Move the robot.
                9. Skip the turn.
                10. Close the application.
                                
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





