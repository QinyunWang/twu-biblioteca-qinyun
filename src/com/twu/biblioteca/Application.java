package com.twu.biblioteca;

import java.util.Scanner;

public class Application {

    private Printer printer;
    private BookList bookList;
    private MainMenu menu;
    private Scanner scanner;
    private Customer customer;

    public Application(Printer printer, BookList bookList, Customer customer) {
        this.printer = printer;
        this.bookList = bookList;
        this.customer = customer;
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
                bookList.outputList(printer);
                printer.print("Enter the number of book to checkout or 0 to go back");
                int bookNum = scanner.nextInt();
                if (bookNum == 0) {
                    break;
                } else {
                    try {
                        customer.checkOut(bookList.remove(bookNum));
                        printer.print(Printer.ENJOY_BOOK);
                    } catch (IndexOutOfBoundsException e) {
                        printer.print(Printer.BOOK_UNAVAILABLE);
                    }
                    break;
                }
            case 2:
                customer.outputBookList(printer);
                printer.print("Enter the number of book to return or 0 to go back");
                int bookNum1 = scanner.nextInt();
                if (bookNum1 == 0) {
                    break;
                } else {
                    try {
                        bookList.addBook(customer.returnBook(bookNum1));
                        printer.print(Printer.RETURN_SUCCESS);
                    } catch (IndexOutOfBoundsException e) {
                        printer.print(Printer.INVALID_RETURN);
                    }
                    break;
                }
            default:
                printer.print(Printer.INVALID_OPTION);
        }
    }

}
