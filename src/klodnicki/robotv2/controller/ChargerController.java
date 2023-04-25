package klodnicki.robotv2.controller;

import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;
import klodnicki.robotv2.exception.ObjectNotFoundException;
import klodnicki.robotv2.service.ChargerService;

import java.util.Scanner;

public class ChargerController {
    private final ChargerService chargerService;

    public ChargerController(ChargerService chargerService) {
        this.chargerService = chargerService;
    }

    public void createCharger() {
        Scanner scanner = new Scanner(System.in); //TODO: InputMismatchException - jak pyta ile gniazdek a odpowiadasz stringiem
        System.out.println("How many energy plugs you want to create?");
        int energySlots = scanner.nextInt();
        System.out.println("Give the name for the charger.");
        String chargerName = scanner.nextLine();
        scanner.nextLine();
        chargerService.create(energySlots, chargerName);
        System.out.println("Charger " + chargerName + "has been created."); //TODO: czemu nie wyswietla nazwy chargera?
    }

    public void plugIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which charger you want to choose to plug robot in?");
        String chargerName = scanner.nextLine();
        System.out.println("Which robot you want to connect to charger?");
        String robotName = scanner.nextLine();
        try {
            chargerService.plugIn(chargerName, robotName);
            System.out.println("Robot" + robotName + "has been plugged in.");
        }catch (ObjectNotFoundException | NotEnoughFreeEnergySlotsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void unplug() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which charger you want to choose to unplug robot?");
        String chargerName = scanner.nextLine();
        System.out.println("Which robot you want to unplug from the charger?");
        String robotName = scanner.nextLine();
        try {
            chargerService.unplug(chargerName, robotName);
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
