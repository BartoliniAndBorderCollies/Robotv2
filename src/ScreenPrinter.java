public class ScreenPrinter {

    // pokazuje komunikaty uzytkownikowi
    // pewnie bedzie jeszcze jedna komenda: dodaj robota.

    public void showMenu() {

        System.out.println("""
                                
                Hello, welcome to Robot command center.
                
                What do you want to do? Type the answer:
                0. Create the robot.
                1. Turn on the robot.
                2. Turn off the robot.
                3. Create a charger to be able to recharge battery.
                4. Plug in the robot and start charging.
                5. Unplug the robot from the charger.
                6. Move the robot.
                7. Skip the turn.
                8. Close the application.
                                
                """);
    }




}
