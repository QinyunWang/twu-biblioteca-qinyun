package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class MovieTest {

    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Titanic", "James Cameron", 1997, 9);
    }

    @Test
    public void testGetRate() {
        assertThat(9, is(movie.getRate()));
    }

    @Test
    public void testToString() {
        assertThat("Titanic | James Cameron | 1997 | 9", is(movie.toString()));
    }
}
