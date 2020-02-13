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
        menu.displayMainMenu();
        int option = scanner.nextInt();
        processOption(option);
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                bookList.outputList(printer);
                break;
            default:
                printer.print(Printer.INVALID_OPTION);
        }
    }

}
