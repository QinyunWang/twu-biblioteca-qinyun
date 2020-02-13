package com.twu.biblioteca;

public class MainMenu {

    private Printer printer;

    public MainMenu(Printer printer) {
        this.printer = printer;
    }

    public void displayMainMenu() {
        String menu = "Main Menu\n" +
                "1.List of books\n" +
                "0.Quit the program\nPlease enter your option: ";
        printer.print(menu);
    }
}
