package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title) {
        this.title = title;
        this.author = null;
        this.year = 0;
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        String info = title;
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
