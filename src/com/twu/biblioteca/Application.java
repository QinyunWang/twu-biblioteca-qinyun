package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Application {

    private Printer printer;
    private PublicationList<Book> bookList;
    private PublicationList<Movie> movieList;
    private MainMenu menu;
    private Scanner scanner;
    private Customer customer;
    private HashMap<String, Customer> account;
    private List<Record> records;

    public Application(Printer printer, PublicationList bookList, PublicationList movieList) {
        this.printer = printer;
        this.bookList = bookList;
        this.movieList = movieList;
        menu = new MainMenu(this.printer);
        scanner = new Scanner(System.in);
        records = new ArrayList<>();
        makeUserAccount();
    }

    public void run() {
        logIn();

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
            case 4:
                recordsList();
                break;
            case 5:
                outputCustomerInfo();
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
                Book book = bookList.remove(bookNum);
                customer.checkOutBook(book);
                records.add(new Record(customer, book));
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
                printer.print(Printer.ENJOY_MOVIE);
            } catch (IndexOutOfBoundsException e) {
                printer.print(Printer.MOVIE_UNAVAILABLE);
            }
        }
    }

    public void makeUserAccount() {
        account = new HashMap<>();
        account.put("123-1234", new Customer("John", "john.j@gmail.com", 4333222, "123-1234", "123456"));
        account.put("222-3323", new Customer("Karen", "karen.ma@gmail.com", 221122, "222-3323", "admin"));
    }

    private void logIn() {
        printer.print("Enter your library number to log in:");
        String acc = scanner.next();
        if (account.containsKey(acc)) {
            printer.print("Enter password:");
            String password = scanner.next();
            if (account.get(acc).checkPassword(password)) {
                this.customer = account.get(acc);
                return;
            } else {
                printer.print("Password is not correct");
                logIn();
            }
        } else {
            printer.print("Account does not exist");
            logIn();
        }
    }

    public void recordsList() {
        for (Record record: records) {
            printer.print(record.toString());
        }
    }

    public void outputCustomerInfo() {
        printer.print(customer.getInfo());
    }


}
