package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PublicationTest {

    private List<Book> bookList;
    private PrintStream printStream;
    private Printer printer;
    private Book book;

    @Before
    public void setUp() throws Exception {
        bookList = new ArrayList<>();
        bookList.add(new Book("Gone with the Wind"));
        bookList.add(new Book("A Journey to the Center of the Earth"));
        bookList.add(new Book("Oliver Twist"));
        book = new Book("Jane Eyre", "Charlotte Bronte", 1847);
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
    }

    @Test
    public void testGetTitle() {
        assertThat(bookList.get(0).getTitle(), is("Gone with the Wind"));
        assertThat(bookList.get(1).getTitle(), is("A Journey to the Center of the Earth"));
    }

    @Test
    public void testGetAuthor() {
        assertThat(book.getAuthor(), is("Charlotte Bronte"));
    }

    @Test
    public void testGetYear() {
        assertThat(book.getYear(), is(1847));
    }

    @Test
    public void shouldPrintBookTitleList() {
        for (Book book: bookList) {
            printer.print(book.getTitle());
        }
        verify(printStream, times(1)).println("Gone with the Wind");
        verify(printStream, times(1)).println("A Journey to the Center of the Earth");
        verify(printStream, times(1)).println("Oliver Twist");
    }

    @Test
    public void shouldPrintAllInformationOfBooks() {
        bookList.add(book);
        for (Book book: bookList) {
            printer.print(book.toString());
        }
        verify(printStream, times(1)).println("Jane Eyre | Charlotte Bronte | 1847");
    }
}
