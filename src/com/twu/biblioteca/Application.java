package com.twu.biblioteca;

import java.util.Scanner;

public class Application {

    private Printer printer;
    private BookList bookList;
    private MainMenu menu;
    private Scanner scanner;

    public Application(Printer printer, BookList bookList) {
        this.printer = printer;
        this.bookList = bookList;
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
                        bookList.remove(bookNum);
                        printer.print(Printer.ENJOY_BOOK);
                    } catch (IndexOutOfBoundsException e) {
                        printer.print(Printer.BOOK_UNAVAILABLE);
                    }
                }
            default:
                printer.print(Printer.INVALID_OPTION);
        }
    }

}
