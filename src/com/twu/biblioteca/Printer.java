package com.twu.biblioteca;

import java.io.PrintStream;

public class Printer {

    public static final String WELCOME_MESSAGE = "Welcome to the Biblioteca App!";
    private PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String string) {
        printStream.println(string);
    }
}
