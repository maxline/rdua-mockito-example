package com.avladykin.calculator;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

/**
 * @author Sergey Mikhluk.
 */
public class CalculatorCli {

    private final Calculator calculator;

    public CalculatorCli(Calculator calculator) {
        this.calculator = calculator;
    }

    public void runInteractiveSession(Reader reader){
        runInteractiveSession(reader, System.out::println);
    }

    private void runInteractiveSession(Reader reader, DoubleConsumer resultConsumer) {
        new BufferedReader(reader).lines()
                .flatMap((s) -> Stream.of(s.split(";")))
                .filter((s) -> !s.trim().isEmpty())
                .mapToDouble(calculator::calculate)
                .forEach(resultConsumer);
    }
}
