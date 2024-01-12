package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Team {

    private String name;
    private List<Person> mitglieder;

    /**
     *
     */
    public Team(String name) {
        this.name = name;
        this.mitglieder = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getMitglied() {
        return mitglieder;
    }

    public void mitgliedHinzufuegen(Person mitglied) {
        mitglieder.add(mitglied);
    }

    public void mitgliedEntfernen(Person mitglied) {
        mitglieder.remove(mitglied);
    }

}
