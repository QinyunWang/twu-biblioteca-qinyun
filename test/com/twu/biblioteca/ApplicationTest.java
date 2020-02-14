package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Application app;
    private PublicationList bookList;
    private PublicationList movieList;
    private Printer printer;
    private PrintStream printStream;
    private Customer customer;

    @Before
    public void setUp() {
        bookList = mock(PublicationList.class);
        movieList = mock(PublicationList.class);
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
        customer = mock(Customer.class);
        app = new Application(printer, bookList, movieList, customer);
    }

    @Test
    public void shouldPrintErrorMessage() {
        app.processOption(9);
        verify(printStream).println(Printer.INVALID_OPTION);
    }

}
