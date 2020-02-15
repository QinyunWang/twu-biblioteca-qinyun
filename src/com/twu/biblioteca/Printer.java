package com.twu.biblioteca;

import java.io.PrintStream;

public class Printer {

    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca.\n" +
            "Your one-stop-shop for great book titles in Bangalore!";
    public static final String INVALID_OPTION = "Please select a valid option!";
    public static final String ENJOY_BOOK = "Thank you! Enjoy the book";
    public static final String ENJOY_MOVIE = "Thank you! Enjoy the movie";
    public static final String BOOK_UNAVAILABLE = "Sorry, that book is not available";
    public static final String MOVIE_UNAVAILABLE = "Sorry, that movie is not available";
    public static final String RETURN_SUCCESS = "Thank you for returning the book";
    public static final String INVALID_RETURN = "That is not a valid book to return";

    private PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String string) {
        printStream.println(string);
    }
}
