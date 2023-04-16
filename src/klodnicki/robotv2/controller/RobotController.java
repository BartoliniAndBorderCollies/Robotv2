package klodnicki.robotv2.controller;

import java.util.Scanner;

public class RobotController {

    private Scanner scanner = new Scanner(System.in);


    public String getRobotNameFromTheUser() {
        System.out.println("What name you want to give to the robot?");
        return scanner.nextLine();
    }







}
