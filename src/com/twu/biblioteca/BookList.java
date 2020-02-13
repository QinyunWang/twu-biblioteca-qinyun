package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> books;

    public BookList() {
        books = new ArrayList<>();
    }

    public BookList(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book newBook) {
        books.add(newBook);
    }

    public int size() {
        return books.size();
    }

    public void outputList(Printer printer) {
        for (Book book: books) {
            printer.print(book.toString());
        }
    }
}
