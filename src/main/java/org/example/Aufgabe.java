package org.example; /**
 /**
 *
 */

/**
 *
 */
public class Aufgabe {

    private String titel;
    private String beschreibung;
    private Person beschaeftigte;
    private Datum fertigBis;
    private boolean abgeschlossen;

    /**
     *
     */
    public Aufgabe(String titel, String beschreibung, Datum fertigBis) {
        // TODO Auto-generated constructor stub
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.beschaeftigte = beschaeftigte;
        this.fertigBis= fertigBis;
        this.abgeschlossen = abgeschlossen;


    }

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }



    public Datum getDatum() {
        return fertigBis;
    }

    public boolean getAbgeschlossen() {
        return abgeschlossen;
    }
}