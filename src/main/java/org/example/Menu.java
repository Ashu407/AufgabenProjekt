package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Menu {


    /**
     *
     */
    public Menu() {

    }



    public void HauptMenuAusgeben() {

        System.out.println("+--------------------------------------------+");
        System.out.println("| Willkommen beim Aufgabenverwaltungssystem! |");
        System.out.println("| Wählen Sie eine Option aus!                |");
        System.out.println("|                                            |");
        System.out.println("| [1] Personenmenü                           |");
        System.out.println("| [2] Aufgabenmenü                           |");
        System.out.println("| [3] Teammenü                               |");
        System.out.println("| [4] Programm beenden                       |");
        System.out.println("|                                            |");
        System.out.println("+--------------------------------------------+");
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


















    public static void PersonenMenuAusgeben()
    {

        System.out.println("+--------------------------------------------+");
        System.out.println("|                Personenmenü                |");
        System.out.println("|--------------------------------------------|");
        System.out.println("| Wählen Sie eine Option aus!                |");
        System.out.println("|                                            |");
        System.out.println("| [1] Person hinzufügen                      |");
        System.out.println("| [2] Person entfernen                       |");
        System.out.println("| [3] Personen auflisten                     |");
        System.out.println("| [4] zurück zum Hauptmenü                   |");
        System.out.println("|                                            |");
        System.out.println("+--------------------------------------------+");
    }

    public static void personenMenu(List<Person> personenListe, Scanner scanner) {


        boolean personenMenuWeiter = true;

        while (personenMenuWeiter) {

            PersonenMenuAusgeben();

            String personenMenuAuswahl = scanner.next();
            scanner.nextLine(); // Leerzeichen nach der Eingabe lesen

            switch (personenMenuAuswahl) {
                case "1":
                    Menu.personHinzufuegen(personenListe, scanner);
                    break;
                case "2":
                    Menu.personEntfernen(personenListe, scanner);
                    break;
                case "3":
                    Menu.personAuflisten(personenListe);
                    break;
                case "4":
                    personenMenuWeiter = false;
                    break;
                default:
                    System.out.println("Ungültige Option.");
            }
        }
    }




    private static void personHinzufuegen(List<Person> personenListe, Scanner scanner) {
        System.out.println("Geben Sie den Vornamen ein:");
        String vorname = scanner.nextLine();

        System.out.println("Geben Sie den Nachnamen ein:");
        String nachname = scanner.nextLine();

        System.out.println("Geben Sie die E-Mail-Adresse ein:");
        String email = scanner.nextLine();

        Person neuePerson = new Person(vorname, nachname, email);
        personenListe.add(neuePerson);
        System.out.println("\nNeue Person wurde hinzugefügt!");
    }


    private static void personEntfernen(List<Person> personenListe, Scanner scanner) {

        System.out.println("Geben Sie den Vornamen der zu entfernenden Person ein:");
        String vorname = scanner.nextLine();

        System.out.println("Geben Sie den Nachnamen der zu entfernenden Person ein:");
        String nachname = scanner.nextLine();

        Iterator<Person> iterator = personenListe.iterator();
        boolean personGefunden = false;

        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getVorname().equals(vorname) && person.getNachname().equals(nachname)) {
                iterator.remove();
                personGefunden = true;
                System.out.println("Person wurde erfolgreich entfernt!");
                break;
            }
        }

        if (!personGefunden) {
            System.out.println("Person wurde nicht gefunden.");
        }
    }


    private static void personAuflisten(List<Person> personenListe) {
        System.out.println("Liste der Personen:\n");
        for (Person person : personenListe) {
            System.out.println("+--------------------------------------------+");
            System.out.println("Vorname: " + person.getVorname());
            System.out.println("Nachname: " + person.getNachname());
            System.out.println("E-Mail: " + person.getEmail());
            System.out.println("+--------------------------------------------+\n");
        }
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
































    public static void AufgabenMenuAusgeben()
    {

        System.out.println("+--------------------------------------------+");
        System.out.println("|                Aufgabenmenü                |");
        System.out.println("|--------------------------------------------|");
        System.out.println("| Wählen Sie eine Option aus!                |");
        System.out.println("|                                            |");
        System.out.println("| [1] Aufgabe erstellen                      |");
        System.out.println("| [2] Aufgabe entfernen                      |");
        System.out.println("| [3] Aufgaben auflisten                     |");
        System.out.println("| [4] zurück zum Hauptmenü                   |");
        System.out.println("|                                            |");
        System.out.println("+--------------------------------------------+");
    }

    public static void aufgabenMenu(List<Aufgabe> aufgabenListe, List<Person> personenListe, Scanner scanner) {
        boolean aufgabenMenuWeiter = true;

        while (aufgabenMenuWeiter) {
            AufgabenMenuAusgeben();

            String aufgabenMenuAuswahl = scanner.next();
            scanner.nextLine(); // To consume the newline left by nextInt()

            switch (aufgabenMenuAuswahl) {
                case "1":
                    Menu.aufgabeErstellen(aufgabenListe, personenListe, scanner);
                    break;
                case "2":
                    Menu.aufgabeEntfernen(aufgabenListe, scanner);
                    break;
                case "3":
                    Menu.aufgabenAuflisten(aufgabenListe);
                    break;
                case "4":
                    aufgabenMenuWeiter = false;
                    break;
                default:
                    System.out.println("Ungültige Option.");
            }
        }
    }

    private static void aufgabeErstellen(List<Aufgabe> aufgabenListe, List<Person> personenListe, Scanner scanner) {
        System.out.println("Titel der Aufgabe:");
        String titel = scanner.nextLine();

        System.out.println("Beschreibung der Aufgabe:");
        String beschreibung = scanner.nextLine();



        // Assuming Datum is a class you have for handling dates
        Datum fertigBis = getDatumFromUser(scanner);


        Aufgabe neueAufgabe = new Aufgabe(titel, beschreibung, fertigBis);
        aufgabenListe.add(neueAufgabe);
        System.out.println("Aufgabe hinzugefügt!");
    }

    private static Person selectPerson(List<Person> personenListe, Scanner scanner) {
        if (personenListe.isEmpty()) {
            System.out.println("Keine Personen vorhanden.");
            return null;
        }

        System.out.println("Wählen Sie eine Person aus:");
        for (int i = 0; i < personenListe.size(); i++) {
            Person person = personenListe.get(i);
            System.out.println("[" + (i + 1) + "] " + person.getVorname() + " " + person.getNachname());
        }

        int auswahl = scanner.nextInt();
        scanner.nextLine(); // To consume the newline left by nextInt()

        if (auswahl > 0 && auswahl <= personenListe.size()) {
            return personenListe.get(auswahl - 1);
        } else {
            System.out.println("Ungültige Auswahl.");
            return null;
        }
    }

    private static void aufgabeEntfernen(List<Aufgabe> aufgabenListe, Scanner scanner) {
        System.out.println("Titel der zu entfernenden Aufgabe:");
        String titel = scanner.nextLine();

        Aufgabe zuEntfernen = null;
        for (Aufgabe aufgabe : aufgabenListe) {
            if (aufgabe.getTitel().equals(titel)) {
                zuEntfernen = aufgabe;
                break;
            }
        }

        if (zuEntfernen != null) {
            aufgabenListe.remove(zuEntfernen);
            System.out.println("Aufgabe entfernt!");
        } else {
            System.out.println("Aufgabe nicht gefunden.");
        }
    }

    private static void aufgabenAuflisten(List<Aufgabe> aufgabenListe) {
        if (aufgabenListe.isEmpty()) {
            System.out.println("Keine Aufgaben vorhanden.");
            return;
        }

        System.out.println("Liste der Aufgaben:");
        for (Aufgabe aufgabe : aufgabenListe) {
            System.out.println("Titel: " + aufgabe.getTitel());
            System.out.println("Beschreibung: " + aufgabe.getBeschreibung());
            System.out.println("Fertig bis: " + aufgabe.getDatum());
            System.out.println("Abgeschlossen: " + (aufgabe.getAbgeschlossen() ? "Ja" : "Nein"));
            System.out.println();
        }
    }


    private static Datum getDatumFromUser(Scanner scanner) {
        System.out.println("Geben Sie das Datum ein.");

        System.out.print("Tag: ");
        int tag = scanner.nextInt();

        System.out.print("Monat: ");
        int monat = scanner.nextInt();

        System.out.print("Jahr: ");
        int jahr = scanner.nextInt();
        scanner.nextLine(); // To consume the newline left by nextInt()

        return new Datum(tag, monat, jahr);
    }











    public static void TeamMenuAusgeben()
    {

        System.out.println("+--------------------------------------------+");
        System.out.println("|                  Teammenü                  |");
        System.out.println("|--------------------------------------------|");
        System.out.println("| Wählen Sie eine Option aus!                |");
        System.out.println("|                                            |");
        System.out.println("| [1] Team erstellen                         |");
        System.out.println("| [2] Team entfernen                         |");
        System.out.println("| [3] Person zum Team hinzufügen             |");
        System.out.println("| [4] Person aus Team entfernen              |");
        System.out.println("| [5] Teams auflisten                        |");
        System.out.println("| [6] zurück zum Hauptmenü                   |");
        System.out.println("|                                            |");
        System.out.println("+--------------------------------------------+");
    }




    public static void teamMenu(List<Team> teamListe, List<Person> personenListe, Scanner scanner,List<Aufgabe> aufgabenListe ) {

        boolean teamMenuWeiter = true;

        while (teamMenuWeiter) {

            TeamMenuAusgeben();

            String teamMenuAuswahl = scanner.next();
            scanner.nextLine();

            switch (teamMenuAuswahl) {
                case "1":
                    Menu.teamErstellen(teamListe, aufgabenListe, scanner);
                    break;
                case "2":
                    Menu.teamEntfernen(teamListe, scanner);
                    break;
                case "3":
                    Menu.personZuTeamHinzufuegen(teamListe, personenListe, scanner);
                    break;
                case "4":
                    Menu.personAusTeamEntfernen(teamListe, scanner);
                    break;
                case "5":
                    Menu.teamAuflisten(teamListe, aufgabenListe);
                    break;
                case "6":
                    teamMenuWeiter = false;
                    break;
                default:
                    System.out.println("Ungültige Option.");
            }

        }

    }


    private static void teamErstellen(List<Team> teamListe, List<Aufgabe> aufgabenListe, Scanner scanner) {

        System.out.println("Verfügbare Aufgaben:");
        for (int i = 0; i < aufgabenListe.size(); i++) {
            Aufgabe aufgabe = aufgabenListe.get(i);
            System.out.println("[" + (i + 1) + "] " + aufgabe.getTitel());
        }

        System.out.println("Geben Sie den Teamnamen ein:");
        String teamname = scanner.nextLine();

        Team team = new Team(teamname);
        teamListe.add(team);
        System.out.println("\nTeam: " + teamname + " wurde erstellt!");

        // Optional: add logic to associate selected tasks with the team
    }
    private static void teamEntfernen(List<Team> teamListe, Scanner scanner) {
        System.out.println("Geben Sie den Teamnamen des zu entfernenden Teams ein:");
        String teamname = scanner.nextLine();

        Iterator<Team> iterator = teamListe.iterator();
        boolean teamGefunden = false;

        while (iterator.hasNext()) {
            Team team = iterator.next();
            if (team.getName().equals(teamname)) {
                iterator.remove();
                teamGefunden = true;
                System.out.println(teamname + " wurde erfolgreich entfernt!");
                break;
            }
        }

        if (!teamGefunden) {
            System.out.println("Team nicht gefunden.");
        }
    }




    private static void listTeams(List<Team> teamListe) {
        for (int i = 0; i < teamListe.size(); i++) {
            Team team = teamListe.get(i);
            System.out.println("[" + (i + 1) + "] " + team.getName());
        }
    }



    private static void listMitglieder(List<Person> personenListe) {
        for (int i = 0; i < personenListe.size(); i++) {
            Person person = personenListe.get(i);
            System.out.println("[" + (i + 1) + "] " + person.getVorname() + " " + person.getNachname() + ", " + person.getEmail());
        }
    }



    public static void personZuTeamHinzufuegen(List<Team> teamListe, List<Person> personenListe, Scanner scanner) {
        System.out.println("Verfuegbare Teams:");
        listTeams(teamListe);

        System.out.print("Wähle ein Team durch Angabe der Nummer: ");
        int teamAuswahl = scanner.nextInt();
        scanner.nextLine(); // Leerzeichen nach der Eingabe lesen

        if (teamAuswahl > 0 && teamAuswahl <= teamListe.size()) {
            Team ausgewaehltesTeam = teamListe.get(teamAuswahl - 1);

            System.out.println("Verfuegbare Personen:");
            listMitglieder(personenListe);

            System.out.print("Wähle eine Person durch Angabe der Nummer: ");
            int personAuswahl = scanner.nextInt();
            scanner.nextLine(); // Leerzeichen nach der Eingabe lesen

            if (personAuswahl > 0 && personAuswahl <= personenListe.size()) {
                Person ausgewaehltePerson = personenListe.get(personAuswahl - 1);
                ausgewaehltesTeam.mitgliedHinzufuegen(ausgewaehltePerson);
                System.out.println(ausgewaehltePerson.getVorname() + " " + ausgewaehltePerson.getNachname() +
                        " wurde zum Team '" + ausgewaehltesTeam.getName() + "' hinzugefügt!");
            } else {
                System.out.println("Ungueltige Auswahl für Person.");
            }
        } else {
            System.out.println("Ungueltige Auswahl für Team.");
        }
    }












    private static void personAusTeamEntfernen(List<Team> teamListe, Scanner scanner) {
        System.out.println("Gib den Teamnamen ein:");
        String teamname = scanner.nextLine();

        Team team = getTeamByName(teamListe, teamname);

        if (team != null) {
            System.out.println("Mitglieder im Team " + team.getName() + ":");
            listMitglieder(team.getMitglied());

            System.out.print("Wähle eine Person durch Angabe der Nummer: ");
            int auswahl = scanner.nextInt();
            scanner.nextLine(); // Leerzeichen nach der Eingabe lesen

            if (auswahl > 0 && auswahl <= team.getMitglied().size()) {
                Person person = team.getMitglied().get(auswahl - 1);
                team.mitgliedEntfernen(person);
                System.out.println(person.getVorname() + " " + person.getNachname() + " wurde aus dem Team entfernt!");
            } else {
                System.out.println("Ungültige Auswahl.");
            }
        } else {
            System.out.println("Team nicht gefunden.");
        }
    }















    private static void teamAuflisten(List<Team> teamListe, List<Aufgabe> aufgabenListe) {
        System.out.println("Liste der Teams:\n");
        for (Team team : teamListe) {
            System.out.println("+--------------------------------------------+");
            System.out.println("Teamname: " + team.getName());
            System.out.println("Mitglieder:");
            for (Person person : team.getMitglied()) {
                System.out.println(" - " + person.getVorname() + " " + person.getNachname());
            }

            // Display tasks and their deadlines for each team
            System.out.println("Aufgaben:");
            for (Aufgabe aufgabe : aufgabenListe) { // Loop through all tasks
                System.out.println(" - Aufgabe: " + aufgabe.getTitel() + ", Fertig bis: " + aufgabe.getDatum().toString());
            }

            System.out.println("+--------------------------------------------+\n");
        }
    }








    private static Team getTeamByName(List<Team> teamListe, String teamname) {
        for (Team team : teamListe) {
            if (team.getName().equals(teamname)) {
                return team;
            }
        }
        return null;
    }









////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public static void BeendenDialogAusgeben()
    {

        System.out.println("+--------------------------------------------+");
        System.out.println("| *Wollen Sie wirklich das Programm beenden? |");
        System.out.println("|--------------------------------------------|");
        System.out.println("| Wählen Sie eine Option aus!                |");
        System.out.println("|                                            |");
        System.out.println("| [1] Ja                                     |");
        System.out.println("| [2] Nein                                   |");
        System.out.println("|                                            |");
        System.out.println("+--------------------------------------------+");
    }



    public boolean beendenDialog(Scanner scanner) {
        BeendenDialogAusgeben();

        int auswahl = scanner.nextInt();
        scanner.nextLine();

        switch (auswahl) {
            case 1:
                System.out.println("Programm wird beendet.");
                return false;
            case 2:
                return true;
            default:
                System.out.println("Ungültige Option.");
                return true;
        }
    }





}
