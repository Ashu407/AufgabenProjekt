/**
 *
 */
package org.example;

/**
 *
 */
public class Datum {

    private int tag;
    private int monat;
    private int jahr;

    /**
     *
     */
    public Datum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public int getTag() {
        return tag;
    }

    public int getMonat() {
        return monat;
    }

    public int getJahr() {
        return jahr;
    }

    @Override
    public String toString() {
        return tag + "." + monat + "." + jahr;
    }
}
