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

    public Book remove(int orderNum) throws IndexOutOfBoundsException {
        try {
            return books.remove(orderNum-1);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }

    }

    public List<Book> getBooks() {
        return books;
    }

    public int size() {
        return books.size();
    }

    public void outputList(Printer printer) {
        for (int i=0; i<books.size(); i++) {
            int order = i+1;
            printer.print(order + "." + books.get(i).toString());
        }
    }
}
