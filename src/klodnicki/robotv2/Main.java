package klodnicki.robotv2;

import klodnicki.robotv2.exception.NotEnoughFreeEnergySlotsException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final String ROBOT_NOT_FOUND_MESSAGE = "Robot has not been found.";

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


            screenPrinter.showMenu(turnCounter);

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
                    System.out.println("Give name to the charger.");
                    String chargerName = scanner.nextLine();
                    boolean nameAlreadyExist = false;

                    for (int i = 0; i < chargers.size(); i++) {
                        if (chargerName.equals(chargers.get(i).getName())) {
                            nameAlreadyExist = true;
                            System.out.println("This name already exist.");
                            break;
                        }
                    }
                    if (nameAlreadyExist) {
                        break;
                    }

                    int slotsAmount;
                    System.out.println("How many AC power plugs and sockets you want to have in your charger?");

                    try {
                        slotsAmount = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Answer must be a number.");
                        scanner.nextLine();
                        break;
                    }
                    if (slotsAmount <= 0) {
                        System.out.println("Answer must be a positive number.");
                        break;
                    }

                    Charger createdCharger = new Charger(slotsAmount, chargerName);
                    chargers.add(createdCharger);
                    System.out.println("Charger has been created.");
                }
                // 2. włączyć robota
                // robot jak jest już włączony to walidacja, że przecież jest już włączony
                // jeśli robot jest wyłączony to zmienia status na włączony - komunikat dla użytkownika

                case 3 -> {
                    // wyświetl komuniakt
                    // Pobranie wartości od usera
                    String robotName = getUserInput(scanner, "Give the name of the robot which you want to turn on.");

                    // Znalezienie robota na liście
                    Robot robot = findRobot(robots, robotName);

                    // sprawdzenie czy robot został znaleziony
                    if (isRobotIsNull(robot)) break;

                    //sprawdzenie czy robot nie znajduje się na liscie podłączonych do ładowania robotów.

                    boolean isRobotOnTheChargersList = false;

                    for (int i = 0; i < chargers.size(); i++) {

                        if (chargers.get(i).getPluggedRobots().contains(robot)) {
                            isRobotOnTheChargersList = true;
                            break;
                        }
                    }
                    if (isRobotOnTheChargersList) {
                        System.out.println("Unplug robot from the charger first.");
                        break;
                    }
                    // logika gdy robot został znaleziony
                    robot.turnOn();
                    System.out.println("Robot has been turned on.");
                }

                // 3. wyłączyć robota
                // jeśli robot jest już wyłączony to powiadomić, że przecież jest wyłączony
                // jeśli robot jest włączony to zmienia status na wyłączony - komunikat dla użytkownika

                case 4 -> {
                    String robotName = getUserInput(scanner, "Give the name of the robot which you want to turn off?");

                    Robot robot = findRobot(robots, robotName);
                    if (isRobotIsNull(robot)) break;

                    robot.turnOff();
                    System.out.println("Robot has been turned off. ");
                }

                //4.podłącz ładowarkę.
                // jeśli robot jest włączony informacja, żeby go wyłączyć
                // jeśli robot jest wyłączony to informacja, żeby najpierw stworzyć ładowarkę
                // jeśli robot jest wyłączony i ma ładowarkę to zacząć ładować - powiadomić użytkownika

                case 5 -> {
                    if (isAnyChargerCreated(chargers)) break;

                    int userInput;
                    System.out.println("Which charger you want to choose to plug robot in?");

                    showListOfChargers(chargers);

                    // pobranie inputu INTEGER
//                    int x = getUserIntInput(scanner);

                    try {
                        userInput = scanner.nextInt();
                    } catch (InputMismatchException | IndexOutOfBoundsException e) {
                        System.out.println("Must be a number.");
                        break;
                    } finally {
                        scanner.nextLine();
                    }

                    if (userInputExceedTheListBounds(chargers, userInput)) break;

                    Charger charger = chargers.get(userInput);

                    String robotName = getUserInput(scanner, "Which robot you want to connect to charger?");

                    for (int i = 0; i < robots.size(); i++) {
                        if (robots.get(i).getName().equals(robotName)) {
                            if (robots.get(i).isOn()) {
                                System.out.println("Turn off the robot first.");
                                break;
                            }
                            try {
                                charger.plugInRobot(robots.get(i));
                            } catch (NotEnoughFreeEnergySlotsException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("Robot " + robotName + " has been plugged in. ");
                            break;

                        }
                    }
                    //TODO: if robot is not found show the message: This robot does not exist.


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
                    if (isAnyChargerCreated(chargers)) break;

                    int userInput;

                    System.out.println("Which charger you want to choose to unplug robot?");
                    showListOfChargers(chargers);

                    try {
                        userInput = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Must be a number.");
                        scanner.nextLine();
                        break;
                    }
                    if (userInputExceedTheListBounds(chargers, userInput)) break;

                    Charger charger = chargers.get(userInput);

                    scanner.nextLine();

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

                case 7 -> {
                    if (robots.isEmpty()) {
                        System.out.println("The list of robots is empty.");
                        break;
                    }

                    System.out.println("List of robots and energy level.");
                    for (int i = 0; i < robots.size(); i++) {
                        System.out.println(i + ". " + robots.get(i).getName() + " " + robots.get(i).getEnergyLevel() + "%.");
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

                case 8 -> {
                    String robotName = getUserInput(scanner, "Enter the name of robot which you want to move: ");
                    Robot robot = findRobot(robots, robotName);
                    if (isRobotIsNull(robot)) break;
                    if (!robot.isOn()) {
                        System.out.println("Turn robot on first.");
                        break;
                    }

                    screenPrinter.showCommands();
                    String command = scanner.nextLine();
                    boolean foundCommand = false;

                    for (RobotMovement robotMovement : RobotMovement.values()) {
                        if (robotMovement.getName().equals(command)) {
                            try {
                                robot.move(robotMovement);
                                foundCommand = true;
                            } catch (TooLowEnergyException | RobotNotTurnedOnException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    if (foundCommand) {
                        break;
                    }
                    System.out.println("Unknown command.");
                }
                //7. skip the turn
                // jeśli robot nie jest podłączony do ładowarki - nic się nie dzieje, zwykły komunikat next turn
                case 9 -> screenPrinter.printSkipTurn();


                //8/ zamknięcie aplikacji
                // wyjście z pętli i krótki komunikat, że program jest zamykany.

                case 10 -> {
                    System.out.println("Program is closing. ");
                    repeat = false;
                }
            }
            //tutaj trzeba stworzyć ładowanie robotów wszystkich które są w worku z podłączonymi ładowarkami
            for (int i = 0; i < chargers.size(); i++) {
                chargers.get(i).chargeRobots();
            }
            if(response != 5 && response != 6 && response != 7) {
                turnCounter.count();
            }
        } while (repeat);
    }

    private static boolean isAnyChargerCreated(List<Charger> chargers) {
        if (chargers.isEmpty()) {
            System.out.println("There is no any charger on the list.");
            return true;
        }
        return false;
    }

    private static void showListOfChargers(List<Charger> chargers) {
        for (int i = 0; i < chargers.size(); i++) {
            System.out.println(i + ". " + chargers.get(i).toString());
        }
    }

    private static boolean isRobotIsNull(Robot robot) {
        if (robot == null) {
            System.out.println(ROBOT_NOT_FOUND_MESSAGE);
            return true;
        }
        return false;
    }

    private static boolean userInputExceedTheListBounds(List<Charger> chargers, int userInput) {
        if (userInput > chargers.size() - 1 || userInput < 0) {
            System.out.println("You typed an invalid number.");
            return true;
        }
        return false;
    }

    private static Integer getUserIntInput(Scanner scanner) { //TODO: correct method
        Integer userInput;
        try {
            return userInput = scanner.nextInt();
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.println("Must be a number.");
        } finally {
            scanner.nextLine();
        }
        return null;
    }

    private static Robot findRobot(List<Robot> robots, String robotName) {
        Robot robot = null;

        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i).getName().equals(robotName)) {
                robot = robots.get(i);
                break;
            }
        }
        return robot;
    }

    private static String getUserInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}