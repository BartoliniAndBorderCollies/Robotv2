package klodnicki.robotv2.command;

import klodnicki.robotv2.model.Robot;
import klodnicki.robotv2.Workshop;

import java.util.List;
import java.util.Scanner;

public class TurnOnTheRobot implements MenuCommand {

    private Workshop workshop;
    private Scanner scanner;
    private List<Robot> robots;

    public TurnOnTheRobot(Workshop workshop, Scanner scanner) {
        this.workshop = workshop;
        this.scanner = scanner;

    }

    @Override
    public String getName() {
        return "Turn on the robot";
    }

    @Override
    public void execute() {

    }
}
