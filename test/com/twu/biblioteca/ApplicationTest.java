package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Application app;
    private BookList bookList;
    private Printer printer;
    private PrintStream printStream;

    @Before
    public void setUp() {
        bookList = mock(BookList.class);
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
        app = new Application(printer, bookList);
    }

    @Test
    public void shouldPrintErrorMessage() {
        app.processOption(2);
        verify(printStream).println(Printer.INVALID_OPTION);
    }
}