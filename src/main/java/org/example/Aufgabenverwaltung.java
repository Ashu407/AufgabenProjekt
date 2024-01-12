package org.example;
/**
 *
 */

import java.util.List;

/**
 *
 */
public class Aufgabenverwaltung {

    private List<Team> teams;
    private List<Aufgabe> aufgaben;

    /**
     *
     */
    public Aufgabenverwaltung(List<Team> teams, List<Aufgabe> aufgaben) {
        // TODO Auto-generated constructor stub
        this.teams = teams;
        this.aufgaben = aufgaben;
    }

    public List<Team> getTeams(){
        return teams;
    }

    public List<Aufgabe> getAufgaben(){
        return aufgaben;
    }


}
