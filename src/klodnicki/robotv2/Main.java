package klodnicki.robotv2;

import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        List<Robot> robots = new ArrayList<>();
        List<Charger> chargers = new ArrayList<>();

        TurnCounter turnCounter = new TurnCounter();
        ScreenPrinter screenPrinter = new ScreenPrinter();
        Scanner scanner = new Scanner(System.in);

        int response = 0;
        boolean repeat = true;

        // 0. każda tura jest liczona - jest licznik który informuje która to tura
        // każda tura ładuje robota jeśli jest podłączony do ładowania

        do {
            // POCZĄTEK PĘTLI
            // Nr tury
            // przywitanie i krótkie menu co można wykonać

            turnCounter.count();
            screenPrinter.showMenu();

            // użytkownik wydaje komendy

            try {
                response = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Number must be an integer.");
            }
            scanner.nextLine();

            // 0. stworzenie robota
            // użytkownik nadaje imię robotowi.

            switch (response) {
                case 1 -> {

                    System.out.println("Give name to the robot.");
                    String robotName = scanner.nextLine();
                    boolean nameAlreadyExist = false;

                    for (int i = 0; i < robots.size(); i++) {
                        if (robotName.equals(robots.get(i).getName())) {
                            nameAlreadyExist = true;
                            System.out.println("This name already exist.");
                            break;
                        }
                    }
                    if (nameAlreadyExist) {
                        break;
                    }

                    Robot robot = new Robot(robotName);
                    robots.add(robot);
                    System.out.println("Robot " + robotName + " has been created.");
                }
                //1. stworzyć ładowarkę
                // stworzenie ładowarki poprzez new Charger();
                //każda nowo powstała ładowarka ma 3 wolne sloty
                // dodanie łądowarki do listy ładowarek
                // jesli ładowarka nie jest stworzona to ją stworzyć - komunikat dla użytkownika

                case 2 -> {

                    System.out.println("How many AC power plugs and sockets you want to have in your charger?");
                    int slotsAmount = scanner.nextInt();
                    Charger createdCharger = new Charger(slotsAmount);
                    chargers.add(createdCharger);
                    System.out.println("Charger has been created.");

                }
                // 2. włączyć robota
                // robot jak jest już włączony to walidacja, że przecież jest już włączony
                // jeśli robot jest wyłączony to zmienia status na włączony - komunikat dla użytkownika

                case 3 -> {
                    System.out.println("Give the name of the robot which you want to turn on.");
                    String robotName = scanner.nextLine();

                    for (int i = 0; i < robots.size(); i++) {
                        if (robots.get(i).getName().equals(robotName)) {
                            robots.get(i).turnOn();
                            System.out.println(" Robot has been turned on.");
                            break;
                        }
                    }
                }

                // 3. wyłączyć robota
                // jeśli robot jest już wyłączony to powiadomić, że przecież jest wyłączony
                // jeśli robot jest włączony to zmienia status na wyłączony - komunikat dla użytkownika
                case 4 -> {
                    System.out.println("Give the name of the robot which you want to turn off?");
                    String robotName = scanner.nextLine();

                    for (int i = 0; i < robots.size(); i++) {
                        if (robots.get(i).getName().equals(robotName)) {
                            robots.get(i).turnOff();
                            System.out.println("Robot has been turned off. ");
                            break;
                        }
                    }
                }
                //4.podłącz ładowarkę.
                // jeśli robot jest włączony informacja, żeby go wyłączyć
                // jeśli robot jest wyłączony to informacja, żeby najpierw stworzyć ładowarkę
                // jeśli robot jest wyłączony i ma ładowarkę to zacząć ładować - powiadomić użytkownika

                case 5 -> {
                    System.out.println("Which charger you want to choose to plug robot in?");
                    for (int i = 0; i < chargers.size(); i++) {
                        System.out.println(i + ". " + chargers.get(i));
                    }
                    int userInput = scanner.nextInt();
                    Charger charger = chargers.get(userInput);

                    System.out.println("Which robot you want to connect to charger?");
                    String robotName = scanner.nextLine();
                    for (int i = 0; i < robots.size(); i++) {
                        if (robots.get(i).getName().equals(robotName)) {
                            try {
                                charger.plugInRobot(robots.get(i));
                            } catch (NotEnoughFreeEnergySlotsException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("Robot " + robotName + " has been plugged in. ");
                            break;
                        }
                    }

                    // znalezienie robota z listy robotów - for loop
                    // podłączenie znalezionego robota do ładowarki. metoda plugIn
                    //jeśli slots>robots.size() to true, dodaj robota
                    // jeśli nie ma wolnych slotów to nie można podłączyć robota do ładowarki
                    // jeśli jest wolny slot to dodanie robota do listy podłączonych robotów do ładowarki
                    // jeśli został podłączony do zaczyna działac metoda chargeRobot
                }

                //5. odłącz robota od ładowarki
                // wybór robota przez użytkownika
                // jeśli robot jest już odłączony to komunikat, że przecież jest odłączony
                // jeśli robot jest podłączony to go odłączyć - komunikat dla użytkownika
                // zaprzestać ładować co tura

                case 6 -> {

                    System.out.println("Which charger you want to choose to unplug robot?");
                    for (int i = 0; i < chargers.size(); i++) {
                        System.out.println(i + ". " + chargers.get(i));
                    }
                    int userInput = scanner.nextInt();
                    Charger charger = chargers.get(userInput);

                    System.out.println("Which robot you want to disconnect from charger?");
                    String robotName = scanner.nextLine();
                    for (int i = 0; i < robots.size(); i++) {
                        if (robots.get(i).getName().equals(robotName)) {
                            charger.unplugRobot(robots.get(i));
                            System.out.println("Robot " + robotName + " has been unplugged.");
                            break;
                        }
                    }
                }

                //poczatek petli
                // pytam uzytkonika jakiego robota chce poruszyc
                //uzytkownik podaje imie robota
                // for loop szuka czy taki jest
                // jesli jest sprawdza czy jest turn on
                // jesli jest turn on przechodzę do ruchów
                // jesli nie ma to komunikat sorry ale robot ktory wpisales nie jest w worku, upewnij sie czy podal
                //es dobra nazwe robota
                // znalazl takiego robota, konsola teraz pyta co uzytkownik chce poruszyc
                // lista mozliwych ruchow + mozliwosc powrotu do menu głownego jesli uzytkownik jednak nie chce ruszyc
                // input usera
                // sprawdzenie czy komenda jest zrozumiała
                // sprawdzanie poziomu baterii robota
                // wykonanie ruchu jesli poziom baterii odpowiada
                // brak ruchu jesli zbyt malo energy i komunikat sorry naładuj go
                //sprawdzenie poziomu baterii po ruchu.
                //jesli osiagnal poziom ponizej 5% robot turn off.
                //koniec petli

                case 7 -> {
                    System.out.println("Enter the name of robot which you want to move: ");
                    String robotName = scanner.nextLine();
                    Robot robot = null;

                    for (int i = 0; i < robots.size(); i++) {
                        if (robots.get(i).getName().equals(robotName)) {
                            robot = robots.get(i);
                            break;
                        }
                    }
                    if (robot == null) {
                        System.out.println("Robot has not been found. ");
                        break;
                    }

                    screenPrinter.showCommands();
                    String command = scanner.nextLine();
                    //TODO: jesli command nie jest RobotMovement.values

                    for (RobotMovement robotMovement : RobotMovement.values()) {
                        if (robotMovement.getName().equals(command)) {
                            try {
                                robot.move(robotMovement);
                            } catch (TooLowEnergyException | RobotNotTurnedOnException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                //7. skip the turn
                // jeśli robot nie jest podłączony do ładowarki - nic się nie dzieje, zwykły komunikat next turn
                case 8 -> turnCounter.skipTurn();

                //8/ zamknięcie aplikacji
                // wyjście z pętli i krótki komunikat, że program jest zamykany.

                case 9 -> {
                    System.out.println("Program is closing. ");
                    repeat = false;
                }
            }
            //tutaj trzeba stworzyć ładowanie robotów wszystkich które są w worku z podłączonymi ładowarkami
            for (int i = 0; i < chargers.size(); i++) {
                chargers.get(i).chargeRobots();
            }
        } while (repeat);
    }
}