package com.twu.biblioteca;

public class Movie extends Publication {

    private int rate;

    public Movie(String title) {
        super(title);
    }

    public Movie(String title, String director, int year, int rate) {
        super(title, director, year);
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        String info = getTitle();
        if (getAuthor() != null) {
            info += " | ";
            info += getAuthor();
        }
        if (getYear() != 0) {
            info += " | ";
            info += getYear();
        }
        info += " | ";
        if (getRate() == 0) {
            info += "Unrated";
        } else {
            info += getRate();
        }
        return info;
    }
}
