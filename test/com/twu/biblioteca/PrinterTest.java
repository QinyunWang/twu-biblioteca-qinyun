package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrinterTest {

    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        Printer printer = new Printer(printStream);
        printer.print(Printer.WELCOME_MESSAGE);
        verify(printStream).println(Printer.WELCOME_MESSAGE);
    }
}
