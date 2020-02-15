package com.twu.biblioteca;

public class MainMenu {

    private Printer printer;

    public MainMenu(Printer printer) {
        this.printer = printer;
    }

    public void displayMainMenu() {
        String menu = "Main Menu\n" +
                "1.List of books\n" +
                "2.Return book\n" +
                "3.List of movies\n" +
                "4.Check borrow info\n" +
                "5.Customer information\n" +
                "0.Quit the program\nPlease enter your option: ";
        printer.print(menu);
    }
}
