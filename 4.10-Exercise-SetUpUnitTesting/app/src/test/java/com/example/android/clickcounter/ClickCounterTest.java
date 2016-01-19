package com.example.android.clickcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClickCounterTest {

    @Test
    public void testIncrement() {
        ClickCounter counter = new ClickCounter();
        assertEquals(0, counter.getCount());

        counter.increment();
        assertEquals(1, counter.getCount());

    }
}