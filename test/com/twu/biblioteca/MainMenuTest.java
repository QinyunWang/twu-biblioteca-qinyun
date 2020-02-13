package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainMenuTest {

    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        Printer printer = new Printer(printStream);
        MainMenu menu = new MainMenu(printer);
        menu.displayMainMenu();
        verify(printStream).println("Main Menu\n" +
                "1.List of books\nPlease enter your option: ");
    }
}
