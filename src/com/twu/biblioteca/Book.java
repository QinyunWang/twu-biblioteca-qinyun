package com.twu.biblioteca;

public class Book extends Publication{

    public Book(String title) {
        super(title);
    }

    public Book(String title, String author, int year) {
        super(title, author, year);
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
        return info;
    }
}
