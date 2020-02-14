package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.run();
    }

    private static void run() {
        PrintStream printStream = System.out;
        Printer printer = new Printer(printStream);
        // book list (to be replaced by real data in the future)
        List<Book> bookList = new ArrayList<>();

        // welcome message
        printer.print(Printer.WELCOME_MESSAGE);

        bookList.add(new Book("Gone with the Wind"));
        bookList.add(new Book("A Journey to the Center of the Earth"));
        bookList.add(new Book("Oliver Twist"));
        bookList.add(new Book("Jane Eyre", "Charlotte Bronte", 1847));



        PublicationList<Book> books = new PublicationList<>(bookList);
        PublicationList<Movie> movies = new PublicationList<>();
        movies.addPub(new Movie("Titanic", "James Cameron", 1997, 9));

        Customer customer = new Customer();

        Application app = new Application(printer, books, movies, customer);
        app.run();

    }

}
