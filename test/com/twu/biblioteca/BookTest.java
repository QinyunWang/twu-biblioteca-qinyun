package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookTest {

    private List<Book> bookList;
    private PrintStream printStream;
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        bookList = new ArrayList<>();
        bookList.add(new Book("Gone with the Wind"));
        bookList.add(new Book("A Journey to the Center of the Earth"));
        bookList.add(new Book("Oliver Twist"));
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
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
}
