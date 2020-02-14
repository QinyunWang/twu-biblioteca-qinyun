package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookListTest {

    private List<Book> books;
    private PublicationList<Book> bookList;
    private PrintStream printStream;
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        books.add(new Book("Gone with the Wind"));
        books.add(new Book("Jane Eyre", "Charlotte Bronte", 1847));
        bookList = new PublicationList<>(books);
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
    }

    @Test
    public void testOutputBookList() {
        bookList.outputList(printer);
        verify(printStream).println("Gone with the Wind");
        verify(printStream).println("Jane Eyre | Charlotte Bronte | 1847");
    }

    @Test
    public void testSize() {
        assertThat(2, is(bookList.size()));
    }

    @Test
    public void testAddBook() {
        bookList.addPub(new Book("War and Peace", "Makolovsiki", 1923));
        assertThat(3, is(bookList.size()));
        bookList.outputList(printer);
        verify(printStream, times(1)).println("War and Peace | Makolovsiki | 1923");
    }
}
