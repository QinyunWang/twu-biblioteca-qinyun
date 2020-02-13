package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.run();
    }

    public static void run() {
        PrintStream printStream = System.out;
        Printer printer = new Printer(printStream);

        // welcome message
        printer.print(Printer.WELCOME_MESSAGE);
    }
}
