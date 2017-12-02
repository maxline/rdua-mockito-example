package com.avladykin.calculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.StringReader;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * @author Sergey Mikhluk.
 */
public class CalculatorCliTest {

    private Calculator calculatorMock;
    private CalculatorCli calculatorCli;

    @Before
    public void setUp() throws Exception {
        calculatorMock = Mockito.mock(Calculator.class);
        calculatorCli = new CalculatorCli(calculatorMock);
    }

    @Test
    public void emptyExpressionsMustBeSkipped() {
        calculatorCli.runInteractiveSession(new StringReader(";\n  ;;; \t\n;;"));

        verifyZeroInteractions(calculatorMock);
    }

    @Test
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated() {
        calculatorCli.runInteractiveSession(new StringReader("1;2;3"));

        verify(calculatorMock).calculate("1");
        verify(calculatorMock).calculate("2");
        verify(calculatorMock).calculate("3");
    }

    @Test
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated2() {
        when(calculatorMock.calculate("1")).thenReturn(1d);
        when(calculatorMock.calculate("2")).thenReturn(2d);
        when(calculatorMock.calculate("3")).thenReturn(3d);
        calculatorCli.runInteractiveSession(new StringReader("1;2;3"));

        verify(calculatorMock).calculate("1");
        verify(calculatorMock).calculate("2");
        verify(calculatorMock).calculate("3");
    }

}