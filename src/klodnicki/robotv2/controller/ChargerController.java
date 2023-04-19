package klodnicki.robotv2.controller;

import klodnicki.robotv2.service.ChargerService;
import klodnicki.robotv2.service.RobotService;

import java.util.Scanner;

public class ChargerController {
        private ChargerService chargerService = new ChargerService();

    public void createCharger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many energy plugs you want to create? Give the charger name.");
        chargerService.create(scanner.nextInt(), scanner.nextLine());
    }
}
