
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        List<Robot> robots = new ArrayList<>();
        TurnCounter turnCounter = new TurnCounter();
        Charger charger;
        ScreenPrinter screenPrinter = new ScreenPrinter();
        Scanner scanner = new Scanner(System.in);

        int response;

        // 0. każda tura jest liczona - jest licznik który informuje która to tura
        // każda tura ładuje robota jeśli jest podłączony do ładowania

        do {
            // POCZĄTEK PĘTLI
            // Nr tury
            // przywitanie i krótkie menu co można wykonać

            turnCounter.count();
            charger.chargeRobot();
            screenPrinter.showMenu();

            // użytkownik wydaje komendy
            // 0. stworzenie robota
            // użytkownik nadaje imię robotowi.

            scanner.nextLine();
            response = scanner.nextInt();

            switch (response) {
                case 0 -> {
                    System.out.println("Give name to the robot.");
                    String robotName = scanner.nextLine();
                    Robot robot = new Robot(robotName);
                    robots.add(robot);
                    System.out.println("Robot " + robotName + " has been created.");


                }


            }


        } while (true);


//        1. włączyć robota
        // robot jak jest już włączony to walidacja, że przecież jest już włączony
        // jeśli robot jest wyłączony to zmienia status na włączony - komunikat dla użytkownika


        // 2. wyłączyć robota
        // jeśli robot jest już wyłączony to powiadomić, że przecież jest wyłączony
        // jeśli robot jest włączony to zmienia status na wyłączony - komunikat dla użytkownika

        //3. stworzyć ładowarkę
        // stworzenie ładowarki poprzez new Charger();
        // jeśli ładowarka jest już stworzona to powiadomić, że przecież istnieje
        // jesli ładowarka nie jest stworzona to ją stworzyć - komunikat dla użytkownika

        //4.podłącz ładowarkę.
        // jeśli robot jest włączony informacja, żeby go wyłączyć
        // jeśli robot jest wyłączony to informacja, żeby najpierw stworzyć ładowarkę
        // jeśli robot jest wyłączony i ma ładowarkę to zacząć ładować - powiadomić użytkownika

        //5. odłącz robota od ładowarki
        // jeśli robot jest już odłączony to komunikat, że przecież jest odłączony
        // jeśli robot jest podłączony to go odłączyć - komunikat dla użytkownika
        // zaprzestać ładować co tura

        //6. poruszyć robota
        // można poruszyć robota jak jest włączony
        // jak jest wyłączony powiadomić, że musi być włączony
        // jesli jest włączony przechodzimy do kolejnego menu z wyborem co ma robić
        // każdy ruch zabiera energię
        // gdy dojdzie do zera wyłączyć robota
        // powiadomić o niskim stanie energii
        // jeśli ma zbyt małą ilosć energii to powiadomić, że nie może tego uczynić bo energy level too low.
        // możliwośc zaniechania ruchu i powrotu do menu głównego
        // powiadomienie gdy komenda użytkownika jest niezrozumiała

        //7. skip the turn
        // jeśli robot jest podłączony do ładowarki - przybywa mu poziom energii
        // jeśli robot nie jest podłączony do ładowarki - nic się nie dzieje, zwykły komunikat next turn

        //8/ zamknięcie aplikacji
        // wyjście z pętli i krótki komunikat, że program jest zamykany.

        //KONIEC PĘTLI


    }
}