package com.twu.biblioteca;

public class MainMenu {

    private Printer printer;

    public MainMenu(Printer printer) {
        this.printer = printer;
    }

    public void displayMainMenu() {
        String menu = "Main Menu\n" +
                "1.List of books\nPlease enter your option: ";
        printer.print(menu);
    }
}
