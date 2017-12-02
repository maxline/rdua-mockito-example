package com.avladykin.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergey Mikhluk.
 */
public class CalculateTest {
    Calculate calculate;

    @Before
    public void setUp() throws Exception {
        calculate = new Calculate();
    }

    @Test
    public void shouldReturnZero() {
        int expectedValue = 0;
        int actualValue = calculate.add(0, 0);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void shouldAddTwoDigits() {
        int expectedValue = 4;
        int actualValue = calculate.add(2, 2);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void shouldSubTwoDigits() {
        int expectedValue = 4;
        int actualValue = calculate.sub(6, 2);

        assertEquals(expectedValue, actualValue);
    }


}