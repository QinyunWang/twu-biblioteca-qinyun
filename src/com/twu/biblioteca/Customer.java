package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Book> loanedBooks;
    private List<Movie> loanedMovies;
    private String name;
    private String email;
    private int number;
    private String acc;
    private String password;

    public Customer(String name, String email, int number, String acc, String password) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.acc = acc;
        this.password = password;
        loanedBooks = new ArrayList<>();
        loanedMovies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return acc;
    }

    public boolean checkPassword(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void checkOutBook(Book book) {
        loanedBooks.add(book);
    }

    public void checkOutMovie(Movie movie) {
        loanedMovies.add(movie);
    }

    public Book returnBook(int index) throws IndexOutOfBoundsException {
        try {
            return loanedBooks.remove(index-1);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }

    }

    public void outputBookList(Printer printer) {
        for (int i=0; i<loanedBooks.size(); i++) {
            int order = i+1;
            printer.print(order + "." + loanedBooks.get(i).toString());
        }
    }

    public void outPutMovieList(Printer printer) {
        for (int i=0; i<loanedMovies.size(); i++) {
            int order = i+1;
            printer.print(order + "." + loanedMovies.get(i).toString());
        }
    }
}
