package klodnicki.robotv2.controller;

import klodnicki.robotv2.TurnCounter;
import klodnicki.robotv2.exception.MaximumEnergyLevelException;
import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;
import klodnicki.robotv2.exception.ObjectNotFoundException;
import klodnicki.robotv2.model.Charger;
import klodnicki.robotv2.service.ChargerService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChargerController {
    private final ChargerService chargerService;
    private final RobotController robotController;

    public ChargerController(ChargerService chargerService, RobotController robotController) {
        this.chargerService = chargerService;
        this.robotController = robotController;
    }

    public void createCharger() {
        Scanner scanner = new Scanner(System.in);
        int energySlots = 0;
        System.out.println("How many energy plugs you want to create?");
        try {
            energySlots = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Must be a number.");
            return;
        }
        scanner.nextLine();
        System.out.println("Give the name for the charger.");
        String chargerName = scanner.nextLine();
        chargerService.create(energySlots, chargerName);
        System.out.println("Charger " + chargerName + " has been created.");
        TurnCounter.count();
    }

    public void plugIn() {
        Scanner scanner = new Scanner(System.in);

        for (Charger charger : chargerService.getListOfChargers()) {
            System.out.println(charger.toString());
        }
        if (chargerService.getListOfChargers().isEmpty()) {
            System.out.println("There is no charger on the list.");
            return;
        }

        System.out.println("Which charger you want to choose to plug robot in?");
        String chargerName = scanner.nextLine();

        if (robotController.showListOfRobotsAndEnergyLevel().isEmpty()) {
            return;
        }

        System.out.println("Which robot you want to connect to charger?");
        String robotName = scanner.nextLine();

        if (robotController.isOn(robotName)) {
            System.out.println("Robot must be turned off.");
            return;
        }

        try {
            chargerService.plugIn(chargerName, robotName);
            System.out.println("Robot " + robotName + " has been plugged in.");
            TurnCounter.count();
        } catch (ObjectNotFoundException | NotEnoughFreeEnergySlotsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void unplug() {
        if (chargerService.getListOfChargers().isEmpty()) {
            System.out.println("There is no chargers on the list.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which charger you want to choose to unplug robot?");
        System.out.println(chargerService.getListOfChargers());
        String chargerName = scanner.nextLine();

        try {
            if (chargerService.getPluggedRobots(chargerName).isEmpty()) {
                System.out.println("There is no robot connected to this charger: " + chargerName);
                return;
            }
        } catch (ObjectNotFoundException eee) {
            eee.getMessage();
        }

        System.out.println("Which robot you want to unplug from the charger?");

        try {
            System.out.println((chargerService.getPluggedRobots(chargerName)));
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String robotName = scanner.nextLine();

        try {
            chargerService.unplug(chargerName, robotName);
            System.out.println("Robot" + robotName + " has been unplugged.");
            TurnCounter.count();
        } catch (ObjectNotFoundException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public void chargeRobots() {
        try {
            chargerService.chargeRobots();
        }catch (MaximumEnergyLevelException e) {
            System.out.println(e.getMessage());
        }
    }
}

