package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Main {

    /**
     *
     */
    public Main() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Bildschirm leeren

        Menu menu = new Menu();







        Scanner scanner = new Scanner(System.in);
        List<Person> personenListe = new ArrayList<>(); // Liste fuer Personen
        List<Team> teamListe = new ArrayList<>();
        List<Aufgabe> aufgabenListe = new ArrayList<>();


        boolean weiter = true;

        while (weiter) {
            menu.HauptMenuAusgeben();

            String auswahl = scanner.next();
            scanner.nextLine(); // Leerzeichen nach der Eingabe lesen

            switch (auswahl) {
                case "1":
                    Menu.personenMenu(personenListe, scanner);
                    break;
                case "2":
                    Menu.aufgabenMenu(aufgabenListe, personenListe, scanner);
                    break;
                case "3":
                    Menu.teamMenu(teamListe, personenListe,  scanner, aufgabenListe);
                    break;
                case "4":
                    weiter = menu.beendenDialog(scanner);
                    break;
                default:
                    System.out.println("Ungültige Option.");
            }
        }

        scanner.close();
    }

}
