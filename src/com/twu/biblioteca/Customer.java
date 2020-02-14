package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Book> loanedBooks;
    private List<Movie> loanedMovies;

    public Customer() {
        loanedBooks = new ArrayList<>();
        loanedMovies = new ArrayList<>();
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
}
