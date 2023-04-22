package klodnicki.robotv2.controller;

import klodnicki.robotv2.service.ChargerService;

import java.util.Scanner;

public class ChargerController {
    private final ChargerService chargerService;

    public ChargerController(ChargerService chargerService) {
        this.chargerService = chargerService;
    }

    public void createCharger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many energy plugs you want to create? Give the charger name.");//TODO: split into 2
        chargerService.create(scanner.nextInt(), scanner.nextLine());
    }

    public void plugIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which charger you want to choose to plug robot in?");
        String chargerName = scanner.nextLine();
        System.out.println("Which robot you want to connect to charger?");
        String robotName = scanner.nextLine();
        chargerService.plugIn(chargerName, robotName);
    }

}
