package org.example.laba2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {

    int counter = 1;

    @Test
    void from10to() {
        int intValue = 96;
        int regex = 3;
        String expected = "10120";

        System.out.printf("Running test %d ", counter++);
        System.out.printf("Converting %d to %d\n", intValue, regex);
        String result = Converter.from10to(intValue, regex);
        assertEquals(expected, result);

        double doubleValue = 36.945;
        regex = 2;
        expected = "100100.111100011";

        System.out.printf("Running test %d ", counter++);
        System.out.printf("Converting %f to %d\n", doubleValue, regex);
        result = Converter.from10to(doubleValue, regex);
        assertEquals(expected, result);

        doubleValue = 0.945;
        regex = 2;
        expected = "0.111100011";

        System.out.printf("Running test %d ", counter++);
        System.out.printf("Converting %f to %d\n", doubleValue, regex);
        result = Converter.from10to(doubleValue, regex);
        assertEquals(expected, result);
    }

    @Test
    void testFrom10to() {

    }

    @Test
    void from2to10() {
    }
}