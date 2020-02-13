package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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

        // book list (to be replaced by real data in the future)
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Gone with the Wind"));
        bookList.add(new Book("A Journey to the Center of the Earth"));
        bookList.add(new Book("Oliver Twist"));
        for (Book book: bookList) {
            printer.print(book.toString());
        }
    }
}
