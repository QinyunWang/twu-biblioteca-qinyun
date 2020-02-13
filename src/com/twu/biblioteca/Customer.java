package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Book> loanedBooks;

    public Customer() {
        loanedBooks = new ArrayList<>();
    }

    public void checkOut(Book book) {
        loanedBooks.add(book);
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
