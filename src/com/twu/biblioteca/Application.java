package com.twu.biblioteca;

import java.util.Scanner;

public class Application {

    private Printer printer;
    private PublicationList<Book> bookList;
    private PublicationList<Movie> movieList;
    private MainMenu menu;
    private Scanner scanner;
    private Customer customer;

    public Application(Printer printer, PublicationList bookList, PublicationList movieList, Customer customer) {
        this.printer = printer;
        this.bookList = bookList;
        this.customer = customer;
        this.movieList = movieList;
        menu = new MainMenu(this.printer);
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            menu.displayMainMenu();
            int option = scanner.nextInt();
            processOption(option);
        }

    }

    public void processOption(int option) throws IndexOutOfBoundsException {
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                checkOutBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                checkOutMovie();
                break;
            default:
                printer.print(Printer.INVALID_OPTION);
        }
    }

    public void checkOutBook() throws IndexOutOfBoundsException {
        bookList.outputList(printer);
        printer.print("Enter the number of book to checkout or 0 to go back");
        int bookNum = scanner.nextInt();
        if (bookNum == 0) {
            return;
        } else {
            try {
                customer.checkOutBook(bookList.remove(bookNum));
                printer.print(Printer.ENJOY_BOOK);
            } catch (IndexOutOfBoundsException e) {
                printer.print(Printer.BOOK_UNAVAILABLE);
            }
        }
    }

    public void returnBook() {
        customer.outputBookList(printer);
        printer.print("Enter the number of book to return or 0 to go back");
        int bookNum1 = scanner.nextInt();
        if (bookNum1 == 0) {
            return;
        } else {
            try {
                bookList.addPub(customer.returnBook(bookNum1));
                printer.print(Printer.RETURN_SUCCESS);
            } catch (IndexOutOfBoundsException e) {
                printer.print(Printer.INVALID_RETURN);
            }
        }
    }

    public void checkOutMovie() throws IndexOutOfBoundsException {
        movieList.outputList(printer);
        printer.print("Enter the number of movie to checkout or 0 to go back");
        int movieNum = scanner.nextInt();
        if (movieNum == 0) {
            return;
        } else {
            try {
                customer.checkOutMovie(movieList.remove(movieNum));
                printer.print(Printer.ENJOY_BOOK);
            } catch (IndexOutOfBoundsException e) {
                printer.print(Printer.BOOK_UNAVAILABLE);
            }
        }
    }

}
