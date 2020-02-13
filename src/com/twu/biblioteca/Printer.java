package com.twu.biblioteca;

import java.io.PrintStream;

public class Printer {

    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca.\n" +
            "Your one-stop-shop for great book titles in Bangalore!";
    public static final String INVALID_OPTION = "Please select a valid option!";
    public static final String ENJOY_BOOK = "Thank you! Enjoy the book";

    private PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String string) {
        printStream.println(string);
    }
}
