package com.twu.biblioteca;

public class Publication {
    private String title;
    private String author;
    private int year;

    public Publication(){

    }

    public Publication(String title) {
        this.title = title;
        this.author = null;
        this.year = 0;
    }

    public Publication(String title, String author, int year) {
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
}
