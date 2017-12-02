package com.avladykin.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sergey Mikhluk.
 */
public class CalculatorImplTest {
    private static CalculatorImpl calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new CalculatorImpl();
    }

    @Test
    public void zeroTest() throws Exception {
        double expectedValue = 0;
        double actualValue = calculator.calculate("0");

        assertEquals(expectedValue, actualValue, 1e-9);
    }

    @Test
    public void addTest() throws Exception {
        double expectedValue = 4;
        double actualValue = calculator.calculate("2+2");

        assertEquals(expectedValue, actualValue, 1e-9);
    }

    @Test
    public void complexExpressionTest() throws Exception {
        double expectedValue = 2.5;
        double actualValue = calculator.calculate("(2+2)*5/8");

        assertEquals(expectedValue, actualValue, 1e-9);
    }

    @Test
    public void functionExpressionTest() throws Exception {
        double expectedValue = 1;
        double actualValue = calculator.calculate("sin(1)*sin(1)+cos(1)*cos(1)");

        assertEquals(expectedValue, actualValue, 1e-9);
    }
}